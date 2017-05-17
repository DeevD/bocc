package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.DataFootballResult;

/**
 * Created by smmon on 5/12/17.
 */

public class AdapterFootballResult extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    List<DataFootballResult> data = Collections.emptyList();
    DataFootballResult current;
    int currentPos = 0;


    public AdapterFootballResult(Context context, List<DataFootballResult> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.football_result_list, parent, false);
        FootballResultHolder footballResultHolder = new FootballResultHolder(view);
        return footballResultHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FootballResultHolder footballResultHolder = (FootballResultHolder) holder;
        DataFootballResult current = data.get(position);

        footballResultHolder.txtResultDate.setText(current.match_date);
        footballResultHolder.txtResultContent.setText(current.content);

        /*String content_result = current.content;
        String[] arrContent = content_result.split(":");
        Log.d("#TestData", arrContent[0]);*/

        if((position % 2) == 0){
            footballResultHolder.rlFootballRowContainer.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Blue300));
        }
        else{
            footballResultHolder.rlFootballRowContainer.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Blue100));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FootballResultHolder extends RecyclerView.ViewHolder
    {
        TextView txtResultDate;
        TextView txtResultContent;
        RelativeLayout rlFootballRowContainer;
        public FootballResultHolder(View itemView) {
            super(itemView);
            txtResultDate = (TextView) itemView.findViewById(R.id.tv_resultDate);
            txtResultContent = (TextView) itemView.findViewById(R.id.tv_resultContent);
            rlFootballRowContainer = (RelativeLayout) itemView.findViewById(R.id.rl_footballRowContainer);
        }
    }
}
