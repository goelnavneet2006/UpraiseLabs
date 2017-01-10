package com.upraiselabs.models;

public enum ResidentialStatusEnum {
  RES_IND("RES.IND"),
  NRI_NRE("NRI-NRE"),
  NRI_NRO("NRI-NRO"),
  FOREGIN_NATIONAL("FOREGIN NATIONAL"),
  PIO("PIO");

  private String residentialStatus;

  ResidentialStatusEnum(String residentialStatus) {
    this.residentialStatus = residentialStatus;
  }

  public String getResidentialStatus() {
    return this.residentialStatus;
  }

}
