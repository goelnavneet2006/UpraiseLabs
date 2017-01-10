package com.upraiselabs.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.upraiselabs.clientresponses.ClientMessagesEnum;
import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.dbservices.ConnectToDB;

/**
 * Servlet implementation class ActivateAccount
 */
public class ActivateAccountPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final String ACTIVATION_TOKEN = "token";
  private static final String CHARSET_NAME = "UTF-8";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ActivateAccountPage() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String activationToken = request.getParameter(ACTIVATION_TOKEN);
    activationToken = URLEncoder.encode(activationToken, CHARSET_NAME);

    PrintWriter out = response.getWriter();

    Handlebars handlebars = new Handlebars();
    Template template = handlebars.compile("/templates/activate_account");
    HashMap<String, Object> context = new HashMap<String, Object>();

    try {
      Connection dbConnection = ConnectToDB.connectToDB();
      Statement stmt = dbConnection.createStatement(
          ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      stmt.executeQuery(DBQueriesEnum.USE_UPRAISE_LABS_DB.toString());

      ResultSet resultSet = stmt
          .executeQuery("SELECT * FROM USER WHERE activation_token ='"
              .concat(activationToken).concat("';"));

      if (resultSet.first()) {
        if (resultSet.getBoolean("is_active")) {
          context.put("error",
              ClientMessagesEnum.USER_ALREADY_ACTIVATED_ERROR.getMsg());
          out.append(template.apply(context));
        } else {
          resultSet.updateBoolean("is_active", true);
          resultSet.updateRow();

          context.put("success",
              ClientMessagesEnum.USER_SUCCESSFULLY_ACTIVATED.getMsg());
          out.append(template.apply(context));
        }
      } else {
        context.put("error", ClientMessagesEnum.BAD_REQUEST.getMsg());
        out.append(template.apply(context));
      }

      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null;
      }

    } catch (SQLException e) {
      System.out.println(this.getClass().getName() + ":" + e);
      context.put("error", ClientMessagesEnum.INTERNAL_SERVER_ERROR.getMsg());
      out.append(template.apply(context));
    }
  }
}
