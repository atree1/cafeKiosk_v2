package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.MenuDAO;
import org.zerock.dao.OrderDAO;
import org.zerock.dao.OwnerDAO;
import org.zerock.dao.StoreDAO;

public class CafeTest {
	OrderDAO dao=new OrderDAO();
	StoreDAO sdao=new StoreDAO();
	MenuDAO mdao=new MenuDAO();
	OwnerDAO odao=new OwnerDAO();
	@Test
	public void getOrder() {
		System.out.println(odao.getLogin("atree","12345678"));
	//	System.out.println(odao.getOwner("atree"));
	}
	

}
