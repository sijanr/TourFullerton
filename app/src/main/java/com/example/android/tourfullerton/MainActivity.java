package com.example.android.tourfullerton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HomeList> listArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add items to the list
        listArray.add(new HomeList("Bars", "Bars to checkout in Fullerton", R.drawable.bar));
        listArray.add(new HomeList("Restaurants", "Few restaurants to give a try", R.drawable.restaurant));
        listArray.add(new HomeList("Schools", "Some of the schools in Fullerton", R.drawable.education));
        listArray.add(new HomeList("Parks", "Major parks located around Fulerton", R.drawable.park));

        //create an adapter to attach to recycler view
        HomeListAdapter viewAdapter = new HomeListAdapter(this, listArray);

        //set the adapter in recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(viewAdapter);


        //open up the activity related to the item clicked
        viewAdapter.setItemClickListener(new HomeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, BarsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
