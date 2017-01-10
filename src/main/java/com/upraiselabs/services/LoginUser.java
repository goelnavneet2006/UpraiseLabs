package com.upraiselabs.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.upraiselabs.clientresponses.ClientMessagesEnum;
import com.upraiselabs.clientresponses.GenericResponse;
import com.upraiselabs.clientresponses.ResponsePayload;
import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.dbservices.ConnectToDB;
import com.upraiselabs.oldmodels.USER;
import com.upraiselabs.oldmodels.USER_DEMOGRAPHIC;
import com.upraiselabs.security.SecurityAlgo;
import com.upraiselabs.validations.Validator;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final String EMAIL_ADDRESS_PARAM = "loginEmail";
  private static final String PASSWORD_PARAM = "loginPassword";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginUser() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("application/json");
    PrintWriter out = response.getWriter();

    if (LoginSessionManager.isUserLogggedIn(request, response)) {
      response.setStatus(HttpServletResponse.SC_CONFLICT);

      List<GenericResponse> errors = new ArrayList<GenericResponse>();
      GenericResponse error = new GenericResponse();
      error.setMsg(ClientMessagesEnum.USER_IS_ALREADY_LOGGED_IN.getMsg());
      error.setType(ClientMessagesEnum.USER_IS_ALREADY_LOGGED_IN.getType());
      errors.add(error);
      ResponsePayload responseError = new ResponsePayload(
          HttpServletResponse.SC_CONFLICT, errors);
      out.print(responseError.getResponsePayload());
      return;
    }

    String email = request.getParameter(EMAIL_ADDRESS_PARAM);
    String password = request.getParameter(PASSWORD_PARAM);

    if (!Validator.validateEmail(email)
        || !Validator.validatePassword(password)) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

      List<GenericResponse> errors = new ArrayList<GenericResponse>();
      GenericResponse error = new GenericResponse();
      error.setMsg(ClientMessagesEnum.INVALID_LOGIN_CREDENTIALS.getMsg());
      error.setType(ClientMessagesEnum.INVALID_LOGIN_CREDENTIALS.getType());
      errors.add(error);
      ResponsePayload responseError = new ResponsePayload(
          HttpServletResponse.SC_BAD_REQUEST, errors);
      out.print(responseError.getResponsePayload());
      return;
    }

    try {
      Connection dbConnection = ConnectToDB.connectToDB();
      Statement stmt = dbConnection.createStatement(
          ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      stmt.executeQuery(DBQueriesEnum.USE_UPRAISE_LABS_DB.toString());

      ResultSet resultSet = stmt.executeQuery(
          "SELECT * FROM USER WHERE email='".concat(email).concat("';"));

      BeanHandler<USER> userHandler = new BeanHandler<USER>(USER.class);
      USER user = userHandler.handle(resultSet);

      if (user == null) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        List<GenericResponse> errors = new ArrayList<GenericResponse>();
        GenericResponse error = new GenericResponse();
        error.setMsg(ClientMessagesEnum.USER_NOT_REGISTERED.getMsg());
        error.setType(ClientMessagesEnum.USER_NOT_REGISTERED.getType());
        errors.add(error);
        ResponsePayload responseError = new ResponsePayload(
            HttpServletResponse.SC_BAD_REQUEST, errors);
        out.print(responseError.getResponsePayload());
      } else {
        String savedSaltToken = user.getSalt_token();
        String userSuppliedPassword = SecurityAlgo.generateHash(password,
            savedSaltToken);
        String savedPassword = user.getPassword();
        if (userSuppliedPassword.equals(savedPassword)) {

          boolean isActiveFlag = user.isIs_active();
          if (isActiveFlag) {
            // User will be logged in.

            // Updating the last login time.
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            resultSet.updateTimestamp("last_login_time", currentTime);
            resultSet.updateRow();

            String userId = user.getUser_id();
            resultSet = stmt
                .executeQuery("SELECT * FROM USER_DEMOGRAPHIC WHERE user_id='"
                    .concat(userId).concat("';"));

            BeanHandler<USER_DEMOGRAPHIC> userDemographicHandler = new BeanHandler<USER_DEMOGRAPHIC>(
                USER_DEMOGRAPHIC.class);
            USER_DEMOGRAPHIC userDemographic = userDemographicHandler
                .handle(resultSet);
            String firstName = userDemographic.getFirstname();

            response.setStatus(HttpServletResponse.SC_OK);
            LoginSessionManager.setLoginCookies(request, response, firstName,
                email);

            List<GenericResponse> successes = new ArrayList<GenericResponse>();
            GenericResponse success = new GenericResponse();
            success.setMsg(ClientMessagesEnum.SUCCESSFUL_LOGIN.getMsg());
            success.setType(ClientMessagesEnum.SUCCESSFUL_LOGIN.getType());
            successes.add(success);
            ResponsePayload responseError = new ResponsePayload(
                HttpServletResponse.SC_OK, successes);
            out.print(responseError.getResponsePayload());
          } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            List<GenericResponse> successes = new ArrayList<GenericResponse>();
            GenericResponse success = new GenericResponse();
            success.setMsg(ClientMessagesEnum.USER_NOT_ACTIVATED.getMsg());
            success.setType(ClientMessagesEnum.USER_NOT_ACTIVATED.getType());
            successes.add(success);
            ResponsePayload responseError = new ResponsePayload(
                HttpServletResponse.SC_BAD_REQUEST, successes);
            out.print(responseError.getResponsePayload());
          }
        } else {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

          List<GenericResponse> errors = new ArrayList<GenericResponse>();
          GenericResponse error = new GenericResponse();
          error.setMsg(ClientMessagesEnum.INVALID_LOGIN_CREDENTIALS.getMsg());
          error.setType(ClientMessagesEnum.INVALID_LOGIN_CREDENTIALS.getType());
          errors.add(error);
          ResponsePayload responseError = new ResponsePayload(
              HttpServletResponse.SC_BAD_REQUEST, errors);
          out.print(responseError.getResponsePayload());
        }
      }
      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null;
      }
      return;
    } catch (SQLException e) {
      System.out.println(this.getClass().getName() + ":" + e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

      List<GenericResponse> errors = new ArrayList<GenericResponse>();
      GenericResponse error = new GenericResponse();
      error.setMsg(ClientMessagesEnum.INTERNAL_SERVER_ERROR.getMsg());
      error.setType(ClientMessagesEnum.INTERNAL_SERVER_ERROR.getType());
      errors.add(error);

      ResponsePayload responseError = new ResponsePayload(
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errors);
      out.print(responseError.getResponsePayload());
      return;
    }
  }
}
