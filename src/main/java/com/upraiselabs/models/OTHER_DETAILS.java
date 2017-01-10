package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class OTHER_DETAILS {
  private String ODID;
  private String MemberID;
  private String Income;
  private Date DateofNetWorth;
  private String Occupation;
  private boolean IsPoliticallyExposedPerson;
  private boolean IsRelatedToPoliticallyExposedPerson;
  private String AnyOtherInformation;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getODID() {
    return ODID;
  }

  public void setODID(String oDID) {
    ODID = oDID;
  }

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public String getIncome() {
    return Income;
  }

  public void setIncome(String income) {
    Income = income;
  }

  public Date getDateofNetWorth() {
    return DateofNetWorth;
  }

  public void setDateofNetWorth(Date dateofNetWorth) {
    DateofNetWorth = dateofNetWorth;
  }

  public String getOccupation() {
    return Occupation;
  }

  public void setOccupation(String occupation) {
    Occupation = occupation;
  }

  public boolean isIsPoliticallyExposedPerson() {
    return IsPoliticallyExposedPerson;
  }

  public void setIsPoliticallyExposedPerson(
      boolean isPoliticallyExposedPerson) {
    IsPoliticallyExposedPerson = isPoliticallyExposedPerson;
  }

  public boolean isIsRelatedToPoliticallyExposedPerson() {
    return IsRelatedToPoliticallyExposedPerson;
  }

  public void setIsRelatedToPoliticallyExposedPerson(
      boolean isRelatedToPoliticallyExposedPerson) {
    IsRelatedToPoliticallyExposedPerson = isRelatedToPoliticallyExposedPerson;
  }

  public String getAnyOtherInformation() {
    return AnyOtherInformation;
  }

  public void setAnyOtherInformation(String anyOtherInformation) {
    AnyOtherInformation = anyOtherInformation;
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
