package mm.com.blueplanet.bocc.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.adapter.AdapterFootballResult;
import mm.com.blueplanet.bocc.data.DataFootballResult;

/**
 * Created by smmon on 3/13/17.
 */

public class FootballFragment extends Fragment {

    //Timeout counts are in milli-second
    public static final int  CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 150000;
    private static final String API_KEY = "04ec12fb6fbe96d25a4d5186b221596a";
    public View mView;
    private RecyclerView mRVFootballResult;
    private AdapterFootballResult mAdapter;


    public static FootballFragment newInstance(){
        FootballFragment fragment = new FootballFragment();
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_football, container, false);
        new FootballResultAsync().execute();
        return  mView;
    }

    private class FootballResultAsync extends AsyncTask<String, String, String>{
        ProgressDialog pdLoading = new ProgressDialog(getContext());
        HttpURLConnection conn;
        URL url = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\t Results are loading ...");
            pdLoading.setCancelable(true);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try{
                //A URL that produce json format and is either json file or php
                //url = new URL("http://ooredoo.blueplanet.com.mm/bocc/?route=football_result&api_key="+API_KEY);
                url = new URL("http://192.168.100.195/bocc/?route=football_result&api_key="+API_KEY);
                //url = new URL("http://192.168.100.195/bocc/store/result_sample.json");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }

            try{
                //Setup HttpURLConnection class to send and receive date from web app
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                //setDoOutput to true as we receive data from json file
                conn.setDoOutput(true);
            }catch (IOException e1){
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try{
                int response_code = conn.getResponseCode();
                //Check if successful connection
                if(response_code == HttpURLConnection.HTTP_OK){
                    //Read the data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while((line = reader.readLine()) != null){
                        result.append(line);
                    }
                    //Pass data to onPostExecute Method
                    return (result.toString());
                }
                else{
                    return ("Unsuccessfull http url connection");
                }
            } catch (IOException e) {

                e.printStackTrace();
                return e.toString();
            }


        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(s);

            //this method will run on UI thread
            pdLoading.dismiss();
            List<DataFootballResult> data = new ArrayList<>();
            pdLoading.dismiss();
            Log.d("#API_Data", result);

            try {
                JSONArray jArray = new JSONArray(result);

                //Extract data from json and store into ArrayList  as  class objects
                for (int i=0; i<jArray.length(); i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    DataFootballResult dataFootballResult = new DataFootballResult();

                    dataFootballResult.match_id= json_data.getInt("id");
                    dataFootballResult.content = json_data.getString("content");
                    dataFootballResult.match_date = json_data.getString("match_date");
                    data.add(dataFootballResult);

                    //Setup and handover data to recycler view
                    mRVFootballResult = (RecyclerView) mView.findViewById(R.id.rv_footballResult);
                    mAdapter = new AdapterFootballResult(getContext(), data);
                    mRVFootballResult.setAdapter(mAdapter);
                    mRVFootballResult.setLayoutManager(new LinearLayoutManager(getContext()));
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getContext(),e.toString(), Toast.LENGTH_LONG).show();
            }

        }
    }

}
