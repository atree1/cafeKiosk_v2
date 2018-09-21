package org.zerock.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.MenuDAO;
import org.zerock.dao.OrderDAO;
import org.zerock.dao.OrderDetailDAO;
import org.zerock.domain.MenuVO;
import org.zerock.domain.OrderDetailVO;
import org.zerock.util.Converter;

@WebServlet(urlPatterns = ("/user/*"))
public class UserController extends AbstractController {
	static int sno = 1;
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

	public String orderPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<OrderDetailVO> list=new ArrayList<>();
		req.setCharacterEncoding("UTF-8");
		OrderDAO odao = new OrderDAO();
		OrderDetailDAO oddao = new OrderDetailDAO();
		int sum = 0;
		MenuDAO mdao = new MenuDAO();
		odao.create();
		String[] qty_drink = req.getParameterValues("qty_drink");
		String[] qty_dessert = req.getParameterValues("qty_dessert");
		int ono = odao.getOno();
		int total=0;
		for (int i = 0; i < qty_drink.length; i++) {

			String[] order_drink = qty_drink[i].split("_");
			if (!order_drink[1].equals("0")) {
				OrderDetailVO odvo = new OrderDetailVO();
				MenuVO mvo = new MenuVO();
				mvo = mdao.getMenu(Converter.getInt(order_drink[0], -1));
				odvo.setMno(Converter.getInt(order_drink[0], -1)); // 메뉴번호
				odvo.setQty(Converter.getInt(order_drink[1], -1));// 메뉴 수량
				odvo.setOno(ono);
				odvo.setMenu(mvo.getMenu());
				odvo.setPrice(mvo.getPrice());
				odvo.setSno(sno);
				list.add(odvo);
				oddao.addOrderDetail(odvo);
				total+=odvo.getPrice()*odvo.getQty();
			}

		}
		for (int i = 0; i < qty_dessert.length; i++) {

			String[] order_dessert = qty_dessert[i].split("_");
			if (!order_dessert[1].equals("0")) {
				OrderDetailVO odvo = new OrderDetailVO();
				MenuVO mvo = new MenuVO();
				mvo = mdao.getMenu(Converter.getInt(order_dessert[0], -1));
				odvo.setMno(Converter.getInt(order_dessert[0], -1)); // 메뉴번호
				odvo.setQty(Converter.getInt(order_dessert[1], -1));// 메뉴 수량
				odvo.setOno(ono);
				odvo.setMenu(mvo.getMenu());
				odvo.setPrice(mvo.getPrice());
				odvo.setSno(sno);
				list.add(odvo);
				oddao.addOrderDetail(odvo);
				total+=odvo.getPrice()*odvo.getQty();
			}

		}
		req.setAttribute("ono", ono);
		req.setAttribute("orderList", list);
		req.setAttribute("total",total);
		return "order";

	}

}
