package com.tmarat.workmanger;

import android.support.annotation.NonNull;
import android.util.Log;
import androidx.work.Worker;

public class WriteDataWorker extends Worker {

  @NonNull @Override public Result doWork() {

    final String TAG = WriteDataWorker.class.getSimpleName();

    Log.d(TAG, "doWork(): Start");
    Contract.Model model;
    Log.d(TAG, "doWork(): End");
    return Result.SUCCESS;
  }
}
