package ixigo.invincible.takemethere.haimal;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.haimal.Utils.LogClass;
import ixigo.invincible.takemethere.harsh.activities.BaseActivity;
import ixigo.invincible.takemethere.harsh.activities.ShowRecommendationsActivity;
import ixigo.invincible.takemethere.harsh.commons.EventObject;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data;
import ixigo.invincible.takemethere.harsh.requesters.RecommendationRequester;
import ixigo.invincible.takemethere.harsh.util.BackgroundExecutor;

/**
 * Main Activity class where the things start to work ;)
 */

public class HomeScreen extends BaseActivity {
    private static String TAG = "HomeScreen";
    @BindView(R.id.layout_get_destination)
    public LinearLayout layout_get_destination;
    private Data data;

    @Override
    protected int getLayout() {
        return R.layout.activity_homescreen;
    }

    @Subscribe
    @Override
    public void onEvent(final ixigo.invincible.takemethere.harsh.models.eventbus.EventObject eventObject) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                ArrayList<String> places = new ArrayList<String>();
                int counter = 1;
                dismissProgress();
                switch (eventObject.getId()) {
                    case Events.GET_FACEBOOK_SUCCESS:
                        //Toast.makeText(HomeScreen.this, "Get Recommendation SuccessFull", Toast.LENGTH_SHORT).show();
                        data = (Data) eventObject.getObject();
                        LogClass.displayLog(TAG, data.toString());
                        StringBuffer placesName = new StringBuffer();
                        for (int i = 0; i < data.getFlight().size(); i++) {
                            places.add(data.getFlight().get(i).getCityName() + "," + data.getFlight().get(i).getCountryName());
                        }

                        for (int i = 0; i < data.getBudget_flight().size(); i++) {
                            places.add(data.getBudget_flight().get(i).getCityName() + "," + data.getBudget_flight().get(i).getCountryName());
                        }

                        for (int i = 0; i < 5; i++) {
                            Random random = new Random();
                            int randomPlace = random.nextInt(50 - i);
                            LogClass.displayLog(TAG, String.valueOf(randomPlace));
                            placesName.append(places.get(randomPlace));
                            placesName.append("\n");
                            places.remove(randomPlace);
                        }

                        placesName.append("\n Powered by ixigo, your personal Travel Assistant.");

                        LogClass.displayLog(TAG, placesName.toString());

                        PostToFacebookDialog(HomeScreen.this, "Where should I go guys???", "", placesName.toString(), "");
                        break;
                    case Events.GET_RECOMMENDATION_FAILED:
                        // Toast.makeText(ShowRecommendationsActivity.this, "Get Recommendation Failed", Toast.LENGTH_SHORT).show();
                        break;
                    case Events.NO_INTERNET_CONNECTION:
                        // Toast.makeText(ShowRecommendationsActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
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
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, transitionone);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    @OnClick(R.id.fab_ask_my_friends)
    public void postOnFacebook() {
        BackgroundExecutor.getInstance().execute(new RecommendationRequester("facebook_button"));
        showProgress("Getting you some nice places to visit...");
    }

    public void PostToFacebookDialog(Context context, String title, String imageurl, String description, String articleurl) {

        imageurl = "https://static1.squarespace.com/static/55fd7031e4b05d951e5158dc/55fd89b4e4b0fa9f9a864240/56003425e4b00af19b54c631/1448536539304/suitcase.jpg?format=500w";
        articleurl = "https://www.ixigo.com";
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentTitle(title)
                    .setImageUrl(Uri.parse(imageurl))
                    .setContentDescription(description)
                    .setContentUrl(Uri.parse(articleurl))
                    .build();

            ShareDialog.show(this, content);
        }
    }
}
