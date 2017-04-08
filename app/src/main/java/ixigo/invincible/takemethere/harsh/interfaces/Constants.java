package ixigo.invincible.takemethere.harsh.interfaces;

public interface Constants {
    interface ProgressDialogsToastsText {
        String PLEASE_WAIT = "Please Wait...";
        String LOADING_RECOMMENDATION = "Loading Recommendation...";
    }

    interface Events {
        int NO_INTERNET_CONNECTION = 0;
        int GET_RECOMMENDATION_SUCCESSFUL = 1;
        int GET_RECOMMENDATION_FAILED = 2;
    }

    String BUDGET_FLIGHT = "BUDGET_FLIGHT";
}
