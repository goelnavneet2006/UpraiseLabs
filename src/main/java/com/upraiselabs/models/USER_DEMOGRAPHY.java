package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class USER_DEMOGRAPHY {
  private String MemberID;
  private String FirstName;
  private String MiddleName;
  private String LastName;
  private Date DOB;
  private String PAN;
  private ResidentialStatusEnum ResidentialStatus;
  private InvestorCategoryEnum InvestorCategory;
  private int ExpectedAmountforInvestment;
  private boolean KYCStatus;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getMiddleName() {
    return MiddleName;
  }

  public void setMiddleName(String middleName) {
    MiddleName = middleName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public Date getDOB() {
    return DOB;
  }

  public void setDOB(Date dOB) {
    DOB = dOB;
  }

  public String getPAN() {
    return PAN;
  }

  public void setPAN(String pAN) {
    PAN = pAN;
  }

  public ResidentialStatusEnum getResidentialStatus() {
    return ResidentialStatus;
  }

  public void setResidentialStatus(ResidentialStatusEnum residentialStatus) {
    ResidentialStatus = residentialStatus;
  }

  public InvestorCategoryEnum getInvestorCategory() {
    return InvestorCategory;
  }

  public void setInvestorCategory(InvestorCategoryEnum investorCategory) {
    InvestorCategory = investorCategory;
  }

  public int getExpectedAmountforInvestment() {
    return ExpectedAmountforInvestment;
  }

  public void setExpectedAmountforInvestment(int expectedAmountforInvestment) {
    ExpectedAmountforInvestment = expectedAmountforInvestment;
  }

  public boolean isKYCStatus() {
    return KYCStatus;
  }

  public void setKYCStatus(boolean kYCStatus) {
    KYCStatus = kYCStatus;
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
