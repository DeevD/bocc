package mm.com.blueplanet.bocc.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.AdapterFortuneResult;
import mm.com.blueplanet.bocc.data.model.FortuneResult;
import mm.com.blueplanet.bocc.data.model.FortuneResultResponse;
import mm.com.blueplanet.bocc.rest.ApiClient;
import mm.com.blueplanet.bocc.rest.ApiInterface;
import mm.com.blueplanet.bocc.utility.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FortuneDetailActivity extends AppCompatActivity {

    private static final String IE_FORTUNE_TITLE = "IE_FORTUNE_TITLE";
    private static final String IE_FORTUNE_KEYWORD = "IE_FORTUNE_KEYWORD";
    private static final String TAG = "Fortune Result Detail";
    private RecyclerView mRvFortuneResult = null;
    private String mStrKeyword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String strFortuneDetailTitle = getIntent().getStringExtra(IE_FORTUNE_TITLE);
        mStrKeyword = getIntent().getStringExtra(IE_FORTUNE_KEYWORD);
        toolbar.setTitle(strFortuneDetailTitle);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(strFortuneDetailTitle);


        mRvFortuneResult = (RecyclerView) findViewById(R.id.rv_fortune_result);
        mRvFortuneResult.setLayoutManager(new LinearLayoutManager(BOCCApp.getContext()));

        setEmptyFortuneResult();
        loadDataFromAPI();
    }

    /***
     * To initialize empty Data set on recycler view
     * @param : no param
     * */
    private void setEmptyFortuneResult()
    {
        List<FortuneResult> sampleData = Collections.emptyList();
        mRvFortuneResult.setAdapter(new AdapterFortuneResult(BOCCApp.getContext(), R.layout.fortune_result_card, sampleData));

    }


    /***
     *  To Load Data of fortune result with retrofit and setting adapter to display data
     *  @author : Htoo Maung Thait (htoomaungthait@gmail.com)
     *  @since : 2017-05-26
     *  @param : no param
     *  @return : no*/
    private void loadDataFromAPI()
    {
        try{
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<FortuneResultResponse> call = apiService.getFortuneResultByKeyword(Constants.API_kEY, mStrKeyword);
            call.enqueue(new Callback<FortuneResultResponse>() {
                @Override
                public void onResponse(Call<FortuneResultResponse> call, Response<FortuneResultResponse> response) {
                    int statusCode = response.code();
                    if(statusCode == HttpURLConnection.HTTP_OK){
                        List<FortuneResult> fortuneResults = response.body().getResults();
                        Log.d(TAG, "results : "+fortuneResults.toString());
                        mRvFortuneResult.setAdapter(new AdapterFortuneResult(BOCCApp.getContext(),R.layout.fortune_result_card, fortuneResults));
                    }
                }

                @Override
                public void onFailure(Call<FortuneResultResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }catch (Exception e){
            Log.d(TAG, "retrofit block : " + e.toString());
        }
    }





}
