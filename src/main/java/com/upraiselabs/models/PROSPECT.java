package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class PROSPECT {
  private String ProspectID;
  private String FirstName;
  private String MiddleName;
  private String LastName;
  private Date DOB;
  private String PAN;
  private String MobileISD;
  private String Mobile;
  private String Email;
  private ResidentialStatusEnum ResidentialStatus;
  private InvestorCategoryEnum InvestorCategory;
  private int ExpectedAmountforInvestment;
  private boolean VerificationEmailSent;
  private boolean KYCStatus;
  private String ActivationKey;
  private boolean IsDeleted;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getProspectID() {
    return ProspectID;
  }

  public void setProspectID(String prospectID) {
    ProspectID = prospectID;
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

  public boolean isVerificationEmailSent() {
    return VerificationEmailSent;
  }

  public void setVerificationEmailSent(boolean verificationEmailSent) {
    VerificationEmailSent = verificationEmailSent;
  }

  public boolean isKYCStatus() {
    return KYCStatus;
  }

  public void setKYCStatus(boolean kYCStatus) {
    KYCStatus = kYCStatus;
  }

  public String getActivationKey() {
    return ActivationKey;
  }

  public void setActivationKey(String activationKey) {
    ActivationKey = activationKey;
  }

  public boolean isIsDeleted() {
    return IsDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    IsDeleted = isDeleted;
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
