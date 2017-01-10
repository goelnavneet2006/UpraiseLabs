package com.upraiselabs.dbservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.dbservices.ConnectToDB;

public abstract class CreateTable {
  public int createTable(String createTableQuery) throws SQLException {
    Connection myDBConnection = ConnectToDB.connectToDB();
    int finalResult = -1;
    if (myDBConnection != null) {
      Statement stmt = myDBConnection.createStatement(
          ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      stmt.executeQuery(DBQueriesEnum.USE_UPRAISE_LABS_DB.toString());
      finalResult = stmt.executeUpdate(createTableQuery);
    }
    return finalResult;
  }
}
