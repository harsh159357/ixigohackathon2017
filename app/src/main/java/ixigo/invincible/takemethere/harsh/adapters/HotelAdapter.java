package ixigo.invincible.takemethere.harsh.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.customview.TextViewCustom;
import ixigo.invincible.takemethere.harsh.interfaces.Constants;
import ixigo.invincible.takemethere.harsh.models.hotels.DataHotels;

public class HotelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {

    private final int VIEW_ITEM_DATA = 1;
    private ArrayList<Object> objectArrayList;
    private Context context;

    private class HotelViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextViewCustom textViewHotelName;

        HotelViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.iv_recommendation);
            textViewHotelName = (TextViewCustom) view.findViewById(R.id.tv_hotel_name);
        }
    }

    public HotelAdapter(ArrayList<Object> objectArrayList, Context context) {
        this.objectArrayList = objectArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case VIEW_ITEM_DATA:
                View dataView = inflater.inflate(R.layout.item_hotels, viewGroup, false);
                viewHolder = new HotelViewHolder(dataView);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.item_hotels, viewGroup, false);
                viewHolder = new HotelViewHolder(defaultView);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (objectArrayList.get(position) instanceof DataHotels) {
            return VIEW_ITEM_DATA;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIEW_ITEM_DATA:
                HotelViewHolder hotelViewHolder = (HotelViewHolder) viewHolder;
                configureHotelistViewHolder(hotelViewHolder, position);
                break;
            default:
                HotelViewHolder defaultViewHolder = (HotelViewHolder) viewHolder;
                configureHotelistViewHolder(defaultViewHolder, position);
                break;
        }
    }

    private void configureHotelistViewHolder(HotelViewHolder hotelViewHolder, int position) {
        DataHotels dataHotels = (DataHotels) objectArrayList.get(position);
        DrawableRequestBuilder drawableRequestBuilder = Glide.with(context)
                .load(dataHotels.getKeyImageUrl())
                .fitCenter()
                .animate(android.R.anim.fade_in);
        drawableRequestBuilder.placeholder(R.drawable.placeholder);
        drawableRequestBuilder.into(hotelViewHolder.imageView);
        hotelViewHolder.textViewHotelName.setText(dataHotels.getName());
    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

}