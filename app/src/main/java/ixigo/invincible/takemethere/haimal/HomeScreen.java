package ixigo.invincible.takemethere.haimal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ixigo.invincible.takemethere.R;
/**
 * Main Activity class where the things start to work ;)
 */

public class HomeScreen extends AppCompatActivity {


    private static final String TAG = "HomeScreen";
    ImageView iv_take_off_icon;
    LinearLayout layout_get_recommendation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        initializeVars();
    }

    //method to initialize all the required views and variables.
    private void initializeVars() {
        iv_take_off_icon = (ImageView) findViewById(R.id.iv_take_off_icon);
        layout_get_recommendation = (LinearLayout) findViewById(R.id.layout_get_recommendation);


    }
}
