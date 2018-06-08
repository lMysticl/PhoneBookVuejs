package com.mystic.user.infrastructure.handler;

import com.mystic.user.domain.User;
import com.mystic.user.infrastructure.channels.UserChannels;
import com.mystic.user.infrastructure.event.UserRegisteredEvent;
import com.mystic.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisteredEventHandler {

    private final UserRepository userRepository;

    @StreamListener(UserChannels.USER_REGISTERED_CHANNEL_NAME)
    public void handleEvent(UserRegisteredEvent event) {
        System.out.println("!!!!!!!!!!!!!!! UserRegisteredEvent event "+ event);

        User user = new User(event.getUserId(), event.getUsername());
        userRepository.save(user);
    }
}