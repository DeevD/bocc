package mm.com.blueplanet.bocc.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smmon on 5/16/17.
 */

public class ApiClient {
    private static final String BASE_URL= "http://192.168.100.195/?route=latest_beauty_tip";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }

        return retrofit;
    }
}
