package com.tmarat.workmanger;

import android.content.Context;
import com.tmarat.workmanger.data.DbHelper;

public class Model implements Contract.Model{

  private Person person;
  private DbHelper dbHelper;

  Model(Context applicationContext) {
    dbHelper = new DbHelper(applicationContext);
  }

  @Override
  public void getDataFromPresenter(Person person) {
    this.person = person;
  }
}
