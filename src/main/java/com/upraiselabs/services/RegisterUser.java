package com.upraiselabs.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.upraiselabs.clientresponses.ClientMessagesEnum;
import com.upraiselabs.clientresponses.GenericResponse;
import com.upraiselabs.clientresponses.ResponsePayload;
import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.constants.URLMappingEnum;
import com.upraiselabs.dbservices.ConnectToDB;
import com.upraiselabs.security.SecurityAlgo;
import com.upraiselabs.validations.Validator;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final String FIRST_NAME_PARAM = "registerFirstName";
  private static final String MIDDLE_NAME_PARAM = "registerMiddleName";
  private static final String LAST_NAME_PARAM = "registerLastName";
  private static final String MOBILE_PARAM = "registerMobile";
  private static final String LANDLINE_STD_PARAM = "registerLandlineSTD";
  private static final String LANDLINE_NUMBER_PARAM = "registerLandlineNumber";
  private static final String DOB_PARAM = "registerDOB";
  private static final String PAN_PARAM = "registerPAN";
  private static final String ADDRESS_LINE1_PARAM = "registerAddLine1";
  private static final String ADDRESS_LINE2_PARAM = "registerAddLine2";
  private static final String CITY_PARAM = "registerCity";
  private static final String STATE_PARAM = "registerState";
  private static final String PINCODE_PARAM = "registerPincode";
  private static final String EMAIL_ADDRESS_PARAM = "registerEmail";
  private static final String PASSWORD_PARAM = "registerPassword";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RegisterUser() {
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

    String firstName = request.getParameter(FIRST_NAME_PARAM);
    String middleName = request.getParameter(MIDDLE_NAME_PARAM);
    String lastName = request.getParameter(LAST_NAME_PARAM);
    String mobile = request.getParameter(MOBILE_PARAM);
    String landlineSTD = request.getParameter(LANDLINE_STD_PARAM);
    String landlineNumber = request.getParameter(LANDLINE_NUMBER_PARAM);
    String dob = request.getParameter(DOB_PARAM);
    String pan = request.getParameter(PAN_PARAM);
    String addLine1 = request.getParameter(ADDRESS_LINE1_PARAM);
    String addLine2 = request.getParameter(ADDRESS_LINE2_PARAM);
    String city = request.getParameter(CITY_PARAM);
    String state = request.getParameter(STATE_PARAM);
    String pincode = request.getParameter(PINCODE_PARAM);
    String email = request.getParameter(EMAIL_ADDRESS_PARAM);
    String password = request.getParameter(PASSWORD_PARAM);

    List<GenericResponse> errors = new ArrayList<GenericResponse>();

    if (!Validator.validateName(firstName)) {
      GenericResponse error = new GenericResponse();
      error.setField(FIRST_NAME_PARAM);
      error.setMsg(ClientMessagesEnum.FIRST_NAME_ERROR.getMsg());
      error.setType(ClientMessagesEnum.FIRST_NAME_ERROR.getType());
      errors.add(error);
    }

    if (middleName != null && !Validator.validateName(middleName)) {
      GenericResponse error = new GenericResponse();
      error.setField(MIDDLE_NAME_PARAM);
      error.setMsg(ClientMessagesEnum.MIDDLE_NAME_ERROR.getMsg());
      error.setType(ClientMessagesEnum.MIDDLE_NAME_ERROR.getType());
      errors.add(error);
    } else if (middleName == null) {
      middleName = "";
    }

    if (lastName != null && !Validator.validateName(lastName)) {
      GenericResponse error = new GenericResponse();
      error.setField(LAST_NAME_PARAM);
      error.setMsg(ClientMessagesEnum.LAST_NAME_ERROR.getMsg());
      error.setType(ClientMessagesEnum.LAST_NAME_ERROR.getType());
      errors.add(error);
    } else if (lastName == null) {
      lastName = "";
    }

    if (!Validator.validateMobile(mobile)) {
      GenericResponse error = new GenericResponse();
      error.setField(MOBILE_PARAM);
      error.setMsg(ClientMessagesEnum.MOBILE_ERROR.getMsg());
      error.setType(ClientMessagesEnum.MOBILE_ERROR.getType());
      errors.add(error);
    }

    if (landlineSTD != null && !Validator.validateLandline(landlineSTD)) {
      GenericResponse error = new GenericResponse();
      error.setField(LANDLINE_STD_PARAM);
      error.setMsg(ClientMessagesEnum.LANDLINE_STD_ERROR.getMsg());
      error.setType(ClientMessagesEnum.LANDLINE_STD_ERROR.getType());
      errors.add(error);
    } else if (landlineSTD == null) {
      landlineSTD = "";
    }

    if (landlineNumber != null && !Validator.validateLandline(landlineNumber)) {
      GenericResponse error = new GenericResponse();
      error.setField(LANDLINE_NUMBER_PARAM);
      error.setMsg(ClientMessagesEnum.LANDLINE_NUMBER_ERROR.getMsg());
      error.setType(ClientMessagesEnum.LANDLINE_NUMBER_ERROR.getType());
      errors.add(error);
    } else if (landlineNumber == null) {
      landlineNumber = "";
    }

    if (!Validator.validateDOB(dob)) {
      GenericResponse error = new GenericResponse();
      error.setField(DOB_PARAM);
      error.setMsg(ClientMessagesEnum.DOB_ERROR.getMsg());
      error.setType(ClientMessagesEnum.DOB_ERROR.getType());
      errors.add(error);
    } else {
      SimpleDateFormat sdfCurrent = new SimpleDateFormat("dd/MM/yyyy");
      sdfCurrent.setLenient(false);
      try {
        Date date = sdfCurrent.parse(dob);
        SimpleDateFormat sdfNew = new SimpleDateFormat("yyyy-MM-dd");
        dob = sdfNew.format(date);
      } catch (ParseException e) {
        System.out.println(this.getClass().getName() + ":" + e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

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

    if (!Validator.validatePAN(pan)) {
      GenericResponse error = new GenericResponse();
      error.setField(PAN_PARAM);
      error.setMsg(ClientMessagesEnum.PAN_ERROR.getMsg());
      error.setType(ClientMessagesEnum.PAN_ERROR.getType());
      errors.add(error);
    }

    if (!Validator.validateAddressLine(addLine1)) {
      GenericResponse error = new GenericResponse();
      error.setField(ADDRESS_LINE1_PARAM);
      error.setMsg(ClientMessagesEnum.ADDRESS_LINE1_ERROR.getMsg());
      error.setType(ClientMessagesEnum.ADDRESS_LINE1_ERROR.getType());
      errors.add(error);
    }

    if (addLine2 != null && !Validator.validateAddressLine(addLine2)) {
      GenericResponse error = new GenericResponse();
      error.setField(ADDRESS_LINE2_PARAM);
      error.setMsg(ClientMessagesEnum.ADDRESS_LINE2_ERROR.getMsg());
      error.setType(ClientMessagesEnum.ADDRESS_LINE2_ERROR.getType());
      errors.add(error);
    } else if (addLine2 == null) {
      addLine2 = "";
    }

    if (!Validator.validateCityOrState(city)) {
      GenericResponse error = new GenericResponse();
      error.setField(CITY_PARAM);
      error.setMsg(ClientMessagesEnum.CITY_ERROR.getMsg());
      error.setType(ClientMessagesEnum.CITY_ERROR.getType());
      errors.add(error);
    }

    if (!Validator.validateCityOrState(state)) {
      GenericResponse error = new GenericResponse();
      error.setField(STATE_PARAM);
      error.setMsg(ClientMessagesEnum.STATE_ERROR.getMsg());
      error.setType(ClientMessagesEnum.STATE_ERROR.getType());
      errors.add(error);
    }

    if (!Validator.validatePincode(pincode)) {
      GenericResponse error = new GenericResponse();
      error.setField(PINCODE_PARAM);
      error.setMsg(ClientMessagesEnum.PINCODE_ERROR.getMsg());
      error.setType(ClientMessagesEnum.PINCODE_ERROR.getType());
      errors.add(error);
    }

    if (!Validator.validateEmail(email)) {
      GenericResponse error = new GenericResponse();
      error.setField(EMAIL_ADDRESS_PARAM);
      error.setMsg(ClientMessagesEnum.EMAIL_ERROR.getMsg());
      error.setType(ClientMessagesEnum.EMAIL_ERROR.getType());
      errors.add(error);
    }

    if (!Validator.validatePassword(password)) {
      GenericResponse error = new GenericResponse();
      error.setField(PASSWORD_PARAM);
      error.setMsg(ClientMessagesEnum.PASSWORD_ERROR.getMsg());
      error.setType(ClientMessagesEnum.PASSWORD_ERROR.getType());
      errors.add(error);
    }

    if (errors.size() > 0) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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

      if (resultSet.first()) {
        if (dbConnection != null) {
          dbConnection.close();
          dbConnection = null;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        GenericResponse error = new GenericResponse();
        error.setMsg(ClientMessagesEnum.USER_ALREADY_EXISTS.getMsg());
        error.setType(ClientMessagesEnum.USER_ALREADY_EXISTS.getType());
        errors.add(error);

        ResponsePayload responseError = new ResponsePayload(
            HttpServletResponse.SC_BAD_REQUEST, errors);
        out.print(responseError.getResponsePayload());
        return;
      }

      // Creating salt code.
      String saltToken = SecurityAlgo.generateSalt();

      // Creating hash of password.
      String encryptedPassword = SecurityAlgo.generateHash(password, saltToken);

      // Creating activation code.
      String activationToken = SecurityAlgo.generateURLEncodedHash(email);

      String userTableData = "", userDemographicData = "";
      userTableData = "('".concat(email).concat("','").concat(encryptedPassword)
          .concat("','").concat(activationToken).concat("','").concat(saltToken)
          .concat("');");
      stmt.executeUpdate(
          "INSERT INTO USER (email, password, activation_token, salt_token) VALUES "
              .concat(userTableData));
      resultSet = stmt
          .executeQuery("SELECT LAST_INSERT_ID() AS LAST_ID FROM USER");

      resultSet.first();
      String lastInsertIndex = resultSet.getString("LAST_ID");

      userDemographicData = "('".concat(lastInsertIndex).concat("','")
          .concat(firstName).concat("','").concat(middleName).concat("','")
          .concat(lastName).concat("','").concat(mobile).concat("','")
          .concat(landlineSTD).concat("','").concat(landlineNumber)
          .concat("','").concat(dob).concat("','").concat(pan).concat("','")
          .concat(addLine1).concat("','").concat(addLine2).concat("','")
          .concat(city).concat("','").concat(state).concat("','")
          .concat(pincode).concat("');");
      stmt.executeUpdate(
          "INSERT INTO USER_DEMOGRAPHIC (user_id, firstname, middlename, lastname, mobile, landline_std, landline_number, dob, pan, address_line_1, address_line_2, city, state, pincode) VALUES "
              .concat(userDemographicData));

      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null;
      }

      // Send email after registration.
      String domainName = request.getScheme() + "://" + request.getServerName()
          + ":" + request.getServerPort();

      Handlebars handlebars = new Handlebars();
      Template emailSubjectTmpl = handlebars
          .compile("/emailtemplates/account_activation_email_subject");
      Template emailContentTmpl = handlebars
          .compile("/emailtemplates/account_activation_email_content");

      HashMap<String, String> emailContentData = new HashMap<String, String>();
      emailContentData.put("domainName", domainName);
      emailContentData.put("activationToken", activationToken);
      emailContentData.put("activateAccountApiUrl",
          URLMappingEnum.ACTIVATE_ACCOUNT_URL.getRelativeURL());

      String emailSubject = emailSubjectTmpl.apply(null);
      String emailContent = emailContentTmpl.apply(emailContentData);

      EmailSender.sendEmail(email, emailSubject, emailContent);

      // User will be registered.
      response.setStatus(HttpServletResponse.SC_CREATED);
      List<GenericResponse> successes = new ArrayList<GenericResponse>();
      GenericResponse success = new GenericResponse();
      success.setMsg(ClientMessagesEnum.SUCCESSFUL_REGISTRATION.getMsg());
      success.setType(ClientMessagesEnum.SUCCESSFUL_REGISTRATION.getType());
      successes.add(success);

      ResponsePayload responseSuccess = new ResponsePayload(
          HttpServletResponse.SC_CREATED, successes);
      out.print(responseSuccess.getResponsePayload());
      return;
    } catch (SQLException e) {
      System.out.println(this.getClass().getName() + ":" + e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

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
