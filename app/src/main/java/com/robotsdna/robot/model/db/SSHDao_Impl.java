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
import com.robotsdna.robot.model.entities.SSHEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SSHDao_Impl extends SSHDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SSHEntity> __insertionAdapterOfSSHEntity;

  private final EntityDeletionOrUpdateAdapter<SSHEntity> __deletionAdapterOfSSHEntity;

  private final EntityDeletionOrUpdateAdapter<SSHEntity> __updateAdapterOfSSHEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SSHDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSSHEntity = new EntityInsertionAdapter<SSHEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ssh_table` (`id`,`configId`,`ip`,`port`,`username`,`password`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SSHEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.configId);
        if (value.ip == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ip);
        }
        stmt.bindLong(4, value.port);
        if (value.username == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.username);
        }
        if (value.password == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.password);
        }
      }
    };
    this.__deletionAdapterOfSSHEntity = new EntityDeletionOrUpdateAdapter<SSHEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ssh_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SSHEntity value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfSSHEntity = new EntityDeletionOrUpdateAdapter<SSHEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `ssh_table` SET `id` = ?,`configId` = ?,`ip` = ?,`port` = ?,`username` = ?,`password` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SSHEntity value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.configId);
        if (value.ip == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.ip);
        }
        stmt.bindLong(4, value.port);
        if (value.username == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.username);
        }
        if (value.password == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.password);
        }
        stmt.bindLong(7, value.id);
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ssh_table WHERE configId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ssh_table";
        return _query;
      }
    };
  }

  @Override
  public long insert(final SSHEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSSHEntity.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final SSHEntity obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfSSHEntity.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SSHEntity obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSSHEntity.handle(obj);
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
  LiveData<SSHEntity> getSSH(final long configId) {
    final String _sql = "SELECT * FROM ssh_table WHERE configId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, configId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ssh_table"}, false, new Callable<SSHEntity>() {
      @Override
      public SSHEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "configId");
          final int _cursorIndexOfIp = CursorUtil.getColumnIndexOrThrow(_cursor, "ip");
          final int _cursorIndexOfPort = CursorUtil.getColumnIndexOrThrow(_cursor, "port");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final SSHEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new SSHEntity();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            _result.configId = _cursor.getLong(_cursorIndexOfConfigId);
            if (_cursor.isNull(_cursorIndexOfIp)) {
              _result.ip = null;
            } else {
              _result.ip = _cursor.getString(_cursorIndexOfIp);
            }
            _result.port = _cursor.getInt(_cursorIndexOfPort);
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _result.username = null;
            } else {
              _result.username = _cursor.getString(_cursorIndexOfUsername);
            }
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _result.password = null;
            } else {
              _result.password = _cursor.getString(_cursorIndexOfPassword);
            }
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
