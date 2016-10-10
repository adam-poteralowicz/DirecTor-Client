package com.apap.director.domain.chat.model;

import com.apap.director.domain.connection.model.ConnectionData;
import com.apap.director.domain.user.model.User;

public abstract class Chat {

    User client;
    ConnectionData connectionData;

    public abstract void connect();
    public abstract void disconnect();

}
