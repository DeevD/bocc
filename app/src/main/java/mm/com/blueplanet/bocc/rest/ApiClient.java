package mm.com.blueplanet.bocc.rest;

import java.util.concurrent.TimeUnit;

import mm.com.blueplanet.bocc.utility.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by smmon on 5/16/17.
 */

public class ApiClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(Constants.READ_TIMOUT, TimeUnit.SECONDS)
                    .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build();


            retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClient)
                            .build();
        }

        return retrofit;
    }
}
