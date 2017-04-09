package ixigo.invincible.takemethere.harsh.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ixigo.invincible.takemethere.harsh.fragment.HotelsFragment;
import ixigo.invincible.takemethere.harsh.fragment.PlacesToVisitFragment;
import ixigo.invincible.takemethere.harsh.fragment.ThingsToDoFragment;


public class Pager extends FragmentPagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class 
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs 
        switch (position) {
            case 0:
                PlacesToVisitFragment placesToVisitFragment = new PlacesToVisitFragment();
                return placesToVisitFragment;
            case 1:
                HotelsFragment hotelsFragment = new HotelsFragment();
                return hotelsFragment;
            case 2:
                ThingsToDoFragment thingsToDoFragment = new ThingsToDoFragment();
                return thingsToDoFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs 
    @Override
    public int getCount() {
        return tabCount;
    }
}