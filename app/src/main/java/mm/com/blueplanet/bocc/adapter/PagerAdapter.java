package mm.com.blueplanet.bocc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mm.com.blueplanet.bocc.data.model.Emergency;
import mm.com.blueplanet.bocc.fragment.CallCenterFragment;
import mm.com.blueplanet.bocc.fragment.EmergencyFragment;
import mm.com.blueplanet.bocc.fragment.GovermentFragment;

/**
 * Created by Lenovo on 5/25/2017.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CallCenterFragment tab1 = new CallCenterFragment();
                return tab1;
            case 1:
                EmergencyFragment tab2 = new EmergencyFragment();
                return tab2;

            case 2:
                GovermentFragment tab3 = new GovermentFragment();
                return tab3;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}