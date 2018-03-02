package com.mystic.model.repository;

import com.mystic.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public interface UserRepository extends JpaRepository<User, Long> {

    ArrayList<User> findAll();

    Optional<User> findByUserId(Long id);

    User saveAndFlush(User user);

    @Query(value = "SELECT user_id,lastname,firstname,username,password,avatars from app_user where app_user.username LIKE ?1", nativeQuery = true)
    User findByUsername(String name);

}
