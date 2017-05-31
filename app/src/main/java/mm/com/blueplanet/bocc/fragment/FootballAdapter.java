package mm.com.blueplanet.bocc.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.DataFootballResult;

/**
 * Created by Lenovo on 5/29/2017.
 */

public class FootballAdapter extends BaseQuickAdapter<DataFootballResult,BaseViewHolder>{
    List<DataFootballResult>data ;
    Context mContext;

    public FootballAdapter(List<DataFootballResult> data,Context context) {
        super(R.layout.football_result_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataFootballResult item) {
        helper.setText(R.id.tv_resultDate,item.match_date);
        helper.setText(R.id.tv_resultContent,item.content);
    }
}
