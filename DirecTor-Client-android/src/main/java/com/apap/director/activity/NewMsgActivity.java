package com.apap.director.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.dao.model.Conversation;
import com.apap.director.dao.model.ConversationDao;
import com.apap.director.dao.model.DaoSession;
import com.apap.director.dao.model.Message;

import java.util.ArrayList;
import java.util.Date;

public class NewMsgActivity extends Activity {
    EditText newMessageField;
    TextView recipient;
    ListView messagesView;
    ArrayList<String> messages_list;
    ArrayAdapter<String> arrayAdapter;
    int msgPosition;
    Conversation conversation;

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
        conversation = conversationDao.load(String.valueOf(recipient.getText()));

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

        messagesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                msgPosition = position;
                registerForContextMenu(messagesView);
                openContextMenu(messagesView);

            }
        });

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, 1, Menu.NONE, "Copy");
        menu.add(Menu.NONE, 2, Menu.NONE, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 1: {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("message", messages_list.get(msgPosition));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(NewMsgActivity.this, "Message copied to clipboard", Toast.LENGTH_SHORT).show();
                break;
            }
            case 2: {
                messages_list.remove(msgPosition);
                conversation.getMessages().remove(msgPosition);
                arrayAdapter.notifyDataSetChanged();
                break;
            }
        }

        return super.onContextItemSelected(item);
    }

}


