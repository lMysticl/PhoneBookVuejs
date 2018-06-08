package com.mystic.user.infrastructure.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisteredEvent {
    private Long userId;
    private String username;

}