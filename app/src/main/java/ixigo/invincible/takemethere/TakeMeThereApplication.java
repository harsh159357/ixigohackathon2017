package ixigo.invincible.takemethere;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ixigo.invincible.takemethere.harsh.retrofit.ApiInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TakeMeThereApplication extends Application {

    private static final String TAG = TakeMeThereApplication.class.getName();
    private static TakeMeThereApplication _instance;
    private ApiInterface apiInterface;
    private final Handler handler;


    public TakeMeThereApplication() {
        _instance = this;
        handler = new Handler();
    }

    public static TakeMeThereApplication getInstance() {
        if (_instance == null) {
            _instance = new TakeMeThereApplication();
        }
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Application onCreate()");
        initRetrofit();
    }

    public void initRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES);
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public void runOnUiThread(final Runnable runnable) {
        handler.post(runnable);
    }
}
