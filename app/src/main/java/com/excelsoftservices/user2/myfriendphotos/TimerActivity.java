package com.excelsoftservices.user2.myfriendphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zhy.view.flowlayout.TagView;

import java.util.Iterator;
import java.util.Set;

public class TimerActivity extends AppCompatActivity {
    private String[] mVals = new String[]
            {"Animal care", "Astronomy", "Birdwatching", "Blogging", "Collecting", "Computers",
                    "Cooking", "Crafts", "Family time", "Firearms", "Handiwork",
                    "Gardening", "Knitting", "Meditation", "Listening to music","Animal care", "Astronomy", "Birdwatching", "Blogging", "Collecting", "Computers",
                    "Cooking", "Crafts", "Family time", "Firearms", "Handiwork",
                    "Gardening", "Knitting", "Meditation", "Listening to music"};
    private String[] mVals2 = new String[]
            {"Animal care", "Astronomy", "Birdwatching", "Blogging", "Collecting", "Computers",
                    "Cooking", "Crafts", "Family time", "Firearms", "Handiwork",
                    "Gardening", "Knitting", "Meditation", "Listening to music","Animal care", "Astronomy", "Birdwatching", "Blogging", "Collecting", "Computers",
                    "Cooking", "Crafts", "Family time", "Firearms", "Handiwork",
                    "Gardening", "Knitting", "Meditation", "Listening to music"};
    private TagFlowLayout mFlowLayout,mFlowLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        mFlowLayout2 = (TagFlowLayout) findViewById(R.id.id_flowlayout2);
        final LayoutInflater layoutInflater = LayoutInflater.from(this);

        mFlowLayout.setAdapter(new TagAdapter(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView textView = (TextView) layoutInflater.inflate(R.layout.tv,mFlowLayout,false);
                textView.setText(o.toString());
                return textView;
            }
        });

        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                Iterator<Integer> iterator  = selectPosSet.iterator();
                if (iterator.hasNext()) {
                    do {
                        TagView mSelectedTagView = (TagView) mFlowLayout.getChildAt(iterator.next());
                    }while (iterator.hasNext());
                }
            }
        });
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(TimerActivity.this, "You clicked possition at "+mVals[position], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mFlowLayout2.setAdapter(new TagAdapter(mVals2) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView textView = (TextView) layoutInflater.inflate(R.layout.tv2,mFlowLayout,false);
                textView.setText(o.toString());
                return textView;
            }
        });
    }
}
