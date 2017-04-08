package ixigo.invincible.takemethere.harsh.retrofit;

import ixigo.invincible.takemethere.harsh.models.recommendations.Data_;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    String BASE_URL = "http://build2.ixigo.com/api/v2/";

    @GET("widgets/brand/inspire?product=1&apiKey=ixicode!2$")
    Call<Data_> getRecommendations();

}
