package com.apap.director.domain.chat.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.apap.director.domain.chat.model.Chat;

public class ChatService extends Service {

    private final IBinder binder = new ChatBinder(this);
    private Chat chat;

    public IBinder onBind(Intent intent) {
        return binder;
    }

    public Chat getChat(){
        return chat;
    }
}
