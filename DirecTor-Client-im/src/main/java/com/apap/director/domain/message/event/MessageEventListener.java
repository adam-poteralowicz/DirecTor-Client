package com.apap.director.domain.message.event;

import android.util.Log;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;

public class MessageEventListener implements ChatMessageListener{
    public void processMessage(Chat chat, Message message) {
        Log.i("MessageEvenListener", message.getFrom()+": "+message.getBody());
    }
}
