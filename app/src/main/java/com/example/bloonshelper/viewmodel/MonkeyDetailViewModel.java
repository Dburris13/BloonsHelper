package com.example.bloonshelper.viewmodel;

import android.app.Application;
import android.util.Log;

import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.Upgrade;
import com.example.bloonshelper.room.MonkeyRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MonkeyDetailViewModel extends AndroidViewModel {

    MonkeyRepository mMonkeyRepository;
    LiveData<Monkey> mMonkey;
    public List<Upgrade> listOfUpgrades;
    public MutableLiveData<List<Upgrade>> activeUpgrade;
    private int upgradeTracker1, upgradeTracker2, upgradeTracker3;
    private static final String TAG = "MonkeyDetailViewModel";

    public MonkeyDetailViewModel(@NonNull Application application) {
        super(application);
        mMonkeyRepository = MonkeyRepository.getInstance(application);
    }

    public int getUpgradeTracker1() {
        return upgradeTracker1;
    }

    public int getUpgradeTracker2() {
        return upgradeTracker2;
    }

    public int getUpgradeTracker3() {
        return upgradeTracker3;
    }

    public MutableLiveData<List<Upgrade>> getActiveUpgrades() {
        if (activeUpgrade == null) {
            activeUpgrade = new MutableLiveData<List<Upgrade>>();
        }
        return activeUpgrade;
    }

    public LiveData<Monkey> init(String monkeyName) {
        // Only un-comment these lines to initialize the database for the first time (if empty)
//        mMonkeyRepository.insertAll(MonkeysData.DEFAULT_SEARCH_CATEGORY_IMAGES);
//        mMonkeyRepository.insertAllUpgrades(MonkeysData.DEFAULT_UPGRADES);
//        mMonkeyRepository.insertSingleUpgrade(new Upgrade( "MAX", 5, 0, 0,0,  false, false, "none", "max_upgrade.png", "max_upgrade.png", new Cost(0,0,0,0), "NONE", "none"));
        upgradeTracker1 = 0;
        upgradeTracker2 = 0;
        upgradeTracker3 = 0;
        activeUpgrade = getActiveUpgrades();
        mMonkey = mMonkeyRepository.getMonkeyByName(monkeyName);
        listOfUpgrades = (mMonkeyRepository.getUpgradesForMonkey(monkeyName));
        return mMonkey;
    }

    public void upgrade(String who) {
        upgradeHandler(who);
        List<Upgrade> temp = new ArrayList<Upgrade>();
        for (int i = 0; i<5; i++) {
            if (upgradeTracker1 > i)
                temp.add(listOfUpgrades.get(i));
            if (upgradeTracker2 > i)
                temp.add(listOfUpgrades.get(i+5));
            if (upgradeTracker3 > i)
                temp.add(listOfUpgrades.get(i+10));
        }
        activeUpgrade.setValue(temp);
    }

    /*
        This method exists to handle the business logic behind upgrading the tower. The following requirements define the monkey upgrades:
            Only one upgrade path can advance past tier 3. Doing so disables the other two from upgrading past tier 3.
            Only two upgrade paths can advance path tier 1. Doing so disables the third upgrade path.
     */
    public void upgradeHandler(String who) {
        switch (who) {
            case "upgrade1":
                if (isLegalUpgrade(upgradeTracker1, upgradeTracker2, upgradeTracker3)) {
                    if (upgradeTracker1 < 5)
                        upgradeTracker1++;
                }
                break;
            case "upgrade2":
                if (isLegalUpgrade(upgradeTracker2, upgradeTracker1, upgradeTracker3)) {
                    if (upgradeTracker2 < 5)
                        upgradeTracker2++;
                }
                break;
            case "upgrade3":
                if (isLegalUpgrade(upgradeTracker3, upgradeTracker1, upgradeTracker2)) {
                    if (upgradeTracker3 < 5)
                        upgradeTracker3++;
                }
                break;
            case "downgrade1":
                    if (upgradeTracker1 > 0)
                        upgradeTracker1--; break;
            case "downgrade2":
                    if (upgradeTracker2 > 0)
                        upgradeTracker2--; break;
            case "downgrade3":
                    if (upgradeTracker3 > 0)
                        upgradeTracker3--; break;
            default: break;
        }
        Log.d(TAG, "upgradeHandler: \ntracker 1: " + upgradeTracker1 + "\ntracker 2: " + upgradeTracker2 + "\ntracker 3: " + upgradeTracker3);
    }

    private boolean isLegalUpgrade(int tracker1, int tracker2, int tracker3) {
        if ((tracker2 != 0 & tracker3 != 0)) {
//            Log.d(TAG, "isLegalUpgrade:  Illegal Change. Two values are non-zero");
            return false;
        }

        if ((tracker1 == 2 & (tracker2 > 2 | tracker3 > 2))) {
//            Log.d(TAG, "isLegalUpgrade:  Illegal Change. You are max tier since someone else is tier 3 or above");
            return false;
        }

        return true;
    }
}