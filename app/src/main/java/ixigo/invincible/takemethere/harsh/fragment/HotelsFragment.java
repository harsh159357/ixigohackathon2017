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
import ixigo.invincible.takemethere.harsh.adapters.HotelAdapter;
import ixigo.invincible.takemethere.harsh.models.hotels.HotelsData;


public class HotelsFragment extends BaseFragment {

    private View rootView;
    private AnyOfTheseHotelsPlacesToVisitThingsToDoActivity anyOfTheseHotelsPlacesToVisitThingsToDoActivity;
    private HotelAdapter hotelAdapter;
    public RecyclerView recyclerViewHotel;
    private ArrayList<Object> objectArrayList = new ArrayList<>();
    private HotelsData data;

    public HotelsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        objectArrayList.addAll(TakeMeThereApplication.getInstance().getHotelsData().getHotelsArrayList());
        anyOfTheseHotelsPlacesToVisitThingsToDoActivity = (AnyOfTheseHotelsPlacesToVisitThingsToDoActivity) context;
        recyclerViewHotel = (RecyclerView) rootView.findViewById(R.id.recycler_view_hotels);
        hotelAdapter = new HotelAdapter(objectArrayList, anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(anyOfTheseHotelsPlacesToVisitThingsToDoActivity);
        recyclerViewHotel.setLayoutManager(mLayoutManager);
        recyclerViewHotel.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHotel.setAdapter(hotelAdapter);
        return rootView;
    }

    @Override
    public String getFragmentName() {
        return HotelsFragment.class.getSimpleName();
    }

}
