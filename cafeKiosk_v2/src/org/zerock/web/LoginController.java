package org.zerock.web;



import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.dao.OwnerDAO;
import org.zerock.domain.OwnerVO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/owner/*")

public class LoginController extends AbstractController {

    public String loginPOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
      log.info("login Post");
      System.out.println("Login post.....");
      String id = req.getParameter("owid");
      String pw = req.getParameter("owpw");
      System.out.println(id + ":" + pw);
      OwnerDAO dao=new OwnerDAO(); 
      OwnerVO vo = new OwnerVO(); ;
      vo=dao.getLogin(id,pw);
      System.out.println(vo);
      if(vo == null){

          return "redirect:/owner/login";
      }
    
      Cookie loginCookie=new Cookie("login", URLEncoder.encode(id,"UTF-8"));
      loginCookie.setMaxAge(60*60*24);
      loginCookie.setPath("/");
        log.info(loginCookie);
      resp.addCookie(loginCookie);
        return "main";
    }
    @Override
    public String getBasic() {
        return "/owner/";
    }

    
    protected String loginGET(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	return "login";
    }

}
