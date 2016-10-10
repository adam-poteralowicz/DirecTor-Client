package main.java.com.apap.director;

import android.app.Application;
import android.content.Context;

/**
 * Created by Adam on 2016-10-09.
 */
    public class App extends Application {

        private static Context mContext;

        @Override
        public void onCreate() {
            super.onCreate();
            mContext = this;
        }

        public static Context getContext(){
            return mContext;
        }
    }
