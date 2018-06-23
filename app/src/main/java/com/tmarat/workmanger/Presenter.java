package com.tmarat.workmanger;

public class Presenter implements Contract.Presenter {

  private Contract.View view;
  private Contract.Model model;

  public Presenter(Contract.View view) {
    this.view = view;
    model = new Model();
  }

  private void checkData() {
    Person person = view.getUserInput();
    if (person.getName().equals("") || person.getSurname().equals("") || person.getAge().equals("")) {
      view.showSnackBar(R.string.empty_values);
    }
  }
}
