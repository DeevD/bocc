package mm.com.blueplanet.bocc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mm.com.blueplanet.bocc.R;

/**
 * Created by smmon on 3/13/17.
 */

public class FavouriteFragment extends Fragment{

    public static FavouriteFragment newInstance(){
        FavouriteFragment fragment = new FavouriteFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        return view;
    }
}
