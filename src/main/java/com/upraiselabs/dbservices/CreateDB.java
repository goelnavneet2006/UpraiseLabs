package com.upraiselabs.dbservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class CreateDB {
  public int createDB(Connection myDBConnection, String dbQuery)
      throws SQLException {
    int finalResult = -1;
    if (myDBConnection != null) {
      Statement stmt = myDBConnection.createStatement(
          ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      finalResult = stmt.executeUpdate(dbQuery);
    }
    return finalResult;
  }
}
