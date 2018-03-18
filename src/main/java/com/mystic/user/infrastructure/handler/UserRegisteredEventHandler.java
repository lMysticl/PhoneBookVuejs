package com.mystic.user.infrastructure.handler;

import com.targetbrain.mailing.domain.vo.EmailAddress;
import com.targetbrain.sms.domain.vo.PhoneNumber;
import com.targetbrain.user.domain.User;
import com.targetbrain.user.infrastructure.channels.UserChannels;
import com.targetbrain.user.infrastructure.event.UserRegisteredEvent;
import com.targetbrain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisteredEventHandler {
    private final UserRepository userRepository;

    @StreamListener(UserChannels.USER_REGISTERED_CHANNEL_NAME)
    public void handleEvent(UserRegisteredEvent event) {
        User user = new User(event.getId(), EmailAddress.of(event.getEmail()), PhoneNumber.of(event.getPhone()));
        userRepository.save(user);
    }
}