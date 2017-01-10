package com.upraiselabs.oldmodels;

import java.sql.Timestamp;

public class USER {
  private String user_id;
  private String email;
  private String password;
  private boolean is_active;
  private Timestamp creation_time;
  private Timestamp last_login_time;
  private String activation_token;
  private String salt_token;

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  public Timestamp getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Timestamp creation_time) {
    this.creation_time = creation_time;
  }

  public Timestamp getLast_login_time() {
    return last_login_time;
  }

  public void setLast_login_time(Timestamp last_login_time) {
    this.last_login_time = last_login_time;
  }

  public String getActivation_token() {
    return activation_token;
  }

  public void setActivation_token(String activation_token) {
    this.activation_token = activation_token;
  }

  public String getSalt_token() {
    return salt_token;
  }

  public void setSalt_token(String salt_token) {
    this.salt_token = salt_token;
  }

}
