package com.example.bloonshelper.room;

import android.content.Context;

import com.example.bloonshelper.data.Monkey;

import java.util.List;
import java.util.concurrent.Executor;

import androidx.lifecycle.LiveData;

public class MonkeyRepository {

    private MonkeyDatabase mMonkeyDatabase;
    private LiveData<List<Monkey>> monkeyList;
    private Executor executor;

    public MonkeyRepository(Context context) {
        mMonkeyDatabase = MonkeyDatabase.getDatabase(context);
    }

    public void insertMonkeyTask(Monkey... monkeys) {
        mMonkeyDatabase.getMonkeyDao().insertAll(monkeys);
    }
//
//    public void updateMonkeyTask(Monkey monkey) {
//
//    }

    public LiveData<List<Monkey>> getMonkeyList() {
        return mMonkeyDatabase.getMonkeyDao().getAllBaseMonkeys();
    }

    public void deleteAll() {
        mMonkeyDatabase.getMonkeyDao().deleteAll();
    }
}
