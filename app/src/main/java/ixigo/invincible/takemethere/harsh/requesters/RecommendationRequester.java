package ixigo.invincible.takemethere.harsh.requesters;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;

import ixigo.invincible.takemethere.harsh.controllers.HTTPOperationController;
import ixigo.invincible.takemethere.harsh.interfaces.BaseRequester;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data_;
import ixigo.invincible.takemethere.harsh.retrofit.APIResponse;

public class RecommendationRequester implements BaseRequester {

    public RecommendationRequester() {
    }

    @Override
    public void run() {
        APIResponse<Data_> recommendationResponse = HTTPOperationController.getRecommendations();
        if (recommendationResponse != null) {
            if (recommendationResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {
                EventBus.getDefault().post(new EventObject(Events.GET_RECOMMENDATION_SUCCESSFUL, recommendationResponse.getResponse()));
            } else {
                EventBus.getDefault().post(new EventObject(Events.GET_RECOMMENDATION_FAILED, null));
            }

        } else {
            EventBus.getDefault().post(new EventObject(Events.NO_INTERNET_CONNECTION, 0));
        }

    }

}
