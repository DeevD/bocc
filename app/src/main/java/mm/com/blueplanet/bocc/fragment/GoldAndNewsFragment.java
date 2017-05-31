package mm.com.blueplanet.bocc.fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.bohush.geometricprogressview.GeometricProgressView;
import net.bohush.geometricprogressview.TYPE;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.HomeActivity;

/**
 * Created by Lenovo on 5/28/2017.
 */

public class GoldAndNewsFragment extends android.support.v4.app.Fragment {

    public static GoldAndNewsFragment newInstace()
    {
        GoldAndNewsFragment goldAndNewsFragment = new GoldAndNewsFragment();
        return goldAndNewsFragment;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.gold_news_frag,container,false);
        android.support.v4.app.Fragment fragment = getFragmentManager().findFragmentById(R.id.fl_container);

        GeometricProgressView progressView = (GeometricProgressView)view.findViewById(R.id.progressView);
        progressView.setType(TYPE.TRIANGLE);
        progressView.setNumberOfAngles(6);
        progressView.setColor(Color.parseColor("#F44336"));
        progressView.setDuration(1000);
//       if(fragment != null){
//          // getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fl_container)).commit();
//            getFragmentManager().beginTransaction().remove(fragment).commit();



            getFragmentManager().beginTransaction()
                    .replace(R.id.fl_container2, GoldExchangeFragment.newInstance())
                    .commit();

            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fl_container3, NewFragment.newInstance())

                    .commit();
        if (progressView.isShown())
        {
            progressView.setVisibility(View.INVISIBLE);
        }


     //  }




        return view;
    }
}
