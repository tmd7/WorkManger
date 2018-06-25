package com.tmarat.workmanger;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.util.Log;

public class Presenter implements Contract.Presenter {

  private final String TAG = Presenter.class.getSimpleName();

  private Contract.View view;
  private Contract.Model model;

  Presenter(Contract.View view, Context applicationContext,
      LifecycleOwner lifecycleOwner) {
    Log.d(TAG, "Presenter()");
    this.view = view;
    model = new Model(lifecycleOwner);
  }

  @Override public void checkData(Person person) {
    Log.d(TAG, "checkData()");

    if (person.getName().equals("") || person.getSurname().equals("")
        || person.getAge().equals("")) {
      view.showToast(R.string.empty_values);
    } else {
      //if data is OK, passes to model
      model.getDataFromPresenter(person);
      view.clearEditText();
    }
  }
}
