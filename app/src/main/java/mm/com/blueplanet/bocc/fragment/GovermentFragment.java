package mm.com.blueplanet.bocc.fragment;

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

import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.DetailGov;
import mm.com.blueplanet.bocc.adapter.Call_Center_AnimationAdapter;
import mm.com.blueplanet.bocc.adapter.Goverment_AnimationAdapter;
import mm.com.blueplanet.bocc.data.model.CallCenter;
import mm.com.blueplanet.bocc.data.model.Goverment;

/**
 * Created by Lenovo on 5/25/2017.
 */

public class GovermentFragment extends Fragment {
    Goverment_AnimationAdapter adapter;
    ArrayList<Goverment> callCenters;
    RecyclerView recyclerView;
    Paint p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.call_center_frag, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.call_center_rcycler_view);
        p = new Paint();
        callCenters = new ArrayList<>();

        callCenters.add(new Goverment("   နိုင္ငံေတာ္သမၼတရုံး", "012399666",  "နိုင္ငံေတာ္သမၼတရုံး",  "နိုင္ငံေတာ္သမၼတရုံး",R.drawable.ic_president_office));
        callCenters.add(new Goverment("အလုပ္သမား", "01667644",  "အလုပ္သမား",  "အလုပ္သမား",R.drawable.ic_labour));
        callCenters.add(new Goverment("လဝက", "067431062",  "လဝက",  "လဝက",R.drawable.ic_moip));



        adapter = new Goverment_AnimationAdapter(getActivity(), callCenters);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent detail = new Intent(getActivity(), DetailGov.class);
                detail.putExtra("gov",callCenters.get(position));
                startActivity(detail);
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
//                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                        if(bitmap_fav != null) c.drawBitmap(bitmap_fav,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background, p);
//                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_forward_white);
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
