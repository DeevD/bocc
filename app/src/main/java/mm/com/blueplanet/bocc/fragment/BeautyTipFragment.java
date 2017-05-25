package mm.com.blueplanet.bocc.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.AdapterBeautyTip;
import mm.com.blueplanet.bocc.data.model.BeautyTip;
import mm.com.blueplanet.bocc.data.model.BeautyTipResponse;
import mm.com.blueplanet.bocc.rest.ApiClient;
import mm.com.blueplanet.bocc.rest.ApiInterface;
import mm.com.blueplanet.bocc.utility.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by smmon on 3/13/17.
 */

public class BeautyTipFragment extends Fragment {

    private static final String TAG = "Beauty Tip";
    private RecyclerView m_rv_BeautyTip = null;
    private ProgressDialog mProgressDialog =  null;

    Handler handle =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mProgressDialog.incrementProgressBy(1);
        }
    };


    public static BeautyTipFragment newInstance() {
        BeautyTipFragment fragment = new BeautyTipFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beauty_tip, container, false);
        m_rv_BeautyTip = (RecyclerView) view.findViewById(R.id.rv_beautyTip);

        m_rv_BeautyTip.setLayoutManager(new LinearLayoutManager(BOCCApp.getContext()));

        setSampleBeautyTip();
        loadDataFromAPI();





        return view;
    }

    private void setSampleBeautyTip()
    {
        List<BeautyTip> sampleData = new ArrayList<BeautyTip>();
        /*BeautyTip tip1 = new BeautyTip(321, "2017-03-02", "test data1");
        BeautyTip tip2 = new BeautyTip(322, "2017-03-02", "test data2");
        sampleData.add(0, tip1);
        sampleData.add(1, tip2);*/

        m_rv_BeautyTip.setAdapter(new AdapterBeautyTip(sampleData, R.layout.beautytip_card_list, BOCCApp.getContext()));
    }
    private void loadDataFromAPI(){
        mProgressDialog =  new ProgressDialog(getContext());
        mProgressDialog.setMax(100);
        mProgressDialog.setTitle("Beauty Tip Data Loading From Server");
        mProgressDialog.setMessage("It is loading ....");
        mProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                   //Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<BeautyTipResponse> call = apiService.getLatestBeautyTip(Constants.API_kEY);
            call.enqueue(new Callback<BeautyTipResponse>() {
                @Override
                public void onResponse(Call<BeautyTipResponse> call, Response<BeautyTipResponse> response) {
                    int statusCode = response.code();
                    //Log.d(TAG, response.raw().toString());
                    if (statusCode == HttpURLConnection.HTTP_OK) {
                        List<BeautyTip> beautyTips = response.body().getResults();
                        Log.d(TAG, "results : "+beautyTips.toString());
                        m_rv_BeautyTip.setAdapter(new AdapterBeautyTip(beautyTips, R.layout.beautytip_card_list, getContext()));


                    }
                    if(mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }

                }

                @Override
                public void onFailure(Call<BeautyTipResponse> call, Throwable t) {
                    mProgressDialog.dismiss();
                    // Log error  here  since request  failed
                    Log.e(TAG, t.toString());
                }
            });
        } catch (Exception e) {
            mProgressDialog.dismiss();
            Log.d(TAG, "retrofit block : " + e.toString());
        }
    }


}
