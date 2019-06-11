package com.example.android.tourfullerton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {

    private ArrayList<HomeList> homeList = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    /**
     * Constructor that initializes context and list data
     */
    public HomeListAdapter(Context context, ArrayList<HomeList> homeList) {
        this.homeList = homeList;
        mContext = context;
    }


    /**
     * Inflate the layout to hold the items in the list of data
     *
     * @param viewGroup ViewGroup on which the data will be added
     * @param i         viewtype of the new view
     * @return New ViewHolder
     */
    @NonNull
    @Override
    public HomeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false));
    }


    /**
     * Binds the data to the ViewHolder
     *
     * @param viewHolder The viewholder in which the data is to be binded
     * @param i          The adapter position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HomeList currentItem = homeList.get(i);

        viewHolder.title.setText(currentItem.getTitle());
        viewHolder.titleDetail.setText(currentItem.getTitleDetail());
        Glide.with(mContext).load(currentItem.getImageResourceID()).into(viewHolder.titleImage);
    }


    /**
     * Size of the data set
     *
     * @return The data set size
     */
    @Override
    public int getItemCount() {
        return homeList.size();
    }

    /**
     * ViewHolder class that represents each of the list data item layout
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView titleDetail;
        private ImageView titleImage;

        /**
         * ViewHolder constructor
         *
         * @param itemView The root view of the list_item layout file
         */
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_title);
            titleDetail = itemView.findViewById(R.id.title_detail);
            titleImage = itemView.findViewById(R.id.title_image_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if(index!= RecyclerView.NO_POSITION){
                        listener.onItemClick(index);
                    }
                }
            });
        }
    }
}
