package ixigo.invincible.takemethere.haimal;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.haimal.Utils.DelayAutoCompleteTextView;
import ixigo.invincible.takemethere.haimal.Utils.LogClass;
import ixigo.invincible.takemethere.haimal.adapters.AutoCompleteAdapter;
import ixigo.invincible.takemethere.haimal.modals.City;
import ixigo.invincible.takemethere.harsh.activities.BaseActivity;
import ixigo.invincible.takemethere.harsh.commons.EventObject;

/**
 * Created by haimal on 08/04/17.
 */

public class ShowPredictions extends BaseActivity {

    private static final String TAG = "ShowPredictions";
    @BindView(R.id.et_destination)
    public DelayAutoCompleteTextView et_destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (et_destination.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        et_destination.setAdapter(new AutoCompleteAdapter(this)); // 'this' is Activity instance
        et_destination.setLoadingIndicator((android.widget.ProgressBar) findViewById(R.id.pb_loading_indicator));
        et_destination.setDropDownWidth((getResources().getDisplayMetrics().widthPixels));
        et_destination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                City city = (City) adapterView.getItemAtPosition(position);
                LogClass.displayLog(TAG, city.getCityName() + " clicked");
                et_destination.setText(city.getCityName());

            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_showpredictions;
    }

    @Subscribe
    @Override
    public void onEvent(EventObject eventObject) {

    }
}
