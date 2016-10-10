package main.java.com.apap.director.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import main.java.com.apap.director.App;
import main.java.com.apap.director.R;

import java.util.ArrayList;

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
        messages_list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                messages_list);

        messagesView.setAdapter(arrayAdapter);

        messagesView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                messages_list.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public void onClick(View view) {
        String message = String.valueOf(newMessageField.getText());
        if ("".equals(message)) {
            messages_list.add("Sending empty message for fun!");
        } else {
            messages_list.add(String.valueOf(newMessageField.getText()));
        }

        arrayAdapter.notifyDataSetChanged();
    }

}


