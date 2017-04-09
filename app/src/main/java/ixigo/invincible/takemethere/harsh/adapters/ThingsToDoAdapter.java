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
import ixigo.invincible.takemethere.harsh.models.thingstodo.DataThingsToDo;

public class ThingsToDoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {

    private final int VIEW_ITEM_DATA = 1;
    private ArrayList<Object> objectArrayList;
    private Context context;

    private class LabListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextViewCustom textViewPlacesToVisit;
        TextViewCustom textViewThingsToDo;
        TextViewCustom textViewHotels;

        LabListViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.iv_recommendation);
            textViewPlacesToVisit = (TextViewCustom) view.findViewById(R.id.tv_places_to_visit);
            textViewThingsToDo = (TextViewCustom) view.findViewById(R.id.tv_things_to_do);
            textViewHotels = (TextViewCustom) view.findViewById(R.id.tv_hotels);
        }

    }

    public ThingsToDoAdapter(ArrayList<Object> objectArrayList, Context context) {
        this.objectArrayList = objectArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case VIEW_ITEM_DATA:
                View dataView = inflater.inflate(R.layout.item_things_to_do, viewGroup, false);
                viewHolder = new LabListViewHolder(dataView);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.item_things_to_do, viewGroup, false);
                viewHolder = new LabListViewHolder(defaultView);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (objectArrayList.get(position) instanceof DataThingsToDo) {
            return VIEW_ITEM_DATA;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIEW_ITEM_DATA:
                LabListViewHolder labListViewHolder = (LabListViewHolder) viewHolder;
                configureLabListViewHolder(labListViewHolder, position);
                break;
            default:
                LabListViewHolder defaultViewHolder = (LabListViewHolder) viewHolder;
                configureLabListViewHolder(defaultViewHolder, position);
                break;
        }
    }

    private void configureLabListViewHolder(LabListViewHolder labListViewHolder, int position) {
        DataThingsToDo dataThingsToDo = (DataThingsToDo) objectArrayList.get(position);
        DrawableRequestBuilder drawableRequestBuilder = Glide.with(context)
                .load(dataThingsToDo.getAddress())
                .fitCenter()
                .animate(android.R.anim.fade_in);

        drawableRequestBuilder.placeholder(R.drawable.placeholder);
        drawableRequestBuilder.into(labListViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

}