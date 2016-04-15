package com.botou.hx.marketclient.fragment;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.botou.hx.marketclient.R;
import com.botou.hx.marketclient.adapter.MeAdapter;

/**
 * Created by Amethyst on 16/4/15/10/17.
 */
public class MeFragment extends BaseFragment {
    Toolbar meToolbar;
    private MeAdapter adapter;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        initToolbar(view);
    }

    private void initToolbar(View view){
        meToolbar = findView(R.id.meToolbar, view);
        meToolbar.setTitle("我的");
    }

    @Override
    protected int getLayout() {
        return R.layout.me_fragment;
    }
}
