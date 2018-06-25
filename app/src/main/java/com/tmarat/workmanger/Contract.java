package com.tmarat.workmanger;

public interface Contract {

  interface View {
    void showToast(int resId);
  }

  interface Presenter {
    void checkData(Person person);
  }

  interface Model {
    void getDataFromPresenter(Person person);
  }
}
