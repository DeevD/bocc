package mm.com.blueplanet.bocc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import mm.com.blueplanet.bocc.BOCCApp;
import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.CallCenterDetailActivity;
import mm.com.blueplanet.bocc.activity.DetailHotline;
import mm.com.blueplanet.bocc.adapter.Call_Center_AnimationAdapter;
import mm.com.blueplanet.bocc.data.model.CallCenter;
import mm.com.blueplanet.bocc.database.DBHandler;

/**
 * Created by Lenovo on 5/25/2017.
 */

public class CallCenterFragment extends Fragment {
    Call_Center_AnimationAdapter adapter;
    ArrayList<CallCenter> callCenters;
    RecyclerView recyclerView;
    Paint p;
    ShineButton shineButton;
    DBHandler mDBHanlder;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.call_center_frag, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.call_center_rcycler_view);
        p = new Paint();

        shineButton = (ShineButton)view.findViewById(R.id.shinebutton);


        callCenters = new ArrayList<>();

        callCenters.add(new CallCenter(" 1875 Hotline" +
                " သည္ လူႀကီးမင္းတို႕အတြက္ ဂဏန္းေဗဒင္၊ ေန႕သားေဗဒင္၊ ေနာက္ဆုံးရေဘာလုံးပြဲစဥ္မ်ား၊ အားကစားသတင္းမ်ား၊ ေဘာလုံးပြဲရလဒ္မ်ား၊ IT & Mobile Help Desk ၊ အလွအပေရးရာနွင့္ ကုန္စည္ဒိုင္ေစ်းႏႈန္းမ်ားနွင့္" +

                " အလုပ္အကိုင္ရွာေဖြေရး ဝန္ေဆာင္မႈမ်ားအား အခ်ိန္နွင့္တေျပးညီ" +
                " ေျဖၾကားေပးသည့္ Blue Ocean Contact Center ၏ hotline ဝန္ေဆာင္မႈ တစ္ခုျဖစ္ပါသည္။ ", "1875", "လူႀကီးမင္းတို႕အေနျဖင့္ မိမိတို႕၏ လူမႈဘဝစိတ္ခံစားမႈမ်ား၊ အခ်စ္ေရး အိမ္ေတာင္ေရး ျပႆနာမ်ား၊ " +
                "မိသားစုေရးရာကိစၥမ်ား၊ အထီးက်န္ စိတ္ဖိစီးမႈမ်ားကိုလည္း စိတ္ခ်ယုံၾကည္စြာ ဆက္သြယ္ေဆြးေႏြးၿပီး အၾကံḩာဏ္မ်ားရယူနိုင္ပါသည္။", "ေန့စဥ္ဘ၀အေရး သိခ်င္တာေမး", R.drawable.ic_1875));
        callCenters.add(new CallCenter(" 1876 Hotline သည္ လူၾကီးမင္းတို့၏ အေထြေထြစံုစမ္းမွုမ်ားကို ၂၄နာရီပတ္လံုး ေၿဖၾကားေပးသည့္ Hotline ၀န္ေဆာင္မွုတစ္ခုၿဖစ္ပါသည္။  \n 1876 Hotline ၏ Directory Service တြင္ စီးပြားေရးလုပ္ငန္းမ်ား၏ ဖုန္းနံပါတ္မ်ား၏ဖုန္းနံပါတ္ႏွင့္ လိပ္စာမ်ား၊ ဌာနဆိုင္ရာလုပ္ငန္းမ်ား၏ ဖုန္းနံပါတ္ႏွင့္ လိပ္စာမ်ား၊ ေဆးရံု၊ေဆးခန္း၊ဟုိတယ္၊ရုုပ္ရွင္၊ ပန္းၿခံ ၊ shopping center ၊ အသင္းအဖြဲ့မ်ား၏ လိပ္စာမ်ား အစရွိသည္တို့ကို ေမးၿမန္းနိုင္ပါသည္။ \n" +
                " ထို့အၿပင္ အခ်ိန္ႏွင့္တေၿပးညီ ၏ ေရႊေစ်းႏွင့္ ေငြေၾကးလဲလွယ္ႏွဳန္းမ်ား၊ မိုးေလ၀သ သတင္းမ်ား၊ ေၿမငလ်င္သတင္း ၊ မီးေလာင္မွုသတင္းမ်ား ၊ လတ္တေလာ Update သတင္မ်ား ၊ တပတ္အတြင္း ရံုတင္ ၿပသလ်က္ရွိေသာ ဇာတ္ကားမ်ား၊ ေဖ်ာ္ေၿဖပြဲလတ္မွတ္ ၀န္ေဆာင္မွုမ်ားအတြက္ ဆက္သြယ္ေမးၿမန္းႏိုင္ပါသည္။ \n အေထြေထြ ဗဟုသုတမ်ားကိုလည္း ေၿဖၾကားေပးလ်က္ရွိပါသည္။  ", "1876", "", "လြယ္လြယ္ကူကူအခ်ိန္မေရြး သိခ်င္တာေမး", R.drawable.ic_1876));
        callCenters.add(new CallCenter("1877 hotline သည္ လူႀကီးမင္းတို႕အတြက္ က်န္းမာေရး ဝန္ေဆာင္မႈမ်ားကို ေပးေနသည့္ Doctor On Call Health Care Service တစ္ခုျဖစ္ပါသည္။\n" +
                "လူႀကီးမင္းတို႕၏ က်န္းမာေရးျပႆနာမ်ားကို လုံျခံဳစိတ္ခ်စြာ တိုင္ပင္ေဆြးေႏြးနိုင္သည့္အျပင္ လူႀကီးမင္းတို႕၏ က်န္းမာေရးလိုအပ္ခ်က္အလုိက္ သင့္ေတာ္ေသာ ေဆးရုံေဆးခန္း ဓါတ္ခြဲခန္းလိပ္စာမ်ားကိုလည္း လမ္းညႊန္ေပးလ်က္ရွိပါသည္။ \n", "1877", "", " Healthcare Made Easy", R.drawable.ic_1877));
        callCenters.add(new CallCenter(" 1880 Hotline သည္ လူႀကီးမင္းတို႕၏ အသက္အႏၱရာယ္ျဖစ္ပြားျခင္း၊ ရန္ကုန္ၿမိဳ႕တြင္း ဧရိယာထဲတြင္ အေရးေပၚေသြးလိုအပ္ျခင္း၊ ေအာက္စီဂ်င္ဘူး လိုအပ္ျခင္းတို႕အတြက္ ၂၄ နရီပါတ္လုံး ဆက္သြာယ္ေျျမးျမန္း\n" +
                "အကူအညီရယူနိုင္သည့္ ဝန္ေဆာင္မႈတစ္ခုျဖစ္ပါသည္။\n", "1880", "", "အျမန္လမ္းအေရးေပါ္ (၂၄)နာရီကူညီမည့္", R.drawable.ic_1880));
        callCenters.add(new CallCenter(" 1883 Hotline သည္ ျပည္ၾကားေရးဝန္ႀကီးဌာန၏ Call Center Hotline တစ္ခုျဖစ္ျပီး ျပည္တြင္းသတင္းမ်ား၊ မိုးေလဝသသတင္းမ်ား၊ ေနာက္ဆုံးရ ထူးျခားျဖစ္စဥ္တင္းမ်ားကို ဆက္သြယ္ေမးျမန္းနိုင္ပါသည္၊\n" +
                "ဝန္ႀကီးဌာနႏွင့္ ပတ္သက္ေသာ သတင္းမ်ားနွင့္ အင္တာနက္မွ သတင္းမ်ားကိုလည္း အတည္ျပဳေမးျမန္းနိုင္ပါသည္။\n ", "1883", "", "ထူးျခားသတင္းမ်ားအေရး ေန႔စဥ္ေမး", R.drawable.ic_1883));
        callCenters.add(new CallCenter(" 1886 Hotline သည္ လူႀကီးမင္းတို႕ ခရီးသြားလာရာတြင္ အဆင္ေျပေခ်ာေမြ႕လြယ္ကူေအာင္ ေဆာင္ရြက္ေပးေနေသာ Travel Hotline တစ္ခုျဖစပါသည္။\n" +
                "ျမန္မာျပည္အနွံ႕ အေဝးေျပးကားလက္မွတ္မ်ား၊ ျပည္တြင္း-ျပည္ပ ေလယာဥ္လက္မွတ္မ်ားကို ဖုန္းတစ္ခ်က္ဆက္ရုံျဖင့္ အိမ္တိုင္ရာေရာက္ လိုက္လံပို႕ေဆာင္ေပးပါသည္။" +
                "                        n\"ထို႕အျပင္ ေခ်ာင္းသာ၊ ေငြေဆာင္၊ ငပလီ ကမ္းေျခအပန္းေျဖခရီးစဥ္မ်ား၊ ျပည္တြင္းျပည္ပဘုရားဖူးနွင့္ အပန္းေျဖခရီးစဥ္မ်ား၊ Hotel Booking ျပဳလုပ္ေပးျခင္းမ်ား စသည့္ ဝန္ေဆာင္မႈမ်ားကိုလည္း လူႀကီးမင္းတို႕ စိတ္တိုင္းက်ေဆာင္ရြက္ေပးလ်က္ရွိပါသည္။\n ", "1886", "", "ထူးျခားသတင္းမ်ားအေရး ေန႔စဥ္ေမး", R.drawable.ic_1886));


        adapter = new Call_Center_AnimationAdapter(getActivity(), callCenters);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(),DetailHotline.class);
                intent.putExtra("callcenter",callCenters.get(position));
                startActivity(intent);
            }
        });
        initSwipe();
        return view;
    }


    private void initSwipe() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT) {
//                    adapter.removeItem(position);
                    Uri call = Uri.parse(callCenters.get(position).getPhone());
                    Intent surf = new Intent(Intent.ACTION_DIAL, call);
                    surf.setData(Uri.parse("tel:" +call));
                    getActivity().startActivity(surf);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(),"Swipe Left" + callCenters.get(position).getPhone(),Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getActivity(),"Swipe Right",Toast.LENGTH_LONG).show();
                    mDBHanlder = new DBHandler(getActivity());
                    mDBHanlder.insertFav(callCenters.get(position));
                    Toast.makeText(getActivity()," successful adding fav call center ", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
//                    removeView();
//                    edit_position = position;
//                    alertDialog.setTitle("Edit Country");
//                    et_country.setText(countries.get(position));
//                    alertDialog.show();
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;

                Drawable phone = getResources().getDrawable(R.drawable.phone_slide);
                Bitmap bitmap_phone = drawableToBitmap(phone);
                Drawable favr = getResources().getDrawable(R.drawable.fav);
                Bitmap bitmap_fav = drawableToBitmap(favr);
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if (dX > 0) {
                        p.setColor(Color.parseColor("#F44336"));//388E3C 388E3C D32F2F
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX, (float) itemView.getBottom());
                        c.drawRect(background, p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                        if(bitmap_fav != null) c.drawBitmap(bitmap_fav,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background, p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_forward_white);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
                        if(bitmap_phone != null) c.drawBitmap(bitmap_phone,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

}
