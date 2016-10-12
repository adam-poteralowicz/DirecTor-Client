package com.apap.director.config.dagger;

import com.apap.director.domain.chat.module.ChatModule;
import com.apap.director.domain.connection.module.ConnectionModule;
import com.apap.director.domain.message.module.MessageModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ChatModule.class, MessageModule.class, ConnectionModule.class})
public class ChatComponent {
    public ChatComponent(){

    }
}
