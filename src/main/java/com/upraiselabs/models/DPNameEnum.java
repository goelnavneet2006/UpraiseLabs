package com.upraiselabs.models;

public enum DPNameEnum {
  NSDL("NSDL"),
  CDSL("CDSL");

  private String dpName;

  DPNameEnum(String dpName) {
    this.dpName = dpName;
  }

  public String getDPName() {
    return this.dpName;
  }

}
