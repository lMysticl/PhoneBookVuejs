package com.mystic.service;

import com.mystic.model.entity.Contact;
import com.mystic.model.entity.User;
import com.mystic.model.repository.ContactRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddRandomContactsTest {

    @Autowired
    private UserService getUserService;

    @Autowired
    private ContactRepository contactRepository;

    private User user;

    @Before
    public void setUp() {
        user= getUserService.findById(492L);
    }


    @Test
    @Ignore
    public void getClientFromExcel() throws IOException, ParseException {


        String fileName = "F:\\Java\\PhoneBook_ver3.0\\PhoneBook\\src\\main\\resources\\static\\MOCK_DATA.json";

        List<String> list = new ArrayList<>();
        List<Contact> contactList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray copy = new JSONArray(list);

        for (int i = 100; i < 300; i++) {
            String s = copy.get(i).toString();

            JSONObject jsonObject = new JSONObject(s);
            String firstname = jsonObject.has("first_name") ? jsonObject.getString("first_name") : "";
            Long id = jsonObject.has("id") ? jsonObject.getLong("id"): 0;
            String last_name = jsonObject.has("last_name") ? jsonObject.getString("last_name") : "";
            String email = jsonObject.has("email") ? jsonObject.getString("email") : "";
            String phone_number = jsonObject.has("phone_number") ? jsonObject.getString("phone_number") : "";
            String country = jsonObject.has("country") ? jsonObject.getString("country") : "";
            String address = jsonObject.has("address") ? jsonObject.getString("address") : "";

            Contact contact = new Contact();
            contact.setContactId(id);
            contact.setUserId(492L);
            contact.setUser(user);
            contact.setFirstname(firstname);
            contact.setMobilePhone(phone_number);
            contact.setLastname(last_name);
            contact.setEmail(email);
            contact.setCountry(country);
            contact.setAddress(address);
            contactList.add(contact);
        }
        contactRepository.save(contactList);

    }
}
