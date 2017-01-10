package com.upraiselabs.models;

public enum OtherAccountTypeEnum {
  NRE("NRE"),
  NRO("NRO"),
  FCNR("FCNR"),
  NRSR("NRSR");

  private String otherAccountType;

  OtherAccountTypeEnum(String otherAccountType) {
    this.otherAccountType = otherAccountType;
  }

  public String getOtherAccountType() {
    return this.otherAccountType;
  }

}
