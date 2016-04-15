package com.botou.hx.marketclient.adapter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.botou.hx.marketclient.BaseApplication;
import com.botou.hx.marketclient.R;

/**
 * Created by Administrator on 2016/4/13.
 */
public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ARGS_WHAT = 0x1101;
    private static final int DELAY_TIME = 2000;
    private LayoutInflater layoutInflater;
    private Handler mainHandler = new Handler();
    private HandlerThread mHandlerThread;
    private boolean controlThread = false;
    private Handler mHandler;
    public ShopAdapter() {
        layoutInflater = LayoutInflater.from(BaseApplication.getmContext());
    }

    //建立枚举 2个item 类型
    public enum ITEM_TYPE {
        ITEM1,
        ITEM2,
        ITEM3
    }
    /*根据位置的不同加载不同的布局*/
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//       if (ITEM_TYPE.ITEM1.ordinal() == viewType){
        Toast.makeText(BaseApplication.getmContext(), "444", Toast.LENGTH_SHORT).show();

        return new ViewHolderITEM1(layoutInflater.inflate(R.layout.shop_carousel_item, null));
//       }else if (ITEM_TYPE.ITEM2.ordinal() == viewType){
//           return new ViewHolderITEM2(layoutInflater.inflate(R.layout.shop_carousel_item, null));
//       } else {
//           return new ViewHolderITEM3(layoutInflater.inflate(R.layout.shop_carousel_item, null));
//       }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0)
        if (holder instanceof ViewHolderITEM1){
            CarouselAdapter adapter = new CarouselAdapter(BaseApplication.getmContext());
            ((ViewHolderITEM1) holder).pager.setAdapter(adapter);
            initThread(((ViewHolderITEM1) holder).pager);
            HeaderMudoleAdapter adapter1 = new HeaderMudoleAdapter();
            RecyclerView.LayoutManager manager = new LinearLayoutManager(BaseApplication.getmContext(), LinearLayoutManager.HORIZONTAL,false);
            ((ViewHolderITEM1) holder).shopRv.setLayoutManager(manager);
            ((ViewHolderITEM1) holder).shopRv.setAdapter(adapter1);
        }
    }
/*保证轮播图能够显示即便第一个位置没有数据也能够显示*/
    @Override
    public int getItemCount() {
        return 1;
    }

    /*根据位置的不同，返回不同样式*/
//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0){
//            return ITEM_TYPE.ITEM1.ordinal();
//
//        }else if (position % 2 == 1){
//            return ITEM_TYPE.ITEM2.ordinal();
//        }
//        return ITEM_TYPE.ITEM3.ordinal();
//    }

    //轮播图的位置显示位置0
    class ViewHolderITEM1 extends RecyclerView.ViewHolder{
        private ViewPager pager;
        private RecyclerView shopRv;
        private TextView bargainTv;

        public ViewHolderITEM1(View itemView) {
            super(itemView);
            pager = (ViewPager) itemView.findViewById(R.id.shopVp);
            shopRv = (RecyclerView) itemView.findViewById(R.id.shopRv);
            bargainTv = (TextView) itemView.findViewById(R.id.bargainTv);
        }
    }

    //当位置为基数显示的布局
    class ViewHolderITEM2 extends RecyclerView.ViewHolder{
        public ViewHolderITEM2(View itemView) {
            super(itemView);
        }
    }

    //当位置为偶数显示的布局，0进行了特殊的定义
    class ViewHolderITEM3 extends RecyclerView.ViewHolder{
        public ViewHolderITEM3(View itemView) {
            super(itemView);

        }
    }

    private void initThread(final ViewPager viewPager) {
        mHandlerThread = new HandlerThread("loop_viewPager");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                runChangePager(viewPager);
                if (controlThread) {
                    mHandler.sendEmptyMessageDelayed(ARGS_WHAT, DELAY_TIME);
                }
            }
        };
    }

    private void runChangePager(final ViewPager viewPager) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                int index = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++index);
            }
        });
    }
}
