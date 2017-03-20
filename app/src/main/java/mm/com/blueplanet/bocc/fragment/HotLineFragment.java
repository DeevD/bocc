package mm.com.blueplanet.bocc.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.HotLineDetailActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class HotLineFragment extends Fragment {

    @BindView(R.id.th_hot_line_tab_host)
    TabHost thHotLine;


    public static HotLineFragment newInstance(){
        HotLineFragment fragment = new HotLineFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotline, container, false);
        ButterKnife.bind(this, rootView);
        thHotLine.setup();
        TabSetup(thHotLine);






        return  rootView;
    }

    /**
     * Adding and configuration of tabs
     * @param : TabHost tabHost
     * @return : void
     * */
    private void TabSetup(TabHost tabHost){
        //Our Call Center Tab
        TabHost.TabSpec spec = tabHost.newTabSpec("Our Call Center");
        spec.setContent(R.id.tab_our_call_center);
        spec.setIndicator("Call Center");
        tabHost.addTab(spec);

        //Emergency Tab
        spec = tabHost.newTabSpec("Emergency");
        spec.setContent(R.id.tab_emergency);
        spec.setIndicator("Emergency");
        tabHost.addTab(spec);

        //Government Tab
        spec = tabHost.newTabSpec("Government");
        spec.setContent(R.id.tab_government);
        spec.setIndicator("Government");
        tabHost.addTab(spec);
    }

    @OnClick(R.id.cv_1875)
    public void onTabCardView1875(View view){
        goToCallCenterDetail("Hotline 1875");
    }

    @OnClick(R.id.cv_1876)
    public void onTabCardView1876(View view){
        goToCallCenterDetail("Hotline 1876");
    }

    @OnClick(R.id.cv_1877)
    public void onTabCardView1877(View view){
        goToCallCenterDetail("Hotline 1877");
    }

    @OnClick(R.id.cv_1880)
    public void onTabCardView1880(View view){
        goToCallCenterDetail("Hotline 1880");
    }

    @OnClick(R.id.cv_1883)
    public void onTabCardView1883(){
        goToCallCenterDetail("Hotline 1883");
    }

    @OnClick(R.id.cv_1886)
    public void onTabCardView1886(){
        goToCallCenterDetail("Hotline 1886");
    }

    @OnClick(R.id.cv_highway_ambulance)
    public void onTabCardViewHighWayAmbulance(){
        goToCallCenterDetail("Highway ambulance");
    }
    @OnClick(R.id.cv_police)
    public void onTabCardViewPolice(){
        goToCallCenterDetail("Police Department");
    }
    @OnClick(R.id.cv_fire_station)
    public void onTabCardViewFireStation(){
        goToCallCenterDetail("Fire Station");
    }
    @OnClick(R.id.cv_ambulance)
    public void onTabCardViewAmbulance(){
        goToCallCenterDetail("Ambulance");
    }
    @OnClick(R.id.cv_president_office)
    public void onTabCardViewPresidentOffice(){
        goToCallCenterDetail("President Office");
    }
    @OnClick(R.id.cv_labour_ministry)
    public void onTabCardViewLabourMinistry(){
        goToCallCenterDetail("Ministry of Labour");
    }
    @OnClick(R.id.cv_ministry_of_immigration)
    public void onTabCardViewImmigrationMinistry(){
        goToCallCenterDetail("Ministry of Immigration");
    }


    private void goToCallCenterDetail(String hotlineTitle){
        Intent intent = new Intent(getActivity(), HotLineDetailActivity.class);
        intent.putExtra("IE_HOTLINE_TITLE", hotlineTitle);
        //Intent intent = HotLineDetailActivity.newIntent(hotlineTitle);
        startActivity(intent);
    }


}
