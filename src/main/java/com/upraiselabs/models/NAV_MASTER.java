package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class NAV_MASTER {
  private String NMID;
  private String SMID;
  private Date Date;
  private int NAV;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getNMID() {
    return NMID;
  }

  public void setNMID(String nMID) {
    NMID = nMID;
  }

  public String getSMID() {
    return SMID;
  }

  public void setSMID(String sMID) {
    SMID = sMID;
  }

  public Date getDate() {
    return Date;
  }

  public void setDate(Date date) {
    Date = date;
  }

  public int getNAV() {
    return NAV;
  }

  public void setNAV(int nAV) {
    NAV = nAV;
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
