//package com.mystic.service;
//
//import com.mystic.model.entity.Contact;
//import com.mystic.model.repository.ContactRepository;
//import com.mystic.user.domain.User;
//import com.mystic.user.service.UserService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author Pavel Putrenkov
// * @version 1.0
// * @since
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Ignore
//public class ContactServiceImplTest {
//
//
//    private static final String ADDRESS = "123 6th St. \n" +
//            "Melbourne, FL 32904";
//
//    private static final String GERMANY = "Germany";
//
//    private static final String EMAIL = "Scombed1958@armyspy.com";
//
//    private static final String LASTNAME = "Carder";
//
//    private static final String FIRSTNAME = "John";
//
//    private static final String MOBILE_PHONE = "+1-202-555-0153";
//
//    @Autowired
//    private UserService getUserService;
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    private Contact contact;
//
//
//    @Before
//    public void setUp() {
//
//        User user = getUserService.findById(11L);
//
//        contact = new Contact();
//        contact.setUserId(11L);
//        contact.setUser(user);
//        contact.setAddress(ADDRESS);
//        contact.setCountry(GERMANY);
//        contact.setEmail(EMAIL);
//        contact.setLastname(LASTNAME);
//        contact.setFirstname(FIRSTNAME);
//        contact.setMobilePhone(MOBILE_PHONE);
//
//    }
//
//    @Transactional
//    @Rollback
//    @Test
//    public void addContactTest() {
//
//        Contact contact = contactRepository.saveAndFlush(this.contact);
//
//        Assert.assertTrue(contact.getMobilePhone().equals(MOBILE_PHONE));
//        Assert.assertTrue(contact.getUserId() != 0);
//
//        Contact actual = this.contact;
//        Contact current = contactRepository.findOne(this.contact.getContactId());
//        Assert.assertEquals(actual, current);
//
//    }
//}
