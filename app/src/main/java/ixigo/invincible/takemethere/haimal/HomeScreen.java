package ixigo.invincible.takemethere.haimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @BindView(R.id.iv_take_off_icon)
    ImageView iv_take_off_icon;
    @BindView(R.id.et_destination)
    AutoCompleteTextView et_destination;
    @BindView(R.id.layout_get_recommendation)
    LinearLayout layout_get_recommendation;

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

}
