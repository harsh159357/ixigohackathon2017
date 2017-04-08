package ixigo.invincible.takemethere.harsh.controllers;

import ixigo.invincible.takemethere.TakeMeThereApplication;
import ixigo.invincible.takemethere.harsh.retrofit.ApiInterface;
import ixigo.invincible.takemethere.harsh.retrofit.ConnectionUtil;
import ixigo.invincible.takemethere.harsh.retrofit.APIResponse;

public class HTTPOperationController {

    private final String TAG = HTTPOperationController.class.getSimpleName();

    public static APIResponse getRecommendations() {
        ApiInterface apiInterface = TakeMeThereApplication.getInstance().getApiInterface();
        return ConnectionUtil.execute(apiInterface.getRecommendations());
    }

}