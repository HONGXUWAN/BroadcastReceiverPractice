package com.example.broadcastreceiverpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhongxu on 2017/5/16.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.add(activity);
    }
    public static void finishAll(){
        for (Activity activity : activities){
            activity.finish();
        }
    }
}
