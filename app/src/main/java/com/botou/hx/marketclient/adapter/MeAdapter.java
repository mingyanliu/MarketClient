package com.botou.hx.marketclient.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by Amethyst on 16/4/15/10/25.
 */
public class MeAdapter extends BaseAdapter {
    public MeAdapter(List dataList, Context context) {
        super(dataList, context);
    }

    @Override
    protected void onBindData(ViewHolder holder, Object data) {

    }

    @Override
    protected ViewHolder onCreateHolder(View view) {
        return null;
    }

    @Override
    protected int onItemCreate() {
        return 0;
    }
}
