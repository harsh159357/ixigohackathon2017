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
import ixigo.invincible.takemethere.harsh.adapters.ThingsToDoAdapter;


public class ThingsToDoFragment extends BaseFragment {

    private View rootView;
    private AnyOfTheseHotelsPlacesToVisitThingsToDoActivity anyOfTheseHotelsPlacesToVisitThingsToDoActivity;
    private ThingsToDoAdapter thingsToDoAdapter;
    public RecyclerView recyclerViewThingsToDo;
    private ArrayList<Object> objectArrayList = new ArrayList<>();

    public ThingsToDoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_things_to_do, container, false);
        objectArrayList.addAll(TakeMeThereApplication.getInstance().getThingsToDoData().getThingsToDoArrayList());
        recyclerViewThingsToDo = (RecyclerView) rootView.findViewById(R.id.recycler_view_things_to_do);
        anyOfTheseHotelsPlacesToVisitThingsToDoActivity = (AnyOfTheseHotelsPlacesToVisitThingsToDoActivity) context;
        thingsToDoAdapter = new ThingsToDoAdapter(objectArrayList, anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        recyclerViewThingsToDo.setLayoutManager(mLayoutManager);
        recyclerViewThingsToDo.setItemAnimator(new DefaultItemAnimator());
        recyclerViewThingsToDo.setAdapter(thingsToDoAdapter);
        return rootView;
    }

    @Override
    public String getFragmentName() {
        return ThingsToDoFragment.class.getSimpleName();
    }

}
