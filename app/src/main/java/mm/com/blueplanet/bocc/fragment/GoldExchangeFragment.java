package mm.com.blueplanet.bocc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.bohush.geometricprogressview.GeometricProgressView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.AdapterGoldAndExchangeRate;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRate;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRateResponse;
import mm.com.blueplanet.bocc.rest.ApiClient;
import mm.com.blueplanet.bocc.rest.ApiInterface;
import mm.com.blueplanet.bocc.utility.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 5/28/2017.
 */

public class GoldExchangeFragment extends Fragment {
    RecyclerView recyclerView;
    List<GoldAndExchangeRate> goldList;
    public static final String LOG = " GOlD EXCHANGE";
    AdapterGoldAndExchangeRate adapterGoldAndExchangeRate;
    CardView cardView;
    public static GoldExchangeFragment newInstance() {
        GoldExchangeFragment fragment = new GoldExchangeFragment();
        return fragment;
    }
    TextView goldText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.gold_exchange_frag, container, false);

        goldList = new ArrayList<>();
        goldText = (TextView)view.findViewById(R.id.gold_exchange_text);
        goldText.setVisibility(View.INVISIBLE);

        recyclerView = (RecyclerView) view.findViewById(R.id.gold_exchnage_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapterGoldAndExchangeRate = new AdapterGoldAndExchangeRate(goldList, R.layout.ger_card_list, getActivity());
        recyclerView.setAdapter(adapterGoldAndExchangeRate);
        loadAPIGOLD();

        return view;
    }

    private void loadAPIGOLD() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<GoldAndExchangeRateResponse> call = apiInterface.getLatestGoldAndExchangeRate(Constants.API_kEY);
        call.enqueue(new Callback<GoldAndExchangeRateResponse>() {
            @Override
            public void onResponse(Call<GoldAndExchangeRateResponse> call, Response<GoldAndExchangeRateResponse> response) {
                int statusCode = response.code();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    goldList = response.body().getResults();
                    //Log.d(TAG, "result :"+goldAndExchangeRates.toString());
                    GeometricProgressView geometricProgressView = (GeometricProgressView) getActivity().findViewById(R.id.progressView);
                    geometricProgressView.setDuration(1000);
                    geometricProgressView.setVisibility(View.GONE);
                    goldText.setVisibility(View.VISIBLE);
                    goldText.setBackgroundColor(Color.parseColor("#2196F3"));
                    recyclerView.setAdapter(new AdapterGoldAndExchangeRate(goldList, R.layout.ger_card_list, BOCCApp.getContext()));
                }

            }

            @Override
            public void onFailure(Call<GoldAndExchangeRateResponse> call, Throwable t) {
                // Log error  here  since request  failed
                Log.e(LOG, t.toString());
            }
        });

    }
}
