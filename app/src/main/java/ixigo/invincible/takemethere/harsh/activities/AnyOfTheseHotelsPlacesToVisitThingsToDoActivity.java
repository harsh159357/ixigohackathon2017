package ixigo.invincible.takemethere.harsh.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

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
        tabLayout.addTab(tabLayout.newTab().setText(Types.HOTEL + "S"));
        tabLayout.addTab(tabLayout.newTab().setText(Types.THINGS_TO_DO));


        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        customViewPager.setAdapter(adapter);
        if (getIntent().getStringExtra(ShowRecommendationsActivity.CLICK_TYPE).equals(Types.PLACES_TO_VISIT)) {
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            tab.select();
        } else if (getIntent().getStringExtra(ShowRecommendationsActivity.CLICK_TYPE).equals(Types.HOTEL)) {
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        } else {
            TabLayout.Tab tab = tabLayout.getTabAt(2);
            tab.select();
        }
        customViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
