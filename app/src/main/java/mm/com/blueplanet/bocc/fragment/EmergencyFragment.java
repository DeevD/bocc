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
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

import mm.com.blueplanet.bocc.R;
import mm.com.blueplanet.bocc.activity.DetailEmergecny;
import mm.com.blueplanet.bocc.activity.DetailHotline;
import mm.com.blueplanet.bocc.adapter.Emergency_AnimationAdapter;
import mm.com.blueplanet.bocc.data.model.Emergency;

/**
 * Created by Lenovo on 5/25/2017.
 */

public class EmergencyFragment extends Fragment{
    RecyclerView recyclerView;
    ArrayList<Emergency>emergencies;
    Paint p = new Paint();
    Emergency_AnimationAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.call_center_frag,container,false);
        emergencies = new ArrayList<>();
        emergencies.add(new Emergency("High way Ambulance","1880",  "အေရးေပၚ",
                "အေရးေပၚ",R.drawable.ic_high_way_ambulance));
        emergencies.add(new Emergency("Police","199",  "ရဲတပ္ဖြဲ႕",
                "ရဲတပ္ဖြဲ႕",R.drawable.ic_police));
        emergencies.add(new Emergency("Fire Station","191",  "မီးသတ္",
                "မီးသတ္",R.drawable.ic_fire));
        emergencies.add(new Emergency("Ambulance","192",  "အေရးေပၚ",
                "အေရးေပၚ",R.drawable.ic_ambulance));

        adapter = new Emergency_AnimationAdapter(getActivity(),emergencies);
        recyclerView = (RecyclerView)view.findViewById(R.id.call_center_rcycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent detail = new Intent(getActivity(), DetailEmergecny.class);
                detail.putExtra("emergency",emergencies.get(position));
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
                    Uri call = Uri.parse(emergencies.get(position).getPhone());
                    Intent surf = new Intent(Intent.ACTION_DIAL, call);
                    surf.setData(Uri.parse("tel:" +call));
                    getActivity().startActivity(surf);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(),"Swipe Left" + emergencies.get(position).getPhone(),Toast.LENGTH_LONG).show();

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
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                        if(bitmap_fav != null) c.drawBitmap(bitmap_fav,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background, p);
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
