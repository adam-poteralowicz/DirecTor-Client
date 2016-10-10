package com.apap.director.dao;

import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

import java.io.IOException;

/**
 * Created by Adam on 2016-10-10.
 */
public class DaoGenerator extends org.greenrobot.greendao.generator.DaoGenerator {

    public DaoGenerator() throws IOException {
    }

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(1, "com.apap.director.dao.model");

        Entity contact = schema.addEntity("Contact");
        contact.addStringProperty("name").notNull();

        new DaoGenerator().generateAll(schema, "../DirecTor-Client/DirecTor-Client-android/src/main/java");
    }
}
