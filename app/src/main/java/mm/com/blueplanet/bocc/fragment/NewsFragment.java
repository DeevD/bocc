package mm.com.blueplanet.bocc.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mm.com.blueplanet.bocc.R;

/**
 * Created by smmon on 3/13/17.
 */

public class NewsFragment extends Fragment {

    public static NewsFragment newInstance(){
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        return  view;
    }
}
