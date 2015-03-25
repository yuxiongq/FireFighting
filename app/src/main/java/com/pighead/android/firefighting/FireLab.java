package com.pighead.android.firefighting;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Pighead on 3/25/15.
 */
public class FireLab {
    private static FireLab sFireLab;
    private Context mAppContext;
    private ArrayList<Fire> mFires;

    private FireLab(Context appContext) {
        mAppContext = appContext;
        mFires = new ArrayList<Fire>();

        for (int i = 0; i < 100; i++) {
            Fire f = new Fire();
            f.setTitle("Fire #" + i);
            f.setChecked(i%2 == 0); // Every other one
            mFires.add(f);
        }
    }

    public ArrayList<Fire> getFires() {
        return mFires;
    }

    public Fire getFire(UUID id) {
        for (Fire f : mFires) {
            if (f.getId().equals(id))
                return f;
        }
        return null;
    }

    public static FireLab get(Context c) {
        if (sFireLab == null) {
            sFireLab = new FireLab(c.getApplicationContext());
        }
        return sFireLab;
    }
}
