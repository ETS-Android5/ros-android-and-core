package com.robotsdna.robot.model.db;

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
import com.robotsdna.robot.model.entities.ConfigEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConfigDao_Impl extends ConfigDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConfigEntity> __insertionAdapterOfConfigEntity;

  private final EntityDeletionOrUpdateAdapter<ConfigEntity> __deletionAdapterOfConfigEntity;

  private final EntityDeletionOrUpdateAdapter<ConfigEntity> __updateAdapterOfConfigEntity;

  private final SharedSQLiteStatement __preparedStmtOfRemoveConfig;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ConfigDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConfigEntity = new EntityInsertionAdapter<ConfigEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `config_table` (`id`,`creationTime`,`lastUsed`,`name`,`isFavourite`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.creationTime);
        stmt.bindLong(3, value.lastUsed);
        if (value.name == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.name);
        }
        final int _tmp;
        _tmp = value.isFavourite ? 1 : 0;
        stmt.bindLong(5, _tmp);
      }
    };
    this.__deletionAdapterOfConfigEntity = new EntityDeletionOrUpdateAdapter<ConfigEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `config_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigEntity value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfConfigEntity = new EntityDeletionOrUpdateAdapter<ConfigEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `config_table` SET `id` = ?,`creationTime` = ?,`lastUsed` = ?,`name` = ?,`isFavourite` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.creationTime);
        stmt.bindLong(3, value.lastUsed);
        if (value.name == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.name);
        }
        final int _tmp;
        _tmp = value.isFavourite ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.id);
      }
    };
    this.__preparedStmtOfRemoveConfig = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM config_table where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM config_table";
        return _query;
      }
    };
  }

  @Override
  public long insert(final ConfigEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfConfigEntity.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final ConfigEntity obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfConfigEntity.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ConfigEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfConfigEntity.handle(obj);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void removeConfig(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveConfig.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveConfig.release(_stmt);
    }
  }

  @Override
  void deleteAll() {
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
  LiveData<List<ConfigEntity>> getAllConfigs() {
    final String _sql = "SELECT * FROM config_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"config_table"}, false, new Callable<List<ConfigEntity>>() {
      @Override
      public List<ConfigEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreationTime = CursorUtil.getColumnIndexOrThrow(_cursor, "creationTime");
          final int _cursorIndexOfLastUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsed");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final List<ConfigEntity> _result = new ArrayList<ConfigEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ConfigEntity _item;
            _item = new ConfigEntity();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            _item.creationTime = _cursor.getLong(_cursorIndexOfCreationTime);
            _item.lastUsed = _cursor.getLong(_cursorIndexOfLastUsed);
            if (_cursor.isNull(_cursorIndexOfName)) {
              _item.name = null;
            } else {
              _item.name = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _item.isFavourite = _tmp != 0;
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
  LiveData<ConfigEntity> getConfig(final long id) {
    final String _sql = "SELECT * FROM config_table where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"config_table"}, false, new Callable<ConfigEntity>() {
      @Override
      public ConfigEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreationTime = CursorUtil.getColumnIndexOrThrow(_cursor, "creationTime");
          final int _cursorIndexOfLastUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsed");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final ConfigEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new ConfigEntity();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            _result.creationTime = _cursor.getLong(_cursorIndexOfCreationTime);
            _result.lastUsed = _cursor.getLong(_cursorIndexOfLastUsed);
            if (_cursor.isNull(_cursorIndexOfName)) {
              _result.name = null;
            } else {
              _result.name = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _result.isFavourite = _tmp != 0;
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
  LiveData<ConfigEntity> getLatestConfig() {
    final String _sql = "SELECT * FROM config_table ORDER BY creationTime DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"config_table"}, false, new Callable<ConfigEntity>() {
      @Override
      public ConfigEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreationTime = CursorUtil.getColumnIndexOrThrow(_cursor, "creationTime");
          final int _cursorIndexOfLastUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsed");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final ConfigEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new ConfigEntity();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            _result.creationTime = _cursor.getLong(_cursorIndexOfCreationTime);
            _result.lastUsed = _cursor.getLong(_cursorIndexOfLastUsed);
            if (_cursor.isNull(_cursorIndexOfName)) {
              _result.name = null;
            } else {
              _result.name = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _result.isFavourite = _tmp != 0;
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
  ConfigEntity getLatestConfigDirect() {
    final String _sql = "SELECT * FROM config_table ORDER BY creationTime DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreationTime = CursorUtil.getColumnIndexOrThrow(_cursor, "creationTime");
      final int _cursorIndexOfLastUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsed");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
      final ConfigEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new ConfigEntity();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.creationTime = _cursor.getLong(_cursorIndexOfCreationTime);
        _result.lastUsed = _cursor.getLong(_cursorIndexOfLastUsed);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _result.name = null;
        } else {
          _result.name = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
        _result.isFavourite = _tmp != 0;
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
