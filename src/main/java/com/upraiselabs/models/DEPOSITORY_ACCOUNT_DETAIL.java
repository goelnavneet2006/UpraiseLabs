package com.upraiselabs.models;

import java.sql.Timestamp;

public class DEPOSITORY_ACCOUNT_DETAIL {
  private String DAID;
  private String CANID;
  private DPNameEnum DPName;
  private String DPParticipantName;
  private String DPParticipantID;
  private String BeneficiaryAccountNo;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getDAID() {
    return DAID;
  }

  public void setDAID(String dAID) {
    DAID = dAID;
  }

  public String getCANID() {
    return CANID;
  }

  public void setCANID(String cANID) {
    CANID = cANID;
  }

  public DPNameEnum getDPName() {
    return DPName;
  }

  public void setDPName(DPNameEnum dPName) {
    DPName = dPName;
  }

  public String getDPParticipantName() {
    return DPParticipantName;
  }

  public void setDPParticipantName(String dPParticipantName) {
    DPParticipantName = dPParticipantName;
  }

  public String getDPParticipantID() {
    return DPParticipantID;
  }

  public void setDPParticipantID(String dPParticipantID) {
    DPParticipantID = dPParticipantID;
  }

  public String getBeneficiryAccountNo() {
    return BeneficiaryAccountNo;
  }

  public void setBeneficiryAccountNo(String beneficiaryAccountNo) {
    BeneficiaryAccountNo = beneficiaryAccountNo;
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
