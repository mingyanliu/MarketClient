package com.botou.hx.marketclient.activity;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/13.
 */
public class ActivityControl {
    private static final Map<String, Activity> activityMap = new HashMap<>();

    public static void addAty(String key, Activity aty) {
        activityMap.put(key, aty);
    }

    public static boolean removeAty(String key) {
        Activity aty = activityMap.remove(key);
        if (aty != null) {
            return true;
        }
        return false;
    }

    public static void finishAll(){
        Set<String> activities =  activityMap.keySet();
        for (String key : activities) {
            activityMap.get(key).finish();
        }
    }

}
