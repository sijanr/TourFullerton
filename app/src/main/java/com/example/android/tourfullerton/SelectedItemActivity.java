package com.example.android.tourfullerton;

import android.support.v4.content.ContextCompat;
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
                itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList, ContextCompat.getColor(this, R.color.BARS_COLOR));
                break;

            //if the user selects restaurants
            case RESTAURANTS:
                getSupportActionBar().setTitle("Restaurants");
                selectedItemArrayList.clear();
                selectedItemArrayList.add(new SelectedItem(R.drawable.citizen_kitchen_restaurant, "Citizen Kitchen", "(714) 635-9027", "1500 S Raymond Ave, Fullerton, CA 92831 "));
                selectedItemArrayList.add(new SelectedItem(R.drawable.j_korean_cuisine_restaurant, "J's Korean Cuisine", "(714) 519-3360", "114 W Commonwealth Ave, Fullerton, CA 92832 "));
                itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList, ContextCompat.getColor(this, R.color.RESTAURANTS_COLOR));
                break;

            // if the user selects schools
            case SCHOOLS:
                getSupportActionBar().setTitle("Schools");
                selectedItemArrayList.clear();
                selectedItemArrayList.add(new SelectedItem(R.drawable.fullerton_high_school, "Fullerton Union High School", "(714) 626-3800", "201 E. Chapman Ave, Fullerton, CA 92832"));
                selectedItemArrayList.add(new SelectedItem(R.drawable.fullerton_college, "Fullerton College", "(714) 992-7000", "321 E Chapman Avenue, Fullerton, CA 92832"));
                selectedItemArrayList.add(new SelectedItem(R.drawable.california_state_fullerton, "California State University, Fullerton", "(657) 278-2011", "800 N. State College Blvd, Fullerton, CA 92831"));
                itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList, ContextCompat.getColor(this, R.color.SCHOOLS_COLOR));
                break;

            //if the user selects parks
            case PARKS:
                getSupportActionBar().setTitle("Parks");
                selectedItemArrayList.clear();
                selectedItemArrayList.add(new SelectedItem(R.drawable.craig_park, "Craig Regional Park", "(714) 973-3180", "3300 State College Blvd, Fullerton, CA 92832"));
                selectedItemArrayList.add(new SelectedItem(R.drawable.hillcrest_park, "Hillcrest Park", "", "1155 N Lemon St, Fullerton, CA 92832"));
                selectedItemArrayList.add(new SelectedItem(R.drawable.rolling_hills_park, "Rolling Hills Park", "", "1515 E Bastanchury Rd, Fullerton, CA 92835"));
                itemListAdapter = new SelectedItemListAdapter(this, selectedItemArrayList, ContextCompat.getColor(this, R.color.PARKS_COLOR));
                break;

        }

        //find the handle and set the adapter of the recycler view
        mRecyclerView = findViewById(R.id.selected_item_recycler_view);
        mRecyclerView.setAdapter(itemListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
