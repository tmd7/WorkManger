package com.tmarat.workmanger;

public class Presenter implements Contract.Presenter {

  private Contract.View view;
  private Contract.Model model;

  Presenter(Contract.View view) {
    this.view = view;
    model = new Model();
  }

  @Override
  public void checkData() {
    Person person = view.getUserInput();
    if (person.getName().equals("") || person.getSurname().equals("") || person.getAge().equals("")) {
      view.showSnackBar(R.string.empty_values);
    } else {

      //if data is OK, transfers to model
      model.getDataFromPresenter(person);
    }
  }
}
