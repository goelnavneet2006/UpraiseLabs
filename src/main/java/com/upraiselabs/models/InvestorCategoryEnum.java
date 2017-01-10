package com.upraiselabs.models;

public enum InvestorCategoryEnum {
  INDIVIDUAL("Individual"),
  MINOR("Minor"),
  SOLE_PROPRIETOR("Sole-Proprietor");

  private String investorCategory;

  InvestorCategoryEnum(String investorCategory) {
    this.investorCategory = investorCategory;
  }

  public String getInvestorCategory() {
    return this.investorCategory;
  }

}
