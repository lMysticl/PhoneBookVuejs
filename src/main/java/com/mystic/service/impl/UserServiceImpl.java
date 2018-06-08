//package com.mystic.service.impl;
//
//import com.mystic.exceptions.RegistrationException;
//import com.mystic.service.UserService;
//import com.mystic.user.domain.User;
//import com.mystic.user.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.json.JSONObject;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
///**
// * @author Putrenkov Pavlo
// */
//@Service("userService")
//@AllArgsConstructor
//@Slf4j
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//
//
//
////    private final ValidationRegistration validationRegistration;
////
////    private final ValidationPassword validationPassword;
//
//
//    public User findByUsername(String username) throws UsernameNotFoundException {
//        if (userRepository.findByUsername(username) != null) {
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return userRepository.findByUsername(username);
//    }
//
//
//    public User setUser(@RequestBody String data) throws RegistrationException {
//
//        JSONObject copy = new JSONObject(data);
//
//        User user = new User();
//
//        String firstname = copy.has("firstname") ? copy.getString("firstname") : "";
//
//        String lastname = copy.has("lastname") ? copy.getString("lastname") : "";
//
//        String password = copy.has("password") ? copy.getString("password") : "";
//
//        String username = copy.has("username") ? copy.getString("username") : "";
//
//        String avatar = copy.has("avatar") ? copy.getString("avatar") : "";
//
//        Long userId = copy.has("userId") ? copy.getLong("userId") : 0;
//
//        if (!(userId == 0)) {
//             user.setUserId(userId);
//        }
//
////        validationRegistration.validation(firstname, username);
//
//        user.setFirstname(firstname);
//
//        user.setLastname(lastname);
//
//        user.setAvatar(avatar);
//
////        cheackPassword(copy, user, password);
//
//        user.setUsername(username);
//
////        user.addRole(roleRepository.findOne(1L));
//
//        return user;
//
//    }
//
////    private void cheackPassword(JSONObject copy, User user, String password) {
////        if(copy.has("password")) {
////
////            user.setPassword(DigestUtils.sha256Hex(password));
////
////        }else {
////
////            User  userPas = getUser((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
////
////            user.setPassword(userPas.getPassword());
////
////        }
////    }
//
////    public void checkPassword(User user, String data) throws RegistrationException {
////
////        JSONObject copy = new JSONObject(data);
////
////        String oldPassword = copy.has("oldPassword") ? copy.getString("oldPassword") : "";
////
////        String newPassword = copy.has("newPassword") ? copy.getString("newPassword") : "default";
////
////        validationPassword.validation(user, oldPassword);
////
////        user.setPassword(DigestUtils.sha256Hex(newPassword));
////    }
//
//    public void save(User user) {
//        userRepository.save(user);
//    }
//
//    public User getUser(String username) {
//        log.info(userRepository.findByUsername(username).toString());
//        return userRepository.findByUsername(username);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User findById(Long id) throws AccessDeniedException {
//        return userRepository.findOne(id);
//    }
//
//    public List<User> findAll() throws AccessDeniedException {
//        return userRepository.findAll();
//    }
//}
