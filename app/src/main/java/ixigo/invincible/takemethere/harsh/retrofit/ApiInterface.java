package ixigo.invincible.takemethere.harsh.retrofit;

import ixigo.invincible.takemethere.harsh.models.hotels.HotelsData_;
import ixigo.invincible.takemethere.harsh.models.placestovisit.PlacesToVisitData_;
import ixigo.invincible.takemethere.harsh.models.recommendations.Data_;
import ixigo.invincible.takemethere.harsh.models.thingstodo.ThingsToDoData_;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    interface Types {
        String HOTEL = "Hotel";
        String PLACES_TO_VISIT = "Places To Visit";
        String THINGS_TO_DO = "Things To Do";
    }

    String BUDGET_FLIGHT = "BUDGET_FLIGHT";
    String BASE_URL = "http://build2.ixigo.com/api/";
    String API_KEY = "ixicode!2$";
    String SKIP = "0";
    String LIMIT = "100";

    @GET("v2/widgets/brand/inspire?product=1&apiKey=" + API_KEY)
    Call<Data_> getRecommendations();

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=" + API_KEY + "&type=" + Types.HOTEL + "&skip=" + SKIP + "&limit=" + LIMIT)
    Call<HotelsData_> getHotels(@Path("cityId") String cityId);

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=" + API_KEY + "&type=" + Types.PLACES_TO_VISIT + "&skip=" + SKIP + "&limit=" + LIMIT)
    Call<PlacesToVisitData_> getPlacesToVisit(@Path("cityId") String cityId);

    @GET("v3/namedentities/city/{cityId}/categories?apiKey=" + API_KEY + "&type=" + Types.THINGS_TO_DO + "&skip=" + SKIP + "&limit=" + LIMIT)
    Call<ThingsToDoData_> getThingsToDo(@Path("cityId") String cityId);

    @GET("v3/namedentities/city/{cityId}/categories")
    Call<Object> getAnyOutOfTheseThingsToDoPlacesToVisitHotels(@Path("cityId") String cityId,
                                                               @Query("apiKey") String apiKey,
                                                               @Query("type") String type,
                                                               @Query("skip") String skip,
                                                               @Query("limit") String limit);

}
