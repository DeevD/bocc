package mm.com.blueplanet.bocc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.FortuneDetailActivity;


/**
 * Created by smmon on 3/13/17.
 */

public class FortuneFragment extends Fragment{





    public static FortuneFragment newInstance(){
        FortuneFragment fragment = new FortuneFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fortune, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.fab_call_for_fortune)
    public void onTabCallForFortune(View view){
        Snackbar.make(view, "It will make call to call center for your fortune soon !", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    /***
     * To go to activity detail with respect to clicked number and keyword
     * @param : String title, String keyword
     * ***/
    private void goToFortuneDetailActivity(String title, String keyword){
        Intent intent = new Intent(getActivity(), FortuneDetailActivity.class);
        intent.putExtra("IE_FORTUNE_TITLE",title);
        intent.putExtra("IE_FORTUNE_KEYWORD",keyword);
        startActivity(intent);
    }

    @OnClick(R.id.cv_n1)
    public void onTabView_cvNum1(View view){   goToFortuneDetailActivity("Horo Number 1", "HAN1");}
    @OnClick(R.id.cv_n2)
    public void onTabView_cvNum2(View view){   goToFortuneDetailActivity("Horo Number 2", "HAN2");}
    @OnClick(R.id.cv_n3)
    public void onTabView_cvNum3(View view){   goToFortuneDetailActivity("Horo Number 3", "HAN3");}
    @OnClick(R.id.cv_n4)
    public void onTabView_cvNum4(View view){   goToFortuneDetailActivity("Horo Number 4", "HAN4");}
    @OnClick(R.id.cv_n5)
    public void onTabView_cvNum5(View view){   goToFortuneDetailActivity("Horo Number 5", "HAN5");}
    @OnClick(R.id.cv_n6)
    public void onTabView_cvNum6(View view){   goToFortuneDetailActivity("Horo Number 6", "HAN6");}
    @OnClick(R.id.cv_n7)
    public void onTabView_cvNum7(View view){   goToFortuneDetailActivity("Horo Number 7", "HAN7");}
    @OnClick(R.id.cv_n8)
    public void onTabView_cvNum8(View view){   goToFortuneDetailActivity("Horo Number 8", "HAN8");}
    @OnClick(R.id.cv_n9)
    public void onTabView_cvNum9(View view){   goToFortuneDetailActivity("Horo Number 9", "HAN9");}
}
