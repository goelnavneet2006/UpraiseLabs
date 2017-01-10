package com.upraiselabs.models;

public enum TypeOfTransactionEnum {
  PURCHASE("Purchase"),
  REMITTANCE("Remittance");

  private String typeOfTranscation;

  TypeOfTransactionEnum(String typeOfTranscation) {
    this.typeOfTranscation = typeOfTranscation;
  }

  public String getTypeOfTranscation() {
    return this.typeOfTranscation;
  }

}
