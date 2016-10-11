package com.apap.director.dao.model;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.apap.director.dao.model.Contact;
import com.apap.director.dao.model.Conversation;
import com.apap.director.dao.model.Message;

import com.apap.director.dao.model.ContactDao;
import com.apap.director.dao.model.ConversationDao;
import com.apap.director.dao.model.MessageDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig contactDaoConfig;
    private final DaoConfig conversationDaoConfig;
    private final DaoConfig messageDaoConfig;

    private final ContactDao contactDao;
    private final ConversationDao conversationDao;
    private final MessageDao messageDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        contactDaoConfig = daoConfigMap.get(ContactDao.class).clone();
        contactDaoConfig.initIdentityScope(type);

        conversationDaoConfig = daoConfigMap.get(ConversationDao.class).clone();
        conversationDaoConfig.initIdentityScope(type);

        messageDaoConfig = daoConfigMap.get(MessageDao.class).clone();
        messageDaoConfig.initIdentityScope(type);

        contactDao = new ContactDao(contactDaoConfig, this);
        conversationDao = new ConversationDao(conversationDaoConfig, this);
        messageDao = new MessageDao(messageDaoConfig, this);

        registerDao(Contact.class, contactDao);
        registerDao(Conversation.class, conversationDao);
        registerDao(Message.class, messageDao);
    }
    
    public void clear() {
        contactDaoConfig.clearIdentityScope();
        conversationDaoConfig.clearIdentityScope();
        messageDaoConfig.clearIdentityScope();
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public ConversationDao getConversationDao() {
        return conversationDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

}
