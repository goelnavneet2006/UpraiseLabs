package com.upraiselabs.services;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upraiselabs.constants.SessionConfig;
import com.upraiselabs.constants.URLMappingEnum;
import com.upraiselabs.security.SecurityAlgo;
import com.upraiselabs.constants.CookieNamesEnum;

public abstract class LoginSessionManager {

  public static void setLogoutSessionUntilNextExpiry(
      HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null || !request.isRequestedSessionIdValid()) {
      session = request.getSession();
    } else {
      session.setMaxInactiveInterval(SessionConfig.SESSION_EXPIRY_TIME);
    }
  }

  public static void setLoginSessionUntilNextExpiry(
      HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    session.setMaxInactiveInterval(SessionConfig.SESSION_EXPIRY_TIME);
  }

  public static boolean isUserLogggedIn(HttpServletRequest request,
      HttpServletResponse response) {
    HttpSession session = request.getSession(false);
    if (request.isRequestedSessionIdValid()) {
      if (session.getAttribute(SessionConfig.SESSION_AUTH_TOKEN) != null) {
        if (request.isSecure()) {
          String sessionAuthToken = session
              .getAttribute(SessionConfig.SESSION_AUTH_TOKEN).toString();
          Cookie authTokenCookie = getCookie(request,
              CookieNamesEnum.AUTH_TOKEN.getName());
          if (authTokenCookie != null
              && sessionAuthToken.equals(authTokenCookie.getValue())) {
            setLoginSessionUntilNextExpiry(request);
            return true;
          }
        } else {
          setLoginSessionUntilNextExpiry(request);
          return true;
        }
      }
    }
    logoutUser(request, response);
    setLogoutSessionUntilNextExpiry(request);
    return false;
  }

  public static void logoutUser(HttpServletRequest request,
      HttpServletResponse response) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.removeAttribute(SessionConfig.SESSION_EMAIL);
      session.removeAttribute(SessionConfig.SESSION_AUTH_TOKEN);
      session.setMaxInactiveInterval(SessionConfig.SESSION_EXPIRY_TIME);
    }

    Cookie firstNameCookie = getCookie(request,
        CookieNamesEnum.FIRST_NAME.getName());
    if (firstNameCookie != null) {
      firstNameCookie.setMaxAge(0);
      response.addCookie(firstNameCookie);
    }

    Cookie authTokenCookie = getCookie(request,
        CookieNamesEnum.AUTH_TOKEN.getName());
    if (authTokenCookie != null) {
      authTokenCookie.setMaxAge(0);
      response.addCookie(authTokenCookie);
    }
  }

  public static void setLoginCookies(HttpServletRequest request,
      HttpServletResponse response, String firstName, String email) {

    HttpSession session = request.getSession();
    String authToken = SecurityAlgo.generateSalt();
    session.setAttribute(SessionConfig.SESSION_EMAIL, email);
    session.setAttribute(SessionConfig.SESSION_AUTH_TOKEN, authToken);
    session.setMaxInactiveInterval(SessionConfig.SESSION_EXPIRY_TIME);

    Cookie firstNameCookie = new Cookie(CookieNamesEnum.FIRST_NAME.getName(),
        null);
    firstNameCookie.setValue(firstName);
    firstNameCookie.setPath("/");
    firstNameCookie.setMaxAge(SessionConfig.COOKIE_EXPIRY_TIME);
    response.addCookie(firstNameCookie);

    Cookie authTokenCookie = new Cookie(CookieNamesEnum.AUTH_TOKEN.getName(),
        null);
    authTokenCookie.setValue(authToken);
    authTokenCookie.setPath("/");
    authTokenCookie.setSecure(true);
    authTokenCookie.setMaxAge(SessionConfig.COOKIE_EXPIRY_TIME);
    response.addCookie(authTokenCookie);
  }

  public static Cookie getCookie(HttpServletRequest request,
      String cookieName) {
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (cookie.getName().equals(cookieName)) {
          return cookie;
        }
      }
    }
    return null;
  }

  public static void setHeaderContext(HttpServletRequest request,
      HttpServletResponse response, HashMap<String, Object> context) {
    boolean isUserLoggedIn = LoginSessionManager.isUserLogggedIn(request,
        response);
    context.put("isUserLoggedIn", isUserLoggedIn);
    if (isUserLoggedIn) {
      context.put("signoutUserUrl",
          URLMappingEnum.SIGNOUT_USER_URL.getRelativeURL());
      Cookie firstNameCookie = LoginSessionManager.getCookie(request,
          CookieNamesEnum.FIRST_NAME.getName());
      if (firstNameCookie != null) {
        context.put("firstName", firstNameCookie.getValue());
      } else {
        HttpSession session = request.getSession(false);
        String sessionEmail = session.getAttribute(SessionConfig.SESSION_EMAIL)
            .toString();
        context.put("firstName", sessionEmail);
      }
    } else {
      context.put("registerUserUrl",
          URLMappingEnum.REGISTER_USER_URL.getRelativeURL());
    }
  }
}
