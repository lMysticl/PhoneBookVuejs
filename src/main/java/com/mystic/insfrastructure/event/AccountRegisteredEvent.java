package com.mystic.insfrastructure.event;

import com.mystic.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/*
* @author Pavlo Putrenkov
*/

@Getter
@EqualsAndHashCode
public class AccountRegisteredEvent {

    private long userId;

    private String username;

    private String firstname;

    private String lastname;

    private String avatar;

    public AccountRegisteredEvent(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.avatar = user.getAvatar();
    }
}