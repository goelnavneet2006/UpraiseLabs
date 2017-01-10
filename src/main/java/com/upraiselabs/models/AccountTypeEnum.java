package com.upraiselabs.models;

public enum AccountTypeEnum {
  SAVINGS("Savings"),
  CURRENT("Current"),
  CASH_CREDIT("Cash Credit"),
  O_D("O/D"),
  OTHERS("Others");

  private String accountType;

  AccountTypeEnum(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountType() {
    return this.accountType;
  }

}
