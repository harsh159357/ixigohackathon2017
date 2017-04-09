package ixigo.invincible.takemethere.harsh.requesters;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import ixigo.invincible.takemethere.harsh.controllers.HTTPOperationController;
import ixigo.invincible.takemethere.harsh.interfaces.BaseRequester;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data_;
import ixigo.invincible.takemethere.harsh.models.recommendations.FlightData;
import ixigo.invincible.takemethere.harsh.retrofit.APIResponse;

public class RecommendationRequester implements BaseRequester {

    public RecommendationRequester() {
    }

    @Override
    public void run() {
        APIResponse<Data_> recommendationResponse = HTTPOperationController.getRecommendations();
        if (recommendationResponse != null) {
            if (recommendationResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Data data = recommendationResponse.getResponse().getData();

                ArrayList<FlightData> flightDatas = data.getBudget_flight();
                for (FlightData flightData : flightDatas) {
                    flightData.setType(BUDGET_FLIGHT);
                }
                data.setBudget_flight(flightDatas);
                EventBus.getDefault().post(new EventObject(Events.GET_RECOMMENDATION_SUCCESSFUL, recommendationResponse.getResponse().getData()));
            } else {
                EventBus.getDefault().post(new EventObject(Events.GET_RECOMMENDATION_FAILED, null));
            }

        } else {
            EventBus.getDefault().post(new EventObject(Events.NO_INTERNET_CONNECTION, null));
        }

    }

}
