package com.upraiselabs.constants;

public enum DBQueriesEnum {
  CREATE_UPRAISE_LABS_DB_QUERY("CREATE DATABASE UPRAISE_LABS_DB;"),

  USE_UPRAISE_LABS_DB("USE UPRAISE_LABS_DB;"),

  CREATE_USER_TABLE(
      "CREATE TABLE USER (user_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY, email VARCHAR(128) NOT NULL, password VARCHAR(64) NOT NULL, is_active BOOL NOT NULL DEFAULT FALSE, creation_time TIMESTAMP NOT NULL DEFAULT NOW(), last_login_time TIMESTAMP NOT NULL DEFAULT NOW(), activation_token VARCHAR(64) NOT NULL, salt_token VARCHAR(64) NOT NULL);"),

  CREATE_USER_DEMOGRAPHIC_TABLE(
      "CREATE TABLE USER_DEMOGRAPHIC (user_demographic_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY, user_id INT(8) UNSIGNED NOT NULL, firstname VARCHAR(32) NOT NULL, middlename VARCHAR(32), lastname VARCHAR(32), mobile VARCHAR(16) NOT NULL, landline_std VARCHAR(16), landline_number VARCHAR(16), dob DATE NOT NULL, pan VARCHAR(16) NOT NULL, address_line_1 VARCHAR(64) NOT NULL, address_line_2 VARCHAR(64), city VARCHAR(32) NOT NULL, state VARCHAR(32) NOT NULL,pincode VARCHAR(8) NOT NULL, creation_time TIMESTAMP NOT NULL DEFAULT NOW(), created_by ENUM('user', 'admin') NOT NULL DEFAULT 'user', last_updated_time TIMESTAMP NOT NULL DEFAULT NOW(), last_updated_by ENUM('user', 'admin') NOT NULL DEFAULT 'user', FOREIGN KEY (user_id) REFERENCES USER(user_id));"),

  CREATE_MUTUAL_FUND_NAV_TABLE(
      "CREATE TABLE MUTUAL_FUND_NAV (mutual_fund_nav_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY, fund_name VARCHAR(32) NOT NULL, fund_id  VARCHAR(32) NOT NULL, face_value VARCHAR(32) NOT NULL, opening_day_value VARCHAR(32) NOT NULL, previous_day_value VARCHAR(32) NOT NULL, current_day_value VARCHAR(32) NOT NULL, creation_time TIMESTAMP NOT NULL DEFAULT NOW(), created_by ENUM('manual', 'feed') NOT NULL DEFAULT 'manual', last_updated_time TIMESTAMP NOT NULL DEFAULT NOW(), last_updated_by ENUM('manual', 'feed') NOT NULL DEFAULT 'manual');"),

  CREATE_USER_HOLDINGS_TABLE(
      "CREATE TABLE USER_HOLDINGS (user_holdings_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY, user_id INT(8) UNSIGNED NOT NULL, mutual_fund_id  VARCHAR(32) NOT NULL, mutual_fund_units VARCHAR(32) NOT NULL, creation_time TIMESTAMP NOT NULL DEFAULT NOW(), created_by ENUM('manual', 'feed') NOT NULL DEFAULT 'manual', last_updated_time TIMESTAMP NOT NULL DEFAULT NOW(), last_updated_by ENUM('manual', 'feed') NOT NULL DEFAULT 'manual', FOREIGN KEY (user_id) REFERENCES USER(user_id));");

  private final String dbQuery;

  DBQueriesEnum(String dbQuery) {
    this.dbQuery = dbQuery;
  }

  public String toString() {
    return this.dbQuery;
  }
}
