package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class SCHEMES_MASTER {
  private String SMID;
  private String MFName;
  private boolean SchemeName;
  private SchemeTypeEnum Type;
  private RegularDirectEnum RegularDirect;
  private PlanOptionEnum PlanOption;
  private Date LaunchDate;
  private int FaceValue;
  private int NAVonLaunch;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getSMID() {
    return SMID;
  }

  public void setSMID(String sMID) {
    SMID = sMID;
  }

  public String getMFName() {
    return MFName;
  }

  public void setMFName(String mFName) {
    MFName = mFName;
  }

  public boolean isSchemeName() {
    return SchemeName;
  }

  public void setSchemeName(boolean schemeName) {
    SchemeName = schemeName;
  }

  public SchemeTypeEnum getType() {
    return Type;
  }

  public void setType(SchemeTypeEnum type) {
    Type = type;
  }

  public RegularDirectEnum getRegularDirect() {
    return RegularDirect;
  }

  public void setRegularDirect(RegularDirectEnum regularDirect) {
    RegularDirect = regularDirect;
  }

  public PlanOptionEnum getPlanOption() {
    return PlanOption;
  }

  public void setPlanOption(PlanOptionEnum planOption) {
    PlanOption = planOption;
  }

  public Date getLaunchDate() {
    return LaunchDate;
  }

  public void setLaunchDate(Date launchDate) {
    LaunchDate = launchDate;
  }

  public int getFaceValue() {
    return FaceValue;
  }

  public void setFaceValue(int faceValue) {
    FaceValue = faceValue;
  }

  public int getNAVonLaunch() {
    return NAVonLaunch;
  }

  public void setNAVonLaunch(int nAVonLaunch) {
    NAVonLaunch = nAVonLaunch;
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
