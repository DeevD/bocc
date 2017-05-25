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
import mm.com.blueplanet.bocc.data.model.GoldAndExchangeRate;

/**
 * Created by smmon on 5/23/17.
 */

public class AdapterGoldAndExchangeRate extends RecyclerView.Adapter<AdapterGoldAndExchangeRate.GoldAndExchangeRateViewHolder>
{
    private List<GoldAndExchangeRate> goldAndExchangeRates;
    private int rowLayout;
    private Context context;

    public AdapterGoldAndExchangeRate(List<GoldAndExchangeRate> goldAndExchangeRates, int rowLayout, Context context) {
        this.goldAndExchangeRates = goldAndExchangeRates;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public GoldAndExchangeRateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return  new GoldAndExchangeRateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoldAndExchangeRateViewHolder holder, int position) {
        holder.tvGerDate.setText(goldAndExchangeRates.get(position).getDate());
        holder.tvGerContent.setText(goldAndExchangeRates.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return goldAndExchangeRates.size();
    }


    public static class GoldAndExchangeRateViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout llGer;
        TextView tvGerDate;
        TextView tvGerContent;

        public GoldAndExchangeRateViewHolder(View itemView) {
            super(itemView);

            llGer = (LinearLayout) itemView.findViewById(R.id.ll_ger);
            tvGerDate = (TextView) itemView.findViewById(R.id.tv_ger_date);
            tvGerContent = (TextView) itemView.findViewById(R.id.tv_ger_content);

        }
    }
}
