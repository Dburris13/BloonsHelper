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
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(8) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `monkey_base` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `monkeyName` TEXT, `monkeyClass` TEXT, `monkeyRange` INTEGER NOT NULL, `monkeyPierce` INTEGER NOT NULL, `monkeyDamage` INTEGER NOT NULL, `monkeyCamoDetect` INTEGER NOT NULL, `monkeyLeadPierce` INTEGER NOT NULL, `monkeyFootprint` INTEGER NOT NULL, `monkeyHotkey` INTEGER NOT NULL, `monkeySpecialAbility` TEXT, `monkeyArt` TEXT, `monkeyIcon` TEXT, `path1Upgrade` TEXT, `path2Upgrade` TEXT, `path3Upgrade` TEXT, `buyeasy` INTEGER, `buymedium` INTEGER, `buyhard` INTEGER, `buyimpoppable` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `upgrade` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `upgradeName` TEXT, `upgradeTier` INTEGER NOT NULL, `upgradeRange` INTEGER NOT NULL, `upgradePierce` INTEGER NOT NULL, `upgradeDamage` INTEGER NOT NULL, `upgradeCamoDetect` INTEGER NOT NULL, `upgradeLeadPierce` INTEGER NOT NULL, `upgradeSpecialAbility` TEXT, `upgradeArt` TEXT, `upgradeIcon` TEXT, `baseMonkey` TEXT, `upgradeDescription` TEXT, `upgradeeasy` INTEGER, `upgrademedium` INTEGER, `upgradehard` INTEGER, `upgradeimpoppable` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6c6da7ab460939d77707e097a9d4bdd0')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `monkey_base`");
        _db.execSQL("DROP TABLE IF EXISTS `upgrade`");
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
        final HashMap<String, TableInfo.Column> _columnsMonkeyBase = new HashMap<String, TableInfo.Column>(20);
        _columnsMonkeyBase.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyName", new TableInfo.Column("monkeyName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyClass", new TableInfo.Column("monkeyClass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyRange", new TableInfo.Column("monkeyRange", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyPierce", new TableInfo.Column("monkeyPierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyDamage", new TableInfo.Column("monkeyDamage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyCamoDetect", new TableInfo.Column("monkeyCamoDetect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyLeadPierce", new TableInfo.Column("monkeyLeadPierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyFootprint", new TableInfo.Column("monkeyFootprint", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyHotkey", new TableInfo.Column("monkeyHotkey", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeySpecialAbility", new TableInfo.Column("monkeySpecialAbility", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyArt", new TableInfo.Column("monkeyArt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("monkeyIcon", new TableInfo.Column("monkeyIcon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("path1Upgrade", new TableInfo.Column("path1Upgrade", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("path2Upgrade", new TableInfo.Column("path2Upgrade", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("path3Upgrade", new TableInfo.Column("path3Upgrade", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("buyeasy", new TableInfo.Column("buyeasy", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("buymedium", new TableInfo.Column("buymedium", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("buyhard", new TableInfo.Column("buyhard", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonkeyBase.put("buyimpoppable", new TableInfo.Column("buyimpoppable", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMonkeyBase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMonkeyBase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMonkeyBase = new TableInfo("monkey_base", _columnsMonkeyBase, _foreignKeysMonkeyBase, _indicesMonkeyBase);
        final TableInfo _existingMonkeyBase = TableInfo.read(_db, "monkey_base");
        if (! _infoMonkeyBase.equals(_existingMonkeyBase)) {
          return new RoomOpenHelper.ValidationResult(false, "monkey_base(com.example.bloonshelper.data.Monkey).\n"
                  + " Expected:\n" + _infoMonkeyBase + "\n"
                  + " Found:\n" + _existingMonkeyBase);
        }
        final HashMap<String, TableInfo.Column> _columnsUpgrade = new HashMap<String, TableInfo.Column>(17);
        _columnsUpgrade.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeName", new TableInfo.Column("upgradeName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeTier", new TableInfo.Column("upgradeTier", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeRange", new TableInfo.Column("upgradeRange", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradePierce", new TableInfo.Column("upgradePierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeDamage", new TableInfo.Column("upgradeDamage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeCamoDetect", new TableInfo.Column("upgradeCamoDetect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeLeadPierce", new TableInfo.Column("upgradeLeadPierce", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeSpecialAbility", new TableInfo.Column("upgradeSpecialAbility", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeArt", new TableInfo.Column("upgradeArt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeIcon", new TableInfo.Column("upgradeIcon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("baseMonkey", new TableInfo.Column("baseMonkey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeDescription", new TableInfo.Column("upgradeDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeeasy", new TableInfo.Column("upgradeeasy", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgrademedium", new TableInfo.Column("upgrademedium", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradehard", new TableInfo.Column("upgradehard", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrade.put("upgradeimpoppable", new TableInfo.Column("upgradeimpoppable", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUpgrade = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUpgrade = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUpgrade = new TableInfo("upgrade", _columnsUpgrade, _foreignKeysUpgrade, _indicesUpgrade);
        final TableInfo _existingUpgrade = TableInfo.read(_db, "upgrade");
        if (! _infoUpgrade.equals(_existingUpgrade)) {
          return new RoomOpenHelper.ValidationResult(false, "upgrade(com.example.bloonshelper.data.Upgrade).\n"
                  + " Expected:\n" + _infoUpgrade + "\n"
                  + " Found:\n" + _existingUpgrade);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6c6da7ab460939d77707e097a9d4bdd0", "835b7659527eccc6c61231dd83028bfe");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "monkey_base","upgrade");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `monkey_base`");
      _db.execSQL("DELETE FROM `upgrade`");
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
