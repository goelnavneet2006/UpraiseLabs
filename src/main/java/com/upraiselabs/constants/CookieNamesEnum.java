package com.upraiselabs.constants;

public enum CookieNamesEnum {
  FIRST_NAME("firstname"),
  AUTH_TOKEN("authtoken"),
  EMAIL("email");

  private String cookieName;

  CookieNamesEnum(String cookieName) {
    this.cookieName = cookieName;
  }

  public String getName() {
    return this.cookieName;
  }
}
