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
 * Created by Amethyst on 16/4/15/14/07.
 */
public class UserAdapterAdapter extends RecyclerView.Adapter<UserAdapterAdapter.ViewHolder>{
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(BaseApplication.getmContext()).inflate(R.layout.item_user_work, null, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.user_work_iv.setImageResource(R.mipmap.ic_launcher);
        holder.userWorkTitle.setText("用户订单详情");
        holder.userWorkTime.setText("时间" + "2016-4-11" + "至" + "2016-4-18");
        holder.userWorkPrice.setText("$" + (int)(Math.random()*10000));
        holder.userWorkAddress.setText("付家庄国际村" + (int)(Math.random()*1000));
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView user_work_iv;
        private TextView userWorkTitle,userWorkTime,userWorkPrice,userWorkAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            user_work_iv = (ImageView) itemView.findViewById(R.id.user_work_iv);
            userWorkAddress = (TextView) itemView.findViewById(R.id.userWorkAddress);
            userWorkPrice = (TextView) itemView.findViewById(R.id.userWorkPrice);
            userWorkTime = (TextView) itemView.findViewById(R.id.userWorkTime);
            userWorkTitle = (TextView) itemView.findViewById(R.id.userWorkTitle);
        }
    }
}
