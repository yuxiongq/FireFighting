package com.pighead.android.firefighting;

import android.support.v4.app.Fragment;

/**
 * Created by Pighead on 3/25/15.
 */
public class FireListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new FireListFragment();
    }
}
