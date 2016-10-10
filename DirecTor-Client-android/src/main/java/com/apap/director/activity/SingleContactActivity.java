package com.apap.director.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.dao.model.ContactDao;
import com.apap.director.dao.model.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class SingleContactActivity extends Activity {

    List<String> myOptionsList = null;

    TextView contactNameView;
    ListView options;
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_contact_view);


        final String contactNameFromIntent = getIntent().getStringExtra("contactName");
        contactNameView = (TextView) findViewById(R.id.contactName);
        contactNameView.setText(contactNameFromIntent);

        options = (ListView) findViewById(R.id.optionsList);

        myOptionsList = new ArrayList<String>();
        myOptionsList.add("Send message");
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
                switch (position) {
                    case 0:
                    {
                        intent = new Intent(App.getContext(), NewMsgActivity.class);
                        intent.putExtra("recipient", contactNameFromIntent);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        DaoSession daoSession = ((App) getApplicationContext()).getDaoSession();
                        final ContactDao contactDao = daoSession.getContactDao();

                        contactDao.queryBuilder().where(ContactDao.Properties.Name.eq(contactNameFromIntent))
                                .buildDelete().executeDeleteWithoutDetachingEntities();

                        intent = new Intent(App.getContext(), AuthUserActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

            Intent selectedIntent = new Intent(SingleContactActivity.this, AuthUserActivity.class);
            startActivityForResult(selectedIntent, 0011);

    }


}
