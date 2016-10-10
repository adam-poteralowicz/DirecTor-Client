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
        contact.addStringProperty("name").primaryKey().notNull();
        //Property conversationIdProperty = contact.addLongProperty("conversationId").getProperty();

        Entity conversation = schema.addEntity("Conversation");
        conversation.addIdProperty();
        conversation.addStringProperty("sender").notNull();
        conversation.addStringProperty("recipient").primaryKey().notNull();


        Entity message = schema.addEntity("Message");
        message.addIdProperty();
        message.addStringProperty("sender").notNull();
        message.addStringProperty("recipient").notNull();
        message.addStringProperty("content");
        //Property messageDate =
        message.addDateProperty("date").getProperty();
        //Property conversationId = message.addLongProperty("conversationId").notNull().getProperty();

        // one conversation == many messages
        //ToMany conversationToMessage = conversation.addToMany(message, conversationId);
        //conversationToMessages.setName("messages");
        //conversationToMessage.orderAsc(messageDate);

        // one contact == one conversation
        //contact.addToOne(conversation);

        new DaoGenerator().generateAll(schema, "../DirecTor-Client/DirecTor-Client-android/src/main/java");
    }
}
