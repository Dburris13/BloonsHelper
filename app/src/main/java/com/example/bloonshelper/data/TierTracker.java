package com.example.bloonshelper.data;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

public class TierTracker {
    private static final String TAG = "TierTracker";
    
    private ImageView tb1, tb2, tb3, tb4, tb5;

    public TierTracker(ImageView tb1, ImageView tb2, ImageView tb3, ImageView tb4, ImageView tb5) {
        this.tb1 = tb1;
        this.tb2 = tb2;
        this.tb3 = tb3;
        this.tb4 = tb4;
        this.tb5 = tb5;
    }

    public void update(int currentTier) {
        Log.d(TAG, "update: currentTier = " + currentTier);
        switch (currentTier) {
            case 1: tb1.setBackgroundColor(Color.GREEN); tb2.setBackgroundColor(Color.BLACK); tb3.setBackgroundColor(Color.BLACK); tb4.setBackgroundColor(Color.BLACK); tb5.setBackgroundColor(Color.BLACK); break;
            case 2: tb1.setBackgroundColor(Color.GREEN); tb2.setBackgroundColor(Color.GREEN); tb3.setBackgroundColor(Color.BLACK); tb4.setBackgroundColor(Color.BLACK); tb5.setBackgroundColor(Color.BLACK); break;
            case 3: tb1.setBackgroundColor(Color.GREEN); tb2.setBackgroundColor(Color.GREEN); tb3.setBackgroundColor(Color.GREEN); tb4.setBackgroundColor(Color.BLACK); tb5.setBackgroundColor(Color.BLACK); break;
            case 4: tb1.setBackgroundColor(Color.GREEN); tb2.setBackgroundColor(Color.GREEN); tb3.setBackgroundColor(Color.GREEN); tb4.setBackgroundColor(Color.GREEN); tb5.setBackgroundColor(Color.BLACK); break;
            case 5: tb1.setBackgroundColor(Color.GREEN); tb2.setBackgroundColor(Color.GREEN); tb3.setBackgroundColor(Color.GREEN); tb4.setBackgroundColor(Color.GREEN); tb5.setBackgroundColor(Color.GREEN); break;
            default: tb1.setBackgroundColor(Color.BLACK); tb2.setBackgroundColor(Color.BLACK); tb3.setBackgroundColor(Color.BLACK); tb4.setBackgroundColor(Color.BLACK); tb5.setBackgroundColor(Color.BLACK); break;
        }
    }
}
