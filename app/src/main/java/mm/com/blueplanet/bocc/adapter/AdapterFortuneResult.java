package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.FortuneResult;

/**
 * Created by smmon on 5/26/17.
 */

public class AdapterFortuneResult extends RecyclerView.Adapter<AdapterFortuneResult.FortuneResultViewHolder> {
    private Context context;
    private int intRowLayout;
    private List<FortuneResult> lstFortuneResult = Collections.emptyList();

    public AdapterFortuneResult(Context context, int intRowLayout, List<FortuneResult> lstFortuneResult) {
        this.context = context;
        this.intRowLayout = intRowLayout;
        this.lstFortuneResult = lstFortuneResult;
    }

    @Override
    public FortuneResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(intRowLayout, parent, false);
        return new FortuneResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FortuneResultViewHolder holder, int position) {
        holder.tvPublishedDate.setText(lstFortuneResult.get(position).getPublishedDate());
        holder.tvContent.setText(lstFortuneResult.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return lstFortuneResult.size();
    }


    public static class FortuneResultViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout llFortuneResultCard;
        TextView tvPublishedDate;
        TextView tvContent;

        public FortuneResultViewHolder(View itemView) {
            super(itemView);
            llFortuneResultCard = (LinearLayout) itemView.findViewById(R.id.ll_fortune_result_card);
            tvPublishedDate = (TextView) itemView.findViewById(R.id.tv_fortune_published_date);
            tvContent = (TextView) itemView.findViewById(R.id.tv_fortune_result_content);

        }
    }


}
