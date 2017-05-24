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
import mm.com.blueplanet.bocc.data.model.News;

/**
 * Created by smmon on 5/24/17.
 */

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsViewHolder>
{
    private List<News> newses;
    private int rowLayout;
    private Context context;

    public AdapterNews(List<News> beautyTips, int rowLayout, Context context) {
        this.newses = beautyTips;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.keyword.setText(newses.get(position).getKeyword());
        holder.publishedDate.setText(newses.get(position).getDate());
        holder.content.setText(newses.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return newses.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout newsLayout;
        TextView keyword;
        TextView publishedDate;
        TextView content;

        public NewsViewHolder(View itemView) {
            super(itemView);

            newsLayout = (LinearLayout) itemView.findViewById(R.id.ll_news);
            publishedDate = (TextView) itemView.findViewById(R.id.tv_news_post_date);
            content = (TextView) itemView.findViewById(R.id.tv_news_content);
            keyword = (TextView) itemView.findViewById(R.id.tv_news_heading);

        }
    }
}
