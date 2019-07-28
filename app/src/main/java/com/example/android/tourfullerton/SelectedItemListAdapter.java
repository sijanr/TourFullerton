package com.example.android.tourfullerton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectedItemListAdapter extends RecyclerView.Adapter<SelectedItemListAdapter.ItemsViewHolder> {

    //array list of places
    private ArrayList<SelectedItem> itemArrayList;

    private LayoutInflater mLayoutInflater;

    private int textTitleColor;

    //initialize the layout inflater and list data
    public SelectedItemListAdapter(Context context, ArrayList<SelectedItem> itemArrayList, int titleColor) {
        this.itemArrayList = itemArrayList;
        mLayoutInflater = LayoutInflater.from(context);
        this.textTitleColor = titleColor;
    }


    //view that holds a place information layout
    class ItemsViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemPhone;
        private TextView itemLocation;
        private ImageButton itemPhoneButton;

        //constructor to get the views that need to be used to populate with the list data
        public ItemsViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.text_title);
            itemPhone = itemView.findViewById(R.id.phone_text_view);
            itemLocation = itemView.findViewById(R.id.location_text_view);
            itemPhoneButton = itemView.findViewById(R.id.phone_button);
            itemTitle.setTextColor(textTitleColor);
        }
    }


    //inflate the layout to handle the view to display data appropriately
    @NonNull
    @Override
    public SelectedItemListAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.activity_selected_list_template, viewGroup, false);
        return new ItemsViewHolder(itemView);
    }


    //bind the data to the viewholder at the position
    @Override
    public void onBindViewHolder(@NonNull SelectedItemListAdapter.ItemsViewHolder itemsViewHolder, int i) {
        itemsViewHolder.itemImage.setImageResource(itemArrayList.get(i).getImageResourceID());
        itemsViewHolder.itemTitle.setText(itemArrayList.get(i).getItemTitle());
        if (itemArrayList.get(i).getItemPhoneNumber().equals("")) {
            itemsViewHolder.itemPhone.setVisibility(View.GONE);
            itemsViewHolder.itemPhoneButton.setVisibility(View.GONE);
        } else {
            itemsViewHolder.itemPhone.setText(itemArrayList.get(i).getItemPhoneNumber());
        }
        itemsViewHolder.itemLocation.setText(itemArrayList.get(i).getItemAddress());

    }

    //get the total set of places
    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }
}
