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
import ixigo.invincible.takemethere.harsh.models.thingstodo.DataThingsToDo;

public class ThingsToDoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {

    private final int VIEW_ITEM_DATA = 1;
    private ArrayList<Object> objectArrayList;
    private Context context;

    private class ThingsToDoViewHolder extends RecyclerView.ViewHolder {
        TextViewCustom textViewThingsToDo;

        ThingsToDoViewHolder(View view) {
            super(view);
            textViewThingsToDo = (TextViewCustom) view.findViewById(R.id.tv_things_to_do);
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
                viewHolder = new ThingsToDoViewHolder(dataView);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.item_things_to_do, viewGroup, false);
                viewHolder = new ThingsToDoViewHolder(defaultView);
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
                ThingsToDoViewHolder thingsToDoViewHolder = (ThingsToDoViewHolder) viewHolder;
                configureLabListViewHolder(thingsToDoViewHolder, position);
                break;
            default:
                ThingsToDoViewHolder defaultViewHolder = (ThingsToDoViewHolder) viewHolder;
                configureLabListViewHolder(defaultViewHolder, position);
                break;
        }
    }

    private void configureLabListViewHolder(ThingsToDoViewHolder thingsToDoViewHolder, int position) {
        DataThingsToDo dataThingsToDo = (DataThingsToDo) objectArrayList.get(position);
        thingsToDoViewHolder.textViewThingsToDo.setText(dataThingsToDo.getAddress() + "\n" +
                dataThingsToDo.getCityName() + "\n" + dataThingsToDo.getStateName());
    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

}