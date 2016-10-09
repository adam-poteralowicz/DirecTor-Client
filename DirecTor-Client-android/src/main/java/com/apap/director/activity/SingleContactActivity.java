package com.apap.director.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.apap.director.App;
import com.apap.director.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2016-10-09.
 */
public class SingleContactActivity extends Activity {

    List<String> contacts = null;
    List<String> myOptionsList = null;

    TextView contactNameView;
    ListView options;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_contact_view);

        contacts = getIntent().getStringArrayListExtra("contacts");
        String contactNameFromIntent = getIntent().getStringExtra("contactName");
        contactNameView = (TextView) findViewById(R.id.contactName);
        contactNameView.setText(contactNameFromIntent);

        options = (ListView) findViewById(R.id.optionsList);

        myOptionsList = new ArrayList<String>();
        myOptionsList.add("Send message");
        myOptionsList.add("See conversation");
        myOptionsList.add("Delete from contacts");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                myOptionsList);

        options.setAdapter(arrayAdapter);
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(App.getContext(), myOptionsList.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {

            Intent selectedIntent = new Intent(SingleContactActivity.this, AuthUserActivity.class);
            selectedIntent.putStringArrayListExtra("contacts", (ArrayList<String>) contacts);
            startActivityForResult(selectedIntent, 0011);

    }


}
