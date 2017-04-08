package ixigo.invincible.takemethere.haimal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.Subscribe;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.activities.BaseActivity;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;

public class SplashScreen extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_splashscreen;
    }

    @Subscribe
    @Override
    public void onEvent(EventObject eventObject) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
