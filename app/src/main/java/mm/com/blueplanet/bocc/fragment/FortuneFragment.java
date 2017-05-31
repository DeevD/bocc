package mm.com.blueplanet.bocc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.eminayar.panter.interfaces.OnTextInputConfirmListener;

import com.eminayar.panter.DialogType;
import com.eminayar.panter.PanterDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.FortuneDetailActivity;
import com.eminayar.panter.enums.Animation;


/**
 * Created by smmon on 3/13/17.
 */

public class FortuneFragment extends Fragment{





    public static FortuneFragment newInstance(){
        FortuneFragment fragment = new FortuneFragment();
        return fragment;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fortune, container, false);
        setHasOptionsMenu(true);
        new PanterDialog(getActivity())
                .setHeaderBackground(R.drawable.background_dialog_blue)
                .setHeaderLogo(R.drawable.astrology)
                .setTitle("Enter your birth date")
                .setPositive("I GOT IT")
                .setNegative("DISMISS")
                .setMessage("Enter Your birth date")
                .withAnimation(Animation.POP)
                .setDialogType(DialogType.INPUT)
                .isCancelable(false)
                .input(" Enter Date such 31 ", new OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String input) {
                        int length = input.length();
                        char first = input.charAt(0);
                        char second = input.charAt(1);

                        int firstNum = Integer.parseInt(input.valueOf(first));
                        int secondNum = Integer.parseInt(input.valueOf(second));
                        int finalNum = firstNum + secondNum;



//                                String str="1234";
//                                for(int i=0;i<input.length();i++)
//                                {
//                                    char c=str.charAt(i);
//                                    Character.getNumericValue(c);
//                                    Toast.makeText(getActivity(), " Char to integer " + Character.getNumericValue(c),Toast.LENGTH_SHORT).show();
//
//                                    System.out.println(Character.getNumericValue(c));
//                                    System.out.println(Integer.parseInt(str.valueOf(c)));
//                                }
                        Toast.makeText(getActivity(),"  Total  "+ finalNum,Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
        ButterKnife.bind(this, view);




        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.astrology_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_date:{
                new PanterDialog(getActivity())
                        .setHeaderBackground(R.drawable.background_dialog_blue)
                        .setHeaderLogo(R.drawable.astrology)
                        .setTitle("Enter your birth date")
                        .setPositive("I GOT IT")
                        .setNegative("DISMISS")
                        .setMessage("Enter Your birth date")
                        .withAnimation(Animation.POP)
                        .setDialogType(DialogType.INPUT)
                        .isCancelable(false)
                        .input(" Enter Date such 31 ", new OnTextInputConfirmListener() {
                            @Override
                            public void onTextInputConfirmed(String input) {
                                int length = input.length();
                                char first = input.charAt(0);
                                char second = input.charAt(1);

                                int firstNum = Integer.parseInt(input.valueOf(first));
                                int secondNum = Integer.parseInt(input.valueOf(second));
                                int finalNum = firstNum + secondNum;



//                                String str="1234";
//                                for(int i=0;i<input.length();i++)
//                                {
//                                    char c=str.charAt(i);
//                                    Character.getNumericValue(c);
//                                    Toast.makeText(getActivity(), " Char to integer " + Character.getNumericValue(c),Toast.LENGTH_SHORT).show();
//
//                                    System.out.println(Character.getNumericValue(c));
//                                    System.out.println(Integer.parseInt(str.valueOf(c)));
//                                }
                                Toast.makeText(getActivity(),"  Total  "+ finalNum,Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public void onTabCallForFortune(View view){

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
