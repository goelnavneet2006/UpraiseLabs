package com.upraiselabs.models;

import java.sql.Timestamp;

public class LOGIN_INFO {
  private String LIID;
  private String MemberID;
  private String UserName;
  private String Password;
  private String Salt;
  private boolean IsActiveMember;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getLIID() {
    return LIID;
  }

  public void setLIID(String lIID) {
    LIID = lIID;
  }

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String getSalt() {
    return Salt;
  }

  public void setSalt(String salt) {
    Salt = salt;
  }

  public boolean isIsActiveMember() {
    return IsActiveMember;
  }

  public void setIsActiveMember(boolean isActiveMember) {
    IsActiveMember = isActiveMember;
  }

  public Timestamp getCreatedTime() {
    return CreatedTime;
  }

  public void setCreatedTime(Timestamp createdTime) {
    CreatedTime = createdTime;
  }

  public String getCreatedBy() {
    return CreatedBy;
  }

  public void setCreatedBy(String createdBy) {
    CreatedBy = createdBy;
  }

  public Timestamp getLastUpdatedTime() {
    return LastUpdatedTime;
  }

  public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
    LastUpdatedTime = lastUpdatedTime;
  }

  public String getLastUpdatedBy() {
    return LastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    LastUpdatedBy = lastUpdatedBy;
  }

}
