package ixigo.invincible.takemethere.haimal.asyncclasses;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ixigo.invincible.takemethere.haimal.Utils.API;
import ixigo.invincible.takemethere.haimal.Utils.LogClass;
import ixigo.invincible.takemethere.haimal.Utils.MarshmallowClient;
import ixigo.invincible.takemethere.haimal.modals.City;

/**
 * Created by haimal on 08/04/17.
 */

public class GetCityPredictions {

    private static final String TAG = "GetCityPredictions";


    public static List<City> getCityPredictions(String constraints) {

        List<City> cityList;
        try {

            if (constraints != null) {
                cityList = new ArrayList<>();
                MarshmallowClient client = new MarshmallowClient(API.AUTOCOMPLETE_API + constraints);
                String jsonResponse = client.Execute(MarshmallowClient.RequestMethod.GET);

                LogClass.displayLog(TAG, jsonResponse);

                JSONArray jsonArray = new JSONArray(jsonResponse);

                for (int i = 0; i > jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    City city = new City();
                    city.setCityName(jsonObject.getString("text"));
                    city.setCityId(jsonObject.getString("_id"));
                    city.setCityCountry(jsonObject.getString("co"));
                    city.setCityState(jsonObject.getString("st"));
                    city.setCityXid(jsonObject.getString("xid"));

                    cityList.add(city);
                }

                return cityList;
            }
        } catch (Exception e) {
            LogClass.displayLog(TAG, e.getMessage());
        }
        return null;
    }
}
