package com.seoullo_one;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activity.BaseActivity;


/**
 * Created by S on 2017-10-21.
 */

public class Util extends BaseActivity {
    public static void setGlobalFont(Context context, View view){
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int len = vg.getChildCount();
                for (int i = 0; i < len; i++) {
                    View v = vg.getChildAt(i);
                    if (v instanceof TextView) {
                        ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "BM-HANNA_0.ttf"));
                    }
                    setGlobalFont(context, v);
                }
            }
        }
    }
}
