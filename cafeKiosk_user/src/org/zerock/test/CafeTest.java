package org.zerock.test;


import org.junit.Test;
import org.zerock.dao.OrderDAO;
import org.zerock.dao.OrderDetailDAO;
import org.zerock.domain.OrderDetailVO;

public class CafeTest {
	
	
	OrderDAO odao=new OrderDAO();
	OrderDetailDAO dao=new OrderDetailDAO();
	@Test
	public void getOrder() {
//		
//		OrderDetailVO vo=new OrderDetailVO();
//	
//		vo.setMno(1);
//		vo.setOno(2);
//		vo.setQty(1);
//		vo.setSno(1);
//
//
//		dao.addOrderDetail(vo);
		odao.getList();
	}
	

}
