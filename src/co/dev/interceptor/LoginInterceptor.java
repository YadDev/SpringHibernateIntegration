package co.dev.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.dev.beans.Login;


@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	 @Override
	 
	 public boolean preHandle(HttpServletRequest request,
	   HttpServletResponse response, Object handler) throws Exception
	 {
		 System.out.println("Pre Handle Method");
	  String uri = request.getRequestURI();
	  if(!uri.endsWith("/login") && !uri.endsWith("logout") && !uri.endsWith("loginAuth"))
	  {
	   Login userData = (Login) request.getSession().getAttribute("LOGGEDIN_USER");
	   if(userData == null)
	   {
	    response.sendRedirect("login");
	    return false;
	   }   
	  }
	  return true;
	 }
}
