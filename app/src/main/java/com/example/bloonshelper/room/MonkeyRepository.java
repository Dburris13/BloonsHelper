package com.example.bloonshelper.room;

import android.content.Context;
import android.util.Log;

import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.Upgrade;
import com.example.bloonshelper.singleton.AppExecutors;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MonkeyRepository {

    private static final String TAG = "MonkeyRepository";
    private static MonkeyRepository instance;
    private MonkeyDao monkeyDao;
    private AppExecutors appExecutors;
    private LiveData<Monkey> mSingleMonkey;

    public static MonkeyRepository getInstance(Context context) {
        if (instance == null) {
            instance = new MonkeyRepository(context);
        }
        return instance;
    }

    public MonkeyRepository(Context context) {
        monkeyDao = MonkeyDatabase.getDatabase(context).getMonkeyDao();
        appExecutors = AppExecutors.getsInstance();
    }

    public LiveData<Monkey> getMonkeyByName(String monkeyName) {
        return monkeyDao.getBaseMonkeyByName(monkeyName);
    }

    public void insertMonkey(Monkey monkey) {
        monkeyDao.insertMonkey(monkey);
    }

    public void insertAll(Monkey... monkeys) {
        appExecutors.diskIO().execute(new Runnable() {
                @Override
                public void run() {
                monkeyDao.insertAll(monkeys);
                Log.d(TAG, "run: Inserting All Monkeys into DB");
            }
        });
    }

    public void insertAllUpgrades(Upgrade... upgrades) {
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                monkeyDao.insertAllUpgrades(upgrades);
                Log.d(TAG, "run: Inserting All Upgrades into DB");
            }
        });
    }

    public void insertSingleUpgrade(Upgrade upgrade) {
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                monkeyDao.insertAllUpgrades(upgrade);
                Log.d(TAG, "run: Inserting one Upgrade into DB");
            }
        });
    }

    public LiveData<Upgrade> getUpgradeByName(String monkeyName) {
        return monkeyDao.getUpgradeByName(monkeyName);
    }

    public Upgrade getUpgradeByNameImmediate(String monkeyName) {
        return monkeyDao.getUpgradeByNameIMM(monkeyName);
    }

    public List<Upgrade> getUpgradesForMonkey(String monkeyName) {
        return monkeyDao.getUpgradesForMonkey(monkeyName);
    }

    public LiveData<Upgrade> getUpgradeByUid(int id) {
        return monkeyDao.getUpgradeByID(id);
    }

    public void updateMonkey(Monkey monkey) {
        monkeyDao.updateMonkey(monkey);
    }

    public void deleteAll() {
        monkeyDao.deleteAll();
    }
}
