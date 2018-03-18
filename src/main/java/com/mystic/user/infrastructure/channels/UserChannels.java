package com.mystic.user.infrastructure.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannels {
    String USER_REGISTERED_CHANNEL_NAME = "user_registered_chanel";

    @Input
    SubscribableChannel user_registered_chanel();

}