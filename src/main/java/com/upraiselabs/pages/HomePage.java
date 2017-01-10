package com.upraiselabs.pages;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.upraiselabs.services.FrontEndConfig;
import com.upraiselabs.services.LoginSessionManager;

/**
 * Servlet implementation class Homepage
 */
public class HomePage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HomePage() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Handlebars handlebars = new Handlebars();
    Template template = handlebars.compile("/templates/homepage");
    HashMap<String, Object> context = new HashMap<String, Object>();
    LoginSessionManager.setHeaderContext(request, response, context);
    FrontEndConfig.setFrontEndConfig(context);
    response.getWriter().append(template.apply(context));
  }
}
