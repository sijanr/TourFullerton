package com.example.android.tourfullerton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class BarsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SelectedItemListAdapter itemListAdapter;
    private ArrayList<SelectedItem> selectedItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_list_main);
        getSupportActionBar().setTitle("Bars");

        //add lists of places with their corresponding information to be displayed in the recycler view
        selectedItemArrayList.add(new SelectedItem(R.drawable.the_blue_door_bar, "The Blue Door Bar", getResources().getString(R.string.blue_door_bar_phone), getString(R.string.blue_door_bar_location)));
        selectedItemArrayList.add(new SelectedItem(R.drawable.tribune_bar, "Tribune Bar", getString(R.string.tribune_phone), getString(R.string.tribune_location)));

        //find the handle and set the adapter of the recycler view
        mRecyclerView = findViewById(R.id.selected_item_recycler_view);
        itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList);
        mRecyclerView.setAdapter(itemListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
