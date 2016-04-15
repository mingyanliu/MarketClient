package com.botou.hx.marketclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.botou.hx.marketclient.BaseApplication;
import com.botou.hx.marketclient.R;

/**
 * Created by Amethyst on 16/4/15/09/33.
 */
public class HeaderMudoleAdapter extends RecyclerView.Adapter<HeaderMudoleAdapter.ViewHolder> {

    private int[] imgs = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String[] titles = {"五金", "建材", "品牌", "其他"};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(BaseApplication.getmContext()).inflate(R.layout.header_module_item, null, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(titles[position]);
        holder.iv.setImageResource(imgs[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.moduleIV);
            tv = (TextView) itemView.findViewById(R.id.moduleTV);
        }
    }
}
