package com.example.bloonshelper.room;

import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.Upgrade;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MonkeyDao {

    /*
    All Database functions needed for the base monkey database
     */
    @Query("SELECT * FROM monkey_base")
    LiveData<List<Monkey>> getAllBaseMonkeys();

    @Query("SELECT * FROM monkey_base WHERE monkeyName == :monkeyName")
    LiveData<Monkey> getBaseMonkeyByName(String monkeyName);
    @Insert
    void insertMonkey(Monkey monkey);

    @Insert
    void insertAll(Monkey... monkeys);


    @Update
    void updateMonkey(Monkey monkey);

    @Query("DELETE FROM monkey_base")
    void deleteAll();

    /*
    All Database functions needed for the upgrades Database
     */
    @Insert
    void insertAllUpgrades(Upgrade... upgrades);

    @Insert
    void insertSingleUpgrade(Upgrade upgrade);

    @Query("SELECT * FROM upgrade WHERE upgradeName == :upgradeName")
    LiveData<Upgrade> getUpgradeByName(String upgradeName);

    @Query("SELECT * FROM upgrade WHERE upgradeName == :upgradeName")
    Upgrade getUpgradeByNameIMM(String upgradeName);

    @Query("SELECT * FROM upgrade WHERE uid == :id")
    LiveData<Upgrade> getUpgradeByID(int id);

    @Query("SELECT * FROM upgrade WHERE baseMonkey == :monkeyName")
    List<Upgrade> getUpgradesForMonkey(String monkeyName);

}
