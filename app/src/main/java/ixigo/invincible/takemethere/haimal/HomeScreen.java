package ixigo.invincible.takemethere.haimal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.haimal.adapters.AutoCompleteAdapter;

/**
 * Main Activity class where the things start to work ;)
 */

public class HomeScreen extends AppCompatActivity {


    ImageView iv_take_off_icon;
    AutoCompleteTextView et_destination;
    LinearLayout layout_get_recommendation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeVars();
        setContentView(R.layout.activity_homescreen);
    }

    //method to initialize all the required views and variables.
    private void initializeVars() {
        iv_take_off_icon = (ImageView) findViewById(R.id.iv_take_off_icon);
        et_destination = (AutoCompleteTextView) findViewById(R.id.et_destination);
        //et_destination.setAdapter(new AutoCompleteAdapter(this));
        layout_get_recommendation = (LinearLayout) findViewById(R.id.layout_get_recommendation);

    }
}
