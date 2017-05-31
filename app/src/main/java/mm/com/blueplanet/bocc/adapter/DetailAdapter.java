package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.DetailHotline;
import mm.com.blueplanet.bocc.data.model.CallCenter;

/**
 * Created by Lenovo on 5/30/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {
    int[] dataSetType;
    Context mContext;
    ArrayList<CallCenter> callList = new ArrayList<>();
    CallCenter list;
    public DetailAdapter(Context context, CallCenter callCentersList) {
        mContext= context;
        list = callCentersList;
        callList.add(list);
        dataSetType = new int [callList.size()];

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.test,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("adapter",callList.get(position).getName());
        holder.detailI.setImageResource(callList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return callList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataSetType[position];
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView detailI ;
        public MyViewHolder(View itemView) {
            super(itemView);
            detailI = (ImageView)itemView.findViewById(R.id.detail_icon);

        }
    }
}
