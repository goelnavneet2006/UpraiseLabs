package com.upraiselabs.oldmodels;

import java.sql.Date;
import java.sql.Timestamp;

public class USER_DEMOGRAPHIC {
  private String user_demographic_id;
  private String user_id;
  private String firstname;
  private String middlename;
  private String lastname;
  private String mobile;
  private String landline_std;
  private String landline_number;
  private Date dob;
  private String pan;
  private String address_line_1;
  private String address_line_2;
  private String city;
  private String state;
  private String pincode;
  private Timestamp creation_time;
  private String created_by;
  private Timestamp last_updated_time;
  private String last_updated_by;

  public String getUser_demographic_id() {
    return user_demographic_id;
  }

  public void setUser_demographic_id(String user_demographic_id) {
    this.user_demographic_id = user_demographic_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getLandline_std() {
    return landline_std;
  }

  public void setLandline_std(String landline_std) {
    this.landline_std = landline_std;
  }

  public String getLandline_number() {
    return landline_number;
  }

  public void setLandline_number(String landline_number) {
    this.landline_number = landline_number;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }

  public String getAddress_line_1() {
    return address_line_1;
  }

  public void setAddress_line_1(String address_line_1) {
    this.address_line_1 = address_line_1;
  }

  public String getAddress_line_2() {
    return address_line_2;
  }

  public void setAddress_line_2(String address_line_2) {
    this.address_line_2 = address_line_2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public Timestamp getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Timestamp creation_time) {
    this.creation_time = creation_time;
  }

  public Timestamp getLast_updated_time() {
    return last_updated_time;
  }

  public void setLast_updated_time(Timestamp last_updated_time) {
    this.last_updated_time = last_updated_time;
  }

  public String getCreated_by() {
    return created_by;
  }

  public void setCreated_by(String created_by) {
    this.created_by = created_by;
  }

  public String getLast_updated_by() {
    return last_updated_by;
  }

  public void setLast_updated_by(String last_updated_by) {
    this.last_updated_by = last_updated_by;
  }

}
