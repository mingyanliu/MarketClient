package com.botou.hx.marketclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.botou.hx.marketclient.BaseApplication;
import com.botou.hx.marketclient.R;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/4/13.
 */
public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater layoutInflater;
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
       if (ITEM_TYPE.ITEM1.ordinal() == viewType){
           return new ViewHolderITEM1(layoutInflater.inflate(R.layout.shop_carousel_item, null, false));
       }else if (ITEM_TYPE.ITEM2.ordinal() == viewType){
           return new ViewHolderITEM2(layoutInflater.inflate(R.layout.shop_carousel_item, null, false));
       } else {
           return new ViewHolderITEM3(layoutInflater.inflate(R.layout.shop_carousel_item, null, false));
       }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
/*保证轮播图能够显示即便第一个位置没有数据也能够显示*/
    @Override
    public int getItemCount() {
        return 1;
    }

    /*根据位置的不同，返回不同样式*/
    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return ITEM_TYPE.ITEM1.ordinal();
        }else if (position % 2 == 1){
            return ITEM_TYPE.ITEM2.ordinal();
        }
        return ITEM_TYPE.ITEM3.ordinal();
    }

    //轮播图的位置显示位置0
    class ViewHolderITEM1 extends RecyclerView.ViewHolder{
        public ViewHolderITEM1(View itemView) {
            super(itemView);
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
}
