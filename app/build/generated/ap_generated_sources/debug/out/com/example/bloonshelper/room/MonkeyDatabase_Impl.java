package com.example.bloonshelper.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MonkeyDatabase_Impl extends MonkeyDatabase {
  private volatile MonkeyDao _monkeyDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `monkey_base` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `monkey_name` TEXT, `monkey_class` TEXT, `monkey_range` INTEGER NOT NULL, `monkey_pierce` INTEGER NOT NULL, `monkey_damage` INTEGER NOT NULL, `monkey_camo_detect` INTEGER NOT NULL, `monkey_lead_pierce` INTEGER NOT NULL, `monkey_footprint` INTEGER NOT NULL, `monkey_hotkey` INTEGER NOT NULL, `monkey_special_ability` TEXT, `monkey_art` TEXT, `monkey_icon` TEXT, `monkey_sell_amount` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1bb835284fb20d5e7e892dce1101a261')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `monkey_base`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMonkeyBase = new HashMap<String, TableInfo.Column>(14);
        _columnsMonkeyBase.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_name", new TableInfo.Column("monkey_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_class", new TableInfo.Column("monkey_class", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_range", new TableInfo.Column("monkey_range", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_pierce", new TableInfo.Column("monkey_pierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_damage", new TableInfo.Column("monkey_damage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_camo_detect", new TableInfo.Column("monkey_camo_detect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_lead_pierce", new TableInfo.Column("monkey_lead_pierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_footprint", new TableInfo.Column("monkey_footprint", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_hotkey", new TableInfo.Column("monkey_hotkey", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_special_ability", new TableInfo.Column("monkey_special_ability", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_art", new TableInfo.Column("monkey_art", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_icon", new TableInfo.Column("monkey_icon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkey_sell_amount", new TableInfo.Column("monkey_sell_amount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMonkeyBase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMonkeyBase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMonkeyBase = new TableInfo("monkey_base", _columnsMonkeyBase, _foreignKeysMonkeyBase, _indicesMonkeyBase);
        final TableInfo _existingMonkeyBase = TableInfo.read(_db, "monkey_base");
        if (! _infoMonkeyBase.equals(_existingMonkeyBase)) {
          return new RoomOpenHelper.ValidationResult(false, "monkey_base(com.example.bloonshelper.data.Monkey).\n"
                  + " Expected:\n" + _infoMonkeyBase + "\n"
                  + " Found:\n" + _existingMonkeyBase);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1bb835284fb20d5e7e892dce1101a261", "bdb99f27584566342fa5c8bcc695332c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "monkey_base");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `monkey_base`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public MonkeyDao getMonkeyDao() {
    if (_monkeyDao != null) {
      return _monkeyDao;
    } else {
      synchronized(this) {
        if(_monkeyDao == null) {
          _monkeyDao = new MonkeyDao_Impl(this);
        }
        return _monkeyDao;
      }
    }
  }
}
