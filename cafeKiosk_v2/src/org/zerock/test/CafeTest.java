package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.MenuDAO;
import org.zerock.dao.OrderDAO;
import org.zerock.dao.StoreDAO;
import org.zerock.domain.PageDTO;

public class CafeTest {
	OrderDAO dao=new OrderDAO();
	StoreDAO sdao=new StoreDAO();
	MenuDAO mdao=new MenuDAO();
	@Test
	public void getOrder() {
		PageDTO pageDTO=new PageDTO();
		System.out.println(mdao.getPageList(pageDTO));
	}
	
	public void getStore() {
		System.out.println(sdao.getStore(1));
	}
}
