package org.zerock.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.MenuDAO;
import org.zerock.dao.OrderDetailDAO;
import org.zerock.dao.StoreDAO;
import org.zerock.domain.MenuVO;
import org.zerock.domain.OrderDetailVO;
import org.zerock.util.Converter;

@WebServlet(urlPatterns = "/store/*")
public class StoreController extends AbstractController {
   int sno=1;
   MenuDAO dao = new MenuDAO();
   StoreDAO sdao = new StoreDAO();
   OrderDetailDAO ddao= new OrderDetailDAO();
   
   public String mainGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
           System.out.println("mainGET.......................");

           return "main";
       }
    public String writeGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("writeGET.......................");

        return "write";
    }
    public String writePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("writePOST.......................");
        req.setCharacterEncoding("UTF-8");

      
      String menu = req.getParameter("menu");
      String priceStr = req.getParameter("price");
      String img = req.getParameter("img");
      String category = req.getParameter("category");
      System.out.println("~~~~~~~~~~~~~~~~"+category);
      int price = Converter.getInt(priceStr, -1);

      MenuVO vo = new MenuVO();
      
      vo.setSno(sno);
      vo.setMenu(menu);
      vo.setImg(img);
      vo.setPrice(price);
      vo.setCategory(category);

      dao.addMenu(vo);
      return "redirect:/store/list";
   }
   public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {

      System.out.println("listGET.......................");
//        PageDTO dto = PageDTO.of()
//                   .setPage(Converter.getInt(req.getParameter("page"),1))
//                   .setSize(Converter.getInt(req.getParameter("size"),10));
//           int total=320;
//           PageMaker pageMaker=new PageMaker(total,dto);
//
//           req.setAttribute("pageMaker",pageMaker);
//           req.setAttribute("list", dao.getPageList(dto));

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
      int mno = Converter.getInt(mnoStr,-1);
      req.setAttribute("menu", dao.getMenu(mno));
      return "modify";
   }

   public String modifyPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
      req.setCharacterEncoding("UTF-8");

      String mnoStr = req.getParameter("mno");
      String menu = req.getParameter("menu");
      String img = req.getParameter("img");
      String priceStr = req.getParameter("price");
      String category = req.getParameter("category");
      
      int mno =Converter.getInt(mnoStr,-1);
      int price = Converter.getInt(priceStr,-1);

      MenuVO vo = new MenuVO();
      vo.setMno(mno);
      vo.setSno(sno);
      vo.setMenu(menu);
      vo.setImg(img);
      vo.setPrice(price);
      vo.setCategory(category);

      dao.modifyMenu(vo);

      // resp.sendRedirect("/board/list?page="+pageStr);
      return "redirect:/store/list";
   }
   
    public String removePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{

           System.out.println("REMOVE POST.......................");
           String mnoStr=req.getParameter("mno");
           int mno=Converter.getInt(mnoStr,-1);
           dao.deleteMenu(mno);
           //resp.sendRedirect("/board/list");
           return  "redirect:/store/list";
       }
    
    public String manageGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	 Map<Integer, Integer> map = new HashMap<>();
		 Set<Integer> set = new HashSet<Integer>();
			List<OrderDetailVO> list = ddao.getAllDetail(1);
			
			int sum = 0;
			int partsum = 0;

			for(OrderDetailVO vo : list) {
				sum += vo.getPrice() * vo.getQty();
			}
			
			for(OrderDetailVO vo : list) {
				set.add(vo.getOno());
			}

			for(int ono : set) {
				
				for(OrderDetailVO vo : list) {
					if(ono == vo.getOno()){
						partsum += vo.getPrice();
					}
					
				}
				map.put(ono,partsum);
				partsum = 0;
			}
			
			req.setAttribute("set", set);
			req.setAttribute("map", map);
			req.setAttribute("count", ddao.countMenu(1));
			req.setAttribute("getTotal", sum);
		 	req.setAttribute("detail", ddao.getAllDetail(1));
			req.setAttribute("store", sdao.getStore(1)); 
			return "store"; 
      }

}