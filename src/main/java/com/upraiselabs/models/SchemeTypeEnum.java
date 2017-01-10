package com.upraiselabs.models;

public enum SchemeTypeEnum {
  DEBT("Debt"),
  EQUITY("Equity");

  private String schemeType;

  SchemeTypeEnum(String schemeType) {
    this.schemeType = schemeType;
  }

  public String getSchemeType() {
    return this.schemeType;
  }

}
