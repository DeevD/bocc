package mm.com.blueplanet.bocc.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.bohush.geometricprogressview.GeometricProgressView;
import net.bohush.geometricprogressview.TYPE;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.AdapterNews;
import mm.com.blueplanet.bocc.data.model.News;
import mm.com.blueplanet.bocc.data.model.NewsResponse;
import mm.com.blueplanet.bocc.rest.ApiClient;
import mm.com.blueplanet.bocc.rest.ApiInterface;
import mm.com.blueplanet.bocc.utility.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 5/28/2017.
 */

public class NewFragment extends android.support.v4.app.Fragment {
    RecyclerView recyclerView;
    AdapterNews news;
    List<News> newsList;
    TextView new_text;
    public static NewFragment newInstance()
    {
        NewFragment fragment = new NewFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.news_fragment,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.news_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        newsList = new ArrayList<>();
        new_text = (TextView)view.findViewById(R.id.news_text);
        new_text.setVisibility(View.INVISIBLE);

//        GeometricProgressView progressView = (GeometricProgressView)view.findViewById(R.id.progressView);
//        progressView.setType(TYPE.KITE);
//        progressView.setNumberOfAngles(6);
//        progressView.setColor(Color.parseColor("#00897b"));
//
//        progressView.setDuration(5000);
//        progressView.setFigurePadding(getResources().getDimensionPixelOffset(R.dimen.figure_padding));

        LoadFromAPI();

//        if (newsList!=null)
//        {
//            progressView.setVisibility(View.GONE);
//        }
        news = new AdapterNews(newsList,R.layout.news_card_list,getActivity());
        recyclerView.setAdapter(news);
        return view;
    }

    private void LoadFromAPI() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> callNews = apiInterface.getLatestNews(Constants.API_kEY);
        callNews.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                int  statusCode = response.code();
                if(statusCode == HttpURLConnection.HTTP_OK){
                    newsList= response.body().getResults();

                    recyclerView.setAdapter(new AdapterNews(newsList, R.layout.news_card_list, BOCCApp.getContext()));

                    GeometricProgressView geometricProgressView = (GeometricProgressView) getActivity().findViewById(R.id.progressView);
                    geometricProgressView.setDuration(1000);
                    geometricProgressView.setVisibility(View.GONE);
                    new_text.setVisibility(View.VISIBLE);
                    new_text.setBackgroundColor(Color.parseColor("#2196F3"));

                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("News Fragment ", t.toString());
            }
        });
    }
}
