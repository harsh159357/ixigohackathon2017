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
import ixigo.invincible.takemethere.harsh.interfaces.RecommendationClickListener;
import ixigo.invincible.takemethere.harsh.models.recommendations.FlightData;

public class RecommendationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {

    private final int VIEW_ITEM_DATA = 1;
    private ArrayList<Object> objectArrayList;
    private Context context;
    private RecommendationClickListener recommendationClickListener;

    private class LabListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RecommendationClickListener recommendationClickListener;
        ImageView imageView;
        TextViewCustom textViewPlacesToVisit;
        TextViewCustom textViewThingsToDo;
        TextViewCustom textViewHotels;
        TextViewCustom textViewBudget;

        LabListViewHolder(View view, RecommendationClickListener recommendationClickListener) {
            super(view);
            this.recommendationClickListener = recommendationClickListener;
            imageView = (ImageView) view.findViewById(R.id.iv_recommendation);
            textViewPlacesToVisit = (TextViewCustom) view.findViewById(R.id.tv_places_to_visit);
            textViewThingsToDo = (TextViewCustom) view.findViewById(R.id.tv_things_to_do);
            textViewHotels = (TextViewCustom) view.findViewById(R.id.tv_hotels);
            textViewBudget = (TextViewCustom) view.findViewById(R.id.tv_budget);
            imageView.setOnClickListener(this);
            textViewPlacesToVisit.setOnClickListener(this);
            textViewThingsToDo.setOnClickListener(this);
            textViewHotels.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            FlightData flightData = (FlightData) objectArrayList.get(getAdapterPosition());
            switch (view.getId()) {
                case R.id.iv_recommendation:
                    recommendationClickListener.onImageViewClick(flightData);
                    break;
                case R.id.tv_places_to_visit:
                    recommendationClickListener.onPlacesToVisitClick(flightData);
                    break;
                case R.id.tv_things_to_do:
                    recommendationClickListener.onThingsToDoClick(flightData);
                    break;
                case R.id.tv_hotels:
                    recommendationClickListener.onHotelsClick(flightData);
                    break;
            }
        }
    }

    public RecommendationAdapter(ArrayList<Object> objectArrayList, Context context, RecommendationClickListener recommendationClickListener) {
        this.objectArrayList = objectArrayList;
        this.context = context;
        this.recommendationClickListener = recommendationClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case VIEW_ITEM_DATA:
                View dataView = inflater.inflate(R.layout.item_recommendation, viewGroup, false);
                viewHolder = new LabListViewHolder(dataView, recommendationClickListener);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.item_recommendation, viewGroup, false);
                viewHolder = new LabListViewHolder(defaultView, recommendationClickListener);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (objectArrayList.get(position) instanceof FlightData) {
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
        FlightData flightData = (FlightData) objectArrayList.get(position);
        DrawableRequestBuilder drawableRequestBuilder = Glide.with(context)
                .load(flightData.getImage())
                .fitCenter()
                .animate(android.R.anim.fade_in);

        drawableRequestBuilder.placeholder(R.drawable.placeholder);
        drawableRequestBuilder.into(labListViewHolder.imageView);
        if (flightData.getType().equals(BUDGET_FLIGHT)) {
            labListViewHolder.textViewBudget.setVisibility(View.VISIBLE);
        } else {
            labListViewHolder.textViewBudget.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

}