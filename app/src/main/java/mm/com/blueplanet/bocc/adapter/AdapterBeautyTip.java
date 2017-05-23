package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.BeautyTip;

/**
 * Created by smmon on 5/16/17.
 */

public class AdapterBeautyTip extends RecyclerView.Adapter<AdapterBeautyTip.BeautyTipViewHolder>{
    private List<BeautyTip> beautyTips;
    private int rowLayout;
    private Context context;

    public AdapterBeautyTip(List<BeautyTip> beautyTips, int rowLayout, Context context) {
        this.beautyTips = beautyTips;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public BeautyTipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new BeautyTipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyTipViewHolder holder, int position) {
        holder.publishedDate.setText(beautyTips.get(position).getDate());
        holder.content.setText(beautyTips.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return  beautyTips.size();
    }

    public static class BeautyTipViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout beautyTipLayout;
        TextView publishedDate;
        TextView content;

        public BeautyTipViewHolder(View itemView) {
            super(itemView);

            beautyTipLayout = (LinearLayout) itemView.findViewById(R.id.ll_beautyTipCard);
            publishedDate = (TextView) itemView.findViewById(R.id.tv_beauty_tip_date);
            content = (TextView) itemView.findViewById(R.id.tv_beauty_tip_content);

        }
    }



}
