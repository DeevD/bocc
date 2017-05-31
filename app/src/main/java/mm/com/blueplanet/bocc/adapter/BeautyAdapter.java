package mm.com.blueplanet.bocc.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.BeautyTip;

/**
 * Created by Lenovo on 5/29/2017.
 */

public class BeautyAdapter extends BaseQuickAdapter<BeautyTip,BaseViewHolder> {


    public BeautyAdapter(List<BeautyTip> data, Context context) {
        super(R.layout.beautytip_card_list,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BeautyTip item) {
        helper.setText(R.id.tv_beauty_tip_date,item.getDate());
        helper.setText(R.id.tv_beauty_tip_content,item.getContent());
    }
}
