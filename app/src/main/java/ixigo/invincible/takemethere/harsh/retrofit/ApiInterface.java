package ixigo.invincible.takemethere.harsh.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;


public interface ApiInterface {

    String BASE_URL = "http://build2.ixigo.com/api/v2/";

    @POST("recommendations")
    Call<Object> getRecommendations();

}
