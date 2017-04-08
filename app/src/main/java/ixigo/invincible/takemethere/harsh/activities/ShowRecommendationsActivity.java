package ixigo.invincible.takemethere.harsh.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.adapters.RecommendationAdapter;
import ixigo.invincible.takemethere.harsh.commons.EventObject;

public class ShowRecommendationsActivity extends BaseActivity {

    private RecommendationAdapter recommendationAdapter;
    private RecyclerView recyclerViewRecommendation;
    private ArrayList<Object> objectArrayList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_show_recommendations;
    }

    @Subscribe
    @Override
    public void onEvent(EventObject eventObject) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        To Be Continued
    }
}
