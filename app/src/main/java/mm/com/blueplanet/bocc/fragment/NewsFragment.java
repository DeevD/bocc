package mm.com.blueplanet.bocc.fragment;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import mm.com.blueplanet.bocc.adapter.AdapterGoldAndExchangeRate;
import mm.com.blueplanet.bocc.adapter.AdapterNews;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRate;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRateResponse;
import mm.com.blueplanet.bocc.data.model.News;
import mm.com.blueplanet.bocc.data.model.NewsResponse;
import mm.com.blueplanet.bocc.rest.ApiClient;
import mm.com.blueplanet.bocc.rest.ApiInterface;
import mm.com.blueplanet.bocc.utility.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by smmon on 3/13/17.
 */

public class NewsFragment extends Fragment {

    private static final String TAG = "News";
    private RecyclerView mRvGer = null;
    private RecyclerView mRvNews = null;
    private ProgressDialog mProgressDialog =  null;

    public static NewsFragment newInstance(){
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRvGer = (RecyclerView) view.findViewById(R.id.rv_gold_and_exchange_rate);
        mRvNews = (RecyclerView) view.findViewById(R.id.rv_news);

        mRvGer.setLayoutManager(new LinearLayoutManager(BOCCApp.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvNews.setLayoutManager(new LinearLayoutManager(BOCCApp.getContext()));


        initGerContent();
        initNewsContent();
        loadDataFromAPI();

        return  view;
    }
    /***
     * To initialized empty data set to recycler view of gold and exchange rates
     * @param : no param
     * */
    private void initGerContent()
    {
        List<GoldAndExchangeRate> sampleData = new ArrayList<GoldAndExchangeRate>();
        mRvGer.setAdapter(new AdapterGoldAndExchangeRate(sampleData, R.layout.ger_card_list, BOCCApp.getContext()));

    }
    /***
     * To initialized empty data set to recycler view of gold and exchange rates
     * @param : no param
     * */
    private void  initNewsContent()
    {
        List<News> sampleData = new ArrayList<News>();
        mRvNews.setAdapter(new AdapterNews(sampleData, R.layout.news_card_list, BOCCApp.getContext()));
    }


    /***
     * To load data from API of ger and news to each recycler view.
     * @param : no param
     * */
    private void loadDataFromAPI()
    {
        mProgressDialog =  new ProgressDialog(getContext());
        mProgressDialog.setMax(100);
        mProgressDialog.setTitle("News Data Loading From Server");
        mProgressDialog.setMessage("It is loading ....");
        mProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        try {


            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<GoldAndExchangeRateResponse> call = apiService.getLatestGoldAndExchangeRate(Constants.API_kEY);
            call.enqueue(new Callback<GoldAndExchangeRateResponse>() {
                @Override
                public void onResponse(Call<GoldAndExchangeRateResponse> call, Response<GoldAndExchangeRateResponse> response) {
                    int  statusCode = response.code();
                    if(statusCode == HttpURLConnection.HTTP_OK){
                        List<GoldAndExchangeRate> goldAndExchangeRates = response.body().getResults();
                        //Log.d(TAG, "result :"+goldAndExchangeRates.toString());

                        mRvGer.setAdapter(new AdapterGoldAndExchangeRate(goldAndExchangeRates, R.layout.ger_card_list, BOCCApp.getContext()));
                    }
                    /*if(mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }*/

                }

                @Override
                public void onFailure(Call<GoldAndExchangeRateResponse> call, Throwable t) {
                    // Log error  here  since request  failed
                    Log.e(TAG, t.toString());
                }
            });
        }catch (Exception e){
            Log.d(TAG, "retrofit block : " + e.toString());
            if(mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }

        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<NewsResponse> callNews = apiService.getLatestNews(Constants.API_kEY);
            callNews.enqueue(new Callback<NewsResponse>() {
                @Override
                public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                    int  statusCode = response.code();
                    if(statusCode == HttpURLConnection.HTTP_OK){
                        List<News> newses = response.body().getResults();
                        mRvNews.setAdapter(new AdapterNews(newses, R.layout.news_card_list, BOCCApp.getContext()));
                    }
                    if(mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<NewsResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }catch (Exception e){
            Log.d(TAG, "retrofit block : " + e.toString());
            if(mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }

    }
}
