package ixigo.invincible.takemethere.harsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.TakeMeThereApplication;
import ixigo.invincible.takemethere.harsh.activities.AnyOfTheseHotelsPlacesToVisitThingsToDoActivity;
import ixigo.invincible.takemethere.harsh.adapters.PlacesToVisitAdapter;
import ixigo.invincible.takemethere.harsh.models.placestovisit.PlacesToVisitData;


public class PlacesToVisitFragment extends BaseFragment {

    private View rootView;
    private AnyOfTheseHotelsPlacesToVisitThingsToDoActivity anyOfTheseHotelsPlacesToVisitThingsToDoActivity;
    private PlacesToVisitAdapter placesToVisitAdapter;
    public RecyclerView recyclerViewPlacesToVisit;
    private ArrayList<Object> objectArrayList = new ArrayList<>();
    private PlacesToVisitData placesToVisitData;

    public PlacesToVisitFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_places_to_visit, container, false);
        objectArrayList.addAll(TakeMeThereApplication.getInstance().getPlacesToVisitData().getPlacesToVisitArrayList());
        recyclerViewPlacesToVisit = (RecyclerView) rootView.findViewById(R.id.recycler_view_places_to_visit);
        anyOfTheseHotelsPlacesToVisitThingsToDoActivity = (AnyOfTheseHotelsPlacesToVisitThingsToDoActivity) context;
        placesToVisitAdapter = new PlacesToVisitAdapter(objectArrayList, anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        recyclerViewPlacesToVisit.setLayoutManager(mLayoutManager);
        recyclerViewPlacesToVisit.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPlacesToVisit.setAdapter(placesToVisitAdapter);
        return rootView;
    }

    @Override
    public String getFragmentName() {
        return PlacesToVisitFragment.class.getSimpleName();
    }

}
