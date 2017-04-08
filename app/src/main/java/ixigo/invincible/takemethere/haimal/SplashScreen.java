package ixigo.invincible.takemethere.haimal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ixigo.invincible.takemethere.R;

/**
 * Created by haimal on 08/04/17.
 */

public class SplashScreen extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        initializeVars();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, HomeScreen.class);
                startActivity(intent);
            }
        }, 1000);
    }

    private void initializeVars() {

        context = this;
    }
}
