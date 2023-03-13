package com.example.data.local;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.domain.entity.Category;
import com.example.domain.entity.Entry;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDao_Impl implements MyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Category> __insertionAdapterOfCategory;

  private final EntityInsertionAdapter<Entry> __insertionAdapterOfEntry;

  public MyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategory = new EntityInsertionAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `category` (`id`,`category`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.getId());
        if (value.getCategory() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCategory());
        }
      }
    };
    this.__insertionAdapterOfEntry = new EntityInsertionAdapter<Entry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `entry` (`id`,`API`,`Auth`,`Category`,`Cors`,`Description`,`HTTPS`,`Link`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entry value) {
        stmt.bindLong(1, value.getId());
        if (value.getAPI() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAPI());
        }
        if (value.getAuth() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuth());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategory());
        }
        if (value.getCors() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCors());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        final int _tmp = value.getHTTPS() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getLink() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLink());
        }
      }
    };
  }

  @Override
  public Object insertAllCategory(final List<Category> list,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCategory.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insetAllItem(final List<Entry> list,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntry.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Category>> getAllCategory() {
    final String _sql = "SELECT * FROM category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"category"}, new Callable<List<Category>>() {
      @Override
      public List<Category> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Category _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new Category(_tmpId,_tmpCategory);
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
  public Flow<List<Entry>> getAllItems() {
    final String _sql = "SELECT * FROM entry";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"entry"}, new Callable<List<Entry>>() {
      @Override
      public List<Entry> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAPI = CursorUtil.getColumnIndexOrThrow(_cursor, "API");
          final int _cursorIndexOfAuth = CursorUtil.getColumnIndexOrThrow(_cursor, "Auth");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "Category");
          final int _cursorIndexOfCors = CursorUtil.getColumnIndexOrThrow(_cursor, "Cors");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "Description");
          final int _cursorIndexOfHTTPS = CursorUtil.getColumnIndexOrThrow(_cursor, "HTTPS");
          final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "Link");
          final List<Entry> _result = new ArrayList<Entry>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Entry _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpAPI;
            if (_cursor.isNull(_cursorIndexOfAPI)) {
              _tmpAPI = null;
            } else {
              _tmpAPI = _cursor.getString(_cursorIndexOfAPI);
            }
            final String _tmpAuth;
            if (_cursor.isNull(_cursorIndexOfAuth)) {
              _tmpAuth = null;
            } else {
              _tmpAuth = _cursor.getString(_cursorIndexOfAuth);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCors;
            if (_cursor.isNull(_cursorIndexOfCors)) {
              _tmpCors = null;
            } else {
              _tmpCors = _cursor.getString(_cursorIndexOfCors);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpHTTPS;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHTTPS);
            _tmpHTTPS = _tmp != 0;
            final String _tmpLink;
            if (_cursor.isNull(_cursorIndexOfLink)) {
              _tmpLink = null;
            } else {
              _tmpLink = _cursor.getString(_cursorIndexOfLink);
            }
            _item = new Entry(_tmpId,_tmpAPI,_tmpAuth,_tmpCategory,_tmpCors,_tmpDescription,_tmpHTTPS,_tmpLink);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
