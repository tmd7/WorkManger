package com.tmarat.workmanger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainFragment extends Fragment implements Contract.View {

  private EditText editTextName;
  private EditText editTextSurname;
  private EditText editTextAge;
  private RecyclerView recyclerView;

  private Contract.Presenter presenter;
  Person person;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new Presenter(this, getActivity().getApplicationContext());
    person = new Person();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    setUI(view);
    setOnClickListener(view);
    return view;
  }

  private void setOnClickListener(View view) {
    view.findViewById(R.id.save_bt).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        presenter.checkData();
      }
    });
  }

  private void setUI(View view) {
    editTextName = view.findViewById(R.id.edit_text_name);
    editTextSurname = view.findViewById(R.id.edit_text_surname);
    editTextAge = view.findViewById(R.id.edit_tex_age);
    recyclerView = view.findViewById(R.id.recycler_view_person_list);
  }

  @Override
  public Person getUserInput() {
    person.setName(editTextName.getText().toString());
    person.setSurname(editTextSurname.getText().toString());
    person.setAge(editTextAge.getText().toString());
    return person;
  }

  @Override
  public void showSnackBar(int resId) {
    //SnackBar
  }
}
