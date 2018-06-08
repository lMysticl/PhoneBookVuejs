package com.mystic.user.repository;

import com.mystic.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String name);





    ArrayList<User> findAll();

    Optional<User> findByUserId(Long id);

    User saveAndFlush(User user);

    //    @Query(value = "SELECT user_id,lastname,firstname,username,password,avatars from app_user where app_user.username LIKE ?1", nativeQuery = true)
    User findByUsername(String name);
}