package com.upraiselabs.models;

public enum ModeOfHoldingsEnum {
  SINGLE("Single"),
  ANYONE_OR_SERVIVOR("Anyone or Servivor"),
  JOINT("Joint-Proprietor");

  private String modeOfHoldings;

  ModeOfHoldingsEnum(String modeOfHoldings) {
    this.modeOfHoldings = modeOfHoldings;
  }

  public String getModeOfHoldings() {
    return this.modeOfHoldings;
  }

}
