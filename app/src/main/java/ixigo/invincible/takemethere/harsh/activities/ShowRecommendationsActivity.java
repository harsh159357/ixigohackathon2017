package ixigo.invincible.takemethere.harsh.activities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.adapters.RecommendationAdapter;
import ixigo.invincible.takemethere.harsh.interfaces.RecommendationClickListener;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data;
import ixigo.invincible.takemethere.harsh.models.recommendations.FlightData;
import ixigo.invincible.takemethere.harsh.requesters.RecommendationRequester;
import ixigo.invincible.takemethere.harsh.util.BackgroundExecutor;

public class ShowRecommendationsActivity extends BaseActivity implements RecommendationClickListener {

    private RecommendationAdapter recommendationAdapter;
    @BindView(R.id.recycler_view_recommendation)
    public RecyclerView recyclerViewRecommendation;
    private ArrayList<Object> objectArrayList = new ArrayList<>();
    private Data data;

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
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objectArrayList = new ArrayList<>();
        recommendationAdapter = new RecommendationAdapter(objectArrayList, this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewRecommendation.setLayoutManager(mLayoutManager);
        recyclerViewRecommendation.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRecommendation.setAdapter(recommendationAdapter);
        BackgroundExecutor.getInstance().execute(new RecommendationRequester());
        showProgress(ProgressDialogsToastsText.LOADING_RECOMMENDATION);
    }

    @Override
    public void onImageViewClick(FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onPlacesToVisitClick(FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onThingsToDoClick(FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onHotelsClick(FlightData flightData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
