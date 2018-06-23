package com.tmarat.workmanger;

public class Model implements Contract.Model{

  private Person person;

  @Override
  public void getDataFromPresenter(Person person) {
    this.person = person;
  }
}
