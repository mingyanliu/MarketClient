package com.botou.hx.marketclient.fragment;

import com.botou.hx.marketclient.fragment.BaseFragment;
import com.botou.hx.marketclient.fragment.ShopFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/13.
 */
public class FragmentFactory {
    private static Map<String,BaseFragment> fragmentMap = new HashMap<>();
    public static BaseFragment createFragment(int position){
        BaseFragment f= fragmentMap.get(position);
        if (f == null){
            switch (position){
                case 0:
                    f = new ShopFragment();
                    break;
                case 1:
                    break;
            }
            fragmentMap.put(String.valueOf(position), f);
        }
        return f;
    }
}










