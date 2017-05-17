package mm.com.blueplanet.bocc.rest;

import mm.com.blueplanet.bocc.data.model.BeautyTipResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by smmon on 5/16/17.
 */

public interface ApiInterface {

    @GET("?route=latest_beauty_tip")
    Call<BeautyTipResponse> getLatestBeautyTip(@Query("api_key") String api_key);
}
