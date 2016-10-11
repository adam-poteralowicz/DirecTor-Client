package com.apap.director.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.dao.model.*;

import java.util.ArrayList;
import java.util.Date;

public class NewMsgActivity extends Activity {
    EditText newMessageField;
    TextView recipient;
    ListView messagesView;
    ArrayList<String> messages_list;
    ArrayAdapter<String> arrayAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_msg_view);

        messagesView = (ListView) findViewById(R.id.conversationView);
        newMessageField = (EditText) findViewById(R.id.messengerField);
        recipient = (TextView) findViewById(R.id.newMsgRecipient);
        if (getIntent().getStringExtra("recipient") != null) {
            recipient.setText(getIntent().getStringExtra("recipient"));
        } else {
            recipient.setText(getIntent().getStringExtra("msgTitle"));
        }

        DaoSession daoSession = ((App) getApplicationContext()).getConversationDaoSession();
        ConversationDao conversationDao = daoSession.getConversationDao();
        final Conversation conversation = conversationDao.load(String.valueOf(recipient.getText()));

        messages_list = new ArrayList<String>();
        if (!conversation.getMessages().isEmpty()) {
            for (int i = 0; i < conversation.getMessages().size(); i++) {
                messages_list.add(conversation.getMessages().get(i).getContent());
            }
        }
        arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                messages_list);

        messagesView.setAdapter(arrayAdapter);

        messagesView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                messages_list.remove(position);
                conversation.getMessages().remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public void onClick(View view) {
        DaoSession daoSession = ((App) getApplicationContext()).getConversationDaoSession();
        ConversationDao conversationDao = daoSession.getConversationDao();
        Message message = new Message();
        message.setRecipient(String.valueOf(recipient.getText()));
        message.setDate(new Date());

        String messageText = String.valueOf(newMessageField.getText());
        if ("".equals(messageText)) {
            messages_list.add("Sending empty message for fun!");
            message.setContent("Sending empty message for fun!");
        } else {
            messages_list.add(String.valueOf(newMessageField.getText()));
            message.setContent(String.valueOf(newMessageField.getText()));
        }

        Conversation conversation = conversationDao.load(String.valueOf(recipient.getText()));
        conversation.getMessages().add(message);

        arrayAdapter.notifyDataSetChanged();
    }

}


