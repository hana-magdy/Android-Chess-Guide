package com.example.chessguide;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFrag extends ListFragment {

    ItemSelected activity;
   public interface ItemSelected{
        void OnItemSelection(int index);

    }



    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        activity=(ItemSelected) context;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] pieces = getResources().getStringArray(R.array.pieces);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, pieces){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item

                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setBackgroundColor(Color.BLACK);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.WHITE);

                // Generate ListView Item using TextView
                return view;
            }
        };

        // DataBind ListView with items from ArrayAdapter
        setListAdapter(arrayAdapter);


    }


    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
       activity.OnItemSelection(position);
    }
}
