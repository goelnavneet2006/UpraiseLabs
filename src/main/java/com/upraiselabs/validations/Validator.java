package com.upraiselabs.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;

public abstract class Validator {
  public static boolean validateName(String name) {
    if (name == null) {
      return false;
    }
    return name.matches("[a-zA-Z]+");
  }

  public static boolean validateMobile(String mobile) {
    if (mobile == null) {
      return false;
    }
    return mobile.matches("\\d{10}");
  }

  public static boolean validateLandline(String landline) {
    if (landline == null) {
      return false;
    }
    return landline.matches("\\d+");
  }

  public static boolean validateDOB(String dob) {
    if (dob == null) {
      return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);

    try {
      Date date = sdf.parse(dob);
      System.out.println(date);
    } catch (ParseException e) {
      System.out.println(Class.class.getName() + ":" + e);
      return false;
    }
    return true;
  }

  public static boolean validatePAN(String pan) {
    if (pan == null) {
      return false;
    }
    return pan.matches("[A-Za-z0-9]{10}");
  }

  public static boolean validateAddressLine(String addressLine) {
    if (addressLine == null) {
      return false;
    }
    return addressLine.matches("[A-Za-z0-9\\s\\,\\-\\(\\)\\/]+");
  }

  public static boolean validateCityOrState(String cityOrState) {
    if (cityOrState == null) {
      return false;
    }
    return cityOrState.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
  }

  public static boolean validatePincode(String pincode) {
    if (pincode == null) {
      return false;
    }
    return pincode.matches("\\d{6}");
  }

  public static boolean validateEmail(String email) {
    if (email == null) {
      return false;
    }
    EmailValidator emailValidator = EmailValidator.getInstance(false);
    return emailValidator.isValid(email);
  }

  public static boolean validatePassword(String password) {
    if (password == null) {
      return false;
    }
    return password.matches(".{6,}");
  }

}
