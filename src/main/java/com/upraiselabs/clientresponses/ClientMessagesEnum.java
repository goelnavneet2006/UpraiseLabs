package com.upraiselabs.clientresponses;

public enum ClientMessagesEnum {
  FIRST_NAME_ERROR("Enter a valid first name", "inline"),
  MIDDLE_NAME_ERROR("Enter a valid middle name", "inline"),
  LAST_NAME_ERROR("Enter a valid last name", "inline"),
  MOBILE_ERROR("Enter a valid mobile number", "inline"),
  LANDLINE_STD_ERROR("Enter a valid STD code", "inline"),
  LANDLINE_NUMBER_ERROR("Enter valid landline number", "inline"),
  DOB_ERROR("Enter a valid date of birth", "inline"),
  PAN_ERROR("Enter a valid PAN number", "inline"),
  ADDRESS_LINE1_ERROR("Enter a valid address line 1", "inline"),
  ADDRESS_LINE2_ERROR("Enter a valid address line 2", "inline"),
  CITY_ERROR("Enter a valid city", "inline"),
  STATE_ERROR("Enter a valid state", "inline"),
  PINCODE_ERROR("Enter a valid pincode", "inline"),
  EMAIL_ERROR("Enter a valid email address", "inline"),
  PASSWORD_ERROR("Enter a valid password", "inline"),
  USER_NOT_ACTIVATED("User is not activated. Kindly activate.", "form_level"),
  USER_ALREADY_EXISTS("User is already registered. Kindly proceed to login page.", "form_level"),
  INTERNAL_SERVER_ERROR("Internal server error. Kindly visit after some time.", "form_level"),
  USER_ALREADY_ACTIVATED_ERROR("User is already activated. Kindly proceed to login page.", "form_level"),
  BAD_REQUEST("Bad request.", "form_level"),
  USER_NOT_REGISTERED("User is not registered. Kindly proceed to registration page.", "form_level"),
  INVALID_LOGIN_CREDENTIALS("Invalid login credentials.", "form_level"),
  USER_IS_ALREADY_LOGGED_IN("User is already logged in.", "form_level"),
  SUCCESSFUL_REGISTRATION("User is successfully registered. Kindly check your mails to activate your account.", "form_level"),
  SUCCESSFUL_LOGIN("User is successfully logged in.", "form_level"),
  USER_SUCCESSFULLY_ACTIVATED("User is successfully activated. Kindly proceed to login page.", "form_level");

  private final String msg;
  private final String type;

  ClientMessagesEnum(String msg, String type) {
    this.msg = msg;
    this.type = type;
  }

  public String getMsg() {
    return this.msg;
  }

  public String getType() {
    return this.type;
  }

}
