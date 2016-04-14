package com.botou.hx.marketclient.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;

import com.botou.hx.marketclient.R;
import com.botou.hx.marketclient.fragment.ShopFragment;

public class MainActivity extends AbsBaseActivity{
    private TabHost tabHost;
    private FragmentManager fm;
    private static int count = 0;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        initTabHost(R.layout.tab_shop_fragment, R.id.tabShop);
        initTabHost(R.layout.tab_work_fragment, R.id.tabWork);
        initTabHost(R.layout.tab_card_fragment, R.id.tabCard);
        initTabHost(R.layout.tab_me_fragment, R.id.tabMe);
        tabHost.setCurrentTab(0);
    }

    @Override
    protected void initData() {
        fm = getSupportFragmentManager();
        initFragment();
    }

    private void initTabHost(int idNew, int idOld){
        TabHost.TabSpec spec = tabHost.newTabSpec("spec" + count);
        View tabView = getLayoutInflater().inflate(idNew, null);
        spec.setIndicator(tabView);
        spec.setContent(idOld);
        tabHost.addTab(spec);
    }

    private void initFragment(){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.tabShop, new ShopFragment());
        ft.replace(R.id.tabWork, new Fragment());
        ft.replace(R.id.tabCard, new Fragment());
        ft.replace(R.id.tabMe, new Fragment() );
        ft.commit();
    }
}
