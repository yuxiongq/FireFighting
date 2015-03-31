package com.pighead.android.firefighting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Pighead on 3/31/15.
 */
public class FirePagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ArrayList<Fire> mFires;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPaper);
        setContentView(mViewPager);

        mFires = FireLab.get(this).getFires();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fire fire = mFires.get(position);
                return FireFragment.newInstance(fire.getId());
            }

            @Override
            public int getCount() {
                return mFires.size();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fire fire = mFires.get(position);
                if (fire.getTitle() != null)
                    setTitle(fire.getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID fireID = (UUID) getIntent()
                .getSerializableExtra(FireFragment.EXTRA_FIRE_ID);
        for (int i = 0; i < mFires.size(); i++) {
            if (mFires.get(i).getId().equals(fireID)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
