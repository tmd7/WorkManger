package com.tmarat.workmanger;

import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;
import com.tmarat.workmanger.common.Person;
import com.tmarat.workmanger.contract.CallBack;
import com.tmarat.workmanger.contract.MainContract;

public class Presenter implements MainContract.Presenter {

  private final String TAG = Presenter.class.getSimpleName();

  private MainContract.View view;
  private MainContract.Model model;

  Presenter(MainContract.View view, LifecycleOwner lifecycleOwner) {
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
      model.getDataFromPresenter(person, new CallBack.dataBase() {
        @Override public void onCompleteWriting() {
          view.showToast(R.string.done);
        }
      });

      view.clearEditText();
    }
  }
}
