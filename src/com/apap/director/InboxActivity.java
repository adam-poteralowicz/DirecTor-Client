package com.apap.director;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2016-10-05.
 */
public class InboxActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox_view);

        ListView list = (ListView) findViewById(R.id.msgList);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open msgView of a SPECIFIED conversation
                Intent selectedIntent = new Intent(InboxActivity.this, NewMsgActivity.class);
                startActivityForResult(selectedIntent, 0005);
            }
        });


    }

    public List<String> getMsg() {
        List<String> list = new ArrayList<String>();

        // SQL query to get msgList
        return list;
    }
}
