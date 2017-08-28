package com.excelsoftservices.user2.myfriendphotos;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 1000; i <=1500 ; i++) {
            Log.d("Nought",i+" Pixcel = "+Math.round(pxToDp(i))+"dp");
        }
    }
    public float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_260);
        return dp;
    }
    public double pxToDp(double a){
        return a*40/100;
    }
}
