package ixigo.invincible.takemethere.harsh.interfaces;

public interface Constants {
    String BUDGET_FLIGHT = "BUDGET_FLIGHT";

    interface ProgressDialogsToastsText {
        String PLEASE_WAIT = "Please Wait...";
        String LOADING_RECOMMENDATION = "Loading Recommendation...";
    }

    interface Events {
        int NO_INTERNET_CONNECTION = 0;
        int GET_RECOMMENDATION_SUCCESSFUL = 1;
        int GET_RECOMMENDATION_FAILED = 2;
        int GET_HOTELS_SUCCESSFUL = 3;
        int GET_FACEBOOK_SUCCESS = 20;
        int GET_HOTELS_FAILED = 4;
        int GET_THINGS_TO_DO_SUCCESSFUL = 5;
        int GET_THINGS_TO_DO_FAILED = 6;
        int GET_PLACES_TO_VISIT_SUCCESSFUL = 7;
        int GET_PLACES_TO_VISIT_FAILED = 8;
    }

    interface Types {
        String HOTEL = "Hotel";
        String PLACES_TO_VISIT = "Places To Visit";
        String THINGS_TO_DO = "Things To Do";
    }
    String BASE_URL = "http://build2.ixigo.com/api/";
    String API_KEY = "ixicode!2$";
    String SKIP = "0";
    String LIMIT = "10";

}
