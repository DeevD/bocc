package mm.com.blueplanet.bocc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.data.model.CallCenter;
import mm.com.blueplanet.bocc.database.DBHandler;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class Call_Center_AnimationAdapter extends BaseQuickAdapter<CallCenter, BaseViewHolder> {

    ArrayList<CallCenter> mList;
    Context mContext;
    ShineButton shineButton;

    public Call_Center_AnimationAdapter(Context context, ArrayList<CallCenter> list) {
        super( R.layout.call_center_item,list);
        this.mList = list;
        mContext= context;

    }



    public enum CustomType
    {
        CALLCENTER(1),
        GOV(2),
        EMG(3);
        private final int value ;

        CustomType(final int customValue) {
            value = customValue;
        }
    }

    @Override
    protected void convert(final BaseViewHolder helper, final CallCenter item) {

//        if (shineButton != null)
//            shineButton.init(mContext.getApplicationContext());
//        shineButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        helper.setText(R.id.text_view_hotline, item.getPhone() + " " + "HotLine");
        helper.setText(R.id.text_des, item.getDesc());
        helper.getView(R.id.shinebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"hello i'm shine button",Toast.LENGTH_LONG).show();

                DBHandler dbHandler = new DBHandler(mContext);
                dbHandler.insertFav(item);
            }
        });

        //        Picasso.with(mContext).load(item.album_image).into((ImageView) helper.getView(R.id.img));
        helper.setImageResource(R.id.news_icon, item.getIcon());
    }
}
