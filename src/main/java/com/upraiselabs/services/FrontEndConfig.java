package com.upraiselabs.services;

import java.util.HashMap;

import com.upraiselabs.constants.URLMappingEnum;

public abstract class FrontEndConfig {
  public static void setFrontEndConfig(HashMap<String, Object> context) {
    context.put("registerUserApiUrl",
        URLMappingEnum.REGISTER_USER_API_URL.getRelativeURL());
    context.put("loginUserApiUrl",
        URLMappingEnum.LOGIN_USER_API_URL.getRelativeURL());
    context.put("runOnEnv",
        System.getProperties().getProperty("upraiselabs.runOnEnv"));
  }
}
