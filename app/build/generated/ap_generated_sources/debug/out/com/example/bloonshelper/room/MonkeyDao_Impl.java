package com.example.bloonshelper.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bloonshelper.data.Monkey;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MonkeyDao_Impl implements MonkeyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Monkey> __insertionAdapterOfMonkey;

  private final EntityDeletionOrUpdateAdapter<Monkey> __updateAdapterOfMonkey;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MonkeyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMonkey = new EntityInsertionAdapter<Monkey>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `monkey_base` (`uid`,`monkey_name`,`monkey_class`,`monkey_range`,`monkey_pierce`,`monkey_damage`,`monkey_camo_detect`,`monkey_lead_pierce`,`monkey_footprint`,`monkey_hotkey`,`monkey_special_ability`,`monkey_art`,`monkey_icon`,`monkey_sell_amount`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Monkey value) {
        stmt.bindLong(1, value.uid);
        if (value.monkeyName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.monkeyName);
        }
        if (value.monkeyClass == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.monkeyClass);
        }
        stmt.bindLong(4, value.monkeyRange);
        stmt.bindLong(5, value.monkeyPierce);
        stmt.bindLong(6, value.monkeyDamage);
        final int _tmp;
        _tmp = value.monkeyCamoDetect ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.monkeyLeadPierce ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.monkeyFootprint);
        stmt.bindLong(10, value.monkeyHotkey);
        if (value.monkeySpecialAbility == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.monkeySpecialAbility);
        }
        if (value.monkeyArt == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.monkeyArt);
        }
        if (value.monkeyIcon == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.monkeyIcon);
        }
        stmt.bindLong(14, value.monkeySellAmount);
      }
    };
    this.__updateAdapterOfMonkey = new EntityDeletionOrUpdateAdapter<Monkey>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `monkey_base` SET `uid` = ?,`monkey_name` = ?,`monkey_class` = ?,`monkey_range` = ?,`monkey_pierce` = ?,`monkey_damage` = ?,`monkey_camo_detect` = ?,`monkey_lead_pierce` = ?,`monkey_footprint` = ?,`monkey_hotkey` = ?,`monkey_special_ability` = ?,`monkey_art` = ?,`monkey_icon` = ?,`monkey_sell_amount` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Monkey value) {
        stmt.bindLong(1, value.uid);
        if (value.monkeyName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.monkeyName);
        }
        if (value.monkeyClass == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.monkeyClass);
        }
        stmt.bindLong(4, value.monkeyRange);
        stmt.bindLong(5, value.monkeyPierce);
        stmt.bindLong(6, value.monkeyDamage);
        final int _tmp;
        _tmp = value.monkeyCamoDetect ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.monkeyLeadPierce ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.monkeyFootprint);
        stmt.bindLong(10, value.monkeyHotkey);
        if (value.monkeySpecialAbility == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.monkeySpecialAbility);
        }
        if (value.monkeyArt == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.monkeyArt);
        }
        if (value.monkeyIcon == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.monkeyIcon);
        }
        stmt.bindLong(14, value.monkeySellAmount);
        stmt.bindLong(15, value.uid);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM monkey_base";
        return _query;
      }
    };
  }

  @Override
  public void insertMonkey(final Monkey monkey) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMonkey.insert(monkey);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final Monkey... monkeys) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMonkey.insert(monkeys);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMonkey(final Monkey monkey) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMonkey.handle(monkey);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Monkey>> getAllBaseMonkeys() {
    final String _sql = "SELECT * FROM monkey_base";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"monkey_base"}, false, new Callable<List<Monkey>>() {
      @Override
      public List<Monkey> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfMonkeyName = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_name");
          final int _cursorIndexOfMonkeyClass = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_class");
          final int _cursorIndexOfMonkeyRange = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_range");
          final int _cursorIndexOfMonkeyPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_pierce");
          final int _cursorIndexOfMonkeyDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_damage");
          final int _cursorIndexOfMonkeyCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_camo_detect");
          final int _cursorIndexOfMonkeyLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_lead_pierce");
          final int _cursorIndexOfMonkeyFootprint = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_footprint");
          final int _cursorIndexOfMonkeyHotkey = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_hotkey");
          final int _cursorIndexOfMonkeySpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_special_ability");
          final int _cursorIndexOfMonkeyArt = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_art");
          final int _cursorIndexOfMonkeyIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_icon");
          final int _cursorIndexOfMonkeySellAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_sell_amount");
          final List<Monkey> _result = new ArrayList<Monkey>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Monkey _item;
            _item = new Monkey();
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            _item.monkeyName = _cursor.getString(_cursorIndexOfMonkeyName);
            _item.monkeyClass = _cursor.getString(_cursorIndexOfMonkeyClass);
            _item.monkeyRange = _cursor.getInt(_cursorIndexOfMonkeyRange);
            _item.monkeyPierce = _cursor.getInt(_cursorIndexOfMonkeyPierce);
            _item.monkeyDamage = _cursor.getInt(_cursorIndexOfMonkeyDamage);
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMonkeyCamoDetect);
            _item.monkeyCamoDetect = _tmp != 0;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMonkeyLeadPierce);
            _item.monkeyLeadPierce = _tmp_1 != 0;
            _item.monkeyFootprint = _cursor.getInt(_cursorIndexOfMonkeyFootprint);
            _item.monkeyHotkey = (char) _cursor.getInt(_cursorIndexOfMonkeyHotkey);
            _item.monkeySpecialAbility = _cursor.getString(_cursorIndexOfMonkeySpecialAbility);
            _item.monkeyArt = _cursor.getString(_cursorIndexOfMonkeyArt);
            _item.monkeyIcon = _cursor.getString(_cursorIndexOfMonkeyIcon);
            _item.monkeySellAmount = _cursor.getInt(_cursorIndexOfMonkeySellAmount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Monkey getBaseMonkeyByName(final String monkeyName) {
    final String _sql = "SELECT * FROM monkey_base WHERE monkey_name == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (monkeyName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, monkeyName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfMonkeyName = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_name");
      final int _cursorIndexOfMonkeyClass = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_class");
      final int _cursorIndexOfMonkeyRange = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_range");
      final int _cursorIndexOfMonkeyPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_pierce");
      final int _cursorIndexOfMonkeyDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_damage");
      final int _cursorIndexOfMonkeyCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_camo_detect");
      final int _cursorIndexOfMonkeyLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_lead_pierce");
      final int _cursorIndexOfMonkeyFootprint = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_footprint");
      final int _cursorIndexOfMonkeyHotkey = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_hotkey");
      final int _cursorIndexOfMonkeySpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_special_ability");
      final int _cursorIndexOfMonkeyArt = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_art");
      final int _cursorIndexOfMonkeyIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_icon");
      final int _cursorIndexOfMonkeySellAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "monkey_sell_amount");
      final Monkey _result;
      if(_cursor.moveToFirst()) {
        _result = new Monkey();
        _result.uid = _cursor.getInt(_cursorIndexOfUid);
        _result.monkeyName = _cursor.getString(_cursorIndexOfMonkeyName);
        _result.monkeyClass = _cursor.getString(_cursorIndexOfMonkeyClass);
        _result.monkeyRange = _cursor.getInt(_cursorIndexOfMonkeyRange);
        _result.monkeyPierce = _cursor.getInt(_cursorIndexOfMonkeyPierce);
        _result.monkeyDamage = _cursor.getInt(_cursorIndexOfMonkeyDamage);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfMonkeyCamoDetect);
        _result.monkeyCamoDetect = _tmp != 0;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfMonkeyLeadPierce);
        _result.monkeyLeadPierce = _tmp_1 != 0;
        _result.monkeyFootprint = _cursor.getInt(_cursorIndexOfMonkeyFootprint);
        _result.monkeyHotkey = (char) _cursor.getInt(_cursorIndexOfMonkeyHotkey);
        _result.monkeySpecialAbility = _cursor.getString(_cursorIndexOfMonkeySpecialAbility);
        _result.monkeyArt = _cursor.getString(_cursorIndexOfMonkeyArt);
        _result.monkeyIcon = _cursor.getString(_cursorIndexOfMonkeyIcon);
        _result.monkeySellAmount = _cursor.getInt(_cursorIndexOfMonkeySellAmount);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
