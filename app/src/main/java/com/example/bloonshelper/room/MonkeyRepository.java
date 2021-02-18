package com.example.bloonshelper.room;

import android.content.Context;

import com.example.bloonshelper.data.Monkey;

public class MonkeyRepository {

    private static MonkeyRepository instance;
    private MonkeyDao monkeyDao;

    public static MonkeyRepository getInstance(Context context) {
        if (instance == null) {
            instance = new MonkeyRepository(context);
        }
        return instance;
    }

    public MonkeyRepository(Context context) {
        monkeyDao = MonkeyDatabase.getDatabase(context).getMonkeyDao();
    }

    public Monkey getMonkeyByName(String monkeyName) {
        return monkeyDao.getBaseMonkeyByName(monkeyName);
    }

    public void insertMonkey(Monkey monkey) {
        monkeyDao.insertMonkey(monkey);
    }

    public void insertAll(Monkey... monkeys) {
        monkeyDao.insertAll(monkeys);
    }

    public void updateMonkey(Monkey monkey) {
        monkeyDao.updateMonkey(monkey);
    }

    public void deleteAll() {
        monkeyDao.deleteAll();
    }
}
