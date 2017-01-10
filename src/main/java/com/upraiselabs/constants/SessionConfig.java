package com.upraiselabs.constants;

public abstract class SessionConfig {
  public static final int SESSION_EXPIRY_TIME = 30 * 60;
  public static final int COOKIE_EXPIRY_TIME = 365 * 24 * 60 * 60;
  public static final String SESSION_EMAIL = "email";
  public static final String SESSION_AUTH_TOKEN = "authtoken";
}
