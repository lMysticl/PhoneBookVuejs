package com.mystic.model.repository;

import com.mystic.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Putrenkov Pavlo
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

//    @Modifying
//    @Query(value = "SELECT user_id,lastname,firstname,username,avatar from user where  user.user_id LIKE ?1", nativeQuery = true)
//    ArrayList<Contact> findByUserId(Long userId);

    ArrayList<Contact> findByUserId(Long userId);

    Contact saveAndFlush(Contact contact);

    @Modifying
    @Query(value = "UPDATE Contacts SET firstname = ?2, lastname = ?3, country =?4, mobile_phone = ?5,  address = ?6, email = ?7 WHERE contact_id = ?1", nativeQuery = true)
    @Transactional
    void updateContact(Long contactId,
                       String firstname,
                       String lastname,
                       String country,
                       String mobilePhone,
                       String address,
                       String email);
    @Modifying
    @Query(value = "delete from contacts where contact_id IN ?1", nativeQuery = true)
    void deleteContactWithIds(List<String> ids);
}
