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

    public ArrayList<Contact> getContactForPagination(Long contactId,
                                                      String sortBy,
                                                      String dir,
                                                      Integer cursor,
                                                      Integer offset) {
        ArrayList<Contact> contactOrderBy;

        contactRepository.getContactOrderByContactIdAsc(contactId, cursor, offset);

        switch (sortBy) {
            case "contactId":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderByContactIdAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderByContactIdDesc(contactId, cursor, offset);
                }
                break;
            case "address":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderByFirstNameAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderByFirstNameDesc(contactId, cursor, offset);
                }
                break;

            case "country":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderByCountryAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderByCountryDesc(contactId, cursor, offset);
                }
                break;
            case "email":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderBEmailPhoneAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderBEmailPhoneDesc(contactId, cursor, offset);
                }
                break;
            case "firstname":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderBEmailPhoneAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderBEmailPhoneDesc(contactId, cursor, offset);
                }
                break;
            case "lastname":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderByLastnamePhoneAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderByLastnamePhoneDesc(contactId, cursor, offset);
                }
                break;
            case "mobilePhone":
                if (dir.equals("ASC")) {
                    contactOrderBy = contactRepository.getContactOrderByMobilePhoneAsc(contactId, cursor, offset);
                } else {
                    contactOrderBy = contactRepository.getContactOrderByMobilePhoneDesc(contactId, cursor, offset);
                }
                break;
            default: {
                contactOrderBy = contactRepository.getContactOrderByFirstNameAsc(contactId, cursor, offset);
                break;
            }
        }
        return contactOrderBy;
    }


    public Integer getCountOfContacts(Long userId) {
        return contactRepository.findByUserId(userId).size();
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
