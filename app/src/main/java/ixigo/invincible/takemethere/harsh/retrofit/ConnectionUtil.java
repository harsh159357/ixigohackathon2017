package ixigo.invincible.takemethere.harsh.retrofit;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ConnectionUtil {

    private static String TAG = ConnectionUtil.class.getName();

    public static <T> APIResponse execute(Call call) {
        try {
            Response<T> response = call.execute();
            return new APIResponse<T>(response.code(), response.body(), response.headers());
        } catch (IOException e) {
            Log.d(TAG, "Error in execute api request");
        } catch (Exception ex) {
            Log.d(TAG, "Error in execute api" + ex.getMessage());
        }
        return null;
    }

}
