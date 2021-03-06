package com.tmarat.workmanger.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

  private final String TAG = DbHelper.class.getSimpleName();
  private static final String BASE_NAME = "person.db";
  private static final int BASE_VERSION = 1;

  public DbHelper(Context context) {
    super(context, BASE_NAME, null, BASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    Log.d(TAG, "onCreate()");
    db.execSQL(SqlRequest.CREATE_TABLE_OF_PERSON);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }
}
