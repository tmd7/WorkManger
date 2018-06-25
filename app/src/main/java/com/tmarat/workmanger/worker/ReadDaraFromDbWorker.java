package com.tmarat.workmanger.worker;

import android.database.Cursor;
import android.support.annotation.NonNull;
import androidx.work.Worker;
import com.tmarat.workmanger.common.Person;
import com.tmarat.workmanger.data.DbHelper;
import com.tmarat.workmanger.data.SqlRequest;
import java.util.ArrayList;
import java.util.List;

public class ReadDaraFromDbWorker extends Worker {
  @NonNull @Override public Result doWork() {
    readWork();
    return Result.SUCCESS;
  }

  private void readWork() {
    List<Person> personList = new ArrayList<>();
    DbHelper dbHelper = new DbHelper(getApplicationContext());
    Cursor cursor = dbHelper.getReadableDatabase()
        .query(SqlRequest.PERSON_TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null);

    while (cursor.moveToNext()) {
      Person person = new Person();
      person.setName(cursor.getString(cursor.getColumnIndex(SqlRequest.COLUMN.NAME)));
      person.setSurname(cursor.getString(cursor.getColumnIndex(SqlRequest.COLUMN.SURNAME)));
      person.setAge(cursor.getString(cursor.getColumnIndex(SqlRequest.COLUMN.AGE)));
      personList.add(person);
    }
    cursor.close();
  }
}
