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

public class TakeATourFragment extends Fragment{

    public static TakeATourFragment newInstance(){
        TakeATourFragment fragment = new TakeATourFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_a_tour, container, false);

        return view;
    }
}
