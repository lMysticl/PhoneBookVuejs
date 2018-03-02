package com.mystic.service;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}