package com.example.android.tourfullerton;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstBarFragment extends Fragment {


    public FirstBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.item_description_fragment, container, false);

        TextView title = itemView.findViewById(R.id.item_title);
        title.setText(getResources().getString(R.string.the_blue_door_bar));

        ImageView image = itemView.findViewById(R.id.item_image);
        Glide.with(itemView).load(R.drawable.the_blue_door_bar).into(image);

        TextView phoneNumber = itemView.findViewById(R.id.item_phone);
        phoneNumber.setText(getResources().getString(R.string.blue_door_bar_phone));

        TextView location = itemView.findViewById(R.id.item_location);
        location.setText(getResources().getString(R.string.blue_door_bar_location));

        return itemView;
    }

}
