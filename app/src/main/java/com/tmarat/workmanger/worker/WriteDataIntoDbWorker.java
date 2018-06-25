package com.tmarat.workmanger.worker;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.util.Log;
import androidx.work.Worker;
import com.tmarat.workmanger.common.Person;
import com.tmarat.workmanger.data.DbHelper;
import com.tmarat.workmanger.data.SqlRequest;

public class WriteDataIntoDbWorker extends Worker {

  private static final String NAME = "name";
  private static final String SURNAME = "surname";
  private static final String AGE = "age";
  private final String TAG = WriteDataIntoDbWorker.class.getSimpleName();

  private Person person;

  @NonNull @Override public Result doWork() {
    getData();
    writeWork();
    return Result.SUCCESS;
  }

  private void getData() {
    Log.d(TAG, "getData()");
    person = new Person();
    person.setName(getInputData().getString(NAME, ""));
    person.setSurname(getInputData().getString(SURNAME, ""));
    person.setAge(getInputData().getString(AGE, ""));
  }

  private void writeWork() {
    Log.d(TAG, "doWork: Start");
    DbHelper dbHelper = new DbHelper(getApplicationContext());
    ContentValues cv = new ContentValues();
    cv.put(SqlRequest.COLUMN.NAME, person.getName());
    cv.put(SqlRequest.COLUMN.SURNAME, person.getSurname());
    cv.put(SqlRequest.COLUMN.AGE, person.getAge());
    dbHelper.getWritableDatabase().insert(SqlRequest.PERSON_TABLE_NAME, null, cv);
    Log.d(TAG, "doWork: End");
  }
}
