package com.apap.director;

import android.app.Application;
import android.content.Context;
import com.apap.director.config.dagger.ChatComponent;

/**
 * Created by Adam on 2016-10-09.
 */
    public class App extends Application {

        private static Context mContext;

        ChatComponent chatComponent;

        @Override
        public void onCreate() {
            super.onCreate();

            mContext = this;

            chatComponent = new ChatComponent();
        }

        public static Context getContext(){
            return mContext;
        }
    }
