package com.apap.director.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.activity.AuthUserActivity;
import com.apap.director.activity.SingleContactActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    AuthUserActivity aua = new AuthUserActivity();
    Intent intent;
    List<String> my_contacts_list = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.contacts_view, container, false);

        return rootView;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            my_contacts_list = aua.getContacts();
        }
        super.onActivityCreated(savedInstanceState);



        ListView contactsListView = (ListView) getActivity().findViewById(R.id.contactsView);

        if (my_contacts_list == null) {
            getInitialContacts();

        }
//        //if (NEW_CONTACT_ADDED) {
//        if (aua.getNewContact() != null) {
//            Toast.makeText(App.getContext(), aua.getNewContact(), Toast.LENGTH_LONG).show();
//            my_contacts_list.add(aua.getNewContact());
//        }
        //}

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                my_contacts_list);

        contactsListView.setAdapter(arrayAdapter);

        intent = new Intent(App.getContext(), SingleContactActivity.class);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(App.getContext(), my_contacts_list.get(position), Toast.LENGTH_LONG).show();
                intent.putStringArrayListExtra("contacts", (ArrayList<String>) my_contacts_list);
                intent.putExtra("contactName", my_contacts_list.get(position));
                startActivity(intent);
            }
        });
    }

    public void getInitialContacts() {
        my_contacts_list = new ArrayList<String>();
        my_contacts_list.add("Woland");
        my_contacts_list.add("Behemot");
        my_contacts_list.add("Malgorzata");
        my_contacts_list.add("Mistrz");
    }
}
