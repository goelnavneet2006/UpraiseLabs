package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class CAN_MASTER {
  private String CANID;
  private int CANNumber;
  private ModeOfHoldingsEnum ModeOfHoldings;
  private String PrimaryMemberID;
  private String SecondaryMemberID;
  private String TertiaryMemberID;
  private String ReceivedFrom;
  private Date DeclarationDate;
  private String DeclarationPlace;
  private boolean IsActiveCAN;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getCANID() {
    return CANID;
  }

  public void setCANID(String cANID) {
    CANID = cANID;
  }

  public int getCANNumber() {
    return CANNumber;
  }

  public void setCANNumber(int cANNumber) {
    CANNumber = cANNumber;
  }

  public ModeOfHoldingsEnum getModeOfHoldings() {
    return ModeOfHoldings;
  }

  public void setModeOfHoldings(ModeOfHoldingsEnum modeOfHoldings) {
    ModeOfHoldings = modeOfHoldings;
  }

  public String getPrimaryMemberID() {
    return PrimaryMemberID;
  }

  public void setPrimaryMemberID(String primaryMemberID) {
    PrimaryMemberID = primaryMemberID;
  }

  public String getSecondaryMemberID() {
    return SecondaryMemberID;
  }

  public void setSecondaryMemberID(String secondaryMemberID) {
    SecondaryMemberID = secondaryMemberID;
  }

  public String getTertiaryMemberID() {
    return TertiaryMemberID;
  }

  public void setTertiaryMemberID(String tertiaryMemberID) {
    TertiaryMemberID = tertiaryMemberID;
  }

  public String getReceivedFrom() {
    return ReceivedFrom;
  }

  public void setReceivedFrom(String receivedFrom) {
    ReceivedFrom = receivedFrom;
  }

  public Date getDeclarationDate() {
    return DeclarationDate;
  }

  public void setDeclarationDate(Date declarationDate) {
    DeclarationDate = declarationDate;
  }

  public String getDeclarationPlace() {
    return DeclarationPlace;
  }

  public void setDeclarationPlace(String declarationPlace) {
    DeclarationPlace = declarationPlace;
  }

  public boolean isIsActiveCAN() {
    return IsActiveCAN;
  }

  public void setIsActiveCAN(boolean isActiveCAN) {
    IsActiveCAN = isActiveCAN;
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
