package org.zerock.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.MenuDAO;
import org.zerock.domain.MenuVO;

@WebServlet(urlPatterns=("/user/*"))
public class UserController extends AbstractController{
	
	MenuDAO dao = new MenuDAO();
	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int sno = 1;
		
	      System.out.println("listGET.......................");
	      req.setAttribute("drinkList", dao.getDrinkList(sno));
	      req.setAttribute("dessertList", dao.getDessertList(sno));
	      return "list";
	   }
	
	@Override
	public String getBasic() {
		return "/user/";
	}
	
}
