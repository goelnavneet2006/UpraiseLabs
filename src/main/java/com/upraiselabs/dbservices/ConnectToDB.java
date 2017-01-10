package com.upraiselabs.dbservices;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.upraiselabs.services.ConfigAccessor;

public abstract class ConnectToDB {
  public static Connection connectToDB() throws SQLException {

    Connection dbConnection = null;
    try {
      String JDBC_DRIVER_CLASS = ConfigAccessor
          .getConfig("database.jdbc.driverClass");
      String CONNECTION_URL = ConfigAccessor
          .getConfig("database.jdbc.connectionURL");
      String DB_USER = ConfigAccessor.getConfig("database.jdbc.username");
      String DB_PWD = ConfigAccessor.getConfig("database.jdbc.password");

      Class.forName(JDBC_DRIVER_CLASS);
      System.setProperty("jdbc.drivers", JDBC_DRIVER_CLASS);
      dbConnection = DriverManager.getConnection(CONNECTION_URL, DB_USER,
          DB_PWD);
    } catch (IOException e) {
      System.out.println(Class.class.getName() + ":" + e);
    } catch (ClassNotFoundException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
    return dbConnection;
  }
}
