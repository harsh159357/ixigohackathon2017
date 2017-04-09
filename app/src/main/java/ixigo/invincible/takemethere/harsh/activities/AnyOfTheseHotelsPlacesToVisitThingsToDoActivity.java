package ixigo.invincible.takemethere.harsh.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.harsh.adapters.Pager;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.util.CustomViewPager;

public class AnyOfTheseHotelsPlacesToVisitThingsToDoActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    CustomViewPager customViewPager;

    @Override
    protected int getLayout() {
        return R.layout.activity_any_of_these_hotel_things_to_do_places_to_visit;
    }

    @Subscribe
    @Override
    public void onEvent(final EventObject eventObject) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dismissProgress();
                switch (eventObject.getId()) {
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabLayout.addTab(tabLayout.newTab().setText(Types.PLACES_TO_VISIT));
        tabLayout.addTab(tabLayout.newTab().setText(Types.HOTEL));
        tabLayout.addTab(tabLayout.newTab().setText(Types.THINGS_TO_DO));
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        customViewPager.setAdapter(adapter);
        customViewPager.setCurrentItem(0);
        customViewPager.setPagingEnabled(false);
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        customViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
