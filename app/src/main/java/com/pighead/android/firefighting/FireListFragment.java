package com.pighead.android.firefighting;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by Pighead on 3/25/15.
 */
public class FireListFragment extends ListFragment {

    private ArrayList<Fire> mFires;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.fire_stuff_title);
        mFires = FireLab.get(getActivity()).getFires();
    }
}
