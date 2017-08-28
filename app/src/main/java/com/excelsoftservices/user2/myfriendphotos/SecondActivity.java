package com.excelsoftservices.user2.myfriendphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private RelativeLayout mLinearLayout;
    private String[] mIntrests  = null;
    int pos  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mLinearLayout = (RelativeLayout) findViewById(R.id.ll_activity_second);
        mIntrests = new String[]{"Animal Care",	"American Football" ,	"Backpacking",
                "Astronomy",	"Archery	Boating",
                "Birdwatching"	,"Badminton",	"Camping",
                "Blogging"	,"Baseball"	,"Dancing",
                "Collecting"	,"Basketball"	,"Eating Out",
                "Computer"	,"Billiards"	,"Entertaining",
                "Cooking",	"Bowling"	,"Exercise",
                "Crafts"	,"Cricket" ,	"Going to the Movies",
                "Family time",	"Cycling",	"Going to the Beach",
                "Firearms",	"Extreme Sports" 	,"Shooting Range",
               " Handiwork"	,"Fishing",	"Hiking",
                "Gardening",	"Golf",	"Hunting",
                "Knitting",	"Gymnastics",	"Motorcycling",
                "Meditation"	,"Horse Riding",	"Playing Cards",
               " Listening to Music	","Martial Arts",	"Playing Music",
                "Painting",	"Rugby" ,	"Playing Sports",
                "Reading",	"Running","Sewing"};
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        for (int i = 1; i <22 ; i++) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 20;
            layoutParams.bottomMargin = 10;

            if (mLinearLayout.getChildCount() >1) {
                final View view  = mLinearLayout.getChildAt(mLinearLayout.getChildCount() -1);
                RelativeLayout.MarginLayoutParams layoutParams1 = (RelativeLayout.MarginLayoutParams) view.getLayoutParams();


                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int[] loc = new int[2];
                view.getLocationOnScreen(loc);
                int distance = dm.heightPixels - loc[0];
                Log.d("NaN", "distance** "+distance+" "+loc[0]);


                if(i%3   == 0 ) {
                    layoutParams.addRule(RelativeLayout.BELOW, view.getId());

                }
                    else {
                    layoutParams.addRule(RelativeLayout.RIGHT_OF, view.getId());
                    layoutParams.addRule(RelativeLayout.ALIGN_TOP,view.getId());
                }
            } else {
            }

            TextView mTextView= new TextView(this);
            mTextView.setText(mIntrests[i]);
            mTextView.setId(15151111+i);
            mTextView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mTextView.setTextSize(getResources().getDimension(R.dimen._5sdp));
            mTextView.setTextColor(getResources().getColor(R.color.white));
            mTextView.setPadding(4,3,4,3);

            mTextView.setLayoutParams(layoutParams);
            mLinearLayout.addView(mTextView);


        }

    }
    private void moveToBack(View currentView) {
        ViewGroup viewGroup = ((ViewGroup) currentView.getParent());
        int index = viewGroup.indexOfChild(currentView);
        for(int i = 0; i<index; i++) {
            viewGroup.bringChildToFront(viewGroup.getChildAt(i));
        }
    }
}
