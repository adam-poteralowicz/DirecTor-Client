package com.apap.director.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import com.apap.director.dao.model.Contact;
import com.apap.director.dao.model.ContactDao;
import com.apap.director.dao.model.DaoMaster;
import com.apap.director.dao.model.DaoSession;

import java.util.List;

public class ContactsFragment extends Fragment {

    public AuthUserActivity aua;
    Intent intent;
    List<Contact> my_contacts_list = null;
    List<Contact> my_contacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.contacts_view, container, false);

        aua = (AuthUserActivity) getActivity();



        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        ListView contactsListView = (ListView) getActivity().findViewById(R.id.contactsView);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getContext(), "contact-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        ContactDao contactDao = daoSession.getContactDao();
        insertSampleContacts(daoSession);
        List<Contact> contactsList = contactDao.loadAll();
        for (int i = 0; i < contactsList.size(); i++) {
//            System.out.println(contactsList.get(i));
            Toast.makeText(App.getContext(), contactsList.get(i).getName(), Toast.LENGTH_SHORT).show();
        }

//        if (my_contacts_list == null) {
//
//            my_contacts_list = new ArrayList<Contact>();
//            my_contacts_list = my_contacts;
//            //getInitialContacts();
//        }

        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<Contact>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                contactsList);
        contactsListView.setAdapter(arrayAdapter);

        intent = new Intent(App.getContext(), SingleContactActivity.class);
        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(App.getContext(), my_contacts_list.get(position), Toast.LENGTH_LONG).show();
                //intent.put("contacts", (ArrayList<Contact>) my_contacts_list);
                //intent.putExtra("contactName", my_contacts_list.get(position));
                //startActivity(intent);



            }
        });

//        if (AuthUserActivity.NEW_CONTACT_ADDED) {
//            Toast.makeText(App.getContext(), aua.getNewContact(), Toast.LENGTH_LONG).show();
//            my_contacts_list.add(aua.getNewContact());
//            AuthUserActivity.NEW_CONTACT_ADDED = false;
//            arrayAdapter.notifyDataSetChanged();
//        }

//        Toast.makeText(App.getContext(), "DELETE: "+aua.getUserToDelete(), Toast.LENGTH_LONG).show();
//        my_contacts_list.remove(aua.getUserToDelete());
//        arrayAdapter.notifyDataSetChanged();
    }

//    public void getInitialContacts() {
//        my_contacts_list = new ArrayList<String>();
//        my_contacts_list.add("Woland");
//        my_contacts_list.add("Behemot");
//        my_contacts_list.add("Malgorzata");
//        my_contacts_list.add("Mistrz");
//    }

    public void insertSampleContacts(DaoSession daoSession) {
        ContactDao contactDao = daoSession.getContactDao();
        contactDao.deleteAll();
        insertContact("Woland", daoSession);
        insertContact("Behemot", daoSession);
        insertContact("Malgorzata", daoSession);
        insertContact("Mistrz", daoSession);
        insertContact("Wokulski", daoSession);
    }

    public void insertContact(String name, DaoSession daoSession) {
        Contact contact = new Contact();
        contact.setName(name);
        ContactDao contactDao = daoSession.getContactDao();
        contactDao.insertOrReplace(contact);
    }
}
