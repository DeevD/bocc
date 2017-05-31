package mm.com.blueplanet.bocc.fragment;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.PagerAdapter;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Lenovo on 5/25/2017.
 */

public class HotlineFrag extends Fragment {
    TabHost tabHost;
    private static final String TAG = "FragmentTabs";
    public static final String TAB_WORDS = "words";
    public static final String TAB_NUMBERS = "numbers";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hotline_frag, container, false);

        tabHost = (TabHost) view.findViewById(android.R.id.tabhost);
//
//        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar_hotline);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        Log.e("asdf", "hotlinefrag");

        setMenuVisibility(true);


        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.hot_center_tap)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.em_center_tap)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.go_center_tap)));

//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_1875);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_1875);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_1875);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}