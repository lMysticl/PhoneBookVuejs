package com.mystic.model.repository;

import com.mystic.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


/**
 * @author Putrenkov Pavlo
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    ArrayList<Contact> findByUserId(Long userId);

    Contact saveAndFlush(Contact contact);

    @Modifying
    @Query(value = "UPDATE Contacts SET firstname = ?2, lastname = ?3, middlename = ?4, mobile_phone = ?5, home_phone = ?6, address = ?7, email = ?8 WHERE contact_id = ?1", nativeQuery = true)
    @Transactional
    void updateContact(Long contactId,
                       String firstname,
                       String lastname,
                       String middlename,
                       String mobilePhone,
                       String homePhone,
                       String address,
                       String email);

}
