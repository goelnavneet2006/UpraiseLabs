package com.upraiselabs.constants;

public enum URLMappingEnum {
  HOME_PAGE_URL("/"),
  REGISTER_USER_API_URL("/api/register_user"),
  LOGIN_USER_API_URL("/api/login_user"),
  ACTIVATE_ACCOUNT_URL("/activate_account?token"),
  REGISTER_USER_URL("/register_user"),
  USER_ACCOUNT_URL("/user_account"),
  SIGNOUT_USER_URL("/signout_user");

  private String relativeURL;

  URLMappingEnum(String relativeURL) {
    this.relativeURL = relativeURL;
  }

  public String getRelativeURL() {
    return this.relativeURL;
  }
}
