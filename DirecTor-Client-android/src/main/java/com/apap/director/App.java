package com.apap.director;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apap.director.dao.model.DaoMaster;
import com.apap.director.dao.model.DaoSession;

public class App extends Application {

        public DaoSession daoSession;
        private static Context mContext;

        @Override
        public void onCreate() {
            super.onCreate();
            mContext = this;

            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "contact-db", null);
            SQLiteDatabase db = helper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }

        public static Context getContext(){
            return mContext;
        }

        public DaoSession getDaoSession() {
            return daoSession;
        }
    }
