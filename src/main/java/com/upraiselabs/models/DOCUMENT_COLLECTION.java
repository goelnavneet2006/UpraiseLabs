package com.upraiselabs.models;

import java.sql.Timestamp;

public class DOCUMENT_COLLECTION {
  private String DCID;
  private String MemberID;
  private String DOBProof;
  private String DOBProofLocation;
  private String PANProofLocation;
  private String AddressProof;
  private String AddressProofLocation;
  private String KYCProof;
  private String KYCProofLocation;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getDCID() {
    return DCID;
  }

  public void setDCID(String dCID) {
    DCID = dCID;
  }

  public String getMemberID() {
    return MemberID;
  }

  public void setMemberID(String memberID) {
    MemberID = memberID;
  }

  public String getDOBProof() {
    return DOBProof;
  }

  public void setDOBProof(String dOBProof) {
    DOBProof = dOBProof;
  }

  public String getDOBProofLocation() {
    return DOBProofLocation;
  }

  public void setDOBProofLocation(String dOBProofLocation) {
    DOBProofLocation = dOBProofLocation;
  }

  public String getPANProofLocation() {
    return PANProofLocation;
  }

  public void setPANProofLocation(String pANProofLocation) {
    PANProofLocation = pANProofLocation;
  }

  public String getAddressProof() {
    return AddressProof;
  }

  public void setAddressProof(String addressProof) {
    AddressProof = addressProof;
  }

  public String getAddressProofLocation() {
    return AddressProofLocation;
  }

  public void setAddressProofLocation(String addressProofLocation) {
    AddressProofLocation = addressProofLocation;
  }

  public String getKYCProof() {
    return KYCProof;
  }

  public void setKYCProof(String kYCProof) {
    KYCProof = kYCProof;
  }

  public String getKYCProofLocation() {
    return KYCProofLocation;
  }

  public void setKYCProofLocation(String kYCProofLocation) {
    KYCProofLocation = kYCProofLocation;
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
