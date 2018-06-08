package com.mystic.service.impl;

import com.mystic.model.entity.Contact;
import com.mystic.model.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Putrenkov Pavlo
 */
@Service("contactService")
@AllArgsConstructor
public class ContactServiceImpl {

    private ContactRepository contactRepository;




    @Transactional
    public void deleteSomeUser(List<String> ids) {
        contactRepository.deleteContactWithIds(ids);
    }

    public ArrayList<Contact> getByUserId(Long userId) {
        return contactRepository.findByUserId(userId);
    }

    public void deleteByUserId(Long userId) {
        contactRepository.delete(contactRepository.getOne(userId));
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    public void updateContact(Contact contact) {
        contactRepository.updateContact(
                contact.getContactId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getCountry(),
                contact.getMobilePhone(),
                contact.getAddress(),
                contact.getEmail());
    }


}
