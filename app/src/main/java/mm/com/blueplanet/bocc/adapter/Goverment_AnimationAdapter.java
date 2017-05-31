package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.Goverment;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class Goverment_AnimationAdapter extends BaseQuickAdapter<Goverment, BaseViewHolder> {

    ArrayList<Goverment> mList;
    Context mContext;

    public Goverment_AnimationAdapter(Context context, ArrayList<Goverment> list) {
        super( R.layout.call_center_item,list);
        this.mList = list;
        mContext= context;

    }

    @Override
    protected void convert(BaseViewHolder helper, Goverment item) {
        helper.setText(R.id.text_view_hotline,item.getPhone());
//        helper.setText(R.id.text_view_phone,item.getName());
        helper.setText(R.id.text_des,item.getDesc());
        helper.getView(R.id.shinebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"hello i'm shine button",Toast.LENGTH_LONG).show();
            }
        });
        //        Picasso.with(mContext).load(item.album_image).into((ImageView) helper.getView(R.id.img));
        helper.setImageResource(R.id.news_icon,item.getIcon());
    }
}
