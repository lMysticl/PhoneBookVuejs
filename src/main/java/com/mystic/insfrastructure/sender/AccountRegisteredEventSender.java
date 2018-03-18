package com.mystic.insfrastructure.sender;

import com.mystic.insfrastructure.channels.AccountChannels;
import com.mystic.insfrastructure.event.AccountRegisteredEvent;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/*
* @author Pavlo Putrenkov
*/


@MessagingGateway
public interface AccountRegisteredEventSender {

    @Gateway(requestChannel = AccountChannels.ACCOUNT_REGISTERED_CHANNEL_NAME)
    void send(AccountRegisteredEvent accountRegisteredEvent);
}
