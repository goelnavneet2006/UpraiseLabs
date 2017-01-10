package com.upraiselabs.oldmodels;

import java.sql.Timestamp;

public class MUTUAL_FUND_NAV {
  private String mutual_fund_nav_id;
  private String fund_name;
  private String fund_id;
  private String face_value;
  private String opening_day_value;
  private String previous_day_value;
  private String current_day_value;
  private Timestamp creation_time;
  private String created_by;
  private Timestamp last_updated_time;
  private String last_updated_by;

  public String getMutual_fund_nav_id() {
    return mutual_fund_nav_id;
  }

  public void setMutual_fund_nav_id(String mutual_fund_nav_id) {
    this.mutual_fund_nav_id = mutual_fund_nav_id;
  }

  public String getFund_name() {
    return fund_name;
  }

  public void setFund_name(String fund_name) {
    this.fund_name = fund_name;
  }

  public String getFund_id() {
    return fund_id;
  }

  public void setFund_id(String fund_id) {
    this.fund_id = fund_id;
  }

  public String getFace_value() {
    return face_value;
  }

  public void setFace_value(String face_value) {
    this.face_value = face_value;
  }

  public String getOpening_day_value() {
    return opening_day_value;
  }

  public void setOpening_day_value(String opening_day_value) {
    this.opening_day_value = opening_day_value;
  }

  public String getPrevious_day_value() {
    return previous_day_value;
  }

  public void setPrevious_day_value(String previous_day_value) {
    this.previous_day_value = previous_day_value;
  }

  public String getCurrent_day_value() {
    return current_day_value;
  }

  public void setCurrent_day_value(String current_day_value) {
    this.current_day_value = current_day_value;
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
