package com.upraiselabs.models;

import java.sql.Timestamp;

public class PRIMARY_CONTACT {
  private String PCID;
  private String MemberID;
  private String MobileISD;
  private String Mobile;
  private String Email;
  private boolean IsActiveContact;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getPCID() {
    return PCID;
  }

  public void setPCID(String pCID) {
    PCID = pCID;
  }

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public String getMobileISD() {
    return MobileISD;
  }

  public void setMobileISD(String mobileISD) {
    MobileISD = mobileISD;
  }

  public String getMobile() {
    return Mobile;
  }

  public void setMobile(String mobile) {
    Mobile = mobile;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public boolean isIsActiveContact() {
    return IsActiveContact;
  }

  public void setIsActiveContact(boolean isActiveContact) {
    IsActiveContact = isActiveContact;
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
