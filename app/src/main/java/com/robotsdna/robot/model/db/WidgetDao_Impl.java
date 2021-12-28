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
import com.robotsdna.robot.model.entities.WidgetStorageData;
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
public final class WidgetDao_Impl extends WidgetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WidgetStorageData> __insertionAdapterOfWidgetStorageData;

  private final EntityDeletionOrUpdateAdapter<WidgetStorageData> __deletionAdapterOfWidgetStorageData;

  private final EntityDeletionOrUpdateAdapter<WidgetStorageData> __updateAdapterOfWidgetStorageData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWithConfigId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public WidgetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWidgetStorageData = new EntityInsertionAdapter<WidgetStorageData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `widget_table` (`id`,`type_name`,`widget_config_id`,`data`,`name`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WidgetStorageData value) {
        stmt.bindLong(1, value.id);
        if (value.typeName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.typeName);
        }
        stmt.bindLong(3, value.configId);
        if (value.data == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.data);
        }
        if (value.name == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.name);
        }
      }
    };
    this.__deletionAdapterOfWidgetStorageData = new EntityDeletionOrUpdateAdapter<WidgetStorageData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `widget_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WidgetStorageData value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfWidgetStorageData = new EntityDeletionOrUpdateAdapter<WidgetStorageData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `widget_table` SET `id` = ?,`type_name` = ?,`widget_config_id` = ?,`data` = ?,`name` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WidgetStorageData value) {
        stmt.bindLong(1, value.id);
        if (value.typeName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.typeName);
        }
        stmt.bindLong(3, value.configId);
        if (value.data == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.data);
        }
        if (value.name == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.name);
        }
        stmt.bindLong(6, value.id);
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM widget_table WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteWithConfigId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM widget_table WHERE widget_config_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM widget_table";
        return _query;
      }
    };
  }

  @Override
  public long insert(final WidgetStorageData obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWidgetStorageData.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final WidgetStorageData obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfWidgetStorageData.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final WidgetStorageData obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWidgetStorageData.handle(obj);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  int deleteById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  int deleteWithConfigId(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWithConfigId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteWithConfigId.release(_stmt);
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
  protected LiveData<List<WidgetStorageData>> getWidgetsFor(final long configId) {
    final String _sql = "SELECT * FROM widget_table WHERE widget_config_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, configId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"widget_table"}, false, new Callable<List<WidgetStorageData>>() {
      @Override
      public List<WidgetStorageData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "type_name");
          final int _cursorIndexOfConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "widget_config_id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final List<WidgetStorageData> _result = new ArrayList<WidgetStorageData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WidgetStorageData _item;
            _item = new WidgetStorageData();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfTypeName)) {
              _item.typeName = null;
            } else {
              _item.typeName = _cursor.getString(_cursorIndexOfTypeName);
            }
            _item.configId = _cursor.getLong(_cursorIndexOfConfigId);
            if (_cursor.isNull(_cursorIndexOfData)) {
              _item.data = null;
            } else {
              _item.data = _cursor.getString(_cursorIndexOfData);
            }
            if (_cursor.isNull(_cursorIndexOfName)) {
              _item.name = null;
            } else {
              _item.name = _cursor.getString(_cursorIndexOfName);
            }
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
  public boolean exists(final long configId, final String name) {
    final String _sql = "SELECT EXISTS (SELECT 1 FROM widget_table WHERE widget_config_id = ? AND name = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, configId);
    _argIndex = 2;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  LiveData<WidgetStorageData> getWidgetIntern(final long configId, final long widgetId) {
    final String _sql = "SELECT * FROM widget_table WHERE widget_config_id = ? AND id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, configId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, widgetId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"widget_table"}, false, new Callable<WidgetStorageData>() {
      @Override
      public WidgetStorageData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "type_name");
          final int _cursorIndexOfConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "widget_config_id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final WidgetStorageData _result;
          if(_cursor.moveToFirst()) {
            _result = new WidgetStorageData();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfTypeName)) {
              _result.typeName = null;
            } else {
              _result.typeName = _cursor.getString(_cursorIndexOfTypeName);
            }
            _result.configId = _cursor.getLong(_cursorIndexOfConfigId);
            if (_cursor.isNull(_cursorIndexOfData)) {
              _result.data = null;
            } else {
              _result.data = _cursor.getString(_cursorIndexOfData);
            }
            if (_cursor.isNull(_cursorIndexOfName)) {
              _result.name = null;
            } else {
              _result.name = _cursor.getString(_cursorIndexOfName);
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
