package com.example.bloonshelper.room;

import android.content.Context;

import com.example.bloonshelper.data.Monkey;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monkey.class}, version = 1, exportSchema = true)
public abstract class MonkeyDatabase extends RoomDatabase {

    private static final String TAG = "MonkeyDatabase";
    public static final String DATABASE_NAME = "monkeys_db";
    private static final Object LOCK = new Object();
    private static MonkeyDatabase instance;

    public static MonkeyDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (LOCK)  {
                if(instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MonkeyDatabase.class,
                            DATABASE_NAME
                    ).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }

    public abstract MonkeyDao getMonkeyDao();

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            AppExecutors.getsInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    instance.getMonkeyDao().deleteAll();
//                    instance.getMonkeyDao().insertAll(MonkeysData.populateMonkeysData());
                }
            });
        }
    };

//    public abstract MonkeyUpgradeDao getMonkeyUpgradeDao();
}
