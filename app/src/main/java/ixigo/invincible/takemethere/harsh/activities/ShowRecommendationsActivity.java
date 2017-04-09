package ixigo.invincible.takemethere.harsh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.TakeMeThereApplication;
import ixigo.invincible.takemethere.harsh.adapters.RecommendationAdapter;
import ixigo.invincible.takemethere.harsh.interfaces.RecommendationClickListener;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.models.hotels.HotelsData;
import ixigo.invincible.takemethere.harsh.models.placestovisit.PlacesToVisitData;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data;
import ixigo.invincible.takemethere.harsh.models.recommendations.FlightData;
import ixigo.invincible.takemethere.harsh.models.thingstodo.ThingsToDoData;
import ixigo.invincible.takemethere.harsh.requesters.AnyOfTheseThingsToDoPlacesToVisitHotelsRequester;
import ixigo.invincible.takemethere.harsh.requesters.RecommendationRequester;
import ixigo.invincible.takemethere.harsh.util.BackgroundExecutor;

public class ShowRecommendationsActivity extends BaseActivity implements RecommendationClickListener {

    public static final String CLICK_TYPE = "CLICK_TYPE";
    @BindView(R.id.recycler_view_recommendation)
    public RecyclerView recyclerViewRecommendation;
    private RecommendationAdapter recommendationAdapter;
    private ArrayList<Object> objectArrayList = new ArrayList<>();
    private Data data;
    private String cityId = "";
    private String clickType = "";

    @Override
    protected int getLayout() {
        return R.layout.activity_show_recommendations;
    }

    @Subscribe
    @Override
    public void onEvent(final EventObject eventObject) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dismissProgress();
                switch (eventObject.getId()) {
                    case Events.GET_RECOMMENDATION_SUCCESSFUL:
                        Toast.makeText(ShowRecommendationsActivity.this, "Get Recommendation SuccessFull", Toast.LENGTH_SHORT).show();
                        data = (Data) eventObject.getObject();
                        objectArrayList.addAll(data.getFlight());
                        objectArrayList.addAll(data.getBudget_flight());
                        recommendationAdapter.notifyDataSetChanged();
                        break;
                    case Events.GET_RECOMMENDATION_FAILED:
                        Toast.makeText(ShowRecommendationsActivity.this, "Get Recommendation Failed", Toast.LENGTH_SHORT).show();
                        break;
                    case Events.NO_INTERNET_CONNECTION:
                        Toast.makeText(ShowRecommendationsActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                        break;


                    case Events.GET_PLACES_TO_VISIT_SUCCESSFUL:
                        showProgress(ProgressDialogsToastsText.PLEASE_WAIT);
                        TakeMeThereApplication.getInstance().setPlacesToVisitData((PlacesToVisitData) eventObject.getObject());
                        BackgroundExecutor.getInstance().execute(new AnyOfTheseThingsToDoPlacesToVisitHotelsRequester(cityId, Types.HOTEL));
                        break;
                    case Events.GET_PLACES_TO_VISIT_FAILED:
                        Toast.makeText(ShowRecommendationsActivity.this, "Get Places To Visit Failed", Toast.LENGTH_SHORT).show();
                        break;


                    case Events.GET_HOTELS_SUCCESSFUL:
                        showProgress(ProgressDialogsToastsText.PLEASE_WAIT);
                        TakeMeThereApplication.getInstance().setHotelsData((HotelsData) eventObject.getObject());
                        BackgroundExecutor.getInstance().execute(new AnyOfTheseThingsToDoPlacesToVisitHotelsRequester(cityId, Types.THINGS_TO_DO));
                        break;
                    case Events.GET_HOTELS_FAILED:
                        Toast.makeText(ShowRecommendationsActivity.this, "Get Hotels Failed", Toast.LENGTH_SHORT).show();
                        break;


                    case Events.GET_THINGS_TO_DO_SUCCESSFUL:
                        TakeMeThereApplication.getInstance().setThingsToDoData((ThingsToDoData) eventObject.getObject());
                        Intent intent = new Intent(ShowRecommendationsActivity.this, AnyOfTheseHotelsPlacesToVisitThingsToDoActivity.class);
                        intent.putExtra(CLICK_TYPE,clickType);
                        startActivity(intent);
                        break;
                    case Events.GET_THINGS_TO_DO_FAILED:
                        Toast.makeText(ShowRecommendationsActivity.this, "Get Things To Do Failed", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recommendationAdapter = new RecommendationAdapter(objectArrayList, this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewRecommendation.setLayoutManager(mLayoutManager);
        recyclerViewRecommendation.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRecommendation.setAdapter(recommendationAdapter);
        BackgroundExecutor.getInstance().execute(new RecommendationRequester());
        showProgress(ProgressDialogsToastsText.LOADING_RECOMMENDATION);
    }

    @Override
    public void onImageViewClick(final FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                clickType = Types.PLACES_TO_VISIT;
                getData(flightData);
            }
        });
    }

    @Override
    public void onPlacesToVisitClick(final FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                clickType = Types.PLACES_TO_VISIT;
                getData(flightData);
            }
        });
    }

    @Override
    public void onThingsToDoClick(final FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                clickType = Types.THINGS_TO_DO;
                getData(flightData);
            }
        });
    }

    @Override
    public void onHotelsClick(final FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                clickType = Types.HOTEL;
                getData(flightData);
            }
        });
    }

    private void getData(FlightData flightData) {
        cityId = flightData.getCityId();
        showProgress(ProgressDialogsToastsText.PLEASE_WAIT);
        BackgroundExecutor.getInstance().execute(new AnyOfTheseThingsToDoPlacesToVisitHotelsRequester(cityId, Types.PLACES_TO_VISIT));
    }
}
