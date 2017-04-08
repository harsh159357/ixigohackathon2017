package ixigo.invincible.takemethere.haimal;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.activities.BaseActivity;
import ixigo.invincible.takemethere.harsh.activities.ShowRecommendationsActivity;
import ixigo.invincible.takemethere.harsh.commons.EventObject;

/**
 * Main Activity class where the things start to work ;)
 */

public class HomeScreen extends BaseActivity {
    @BindView(R.id.layout_get_destination)
    public LinearLayout layout_get_destination;

    @Override
    protected int getLayout() {
        return R.layout.activity_homescreen;
    }

    @Subscribe
    @Override
    public void onEvent(EventObject eventObject) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.layout_get_recommendation)
    public void showRecommendation() {
        Intent intent = new Intent(this, ShowRecommendationsActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.tv_destination)
    public void showPredictions() {
        Intent intent = new Intent(this, ShowPredictions.class);
        Pair<View, String> transitionone = Pair.create((View) layout_get_destination, "et_destination");
        //  Pair<View, String> transitiontwo = Pair.create((View) layout_get_destination, "tv_destination");
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, transitionone);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
