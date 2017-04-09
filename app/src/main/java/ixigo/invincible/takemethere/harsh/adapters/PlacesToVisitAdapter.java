package ixigo.invincible.takemethere.harsh.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.customview.TextViewCustom;
import ixigo.invincible.takemethere.harsh.interfaces.Constants;
import ixigo.invincible.takemethere.harsh.models.placestovisit.DataPlacesToVisit;

public class PlacesToVisitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {

    private final int VIEW_ITEM_DATA = 1;
    private ArrayList<Object> objectArrayList;
    private Context context;

    private class PlacesToVisitViewHolder extends RecyclerView.ViewHolder {
        TextViewCustom textViewPlacesToVisit;

        PlacesToVisitViewHolder(View view) {
            super(view);
            textViewPlacesToVisit = (TextViewCustom) view.findViewById(R.id.tv_places_to_visit);
        }

    }

    public PlacesToVisitAdapter(ArrayList<Object> objectArrayList, Context context) {
        this.objectArrayList = objectArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case VIEW_ITEM_DATA:
                View dataView = inflater.inflate(R.layout.item_places_to_visit, viewGroup, false);
                viewHolder = new PlacesToVisitViewHolder(dataView);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.item_places_to_visit, viewGroup, false);
                viewHolder = new PlacesToVisitViewHolder(defaultView);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (objectArrayList.get(position) instanceof DataPlacesToVisit) {
            return VIEW_ITEM_DATA;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIEW_ITEM_DATA:
                PlacesToVisitViewHolder placesToVisitViewHolder = (PlacesToVisitViewHolder) viewHolder;
                configurePlacesToVisitViewHolder(placesToVisitViewHolder, position);
                break;
            default:
                PlacesToVisitViewHolder defaultViewHolder = (PlacesToVisitViewHolder) viewHolder;
                configurePlacesToVisitViewHolder(defaultViewHolder, position);
                break;
        }
    }

    private void configurePlacesToVisitViewHolder(PlacesToVisitViewHolder placesToVisitViewHolder, int position) {
        DataPlacesToVisit dataPlacesToVisit = (DataPlacesToVisit) objectArrayList.get(position);
        placesToVisitViewHolder.textViewPlacesToVisit.setText(dataPlacesToVisit.getAddress() + "\n" +
                dataPlacesToVisit.getCityName() + "\n" + dataPlacesToVisit.getStateName());
    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

}