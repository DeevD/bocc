package mm.com.blueplanet.bocc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mm.com.blueplanet.bocc.R;

/**
 * Created by Lenovo on 5/28/2017.
 */

public class FavEmergencyFragment extends Fragment {

    public static FavEmergencyFragment newInstance(){
        FavEmergencyFragment fragment = new FavEmergencyFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.favourite_emergency,container,false);
        return view;
    }
}
