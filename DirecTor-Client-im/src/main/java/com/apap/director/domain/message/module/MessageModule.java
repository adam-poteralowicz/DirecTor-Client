package com.apap.director.domain.message.module;

import com.apap.director.domain.message.event.MessageEventListener;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class MessageModule {

    @Provides
    @Singleton
    public MessageEventListener provideMessageEventListener(){
        return new MessageEventListener();
    }

}
