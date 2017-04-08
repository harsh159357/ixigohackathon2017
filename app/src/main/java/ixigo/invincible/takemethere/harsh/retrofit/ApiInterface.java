package ixigo.invincible.takemethere.harsh.retrofit;

import ixigo.invincible.takemethere.harsh.models.recommendations.Data_;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiInterface {

    String BASE_URL = "http://build2.ixigo.com/api/";

    @GET("v2/widgets/brand/inspire?product=1&apiKey=ixicode!2$")
    Call<Data_> getRecommendations();

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=ixicode!2$&type=Hotel&skip=0&limit=100000000")
    Call<Object> getHotels(@Path("cityId") String cityId);

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=ixicode!2$&type=Places To Visit&skip=0&limit=100000000")
    Call<Object> getPlacesToVisit(@Path("cityId") String cityId);

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=ixicode!2$&type=Things To Do&skip=0&limit=100000000")
    Call<Object> getThingsToDo(@Path("cityId") String cityId);

}
