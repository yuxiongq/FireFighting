package com.pighead.android.firefighting;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Pighead on 1/26/15.
 */
public class Fire {

    public UUID getId() {
        return mId;
    }

    private UUID mId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String mTitle;

    private Date mDate;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean mChecked) {
        this.mChecked = mChecked;
    }

    private boolean mChecked;

    @Override
    public String toString() {
        return mTitle;
    }

    public Fire() {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
    }
}
