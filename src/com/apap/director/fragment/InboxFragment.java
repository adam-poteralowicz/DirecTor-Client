package com.apap.director.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.apap.director.App;
import com.apap.director.R;

import java.util.ArrayList;
import java.util.List;

public class InboxFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.inbox_view, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView msgListView = (ListView) getActivity().findViewById(R.id.msgList);

        List<String> my_messages_list = new ArrayList<String>();
        my_messages_list.add("Conversation 1");
        my_messages_list.add("Conversation 2");
        my_messages_list.add("Conversation 3");
        my_messages_list.add("Conversation 4");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                my_messages_list);

        msgListView.setAdapter(arrayAdapter);


        msgListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
