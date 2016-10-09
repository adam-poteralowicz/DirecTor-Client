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
import com.apap.director.activity.NewMsgActivity;

import java.util.ArrayList;
import java.util.List;

public class InboxFragment extends Fragment {

    Intent intent;

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

        final List<String> my_messages_list = new ArrayList<String>();
        my_messages_list.add("Conversation 1");
        my_messages_list.add("Conversation 2");
        my_messages_list.add("Conversation 3");
        my_messages_list.add("Conversation 4");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                App.getContext(),
                android.R.layout.simple_list_item_1,
                my_messages_list);

        msgListView.setAdapter(arrayAdapter);

        intent = new Intent(App.getContext(), NewMsgActivity.class);

        msgListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(App.getContext(), my_messages_list.get(position), Toast.LENGTH_LONG).show();
                intent.putExtra("msgTitle", my_messages_list.get(position));
                startActivity(intent);
            }
        });

    }
}
