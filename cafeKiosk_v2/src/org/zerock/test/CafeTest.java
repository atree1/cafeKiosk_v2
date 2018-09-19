package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.OrderDAO;
import org.zerock.dao.StoreDAO;

public class CafeTest {
	OrderDAO dao=new OrderDAO();
	StoreDAO sdao=new StoreDAO();
	@Test
	public void getOrder() {
		
		dao.updateState(23);
	}
	
	public void getStore() {
		System.out.println(sdao.getStore(1));
	}
}
