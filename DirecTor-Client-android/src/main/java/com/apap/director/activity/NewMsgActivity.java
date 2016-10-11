package com.apap.director.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.dao.model.DaoSession;
import com.apap.director.dao.model.Message;
import com.apap.director.dao.model.MessageDao;

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

        // TODO: Loading from DATABASE the messages sent so far
        messages_list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                messages_list);

        messagesView.setAdapter(arrayAdapter);

        messagesView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DaoSession daoSession = ((App) getApplicationContext()).getMessageDaoSession();
                MessageDao messageDao = daoSession.getMessageDao();
                messages_list.remove(position);
                //TODO: Removing messages from database (by conversationId or something else)
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public void onClick(View view) {
        DaoSession daoSession = ((App) getApplicationContext()).getMessageDaoSession();
        MessageDao messageDao = daoSession.getMessageDao();
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

        //TODO: Messages don't get saved in the database
        messageDao.insert(message);

        arrayAdapter.notifyDataSetChanged();
    }

}


