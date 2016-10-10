package com.apap.director.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apap.director.dao.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private final Context context;
    private final List<Contact> contacts;
    private final int textViewResourceId;

    public ContactAdapter(Context context, int textViewResourceId, List<Contact> contacts) {
        super(context, textViewResourceId, contacts);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(textViewResourceId, parent, false);

        }

        return row;
    }
}
