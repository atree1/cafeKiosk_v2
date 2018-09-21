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
	
	@Override
	public String getBasic() {
		return "/user/";
	}
	
}
