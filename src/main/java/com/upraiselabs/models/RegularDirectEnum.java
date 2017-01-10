package com.upraiselabs.models;

public enum RegularDirectEnum {
  REGULAR("Regular"),
  DIRECT("Direct");

  private String regularDirect;

  RegularDirectEnum(String regularDirect) {
    this.regularDirect = regularDirect;
  }

  public String getRegularDirect() {
    return this.regularDirect;
  }

}
