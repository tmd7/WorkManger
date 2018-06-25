package com.tmarat.workmanger.data;

public class SqlRequest {

  public static final String PERSON_TABLE_NAME = "person";

  public static class COLUMN {
    private static final String ID = "_id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String AGE = "age";
  }

  public static final String CREATE_TABLE_OF_PERSON =
      String.format("create table %s ("
          + "%s integer primary key autoincrement, "
          + "%s text, "
          + "%s text, "
          + "%s text);",
          PERSON_TABLE_NAME, COLUMN.ID, COLUMN.NAME, COLUMN.SURNAME, COLUMN.AGE);
}
