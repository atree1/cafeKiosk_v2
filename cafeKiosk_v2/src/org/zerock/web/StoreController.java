package org.zerock.web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.zerock.dao.MenuDAO;
import org.zerock.dao.OrderDetailDAO;
import org.zerock.dao.StoreDAO;
import org.zerock.domain.MenuVO;
import org.zerock.domain.OrderDetailVO;
import org.zerock.util.Converter;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
@WebServlet(urlPatterns = "/store/*")
public class StoreController extends AbstractController {
	int sno = 1;
	MenuDAO dao = new MenuDAO();
	StoreDAO sdao = new StoreDAO();
	OrderDetailDAO ddao = new OrderDetailDAO();

	public String mainGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("mainGET.......................");

		return "main";
	}

	public String writeGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("writeGET.......................");

		return "write";
	}

	public String writePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("writePOST.......................");
		req.setCharacterEncoding("UTF-8");

		String menu = req.getParameter("menu");
		String priceStr = req.getParameter("price");
		String img = req.getParameter("img");
		String category = req.getParameter("category");

		int price = Converter.getInt(priceStr, -1);

		MenuVO vo = new MenuVO();

		vo.setSno(sno);
		vo.setMenu(menu);
		vo.setImg(img);
		vo.setPrice(price);
		vo.setCategory(category);

		Collection<Part> parts = req.getParts();

		parts.stream().filter(part -> part.getContentType() != null).forEach(part -> {
			System.out.println(part.getContentType());
			System.out.println(part.getSubmittedFileName());
			System.out.println("---------------------------");
			System.out.println(part.getName());
			String uploadName = part.getSubmittedFileName();

			try {
				InputStream in = part.getInputStream();
				FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + uploadName);

				IOUtils.copy(in, fos);

				if (ExtChecker.check(uploadName)) {
					// Make Thumbnail image
					BufferedImage bImage = ImageIO.read(new FileInputStream("C:\\zzz\\upload\\" + uploadName));
					BufferedImage thumbnail = Scalr.resize(bImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 150,
							100, Scalr.OP_ANTIALIAS);

					FileOutputStream thfos = new FileOutputStream("C:\\zzz\\upload\\s_" + uploadName);
					ImageIO.write(thumbnail, "jpg", thfos);
					thfos.close();
				}
				in.close();
				fos.close();

				vo.setImg(uploadName);

			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		dao.addMenu(vo);

		return "redirect:/store/list";
	}

	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("listGET.......................");
		req.setAttribute("drinkList", dao.getDrinkList(sno));
		req.setAttribute("dessertList", dao.getDessertList(sno));
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
		int mno = Converter.getInt(mnoStr, -1);
		req.setAttribute("menu", dao.getMenu(mno));
		return "modify";
	}

	public String modifyPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		String mnoStr = req.getParameter("mno");
		String menu = req.getParameter("menu");

		String priceStr = req.getParameter("price");
		String category = req.getParameter("category");

		int mno = Converter.getInt(mnoStr, -1);
		int price = Converter.getInt(priceStr, -1);

		MenuVO vo = new MenuVO();
		vo.setMno(mno);
		vo.setSno(sno);
		vo.setMenu(menu);
		vo.setPrice(price);
		vo.setCategory(category);
		System.out.println(vo);
		Collection<Part> parts = req.getParts();
		parts.stream().filter(part -> part.getContentType() != null).forEach(part -> {
			System.out.println(part.getContentType());
			System.out.println(part.getSubmittedFileName());
			System.out.println("---------------------------");
			System.out.println(part.getName());
			String uploadName = part.getSubmittedFileName();

			try {
				InputStream in = part.getInputStream();
				FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + uploadName);

				IOUtils.copy(in, fos);

				if (ExtChecker.check(uploadName)) {
					// Make Thumbnail image
					BufferedImage bImage = ImageIO.read(new FileInputStream("C:\\zzz\\upload\\" + uploadName));
					BufferedImage thumbnail = Scalr.resize(bImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 150,
							100, Scalr.OP_ANTIALIAS);

					FileOutputStream thfos = new FileOutputStream("C:\\zzz\\upload\\s_" + uploadName);
					ImageIO.write(thumbnail, "jpg", thfos);
					thfos.close();
				}
				in.close();
				fos.close();

				vo.setImg(uploadName);

			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("2:" + vo);
		});
		dao.modifyMenu(vo);

		// resp.sendRedirect("/board/list?page="+pageStr);
		return "redirect:/store/list";
	}

	public String removePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("REMOVE POST.......................");
		String mnoStr = req.getParameter("mno");
		int mno = Converter.getInt(mnoStr, -1);
		dao.deleteMenu(mno);
		// resp.sendRedirect("/board/list");
		return "redirect:/store/list";
	}

	public String manageGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<Integer>();
		List<OrderDetailVO> list = ddao.getAllDetail(1);

		int sum = 0;
		int partsum = 0;

		for (OrderDetailVO vo : list) {
			sum += vo.getPrice() * vo.getQty();
		}

		for (OrderDetailVO vo : list) {
			set.add(vo.getOno());
		}

		for (int ono : set) {

			for (OrderDetailVO vo : list) {
				if (ono == vo.getOno()) {
					partsum += vo.getPrice();
				}

			}
			map.put(ono, partsum);
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