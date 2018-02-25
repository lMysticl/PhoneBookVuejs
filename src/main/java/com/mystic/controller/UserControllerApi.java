package com.mystic.controller;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.entity.User;
import com.mystic.service.UserService;
import com.mystic.service.impl.UserServiceImpl;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Putrenkov Pavlo
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserControllerApi {

    private final UserServiceImpl userServiceImpl;

    private UserService getUserService;

    @PostMapping(value = "/register")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void register(@Valid @RequestBody String data) throws RegistrationException {
        User user = getUserService.getUserService(data);
        userServiceImpl.save(user);
    }



    @GetMapping(value = "/getUsername")
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
