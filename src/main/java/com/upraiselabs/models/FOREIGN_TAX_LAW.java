package com.upraiselabs.models;

import java.sql.Timestamp;

public class FOREIGN_TAX_LAW {
  private String FTLID;
  private String MemberID;
  private boolean IsIndia;
  private String COB;
  private String COBTaxResidencyNo;
  private boolean COBTaxReferenceNo;
  private String COC;
  private String COCTaxResidencyNo;
  private boolean COCTaxReferenceNo;
  private String CON;
  private String CONTaxResidencyNo;
  private boolean CONTaxReferenceNo;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getFTLID() {
    return FTLID;
  }

  public void setFTLID(String fTLID) {
    FTLID = fTLID;
  }

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public boolean isIsIndia() {
    return IsIndia;
  }

  public void setIsIndia(boolean isIndia) {
    IsIndia = isIndia;
  }

  public String getCOB() {
    return COB;
  }

  public void setCOB(String cOB) {
    COB = cOB;
  }

  public String getCOBTaxResidencyNo() {
    return COBTaxResidencyNo;
  }

  public void setCOBTaxResidencyNo(String cOBTaxResidencyNo) {
    COBTaxResidencyNo = cOBTaxResidencyNo;
  }

  public boolean isCOBTaxReferenceNo() {
    return COBTaxReferenceNo;
  }

  public void setCOBTaxReferenceNo(boolean cOBTaxReferenceNo) {
    COBTaxReferenceNo = cOBTaxReferenceNo;
  }

  public String getCOC() {
    return COC;
  }

  public void setCOC(String cOC) {
    COC = cOC;
  }

  public String getCOCTaxResidencyNo() {
    return COCTaxResidencyNo;
  }

  public void setCOCTaxResidencyNo(String cOCTaxResidencyNo) {
    COCTaxResidencyNo = cOCTaxResidencyNo;
  }

  public boolean isCOCTaxReferenceNo() {
    return COCTaxReferenceNo;
  }

  public void setCOCTaxReferenceNo(boolean cOCTaxReferenceNo) {
    COCTaxReferenceNo = cOCTaxReferenceNo;
  }

  public String getCON() {
    return CON;
  }

  public void setCON(String cON) {
    CON = cON;
  }

  public String getCONTaxResidencyNo() {
    return CONTaxResidencyNo;
  }

  public void setCONTaxResidencyNo(String cONTaxResidencyNo) {
    CONTaxResidencyNo = cONTaxResidencyNo;
  }

  public boolean isCONTaxReferenceNo() {
    return CONTaxReferenceNo;
  }

  public void setCONTaxReferenceNo(boolean cONTaxReferenceNo) {
    CONTaxReferenceNo = cONTaxReferenceNo;
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
