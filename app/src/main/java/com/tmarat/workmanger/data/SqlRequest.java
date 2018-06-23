package com.tmarat.workmanger.data;

public class SqlRequest {

  private static final String PERSON_TABLE_NAME = "person";

  public static class COLUMN {
    static final String ID = "_id";
    static final String NAME = "name";
    static final String SURNAME = "surname";
    static final String AGE = "age";
  }

  public static final String CREATE_TABLE_OF_PERSON =
      String.format("create table %s ("
          + "%s integer primary key autoincrement, "
          + "%s text, "
          + "%s text, "
          + "%s text);",
          PERSON_TABLE_NAME, COLUMN.ID, COLUMN.NAME, COLUMN.SURNAME, COLUMN.AGE);
}
