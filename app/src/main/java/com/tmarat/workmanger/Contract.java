package com.tmarat.workmanger;

public interface Contract {

  interface View {
    Person getUserInput();
    void showSnackBar(int resId);
  }

  interface Presenter {
    void checkData();
  }

  interface Model {
    void getDataFromPresenter(Person person);
  }
}
