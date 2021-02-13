package com.example.bloonshelper.room;

import com.example.bloonshelper.data.Monkey;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MonkeyDao {

    @Query("SELECT * FROM monkey_base")
    LiveData<List<Monkey>> getAllBaseMonkeys();

//    @Query("SELECT * FROM monkey_base WHERE monkey_name == :monkeyName")
//    Monkey getBaseMonkeyByName(String monkeyName);
//
//    @Query("SELECT * FROM monkey_upgrade")
//    List<MonkeyUpgrade> getUpgradeMonkey();
//
//    @Insert
//    void insertMonkey(Monkey monkey);

    @Insert
    void insertAll(Monkey... monkeys);
//
//    @Delete
//    void delete(Monkey monkey);

    @Query("DELETE FROM monkey_base")
    void deleteAll();
}
