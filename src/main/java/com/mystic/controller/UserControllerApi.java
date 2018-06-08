package com.mystic.controller;

import com.mystic.user.domain.User;
import com.mystic.user.repository.UserRepository;
import com.mystic.user.service.UserServiceImpl;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserControllerApi {

    private final UserRepository userRepository;

    private final UserServiceImpl userService;


    @GetMapping(value = "/profile")
    @PreAuthorize("permitAll")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public User users() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");

        return userService.getCurrentUser();
    }

//    @PostMapping(value = "/profile/edit")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Something went wrong"),
//            @ApiResponse(code = 403, message = "Access denied"),
//            @ApiResponse(code = 404, message = "The user doesn't exist"),
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public void usersEdit(@RequestBody String data) throws RegistrationException {
//
//        User user = getUserService.setUser(data);
//
//        userRepository.save(user);
//    }


//    @PostMapping(value = "/profile/change-password")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Something went wrong"),
//            @ApiResponse(code = 403, message = "Access denied"),
//            @ApiResponse(code = 404, message = "The user doesn't exist"),
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public void changePassword(@RequestBody String data) throws RegistrationException {
//        User user = userRepository.getUser((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
////        userRepository.checkPassword(user, data);
//        userRepository.save(user);
//    }
}
