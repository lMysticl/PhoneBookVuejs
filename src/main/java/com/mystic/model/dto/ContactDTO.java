package com.mystic.model.dto;

import com.mystic.user.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Data
@Setter
@Getter
public class ContactDTO {

    private long contactId;

    private long userId;

    private String firstname;

    private String lastname;

    private String mobilePhone;

    private String address;

    private String email;

    private String country;

    private User user;

}
