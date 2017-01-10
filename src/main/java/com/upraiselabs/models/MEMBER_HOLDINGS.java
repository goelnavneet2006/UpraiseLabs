package com.upraiselabs.models;

import java.sql.Date;
import java.sql.Timestamp;

public class MEMBER_HOLDINGS {
  private String MHID;
  private String CANID;
  private String SMID;
  private Date TransactionDate;
  private float Amount;
  private Date NAVonTransactionDate;
  private int Units;
  private TypeOfTransactionEnum TypeOfTransaction;
  private int FolioNo;
  private String ProductName;
  private Timestamp CreatedTime;
  private String CreatedBy;
  private Timestamp LastUpdatedTime;
  private String LastUpdatedBy;

  public String getMHID() {
    return MHID;
  }

  public void setMHID(String mHID) {
    MHID = mHID;
  }

  public String getCANID() {
    return CANID;
  }

  public void setCANID(String cANID) {
    CANID = cANID;
  }

  public String getSMID() {
    return SMID;
  }

  public void setSMID(String sMID) {
    SMID = sMID;
  }

  public Date getTransactionDate() {
    return TransactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    TransactionDate = transactionDate;
  }

  public float getAmount() {
    return Amount;
  }

  public void setAmount(float amount) {
    Amount = amount;
  }

  public Date getNAVonTransactionDate() {
    return NAVonTransactionDate;
  }

  public void setNAVonTransactionDate(Date nAVonTransactionDate) {
    NAVonTransactionDate = nAVonTransactionDate;
  }

  public int getUnits() {
    return Units;
  }

  public void setUnits(int units) {
    Units = units;
  }

  public TypeOfTransactionEnum getTypeOfTransaction() {
    return TypeOfTransaction;
  }

  public void setTypeOfTransaction(TypeOfTransactionEnum typeOfTransaction) {
    TypeOfTransaction = typeOfTransaction;
  }

  public int getFolioNo() {
    return FolioNo;
  }

  public void setFolioNo(int folioNo) {
    FolioNo = folioNo;
  }

  public String getProductName() {
    return ProductName;
  }

  public void setProductName(String productName) {
    ProductName = productName;
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
