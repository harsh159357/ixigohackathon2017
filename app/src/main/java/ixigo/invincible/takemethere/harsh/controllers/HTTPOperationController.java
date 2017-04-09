package ixigo.invincible.takemethere.harsh.controllers;

import ixigo.invincible.takemethere.TakeMeThereApplication;
import ixigo.invincible.takemethere.harsh.interfaces.Constants;
import ixigo.invincible.takemethere.harsh.retrofit.APIResponse;
import ixigo.invincible.takemethere.harsh.retrofit.ApiInterface;
import ixigo.invincible.takemethere.harsh.retrofit.ConnectionUtil;

public class HTTPOperationController implements Constants {

    private final String TAG = HTTPOperationController.class.getSimpleName();

    public static APIResponse getRecommendations() {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getRecommendations());
    }

    public static APIResponse getHotels(String cityId) {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getHotels(cityId));
    }

    public static APIResponse getPlacesToVisit(String cityId) {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getPlacesToVisit(cityId));
    }

    public static APIResponse getThingsToDo(String cityId) {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getThingsToDo(cityId));
    }

    public static APIResponse getAnyOutOfTheseThingsToDoPlacesToVisitHotels(String city, String type) {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getAnyOutOfTheseThingsToDoPlacesToVisitHotels(city, API_KEY, type, SKIP, LIMIT));
    }

}