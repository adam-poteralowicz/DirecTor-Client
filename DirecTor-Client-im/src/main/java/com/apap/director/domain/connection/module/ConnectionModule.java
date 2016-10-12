package com.apap.director.domain.connection.module;

import com.apap.director.domain.connection.event.ConnectionEventListener;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ConnectionModule {

    @Provides
    @Singleton
    public ConnectionEventListener provideConnectionEventListener(){
        return new ConnectionEventListener();
    }
}
