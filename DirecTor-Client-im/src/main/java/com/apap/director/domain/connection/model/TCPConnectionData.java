package com.apap.director.domain.connection.model;

import android.util.Log;
import com.apap.director.domain.user.model.User;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

import java.util.logging.Logger;

public class TCPConnectionData extends ConnectionData {

    public TCPConnectionData(User user){
        super(user);
        this.connection = new XMPPTCPConnection(user.getId(), user.getPassword(), user.getHost());
        this.connection.addConnectionListener(this);

        ReconnectionManager manager = ReconnectionManager.getInstanceFor(this.connection);
        manager.enableAutomaticReconnection();
    }

//TODO: implement DIS
    public void connected(XMPPConnection xmppConnection) {
        Log.i("CONNECTION LISTENER", "Connected");
    }

    public void authenticated(XMPPConnection xmppConnection, boolean b) {
        Log.i("CONNECTION LISTENER", "Authenticated");
    }

    public void connectionClosed() {
        Log.i("CONNECTION LISTENER", "Closed");
    }

    public void connectionClosedOnError(Exception e) {
        Log.i("CONNECTION LISTENER", "Closed on error", e);

    }

    public void reconnectionSuccessful() {
        Log.i("CONNECTION LISTENER", "Reconnected");
    }

    public void reconnectingIn(int i) {

    }

    public void reconnectionFailed(Exception e) {

    }
}
