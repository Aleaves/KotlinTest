package com.app.uicore.rec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.uicore.R;
import com.squareup.picasso.Picasso;

public class RecTestActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FeedAdapter mAdapter;
    private RelativeLayout mSuspensionBar;
    private TextView mSuspensionTv;
    private ImageView mSuspensionIv;

    private int mSuspensionHeight;

    private int mCurrentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_test);


        mSuspensionBar = findViewById(R.id.suspension_bars);
        mSuspensionTv = findViewById(R.id.tv_nickname);
        mSuspensionIv = findViewById(R.id.iv_avatar);

        mRecyclerView = findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new FeedAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                mSuspensionHeight = mSuspensionBar.getHeight();

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                View view = layoutManager.findViewByPosition(mCurrentPosition + 1);

                if(null != view){
                    if(view.getTop() <= mSuspensionHeight){
                        mSuspensionBar.setY(-(mSuspensionHeight -  view.getTop() ));
                    }else{
                        mSuspensionBar.setY(0);
                    }
                }

                if(mCurrentPosition != layoutManager.findFirstVisibleItemPosition()){

                    mCurrentPosition = layoutManager.findFirstVisibleItemPosition();

                    updateSuspensionBar();

                }

            }


        });

    }

    private void updateSuspensionBar() {
        Picasso.with(this)
                .load(getAvatarResId(mCurrentPosition))
                .centerInside()
                .fit()
                .into(mSuspensionIv);
        mSuspensionTv.setText("NetEase "  + mCurrentPosition);
    }

    private int getAvatarResId(int position){
        switch (position % 4){
            case 0:
                return R.drawable.avatar1;
            case 1:
                return R.drawable.avatar2;
            case 2:
                return R.drawable.avatar3;
            case 3:
                return R.drawable.avatar4;
        }
        return 0;
    }


}
