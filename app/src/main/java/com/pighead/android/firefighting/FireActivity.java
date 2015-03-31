package com.pighead.android.firefighting;

import android.support.v4.app.Fragment;

import java.util.UUID;


public class FireActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
//        return new FireFragment();

        UUID fireID = (UUID) getIntent()
                .getSerializableExtra(FireFragment.EXTRA_FIRE_ID);
        return FireFragment.newInstance(fireID);
    }
}
