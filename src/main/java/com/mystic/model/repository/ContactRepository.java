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

    ArrayList<Contact> findByUserId(Long userId);

    Contact saveAndFlush(Contact contact);

    @Modifying
    @Query(value = "UPDATE Contacts SET firstname = ?2, lastname = ?3, country =?4, mobile_phone = ?5,  address = ?6, email = ?7 WHERE contact_Id = ?1", nativeQuery = true)
    @Transactional
    void updateContact(Long contactId,
                       String firstname,
                       String lastname,
                       String country,
                       String mobilePhone,
                       String address,
                       String email);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  contact_id ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByContactIdAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);


    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  firstname ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByFirstNameAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  country ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByCountryAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  address ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByAddressAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);
    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  mobile_phone ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByMobilePhoneAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);
    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  lastname ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByLastnamePhoneAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  email ASC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderBEmailPhoneAsc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  contact_id DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByContactIdDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);


    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  firstname DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByFirstNameDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY country DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByCountryDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  address DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByAddressDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);
    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  mobile_phone DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByMobilePhoneDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);
    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  email DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderBEmailPhoneDesc(Long contactId,
                                                     Integer cursor,
                                                     Integer offset);

    @Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE user_id =?1  ORDER BY  lastname DESC LIMIT ?2,?3", nativeQuery = true)
    @Transactional
    ArrayList<Contact> getContactOrderByLastnamePhoneDesc(Long contactId,
                                                         Integer cursor,
                                                         Integer offset);

@Modifying
    @Query(value = "SELECT  contact_id,firstname,lastname,country,address,mobile_phone,email FROM heroku_97c29fa23a87141.contacts WHERE   contact_id IN ?1 OR firstname IN ?1 OR lastname IN ?1 OR country IN ?1 OR address IN ?1 OR mobile_phone IN ?1 OR email IN ?1", nativeQuery = true)
    @Transactional
    ArrayList<Contact> searchContact(String searchItem);

    @Modifying
    @Query(value = "DELETE FROM heroku_97c29fa23a87141.contacts WHERE contact_Id IN ?1", nativeQuery = true)
    void deleteContactWithIds(List<String> ids);


}
