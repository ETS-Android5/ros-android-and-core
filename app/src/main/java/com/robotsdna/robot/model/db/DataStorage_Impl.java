package com.robotsdna.robot.model.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataStorage_Impl extends DataStorage {
  private volatile ConfigDao _configDao;

  private volatile MasterDao _masterDao;

  private volatile WidgetDao _widgetDao;

  private volatile SSHDao _sSHDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `config_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `creationTime` INTEGER NOT NULL, `lastUsed` INTEGER NOT NULL, `name` TEXT, `isFavourite` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `master_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `configId` INTEGER NOT NULL, `ip` TEXT, `port` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `widget_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type_name` TEXT NOT NULL, `widget_config_id` INTEGER NOT NULL, `data` TEXT NOT NULL, `name` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ssh_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `configId` INTEGER NOT NULL, `ip` TEXT, `port` INTEGER NOT NULL, `username` TEXT, `password` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '26ceaefb0ae58a3d5e9a455b74037fe8')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `config_table`");
        _db.execSQL("DROP TABLE IF EXISTS `master_table`");
        _db.execSQL("DROP TABLE IF EXISTS `widget_table`");
        _db.execSQL("DROP TABLE IF EXISTS `ssh_table`");
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
        final HashMap<String, TableInfo.Column> _columnsConfigTable = new HashMap<String, TableInfo.Column>(5);
        _columnsConfigTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigTable.put("creationTime", new TableInfo.Column("creationTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigTable.put("lastUsed", new TableInfo.Column("lastUsed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigTable.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigTable.put("isFavourite", new TableInfo.Column("isFavourite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConfigTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConfigTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConfigTable = new TableInfo("config_table", _columnsConfigTable, _foreignKeysConfigTable, _indicesConfigTable);
        final TableInfo _existingConfigTable = TableInfo.read(_db, "config_table");
        if (! _infoConfigTable.equals(_existingConfigTable)) {
          return new RoomOpenHelper.ValidationResult(false, "config_table(com.robotsdna.robot.model.entities.ConfigEntity).\n"
                  + " Expected:\n" + _infoConfigTable + "\n"
                  + " Found:\n" + _existingConfigTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMasterTable = new HashMap<String, TableInfo.Column>(4);
        _columnsMasterTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMasterTable.put("configId", new TableInfo.Column("configId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMasterTable.put("ip", new TableInfo.Column("ip", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMasterTable.put("port", new TableInfo.Column("port", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMasterTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMasterTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMasterTable = new TableInfo("master_table", _columnsMasterTable, _foreignKeysMasterTable, _indicesMasterTable);
        final TableInfo _existingMasterTable = TableInfo.read(_db, "master_table");
        if (! _infoMasterTable.equals(_existingMasterTable)) {
          return new RoomOpenHelper.ValidationResult(false, "master_table(com.robotsdna.robot.model.entities.MasterEntity).\n"
                  + " Expected:\n" + _infoMasterTable + "\n"
                  + " Found:\n" + _existingMasterTable);
        }
        final HashMap<String, TableInfo.Column> _columnsWidgetTable = new HashMap<String, TableInfo.Column>(5);
        _columnsWidgetTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWidgetTable.put("type_name", new TableInfo.Column("type_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWidgetTable.put("widget_config_id", new TableInfo.Column("widget_config_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWidgetTable.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWidgetTable.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWidgetTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWidgetTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWidgetTable = new TableInfo("widget_table", _columnsWidgetTable, _foreignKeysWidgetTable, _indicesWidgetTable);
        final TableInfo _existingWidgetTable = TableInfo.read(_db, "widget_table");
        if (! _infoWidgetTable.equals(_existingWidgetTable)) {
          return new RoomOpenHelper.ValidationResult(false, "widget_table(com.robotsdna.robot.model.entities.WidgetStorageData).\n"
                  + " Expected:\n" + _infoWidgetTable + "\n"
                  + " Found:\n" + _existingWidgetTable);
        }
        final HashMap<String, TableInfo.Column> _columnsSshTable = new HashMap<String, TableInfo.Column>(6);
        _columnsSshTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSshTable.put("configId", new TableInfo.Column("configId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSshTable.put("ip", new TableInfo.Column("ip", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSshTable.put("port", new TableInfo.Column("port", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSshTable.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSshTable.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSshTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSshTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSshTable = new TableInfo("ssh_table", _columnsSshTable, _foreignKeysSshTable, _indicesSshTable);
        final TableInfo _existingSshTable = TableInfo.read(_db, "ssh_table");
        if (! _infoSshTable.equals(_existingSshTable)) {
          return new RoomOpenHelper.ValidationResult(false, "ssh_table(com.robotsdna.robot.model.entities.SSHEntity).\n"
                  + " Expected:\n" + _infoSshTable + "\n"
                  + " Found:\n" + _existingSshTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "26ceaefb0ae58a3d5e9a455b74037fe8", "059088d51a7e2c99d3c5f88869ecc7f7");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "config_table","master_table","widget_table","ssh_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `config_table`");
      _db.execSQL("DELETE FROM `master_table`");
      _db.execSQL("DELETE FROM `widget_table`");
      _db.execSQL("DELETE FROM `ssh_table`");
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ConfigDao.class, ConfigDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MasterDao.class, MasterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WidgetDao.class, WidgetDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SSHDao.class, SSHDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public ConfigDao configDao() {
    if (_configDao != null) {
      return _configDao;
    } else {
      synchronized(this) {
        if(_configDao == null) {
          _configDao = new ConfigDao_Impl(this);
        }
        return _configDao;
      }
    }
  }

  @Override
  public MasterDao masterDao() {
    if (_masterDao != null) {
      return _masterDao;
    } else {
      synchronized(this) {
        if(_masterDao == null) {
          _masterDao = new MasterDao_Impl(this);
        }
        return _masterDao;
      }
    }
  }

  @Override
  public WidgetDao widgetDao() {
    if (_widgetDao != null) {
      return _widgetDao;
    } else {
      synchronized(this) {
        if(_widgetDao == null) {
          _widgetDao = new WidgetDao_Impl(this);
        }
        return _widgetDao;
      }
    }
  }

  @Override
  public SSHDao sshDao() {
    if (_sSHDao != null) {
      return _sSHDao;
    } else {
      synchronized(this) {
        if(_sSHDao == null) {
          _sSHDao = new SSHDao_Impl(this);
        }
        return _sSHDao;
      }
    }
  }
}
