package com.tmarat.workmanger;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;
import com.tmarat.workmanger.data.DbHelper;
import com.tmarat.workmanger.worker.WriteDataIntoDbWorker;

public class Model implements Contract.Model, LifecycleObserver {

  private final String TAG = Model.class.getSimpleName();

  private OneTimeWorkRequest writeData;
  private LifecycleOwner lifecycleOwner;

  Model(LifecycleOwner lifecycleOwner) {
    Log.d(TAG, "Model()");
    this.lifecycleOwner = lifecycleOwner;
  }

  @Override
  public void getDataFromPresenter(Person person) {
    Log.d(TAG, "getDataFromPresenter()");
    doWorkRequest(person);
    checkWorkerStatus();
  }

  private void doWorkRequest(Person person) {
    Data data = new Data.Builder()
        .putString("name", person.getName())
        .putString("surname", person.getSurname())
        .putString("age", person.getAge())
        .build();

    writeData = new OneTimeWorkRequest
        .Builder(WriteDataIntoDbWorker.class)
        .setInputData(data)
        .build();

    WorkManager.getInstance().enqueue(writeData);
  }

  private void checkWorkerStatus() {
    WorkManager.getInstance()
        .getStatusById(writeData.getId())
        .observe(lifecycleOwner, new Observer<WorkStatus>() {
          @Override public void onChanged(@Nullable WorkStatus workStatus) {
            Log.d(TAG, "onChange: " + workStatus.getState());
            if (workStatus.getState().isFinished()) {
              Log.d(TAG, "Finished");
            }
          }
        });
  }
}
