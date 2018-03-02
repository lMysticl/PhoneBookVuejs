package com.mystic.controller;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.dto.UserDTO;
import com.mystic.model.entity.User;
import com.mystic.service.UserService;
import com.mystic.service.impl.UserServiceImpl;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserControllerApi {

    private final UserServiceImpl userServiceImpl;

    private UserService getUserService;

    @GetMapping(value = "/profile")
    @PreAuthorize("permitAll")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public User users() {

        User user = userServiceImpl.getUser((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        ModelMapper modelMapper = new ModelMapper();

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userServiceImpl.getUser(userDTO.getUsername());
    }

    @PostMapping(value = "/profile/edit")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void usersEdit(@RequestBody String data) throws RegistrationException {

        User user = getUserService.setUser(data);

        userServiceImpl.save(user);
    }


    @PostMapping(value = "/profile/change-password")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void changePassword(@RequestBody String data) throws RegistrationException {

        User user = userServiceImpl.getUser((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userServiceImpl.checkPassword(user, data);
        userServiceImpl.save(user);
    }
}
