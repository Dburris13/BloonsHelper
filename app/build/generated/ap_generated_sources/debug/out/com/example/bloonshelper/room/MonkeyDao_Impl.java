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
import com.example.bloonshelper.data.Cost;
import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.Upgrade;
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

  private final EntityInsertionAdapter<Upgrade> __insertionAdapterOfUpgrade;

  private final EntityDeletionOrUpdateAdapter<Monkey> __updateAdapterOfMonkey;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MonkeyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMonkey = new EntityInsertionAdapter<Monkey>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `monkey_base` (`uid`,`monkeyName`,`monkeyClass`,`monkeyRange`,`monkeyPierce`,`monkeyDamage`,`monkeyCamoDetect`,`monkeyLeadPierce`,`monkeyFootprint`,`monkeyHotkey`,`monkeySpecialAbility`,`monkeyArt`,`monkeyIcon`,`path1Upgrade`,`path2Upgrade`,`path3Upgrade`,`buyeasy`,`buymedium`,`buyhard`,`buyimpoppable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Monkey value) {
        stmt.bindLong(1, value.getUid());
        if (value.getMonkeyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMonkeyName());
        }
        if (value.getMonkeyClass() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMonkeyClass());
        }
        stmt.bindLong(4, value.getMonkeyRange());
        stmt.bindLong(5, value.getMonkeyPierce());
        stmt.bindLong(6, value.getMonkeyDamage());
        final int _tmp;
        _tmp = value.isMonkeyCamoDetect() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isMonkeyLeadPierce() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getMonkeyFootprint());
        stmt.bindLong(10, value.getMonkeyHotkey());
        if (value.getMonkeySpecialAbility() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMonkeySpecialAbility());
        }
        if (value.getMonkeyArt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMonkeyArt());
        }
        if (value.getMonkeyIcon() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMonkeyIcon());
        }
        if (value.getPath1Upgrade() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPath1Upgrade());
        }
        if (value.getPath2Upgrade() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPath2Upgrade());
        }
        if (value.getPath3Upgrade() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getPath3Upgrade());
        }
        final Cost _tmpMonkeyCost = value.getMonkeyCost();
        if(_tmpMonkeyCost != null) {
          stmt.bindLong(17, _tmpMonkeyCost.getEasy());
          stmt.bindLong(18, _tmpMonkeyCost.getMedium());
          stmt.bindLong(19, _tmpMonkeyCost.getHard());
          stmt.bindLong(20, _tmpMonkeyCost.getImpoppable());
        } else {
          stmt.bindNull(17);
          stmt.bindNull(18);
          stmt.bindNull(19);
          stmt.bindNull(20);
        }
      }
    };
    this.__insertionAdapterOfUpgrade = new EntityInsertionAdapter<Upgrade>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `upgrade` (`uid`,`upgradeName`,`upgradeTier`,`upgradeRange`,`upgradePierce`,`upgradeDamage`,`upgradeCamoDetect`,`upgradeLeadPierce`,`upgradeSpecialAbility`,`upgradeArt`,`upgradeIcon`,`baseMonkey`,`upgradeDescription`,`upgradeeasy`,`upgrademedium`,`upgradehard`,`upgradeimpoppable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Upgrade value) {
        stmt.bindLong(1, value.getUid());
        if (value.getUpgradeName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUpgradeName());
        }
        stmt.bindLong(3, value.getUpgradeTier());
        stmt.bindLong(4, value.getUpgradeRange());
        stmt.bindLong(5, value.getUpgradePierce());
        stmt.bindLong(6, value.getUpgradeDamage());
        final int _tmp;
        _tmp = value.isUpgradeCamoDetect() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isUpgradeLeadPierce() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        if (value.getUpgradeSpecialAbility() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUpgradeSpecialAbility());
        }
        if (value.getUpgradeArt() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUpgradeArt());
        }
        if (value.getUpgradeIcon() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUpgradeIcon());
        }
        if (value.getBaseMonkey() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBaseMonkey());
        }
        if (value.getUpgradeDescription() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUpgradeDescription());
        }
        final Cost _tmpUpgradeCost = value.getUpgradeCost();
        if(_tmpUpgradeCost != null) {
          stmt.bindLong(14, _tmpUpgradeCost.getEasy());
          stmt.bindLong(15, _tmpUpgradeCost.getMedium());
          stmt.bindLong(16, _tmpUpgradeCost.getHard());
          stmt.bindLong(17, _tmpUpgradeCost.getImpoppable());
        } else {
          stmt.bindNull(14);
          stmt.bindNull(15);
          stmt.bindNull(16);
          stmt.bindNull(17);
        }
      }
    };
    this.__updateAdapterOfMonkey = new EntityDeletionOrUpdateAdapter<Monkey>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `monkey_base` SET `uid` = ?,`monkeyName` = ?,`monkeyClass` = ?,`monkeyRange` = ?,`monkeyPierce` = ?,`monkeyDamage` = ?,`monkeyCamoDetect` = ?,`monkeyLeadPierce` = ?,`monkeyFootprint` = ?,`monkeyHotkey` = ?,`monkeySpecialAbility` = ?,`monkeyArt` = ?,`monkeyIcon` = ?,`path1Upgrade` = ?,`path2Upgrade` = ?,`path3Upgrade` = ?,`buyeasy` = ?,`buymedium` = ?,`buyhard` = ?,`buyimpoppable` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Monkey value) {
        stmt.bindLong(1, value.getUid());
        if (value.getMonkeyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMonkeyName());
        }
        if (value.getMonkeyClass() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMonkeyClass());
        }
        stmt.bindLong(4, value.getMonkeyRange());
        stmt.bindLong(5, value.getMonkeyPierce());
        stmt.bindLong(6, value.getMonkeyDamage());
        final int _tmp;
        _tmp = value.isMonkeyCamoDetect() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isMonkeyLeadPierce() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getMonkeyFootprint());
        stmt.bindLong(10, value.getMonkeyHotkey());
        if (value.getMonkeySpecialAbility() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMonkeySpecialAbility());
        }
        if (value.getMonkeyArt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMonkeyArt());
        }
        if (value.getMonkeyIcon() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMonkeyIcon());
        }
        if (value.getPath1Upgrade() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPath1Upgrade());
        }
        if (value.getPath2Upgrade() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPath2Upgrade());
        }
        if (value.getPath3Upgrade() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getPath3Upgrade());
        }
        final Cost _tmpMonkeyCost = value.getMonkeyCost();
        if(_tmpMonkeyCost != null) {
          stmt.bindLong(17, _tmpMonkeyCost.getEasy());
          stmt.bindLong(18, _tmpMonkeyCost.getMedium());
          stmt.bindLong(19, _tmpMonkeyCost.getHard());
          stmt.bindLong(20, _tmpMonkeyCost.getImpoppable());
        } else {
          stmt.bindNull(17);
          stmt.bindNull(18);
          stmt.bindNull(19);
          stmt.bindNull(20);
        }
        stmt.bindLong(21, value.getUid());
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
  public void insertAllUpgrades(final Upgrade... upgrades) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUpgrade.insert(upgrades);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSingleUpgrade(final Upgrade upgrade) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUpgrade.insert(upgrade);
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
          final int _cursorIndexOfMonkeyName = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyName");
          final int _cursorIndexOfMonkeyClass = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyClass");
          final int _cursorIndexOfMonkeyRange = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyRange");
          final int _cursorIndexOfMonkeyPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyPierce");
          final int _cursorIndexOfMonkeyDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyDamage");
          final int _cursorIndexOfMonkeyCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyCamoDetect");
          final int _cursorIndexOfMonkeyLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyLeadPierce");
          final int _cursorIndexOfMonkeyFootprint = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyFootprint");
          final int _cursorIndexOfMonkeyHotkey = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyHotkey");
          final int _cursorIndexOfMonkeySpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeySpecialAbility");
          final int _cursorIndexOfMonkeyArt = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyArt");
          final int _cursorIndexOfMonkeyIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyIcon");
          final int _cursorIndexOfPath1Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path1Upgrade");
          final int _cursorIndexOfPath2Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path2Upgrade");
          final int _cursorIndexOfPath3Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path3Upgrade");
          final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "buyeasy");
          final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "buymedium");
          final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "buyhard");
          final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "buyimpoppable");
          final List<Monkey> _result = new ArrayList<Monkey>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Monkey _item;
            final Cost _tmpMonkeyCost;
            if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
              final int _tmpEasy;
              _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
              final int _tmpMedium;
              _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
              final int _tmpHard;
              _tmpHard = _cursor.getInt(_cursorIndexOfHard);
              final int _tmpImpoppable;
              _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
              _tmpMonkeyCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
            }  else  {
              _tmpMonkeyCost = null;
            }
            _item = new Monkey();
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final String _tmpMonkeyName;
            _tmpMonkeyName = _cursor.getString(_cursorIndexOfMonkeyName);
            _item.setMonkeyName(_tmpMonkeyName);
            final String _tmpMonkeyClass;
            _tmpMonkeyClass = _cursor.getString(_cursorIndexOfMonkeyClass);
            _item.setMonkeyClass(_tmpMonkeyClass);
            final int _tmpMonkeyRange;
            _tmpMonkeyRange = _cursor.getInt(_cursorIndexOfMonkeyRange);
            _item.setMonkeyRange(_tmpMonkeyRange);
            final int _tmpMonkeyPierce;
            _tmpMonkeyPierce = _cursor.getInt(_cursorIndexOfMonkeyPierce);
            _item.setMonkeyPierce(_tmpMonkeyPierce);
            final int _tmpMonkeyDamage;
            _tmpMonkeyDamage = _cursor.getInt(_cursorIndexOfMonkeyDamage);
            _item.setMonkeyDamage(_tmpMonkeyDamage);
            final boolean _tmpMonkeyCamoDetect;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMonkeyCamoDetect);
            _tmpMonkeyCamoDetect = _tmp != 0;
            _item.setMonkeyCamoDetect(_tmpMonkeyCamoDetect);
            final boolean _tmpMonkeyLeadPierce;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMonkeyLeadPierce);
            _tmpMonkeyLeadPierce = _tmp_1 != 0;
            _item.setMonkeyLeadPierce(_tmpMonkeyLeadPierce);
            final int _tmpMonkeyFootprint;
            _tmpMonkeyFootprint = _cursor.getInt(_cursorIndexOfMonkeyFootprint);
            _item.setMonkeyFootprint(_tmpMonkeyFootprint);
            final char _tmpMonkeyHotkey;
            _tmpMonkeyHotkey = (char) _cursor.getInt(_cursorIndexOfMonkeyHotkey);
            _item.setMonkeyHotkey(_tmpMonkeyHotkey);
            final String _tmpMonkeySpecialAbility;
            _tmpMonkeySpecialAbility = _cursor.getString(_cursorIndexOfMonkeySpecialAbility);
            _item.setMonkeySpecialAbility(_tmpMonkeySpecialAbility);
            final String _tmpMonkeyArt;
            _tmpMonkeyArt = _cursor.getString(_cursorIndexOfMonkeyArt);
            _item.setMonkeyArt(_tmpMonkeyArt);
            final String _tmpMonkeyIcon;
            _tmpMonkeyIcon = _cursor.getString(_cursorIndexOfMonkeyIcon);
            _item.setMonkeyIcon(_tmpMonkeyIcon);
            final String _tmpPath1Upgrade;
            _tmpPath1Upgrade = _cursor.getString(_cursorIndexOfPath1Upgrade);
            _item.setPath1Upgrade(_tmpPath1Upgrade);
            final String _tmpPath2Upgrade;
            _tmpPath2Upgrade = _cursor.getString(_cursorIndexOfPath2Upgrade);
            _item.setPath2Upgrade(_tmpPath2Upgrade);
            final String _tmpPath3Upgrade;
            _tmpPath3Upgrade = _cursor.getString(_cursorIndexOfPath3Upgrade);
            _item.setPath3Upgrade(_tmpPath3Upgrade);
            _item.setMonkeyCost(_tmpMonkeyCost);
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
  public LiveData<Monkey> getBaseMonkeyByName(final String monkeyName) {
    final String _sql = "SELECT * FROM monkey_base WHERE monkeyName == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (monkeyName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, monkeyName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"monkey_base"}, false, new Callable<Monkey>() {
      @Override
      public Monkey call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfMonkeyName = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyName");
          final int _cursorIndexOfMonkeyClass = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyClass");
          final int _cursorIndexOfMonkeyRange = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyRange");
          final int _cursorIndexOfMonkeyPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyPierce");
          final int _cursorIndexOfMonkeyDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyDamage");
          final int _cursorIndexOfMonkeyCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyCamoDetect");
          final int _cursorIndexOfMonkeyLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyLeadPierce");
          final int _cursorIndexOfMonkeyFootprint = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyFootprint");
          final int _cursorIndexOfMonkeyHotkey = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyHotkey");
          final int _cursorIndexOfMonkeySpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeySpecialAbility");
          final int _cursorIndexOfMonkeyArt = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyArt");
          final int _cursorIndexOfMonkeyIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "monkeyIcon");
          final int _cursorIndexOfPath1Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path1Upgrade");
          final int _cursorIndexOfPath2Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path2Upgrade");
          final int _cursorIndexOfPath3Upgrade = CursorUtil.getColumnIndexOrThrow(_cursor, "path3Upgrade");
          final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "buyeasy");
          final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "buymedium");
          final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "buyhard");
          final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "buyimpoppable");
          final Monkey _result;
          if(_cursor.moveToFirst()) {
            final Cost _tmpMonkeyCost;
            if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
              final int _tmpEasy;
              _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
              final int _tmpMedium;
              _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
              final int _tmpHard;
              _tmpHard = _cursor.getInt(_cursorIndexOfHard);
              final int _tmpImpoppable;
              _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
              _tmpMonkeyCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
            }  else  {
              _tmpMonkeyCost = null;
            }
            _result = new Monkey();
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _result.setUid(_tmpUid);
            final String _tmpMonkeyName;
            _tmpMonkeyName = _cursor.getString(_cursorIndexOfMonkeyName);
            _result.setMonkeyName(_tmpMonkeyName);
            final String _tmpMonkeyClass;
            _tmpMonkeyClass = _cursor.getString(_cursorIndexOfMonkeyClass);
            _result.setMonkeyClass(_tmpMonkeyClass);
            final int _tmpMonkeyRange;
            _tmpMonkeyRange = _cursor.getInt(_cursorIndexOfMonkeyRange);
            _result.setMonkeyRange(_tmpMonkeyRange);
            final int _tmpMonkeyPierce;
            _tmpMonkeyPierce = _cursor.getInt(_cursorIndexOfMonkeyPierce);
            _result.setMonkeyPierce(_tmpMonkeyPierce);
            final int _tmpMonkeyDamage;
            _tmpMonkeyDamage = _cursor.getInt(_cursorIndexOfMonkeyDamage);
            _result.setMonkeyDamage(_tmpMonkeyDamage);
            final boolean _tmpMonkeyCamoDetect;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMonkeyCamoDetect);
            _tmpMonkeyCamoDetect = _tmp != 0;
            _result.setMonkeyCamoDetect(_tmpMonkeyCamoDetect);
            final boolean _tmpMonkeyLeadPierce;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMonkeyLeadPierce);
            _tmpMonkeyLeadPierce = _tmp_1 != 0;
            _result.setMonkeyLeadPierce(_tmpMonkeyLeadPierce);
            final int _tmpMonkeyFootprint;
            _tmpMonkeyFootprint = _cursor.getInt(_cursorIndexOfMonkeyFootprint);
            _result.setMonkeyFootprint(_tmpMonkeyFootprint);
            final char _tmpMonkeyHotkey;
            _tmpMonkeyHotkey = (char) _cursor.getInt(_cursorIndexOfMonkeyHotkey);
            _result.setMonkeyHotkey(_tmpMonkeyHotkey);
            final String _tmpMonkeySpecialAbility;
            _tmpMonkeySpecialAbility = _cursor.getString(_cursorIndexOfMonkeySpecialAbility);
            _result.setMonkeySpecialAbility(_tmpMonkeySpecialAbility);
            final String _tmpMonkeyArt;
            _tmpMonkeyArt = _cursor.getString(_cursorIndexOfMonkeyArt);
            _result.setMonkeyArt(_tmpMonkeyArt);
            final String _tmpMonkeyIcon;
            _tmpMonkeyIcon = _cursor.getString(_cursorIndexOfMonkeyIcon);
            _result.setMonkeyIcon(_tmpMonkeyIcon);
            final String _tmpPath1Upgrade;
            _tmpPath1Upgrade = _cursor.getString(_cursorIndexOfPath1Upgrade);
            _result.setPath1Upgrade(_tmpPath1Upgrade);
            final String _tmpPath2Upgrade;
            _tmpPath2Upgrade = _cursor.getString(_cursorIndexOfPath2Upgrade);
            _result.setPath2Upgrade(_tmpPath2Upgrade);
            final String _tmpPath3Upgrade;
            _tmpPath3Upgrade = _cursor.getString(_cursorIndexOfPath3Upgrade);
            _result.setPath3Upgrade(_tmpPath3Upgrade);
            _result.setMonkeyCost(_tmpMonkeyCost);
          } else {
            _result = null;
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
  public LiveData<Upgrade> getUpgradeByName(final String upgradeName) {
    final String _sql = "SELECT * FROM upgrade WHERE upgradeName == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (upgradeName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, upgradeName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"upgrade"}, false, new Callable<Upgrade>() {
      @Override
      public Upgrade call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfUpgradeName = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeName");
          final int _cursorIndexOfUpgradeTier = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeTier");
          final int _cursorIndexOfUpgradeRange = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeRange");
          final int _cursorIndexOfUpgradePierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradePierce");
          final int _cursorIndexOfUpgradeDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDamage");
          final int _cursorIndexOfUpgradeCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeCamoDetect");
          final int _cursorIndexOfUpgradeLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeLeadPierce");
          final int _cursorIndexOfUpgradeSpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeSpecialAbility");
          final int _cursorIndexOfUpgradeArt = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeArt");
          final int _cursorIndexOfUpgradeIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeIcon");
          final int _cursorIndexOfBaseMonkey = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMonkey");
          final int _cursorIndexOfUpgradeDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDescription");
          final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeeasy");
          final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "upgrademedium");
          final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradehard");
          final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeimpoppable");
          final Upgrade _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUpgradeName;
            _tmpUpgradeName = _cursor.getString(_cursorIndexOfUpgradeName);
            final int _tmpUpgradeTier;
            _tmpUpgradeTier = _cursor.getInt(_cursorIndexOfUpgradeTier);
            final int _tmpUpgradeRange;
            _tmpUpgradeRange = _cursor.getInt(_cursorIndexOfUpgradeRange);
            final int _tmpUpgradePierce;
            _tmpUpgradePierce = _cursor.getInt(_cursorIndexOfUpgradePierce);
            final int _tmpUpgradeDamage;
            _tmpUpgradeDamage = _cursor.getInt(_cursorIndexOfUpgradeDamage);
            final boolean _tmpUpgradeCamoDetect;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUpgradeCamoDetect);
            _tmpUpgradeCamoDetect = _tmp != 0;
            final boolean _tmpUpgradeLeadPierce;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfUpgradeLeadPierce);
            _tmpUpgradeLeadPierce = _tmp_1 != 0;
            final String _tmpUpgradeSpecialAbility;
            _tmpUpgradeSpecialAbility = _cursor.getString(_cursorIndexOfUpgradeSpecialAbility);
            final String _tmpUpgradeArt;
            _tmpUpgradeArt = _cursor.getString(_cursorIndexOfUpgradeArt);
            final String _tmpUpgradeIcon;
            _tmpUpgradeIcon = _cursor.getString(_cursorIndexOfUpgradeIcon);
            final String _tmpBaseMonkey;
            _tmpBaseMonkey = _cursor.getString(_cursorIndexOfBaseMonkey);
            final String _tmpUpgradeDescription;
            _tmpUpgradeDescription = _cursor.getString(_cursorIndexOfUpgradeDescription);
            final Cost _tmpUpgradeCost;
            if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
              final int _tmpEasy;
              _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
              final int _tmpMedium;
              _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
              final int _tmpHard;
              _tmpHard = _cursor.getInt(_cursorIndexOfHard);
              final int _tmpImpoppable;
              _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
              _tmpUpgradeCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
            }  else  {
              _tmpUpgradeCost = null;
            }
            _result = new Upgrade(_tmpUpgradeName,_tmpUpgradeTier,_tmpUpgradeRange,_tmpUpgradePierce,_tmpUpgradeDamage,_tmpUpgradeCamoDetect,_tmpUpgradeLeadPierce,_tmpUpgradeSpecialAbility,_tmpUpgradeArt,_tmpUpgradeIcon,_tmpUpgradeCost,_tmpBaseMonkey,_tmpUpgradeDescription);
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _result.setUid(_tmpUid);
          } else {
            _result = null;
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
  public Upgrade getUpgradeByNameIMM(final String upgradeName) {
    final String _sql = "SELECT * FROM upgrade WHERE upgradeName == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (upgradeName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, upgradeName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfUpgradeName = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeName");
      final int _cursorIndexOfUpgradeTier = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeTier");
      final int _cursorIndexOfUpgradeRange = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeRange");
      final int _cursorIndexOfUpgradePierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradePierce");
      final int _cursorIndexOfUpgradeDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDamage");
      final int _cursorIndexOfUpgradeCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeCamoDetect");
      final int _cursorIndexOfUpgradeLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeLeadPierce");
      final int _cursorIndexOfUpgradeSpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeSpecialAbility");
      final int _cursorIndexOfUpgradeArt = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeArt");
      final int _cursorIndexOfUpgradeIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeIcon");
      final int _cursorIndexOfBaseMonkey = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMonkey");
      final int _cursorIndexOfUpgradeDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDescription");
      final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeeasy");
      final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "upgrademedium");
      final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradehard");
      final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeimpoppable");
      final Upgrade _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUpgradeName;
        _tmpUpgradeName = _cursor.getString(_cursorIndexOfUpgradeName);
        final int _tmpUpgradeTier;
        _tmpUpgradeTier = _cursor.getInt(_cursorIndexOfUpgradeTier);
        final int _tmpUpgradeRange;
        _tmpUpgradeRange = _cursor.getInt(_cursorIndexOfUpgradeRange);
        final int _tmpUpgradePierce;
        _tmpUpgradePierce = _cursor.getInt(_cursorIndexOfUpgradePierce);
        final int _tmpUpgradeDamage;
        _tmpUpgradeDamage = _cursor.getInt(_cursorIndexOfUpgradeDamage);
        final boolean _tmpUpgradeCamoDetect;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfUpgradeCamoDetect);
        _tmpUpgradeCamoDetect = _tmp != 0;
        final boolean _tmpUpgradeLeadPierce;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfUpgradeLeadPierce);
        _tmpUpgradeLeadPierce = _tmp_1 != 0;
        final String _tmpUpgradeSpecialAbility;
        _tmpUpgradeSpecialAbility = _cursor.getString(_cursorIndexOfUpgradeSpecialAbility);
        final String _tmpUpgradeArt;
        _tmpUpgradeArt = _cursor.getString(_cursorIndexOfUpgradeArt);
        final String _tmpUpgradeIcon;
        _tmpUpgradeIcon = _cursor.getString(_cursorIndexOfUpgradeIcon);
        final String _tmpBaseMonkey;
        _tmpBaseMonkey = _cursor.getString(_cursorIndexOfBaseMonkey);
        final String _tmpUpgradeDescription;
        _tmpUpgradeDescription = _cursor.getString(_cursorIndexOfUpgradeDescription);
        final Cost _tmpUpgradeCost;
        if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
          final int _tmpEasy;
          _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
          final int _tmpMedium;
          _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
          final int _tmpHard;
          _tmpHard = _cursor.getInt(_cursorIndexOfHard);
          final int _tmpImpoppable;
          _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
          _tmpUpgradeCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
        }  else  {
          _tmpUpgradeCost = null;
        }
        _result = new Upgrade(_tmpUpgradeName,_tmpUpgradeTier,_tmpUpgradeRange,_tmpUpgradePierce,_tmpUpgradeDamage,_tmpUpgradeCamoDetect,_tmpUpgradeLeadPierce,_tmpUpgradeSpecialAbility,_tmpUpgradeArt,_tmpUpgradeIcon,_tmpUpgradeCost,_tmpBaseMonkey,_tmpUpgradeDescription);
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Upgrade> getUpgradeByID(final int id) {
    final String _sql = "SELECT * FROM upgrade WHERE uid == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"upgrade"}, false, new Callable<Upgrade>() {
      @Override
      public Upgrade call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfUpgradeName = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeName");
          final int _cursorIndexOfUpgradeTier = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeTier");
          final int _cursorIndexOfUpgradeRange = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeRange");
          final int _cursorIndexOfUpgradePierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradePierce");
          final int _cursorIndexOfUpgradeDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDamage");
          final int _cursorIndexOfUpgradeCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeCamoDetect");
          final int _cursorIndexOfUpgradeLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeLeadPierce");
          final int _cursorIndexOfUpgradeSpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeSpecialAbility");
          final int _cursorIndexOfUpgradeArt = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeArt");
          final int _cursorIndexOfUpgradeIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeIcon");
          final int _cursorIndexOfBaseMonkey = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMonkey");
          final int _cursorIndexOfUpgradeDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDescription");
          final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeeasy");
          final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "upgrademedium");
          final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradehard");
          final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeimpoppable");
          final Upgrade _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUpgradeName;
            _tmpUpgradeName = _cursor.getString(_cursorIndexOfUpgradeName);
            final int _tmpUpgradeTier;
            _tmpUpgradeTier = _cursor.getInt(_cursorIndexOfUpgradeTier);
            final int _tmpUpgradeRange;
            _tmpUpgradeRange = _cursor.getInt(_cursorIndexOfUpgradeRange);
            final int _tmpUpgradePierce;
            _tmpUpgradePierce = _cursor.getInt(_cursorIndexOfUpgradePierce);
            final int _tmpUpgradeDamage;
            _tmpUpgradeDamage = _cursor.getInt(_cursorIndexOfUpgradeDamage);
            final boolean _tmpUpgradeCamoDetect;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUpgradeCamoDetect);
            _tmpUpgradeCamoDetect = _tmp != 0;
            final boolean _tmpUpgradeLeadPierce;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfUpgradeLeadPierce);
            _tmpUpgradeLeadPierce = _tmp_1 != 0;
            final String _tmpUpgradeSpecialAbility;
            _tmpUpgradeSpecialAbility = _cursor.getString(_cursorIndexOfUpgradeSpecialAbility);
            final String _tmpUpgradeArt;
            _tmpUpgradeArt = _cursor.getString(_cursorIndexOfUpgradeArt);
            final String _tmpUpgradeIcon;
            _tmpUpgradeIcon = _cursor.getString(_cursorIndexOfUpgradeIcon);
            final String _tmpBaseMonkey;
            _tmpBaseMonkey = _cursor.getString(_cursorIndexOfBaseMonkey);
            final String _tmpUpgradeDescription;
            _tmpUpgradeDescription = _cursor.getString(_cursorIndexOfUpgradeDescription);
            final Cost _tmpUpgradeCost;
            if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
              final int _tmpEasy;
              _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
              final int _tmpMedium;
              _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
              final int _tmpHard;
              _tmpHard = _cursor.getInt(_cursorIndexOfHard);
              final int _tmpImpoppable;
              _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
              _tmpUpgradeCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
            }  else  {
              _tmpUpgradeCost = null;
            }
            _result = new Upgrade(_tmpUpgradeName,_tmpUpgradeTier,_tmpUpgradeRange,_tmpUpgradePierce,_tmpUpgradeDamage,_tmpUpgradeCamoDetect,_tmpUpgradeLeadPierce,_tmpUpgradeSpecialAbility,_tmpUpgradeArt,_tmpUpgradeIcon,_tmpUpgradeCost,_tmpBaseMonkey,_tmpUpgradeDescription);
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _result.setUid(_tmpUid);
          } else {
            _result = null;
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
  public List<Upgrade> getUpgradesForMonkey(final String monkeyName) {
    final String _sql = "SELECT * FROM upgrade WHERE baseMonkey == ?";
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
      final int _cursorIndexOfUpgradeName = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeName");
      final int _cursorIndexOfUpgradeTier = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeTier");
      final int _cursorIndexOfUpgradeRange = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeRange");
      final int _cursorIndexOfUpgradePierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradePierce");
      final int _cursorIndexOfUpgradeDamage = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDamage");
      final int _cursorIndexOfUpgradeCamoDetect = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeCamoDetect");
      final int _cursorIndexOfUpgradeLeadPierce = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeLeadPierce");
      final int _cursorIndexOfUpgradeSpecialAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeSpecialAbility");
      final int _cursorIndexOfUpgradeArt = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeArt");
      final int _cursorIndexOfUpgradeIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeIcon");
      final int _cursorIndexOfBaseMonkey = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMonkey");
      final int _cursorIndexOfUpgradeDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeDescription");
      final int _cursorIndexOfEasy = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeeasy");
      final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "upgrademedium");
      final int _cursorIndexOfHard = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradehard");
      final int _cursorIndexOfImpoppable = CursorUtil.getColumnIndexOrThrow(_cursor, "upgradeimpoppable");
      final List<Upgrade> _result = new ArrayList<Upgrade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Upgrade _item;
        final String _tmpUpgradeName;
        _tmpUpgradeName = _cursor.getString(_cursorIndexOfUpgradeName);
        final int _tmpUpgradeTier;
        _tmpUpgradeTier = _cursor.getInt(_cursorIndexOfUpgradeTier);
        final int _tmpUpgradeRange;
        _tmpUpgradeRange = _cursor.getInt(_cursorIndexOfUpgradeRange);
        final int _tmpUpgradePierce;
        _tmpUpgradePierce = _cursor.getInt(_cursorIndexOfUpgradePierce);
        final int _tmpUpgradeDamage;
        _tmpUpgradeDamage = _cursor.getInt(_cursorIndexOfUpgradeDamage);
        final boolean _tmpUpgradeCamoDetect;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfUpgradeCamoDetect);
        _tmpUpgradeCamoDetect = _tmp != 0;
        final boolean _tmpUpgradeLeadPierce;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfUpgradeLeadPierce);
        _tmpUpgradeLeadPierce = _tmp_1 != 0;
        final String _tmpUpgradeSpecialAbility;
        _tmpUpgradeSpecialAbility = _cursor.getString(_cursorIndexOfUpgradeSpecialAbility);
        final String _tmpUpgradeArt;
        _tmpUpgradeArt = _cursor.getString(_cursorIndexOfUpgradeArt);
        final String _tmpUpgradeIcon;
        _tmpUpgradeIcon = _cursor.getString(_cursorIndexOfUpgradeIcon);
        final String _tmpBaseMonkey;
        _tmpBaseMonkey = _cursor.getString(_cursorIndexOfBaseMonkey);
        final String _tmpUpgradeDescription;
        _tmpUpgradeDescription = _cursor.getString(_cursorIndexOfUpgradeDescription);
        final Cost _tmpUpgradeCost;
        if (! (_cursor.isNull(_cursorIndexOfEasy) && _cursor.isNull(_cursorIndexOfMedium) && _cursor.isNull(_cursorIndexOfHard) && _cursor.isNull(_cursorIndexOfImpoppable))) {
          final int _tmpEasy;
          _tmpEasy = _cursor.getInt(_cursorIndexOfEasy);
          final int _tmpMedium;
          _tmpMedium = _cursor.getInt(_cursorIndexOfMedium);
          final int _tmpHard;
          _tmpHard = _cursor.getInt(_cursorIndexOfHard);
          final int _tmpImpoppable;
          _tmpImpoppable = _cursor.getInt(_cursorIndexOfImpoppable);
          _tmpUpgradeCost = new Cost(_tmpEasy,_tmpMedium,_tmpHard,_tmpImpoppable);
        }  else  {
          _tmpUpgradeCost = null;
        }
        _item = new Upgrade(_tmpUpgradeName,_tmpUpgradeTier,_tmpUpgradeRange,_tmpUpgradePierce,_tmpUpgradeDamage,_tmpUpgradeCamoDetect,_tmpUpgradeLeadPierce,_tmpUpgradeSpecialAbility,_tmpUpgradeArt,_tmpUpgradeIcon,_tmpUpgradeCost,_tmpBaseMonkey,_tmpUpgradeDescription);
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
