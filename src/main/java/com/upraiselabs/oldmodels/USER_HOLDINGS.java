package com.upraiselabs.oldmodels;

import java.sql.Timestamp;

public class USER_HOLDINGS {
  private String user_holdings_id;
  private String user_id;
  private String mutual_fund_id;
  private String mutual_fund_units;
  private Timestamp creation_time;
  private String created_by;
  private Timestamp last_updated_time;
  private String last_updated_by;

  public String getUser_holdings_id() {
    return user_holdings_id;
  }

  public void setUser_holdings_id(String user_holdings_id) {
    this.user_holdings_id = user_holdings_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getMutual_fund_id() {
    return mutual_fund_id;
  }

  public void setMutual_fund_id(String mutual_fund_id) {
    this.mutual_fund_id = mutual_fund_id;
  }

  public String getMutual_fund_units() {
    return mutual_fund_units;
  }

  public void setMutual_fund_units(String mutual_fund_units) {
    this.mutual_fund_units = mutual_fund_units;
  }

  public Timestamp getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Timestamp creation_time) {
    this.creation_time = creation_time;
  }

  public String getCreated_by() {
    return created_by;
  }

  public void setCreated_by(String created_by) {
    this.created_by = created_by;
  }

  public Timestamp getLast_updated_time() {
    return last_updated_time;
  }

  public void setLast_updated_time(Timestamp last_updated_time) {
    this.last_updated_time = last_updated_time;
  }

  public String getLast_updated_by() {
    return last_updated_by;
  }

  public void setLast_updated_by(String last_updated_by) {
    this.last_updated_by = last_updated_by;
  }
}
