package com.mystic.controller;

import com.mystic.exceptions.ContactException;
import com.mystic.model.entity.Contact;
import com.mystic.service.impl.ContactServiceImpl;
import com.mystic.user.service.UserServiceImpl;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Putrenkov Pavlo
 */
@RestController
@AllArgsConstructor
public class ContactController {

    private final UserServiceImpl userServiceImpl;

    private final ContactServiceImpl contactServiceImpl;
    private final UserServiceImpl userService;

//    private final ValidationContact validateContact;

//    private final ValidationService validation;

    @GetMapping(value = "/contacts/get-all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Contact> returnAllContact() {


//        ModelMapper modelMapper = new ModelMapper();
//
//        UserDTO userDTO = modelMapper.map(userServiceImpl.getCurrentUser(), UserDTO.class);
//
//        return contactServiceImpl.getByUserId(userDTO.getUserId());

         return userService.getCurrentUser().getContacts();
    }

    @PostMapping(value = "contacts/add")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Contact addContact(Contact contact) throws ContactException {

        contact.setUserId(userServiceImpl.getCurrentUser().getUserId());
//        validateContact.validateContact(contact);
        return contactServiceImpl.saveContact(contact);
    }


    @PostMapping(value = "contacts/delete")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void deleteContact(Contact contact)  {
        if (contact != null) {
            contactServiceImpl.deleteByUserId(contact.getContactId());
        }
    }

    @PostMapping(value = "contacts/deleteList")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void deleteContactList(String contactId) {
        if (contactId != null) {
            List<String> items = Arrays.asList(contactId.split(","));
            contactServiceImpl.deleteSomeUser(items);
        }
    }


    @PostMapping(value = "contacts/update")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void updateContact(Contact contact) throws ContactException {
        if (contact != null) {
//            validateContact.validateContact(contact);

            contact.setUserId(userServiceImpl.getCurrentUser().getUserId());
            contactServiceImpl.updateContact(contact);
        }
    }
}
