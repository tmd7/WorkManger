package com.tmarat.workmanger;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;
import androidx.work.Worker;
import com.tmarat.workmanger.data.DbHelper;
import com.tmarat.workmanger.data.SqlRequest;

public class Model extends Worker implements Contract.Model, LifecycleObserver {

  private final String TAG = Model.class.getSimpleName();

  private Person person;
  private DbHelper dbHelper;
  private OneTimeWorkRequest workRequest;
  private LifecycleOwner lifecycleOwner;

  Model(Context applicationContext, LifecycleOwner lifecycleOwner) {
    Log.d(TAG, "Model()");
    dbHelper = new DbHelper(applicationContext);
    this.lifecycleOwner = lifecycleOwner;
  }

  Model() {
  }

  @Override
  public void getDataFromPresenter(Person person) {
    Log.d(TAG, "getDataFromPresenter()");
    this.person = person;
    doWorkRequest();
    //checkWorkerStatus();
  }

  private void doWorkRequest() {
    workRequest = new OneTimeWorkRequest.Builder(Model.class).build();
    WorkManager.getInstance().enqueue(workRequest);
  }

  private void checkWorkerStatus() {
    WorkManager.getInstance()
        .getStatusById(workRequest.getId())
        .observe(lifecycleOwner, new Observer<WorkStatus>() {
          @Override public void onChanged(@Nullable WorkStatus workStatus) {
            Log.d(TAG, "onChange: " + workStatus.getState());
            if (workStatus.getState().isFinished()) {
              Log.d(TAG, "Finished");
            }
          }
        });
  }

  @NonNull @Override public Result doWork() {
    Log.d(TAG, "doWork: Start");
    ContentValues cv = new ContentValues();
    cv.put(SqlRequest.COLUMN.NAME, person.getName());
    cv.put(SqlRequest.COLUMN.SURNAME, person.getSurname());
    cv.put(SqlRequest.COLUMN.AGE, person.getAge());
    dbHelper.getWritableDatabase().insert(SqlRequest.PERSON_TABLE_NAME, null, cv);
    Log.d(TAG, "doWork: End");
    return Result.SUCCESS;
  }
}
