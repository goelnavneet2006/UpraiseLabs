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
 * Servlet implementation class Signout
 */
public class SignoutUserPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SignoutUserPage() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    if (LoginSessionManager.isUserLogggedIn(request, response)) {
      Handlebars handlebars = new Handlebars();
      Template template = handlebars.compile("/templates/signout_user");
      HashMap<String, Object> context = new HashMap<String, Object>();
      LoginSessionManager.logoutUser(request, response);
      LoginSessionManager.setHeaderContext(request, response, context);
      FrontEndConfig.setFrontEndConfig(context);
      response.getWriter().append(template.apply(context));
    } else {
      response.sendRedirect(URLMappingEnum.HOME_PAGE_URL.getRelativeURL());
    }
  }
}
