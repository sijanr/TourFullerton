package com.example.android.tourfullerton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SelectedItemActivity extends AppCompatActivity {

    //positions of topics in the main page
    private final int BARS = 0;
    private final int RESTAURANTS = 1;
    private final int SCHOOLS = 2;
    private final int PARKS = 3;

    private RecyclerView mRecyclerView;
    private SelectedItemListAdapter itemListAdapter;
    private ArrayList<SelectedItem> selectedItemArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_list_main);

        //get the position of the topic from the main page
        int position = getIntent().getIntExtra("POSITION", 0);

        //add lists of places with their corresponding information to be displayed in the recycler view depending on the position
        switch (position) {

            // if the user selected bars
            case BARS:
                getSupportActionBar().setTitle("Bars");
                selectedItemArrayList.clear();
                selectedItemArrayList.add(new SelectedItem(R.drawable.the_blue_door_bar, "The Blue Door Bar", getResources().getString(R.string.blue_door_bar_phone), getString(R.string.blue_door_bar_location)));
                selectedItemArrayList.add(new SelectedItem(R.drawable.tribune_bar, "Tribune Bar", getString(R.string.tribune_phone), getString(R.string.tribune_location)));
                break;

            //if the user selects restaurants
            case RESTAURANTS:
                getSupportActionBar().setTitle("Restaurants");
                selectedItemArrayList.clear();
                selectedItemArrayList.add(new SelectedItem(R.drawable.citizen_kitchen_restaurant, "Citizen Kitchen", "(714) 635-9027", "1500 S Raymond Ave, Fullerton, CA 92831 "));
                selectedItemArrayList.add(new SelectedItem(R.drawable.j_korean_cuisine_restaurant, "J's Korean Cuisine", "(714) 519-3360", "114 W Commonwealth Ave, Fullerton, CA 92832 "));
                break;


        }

        //find the handle and set the adapter of the recycler view
        mRecyclerView = findViewById(R.id.selected_item_recycler_view);
        itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList);
        mRecyclerView.setAdapter(itemListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
