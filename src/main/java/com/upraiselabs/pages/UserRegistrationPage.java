package com.upraiselabs.pages;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.upraiselabs.constants.URLMappingEnum;
import com.upraiselabs.services.FrontEndConfig;
import com.upraiselabs.services.LoginSessionManager;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistrationPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserRegistrationPage() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HashMap<String, Object> context = new HashMap<String, Object>();
//    LoginSessionManager.setHeaderContext(request, response, context);
    FrontEndConfig.setFrontEndConfig(context);

    if (LoginSessionManager.isUserLogggedIn(request, response)) {
      response.sendRedirect(URLMappingEnum.USER_ACCOUNT_URL.getRelativeURL());
    } else {
      Handlebars handlebars = new Handlebars();
      Template template = handlebars.compile("/templates/user_registration");
      response.getWriter().append(template.apply(context));
    }

  }
}
