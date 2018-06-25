package com.tmarat.workmanger.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tmarat.workmanger.R;
import com.tmarat.workmanger.common.Person;
import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

  private ArrayList<Person> personList;

  public PersonAdapter(ArrayList<Person> personList) {
    this.personList = personList;
  }

  @NonNull @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.textViewName.setText(personList.get(position).getName());
    holder.textViewSurname.setText(personList.get(position).getSurname());
    holder.textViewAge.setText(personList.get(position).getAge());
  }

  @Override public int getItemCount() {
    return personList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder{

    private TextView textViewName;
    private TextView textViewSurname;
    private TextView textViewAge;

    public ViewHolder(View itemView) {
      super(itemView);
      textViewName = itemView.findViewById(R.id.text_view_name);
      textViewSurname = itemView.findViewById(R.id.text_view_surname);
      textViewAge = itemView.findViewById(R.id.text_view_age);
    }
  }
}
