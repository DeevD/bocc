package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.Emergency;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class Emergency_AnimationAdapter extends BaseQuickAdapter<Emergency, BaseViewHolder> {

    ArrayList<Emergency> mList;
    Context mContext;
    ShineButton shineButton;

    public Emergency_AnimationAdapter(Context context, ArrayList<Emergency> list) {
        super( R.layout.call_center_item,list);
        this.mList = list;
        mContext= context;

    }

    @Override
    protected void convert(BaseViewHolder helper, Emergency item) {
        helper.setText(R.id.text_view_hotline,item.getPhone() + " " + "Hotline");
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
