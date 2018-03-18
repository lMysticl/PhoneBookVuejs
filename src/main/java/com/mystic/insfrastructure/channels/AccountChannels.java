package com.mystic.insfrastructure.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/*
* @author Pavlo Putrenkov
*/

public interface AccountChannels {
    String ACCOUNT_REGISTERED_CHANNEL_NAME = "account_registered_chanel";

    @Output
    MessageChannel account_registered_chanel();

}