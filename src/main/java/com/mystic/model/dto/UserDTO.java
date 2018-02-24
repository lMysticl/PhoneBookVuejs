package com.mystic.model.dto;

import com.mystic.model.entity.Contact;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO {

    private Long userId;

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private String middlename;

    private List<Contact> contacts = new ArrayList<>();

}
