package org.zerock.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.MenuDAO;
import org.zerock.domain.MenuVO;

@WebServlet(urlPatterns = "/store/*")
public class StoreController extends AbstractController {
	int sno=1;
	MenuDAO dao = new MenuDAO();
    public String writeGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("writeGET.......................");

        return "write";
    }
    public String writePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("writePOST.......................");
        req.setCharacterEncoding("UTF-8");

		
		String menu = req.getParameter("menu");
		String priceStr = req.getParameter("price");
	
		int price = Integer.parseInt(priceStr);

		MenuVO vo = new MenuVO();
		
		vo.setSno(sno);
		vo.setMenu(menu);
		vo.setImg("m1.jpg");
		vo.setPrice(price);

		dao.addMenu(vo);
		return "redirect:/store/list";
   }
	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("listGET.......................");
		
		req.setAttribute("list", dao.getList(sno));

		return "list";
	}

	@Override
	public String getBasic() {
		// TODO Auto-generated method stub
		return "/store/";
	}

	public String modifyGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("modifyGET.......................");
		String mnoStr = req.getParameter("mno");
		int mno = Integer.parseInt(mnoStr);
		req.setAttribute("menu", dao.getMenu(mno));
		return "modify";
	}

	public String modifyPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		String mnoStr = req.getParameter("mno");
		String menu = req.getParameter("menu");
		String img = req.getParameter("img");
		String priceStr = req.getParameter("price");
		int mno = Integer.parseInt(mnoStr);
		int price = Integer.parseInt(priceStr);

		MenuVO vo = new MenuVO();
		vo.setMno(mno);
		vo.setSno(sno);
		vo.setMenu(menu);
		vo.setImg(img);
		vo.setPrice(price);

		dao.modifyMenu(vo);

		// resp.sendRedirect("/board/list?page="+pageStr);
		return "redirect:/store/list";
	}
	
	 public String removePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
	        System.out.println("REMOVE POST.......................");
	        String mnoStr=req.getParameter("mno");
	        int mno=Integer.parseInt(mnoStr);
	        dao.deleteMenu(mno);
	        //resp.sendRedirect("/board/list");
	        return  "redirect:/store/list";
	    }
}
