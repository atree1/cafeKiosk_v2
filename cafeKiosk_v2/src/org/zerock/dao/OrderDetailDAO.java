package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OrderDetailVO;
import org.zerock.domain.OwnerVO;

public class OrderDetailDAO {

	private final String prefix = "org.zerock.mapper.OrderDetailMapper";

	public List<OrderDetailVO> getDetail(int ono) {

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
				
			List<OrderDetailVO> list = session.selectList(prefix + ".getDetail",ono);
			return list;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<OrderDetailVO> getAllDetail(int sno){
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			
			List<OrderDetailVO> allList = session.selectList(prefix + ".getAllDetail",sno);
			return allList;
		} catch (Exception e) {
			e.getMessage(); 
		}
		return null;
	}
}
