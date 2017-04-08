package ixigo.invincible.takemethere.harsh.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;


public interface ApiInterface {

    String BASE_URL = "http://build2.ixigo.com/api/v2/";

    @POST("widgets/brand/inspire?product=1&apiKey=ixicode!2$")
    Call<Object> getRecommendations();

}
