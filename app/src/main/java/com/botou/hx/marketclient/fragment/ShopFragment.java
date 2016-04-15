package com.botou.hx.marketclient.fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.botou.hx.marketclient.BaseApplication;
import com.botou.hx.marketclient.R;
import com.botou.hx.marketclient.adapter.ShopAdapter;

/**
 * Created by Administrator on 2016/4/13.
 */
public class ShopFragment extends BaseFragment {
    private ShopAdapter shopAdapter;
    private Toolbar shopToolbar;
    private RecyclerView shopRv;

    @Override
    protected void initData() {
        shopAdapter = new ShopAdapter();
        shopRv = new RecyclerView(BaseApplication.getmContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(BaseApplication.getmContext());
        shopRv.setLayoutManager(manager);
        shopRv.setAdapter(shopAdapter);
    }

    @Override
    protected void initView(View view) {
        initToolbar(view);
    }
    private void initToolbar(View view){
        shopToolbar = findView(R.id.shopToolbar, view);
        shopToolbar.setTitle("首页");

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_shop;
    }
}
