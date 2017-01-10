package com.upraiselabs.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.upraiselabs.constants.SessionConfig;
import com.upraiselabs.constants.URLMappingEnum;
import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.dbservices.ConnectToDB;
import com.upraiselabs.oldmodels.USER;
import com.upraiselabs.oldmodels.USER_DEMOGRAPHIC;
import com.upraiselabs.services.FrontEndConfig;
import com.upraiselabs.services.LoginSessionManager;
import com.upraiselabs.services.UserMutualFunds;

/**
 * Servlet implementation class UserAccount
 */
public class UserAccountPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserAccountPage() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    Handlebars handlebars = new Handlebars();
    Template template = handlebars.compile("/templates/user_account");
    HashMap<String, Object> context = new HashMap<String, Object>();
    LoginSessionManager.setHeaderContext(request, response, context);
    FrontEndConfig.setFrontEndConfig(context);

    if (LoginSessionManager.isUserLogggedIn(request, response)) {
      HttpSession session = request.getSession(false);
      String email = session.getAttribute(SessionConfig.SESSION_EMAIL)
          .toString();

      try {
        Connection dbConnection = ConnectToDB.connectToDB();
        Statement stmt = dbConnection.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.executeQuery(DBQueriesEnum.USE_UPRAISE_LABS_DB.toString());

        ResultSet resultSet = stmt.executeQuery(
            "SELECT * FROM USER WHERE email='".concat(email).concat("';"));

        BeanHandler<USER> userHandler = new BeanHandler<USER>(USER.class);
        USER user = userHandler.handle(resultSet);

        String userId = user.getUser_id();
        resultSet = stmt
            .executeQuery("SELECT * FROM USER_DEMOGRAPHIC WHERE user_id='"
                .concat(userId).concat("';"));

        BeanHandler<USER_DEMOGRAPHIC> userDemographicHandler = new BeanHandler<USER_DEMOGRAPHIC>(
            USER_DEMOGRAPHIC.class);
        USER_DEMOGRAPHIC userDemographic = userDemographicHandler
            .handle(resultSet);
        context.put("userDemographic", userDemographic);

        List<Map<String, Object>> mutualFundList = UserMutualFunds
            .getMutualFundList(userId);
        if (mutualFundList.size() == 0) {
          context.put("mutualFundList", null);
        } else {
          context.put("mutualFundList", mutualFundList);
        }
        if (dbConnection != null) {
          dbConnection.close();
          dbConnection = null;
        }
        out.append(template.apply(context));
      } catch (SQLException e) {
        context.put("error", e.toString());
        out.append(template.apply(context));
      }
    } else {
      response.sendRedirect(URLMappingEnum.HOME_PAGE_URL.getRelativeURL());
    }
  }
}
