package com.apap.director.domain.chat.module;

import com.apap.director.domain.chat.event.ChatEventListener;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ChatModule {

    @Provides
    @Singleton
    public ChatEventListener provideChatEventListener(){
        return new ChatEventListener();
    }
}
