package com.tmarat.workmanger;

public interface Contract {

  interface View {
    void clearEditText();

    void showToast(int resId);
  }

  interface Presenter {
    void checkData(Person person);
  }

  interface Model {
    void getDataFromPresenter(Person person, CallBack.dataBase dataBase);
  }
}
