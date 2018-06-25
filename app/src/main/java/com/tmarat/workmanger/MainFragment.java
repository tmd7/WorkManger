package com.tmarat.workmanger;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainFragment extends Fragment implements Contract.View, LifecycleOwner {

  private final String TAG = MainFragment.class.getSimpleName();

  private EditText editTextName;
  private EditText editTextSurname;
  private EditText editTextAge;
  private RecyclerView recyclerView;

  private Contract.Presenter presenter;
  private Person person;
  private LifecycleOwner lifecycleOwner = new LifecycleOwner() {
    @NonNull @Override public Lifecycle getLifecycle() {
      return MainFragment.this.getLifecycle();
    }
  };

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    Log.d(TAG, "onCreate()");
    super.onCreate(savedInstanceState);
    presenter = new Presenter(this, getActivity().getApplicationContext(), lifecycleOwner);
    person = new Person();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.d(TAG, "onCreateView()");
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    setUI(view);
    setOnClickListener(view);
    return view;
  }

  private void setOnClickListener(View view) {
    Log.d(TAG, "setOnClickListener()");
    view.findViewById(R.id.save_bt).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Log.d(TAG, "onClick()");
        presenter.checkData(getUserInput());
        clearEditText();
      }
    });
  }

  private void setUI(View view) {
    Log.d(TAG, "setUI()");
    editTextName = view.findViewById(R.id.edit_text_name);
    editTextSurname = view.findViewById(R.id.edit_text_surname);
    editTextAge = view.findViewById(R.id.edit_tex_age);
    recyclerView = view.findViewById(R.id.recycler_view_person_list);
  }

  private Person getUserInput() {
    Log.d(TAG, "getUserInput()");
    person.setName(editTextName.getText().toString());
    person.setSurname(editTextSurname.getText().toString());
    person.setAge(editTextAge.getText().toString());
    return person;
  }

  private void clearEditText() {
    Log.d(TAG, "clearEditText()");
    editTextName.setText("");
    editTextSurname.setText("");
    editTextAge.setText("");
  }

  @Override
  public void showToast(int resId) {
    Log.d(TAG, "showToast()");
    Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
  }
}
