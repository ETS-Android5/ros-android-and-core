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
import com.robotsdna.robot.model.entities.MasterEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MasterDao_Impl extends MasterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MasterEntity> __insertionAdapterOfMasterEntity;

  private final EntityDeletionOrUpdateAdapter<MasterEntity> __deletionAdapterOfMasterEntity;

  private final EntityDeletionOrUpdateAdapter<MasterEntity> __updateAdapterOfMasterEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MasterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMasterEntity = new EntityInsertionAdapter<MasterEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `master_table` (`id`,`configId`,`ip`,`port`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MasterEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.configId);
        if (value.ip == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ip);
        }
        stmt.bindLong(4, value.port);
      }
    };
    this.__deletionAdapterOfMasterEntity = new EntityDeletionOrUpdateAdapter<MasterEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `master_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MasterEntity value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfMasterEntity = new EntityDeletionOrUpdateAdapter<MasterEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `master_table` SET `id` = ?,`configId` = ?,`ip` = ?,`port` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MasterEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.configId);
        if (value.ip == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ip);
        }
        stmt.bindLong(4, value.port);
        stmt.bindLong(5, value.id);
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM master_table WHERE configId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM master_table";
        return _query;
      }
    };
  }

  @Override
  public long insert(final MasterEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfMasterEntity.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final MasterEntity obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfMasterEntity.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MasterEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMasterEntity.handle(obj);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void delete(final long configId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, configId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
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
  LiveData<MasterEntity> getMaster(final long configId) {
    final String _sql = "SELECT * FROM master_table WHERE configId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, configId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"master_table"}, false, new Callable<MasterEntity>() {
      @Override
      public MasterEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "configId");
          final int _cursorIndexOfIp = CursorUtil.getColumnIndexOrThrow(_cursor, "ip");
          final int _cursorIndexOfPort = CursorUtil.getColumnIndexOrThrow(_cursor, "port");
          final MasterEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new MasterEntity();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            _result.configId = _cursor.getLong(_cursorIndexOfConfigId);
            if (_cursor.isNull(_cursorIndexOfIp)) {
              _result.ip = null;
            } else {
              _result.ip = _cursor.getString(_cursorIndexOfIp);
            }
            _result.port = _cursor.getInt(_cursorIndexOfPort);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
