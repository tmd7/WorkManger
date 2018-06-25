package com.tmarat.workmanger.contract;

import com.tmarat.workmanger.common.Person;

public interface MainContract {

  interface View {
    void clearEditText();

    void showToast(int resId);
  }

  interface Presenter {
    void checkData(Person person);
  }

  interface Model {
    void getDataFromPresenter(Person person, CallBack.dataBase callBack);
  }
}
