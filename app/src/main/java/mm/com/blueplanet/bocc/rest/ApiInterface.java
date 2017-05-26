package mm.com.blueplanet.bocc.rest;

import mm.com.blueplanet.bocc.data.model.BeautyTipResponse;
import mm.com.blueplanet.bocc.data.model.FortuneResult;
import mm.com.blueplanet.bocc.data.model.FortuneResultResponse;
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRateResponse;
import mm.com.blueplanet.bocc.data.model.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by smmon on 5/16/17.
 */

public interface ApiInterface {

    @GET("?route=latest_beauty_tip")
    Call<BeautyTipResponse> getLatestBeautyTip(@Query("api_key") String api_key);

    @GET("?route=latest_gold_and_exchange_rate")
    Call<GoldAndExchangeRateResponse> getLatestGoldAndExchangeRate(@Query("api_key") String api_key);

    @GET("?route=latest_news")
    Call<NewsResponse> getLatestNews(@Query("api_key") String api_key);

    @GET("?route=fortune_result")
    Call<FortuneResultResponse> getFortuneResultByKeyword(@Query("api_key") String api_key, @Query("keyword") String keyword);


}
