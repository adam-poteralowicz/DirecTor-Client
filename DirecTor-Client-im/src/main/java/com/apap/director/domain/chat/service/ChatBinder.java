package com.apap.director.domain.chat.service;

import android.os.Binder;

public class ChatBinder extends Binder {

        ChatService service;

        public ChatBinder(ChatService service){
            this.service = service;
        }

        public ChatService getService() {
            return service;
        }

}
