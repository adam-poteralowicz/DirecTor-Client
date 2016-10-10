package com.apap.director.domain.connection.model;

import com.apap.director.domain.user.model.User;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;

/**
 * Creates connection configuration for specific user
 */

public abstract class ConnectionData implements ConnectionListener{

    protected AbstractXMPPConnection connection;
    protected User user;

    public ConnectionData(User user){
        this.user = user;
    }

    public AbstractXMPPConnection getConnection() {
        return connection;
    }


}
