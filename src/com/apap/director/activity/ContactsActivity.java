package com.apap.director.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.apap.director.NewMsgActivity;
import com.apap.director.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2016-10-05.
 */
public class ContactsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_view);

        ListView list = (ListView) findViewById(R.id.contactsView);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open conversation with a SPECIFIED contact
                Intent selectedIntent = new Intent(ContactsActivity.this, NewMsgActivity.class);
                startActivityForResult(selectedIntent, 0006);
            }
        });


    }

    public List<String> getMsg() {
        List<String> list = new ArrayList<String>();

        // SQL query to get msgList
        return list;
    }
}
