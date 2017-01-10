package com.upraiselabs.models;

public enum PlanOptionEnum {
  DIVIDEND("Dividend"),
  GROWTH("Growth");

  private String planOption;

  PlanOptionEnum(String planOption) {
    this.planOption = planOption;
  }

  public String getPlanOption() {
    return this.planOption;
  }

}
