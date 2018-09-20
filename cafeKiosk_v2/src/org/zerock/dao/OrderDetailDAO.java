package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OrderDetailVO;

public class OrderDetailDAO {

	private final String prefix = "org.zerock.mapper.OrderDetailMapper";

	public List<OrderDetailVO> getDetail(int ono) {

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
				
			List<OrderDetailVO> list = session.selectList(prefix + ".getDetail",ono);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<OrderDetailVO> getAllDetail(int sno){
		
		List<OrderDetailVO> allList = new ArrayList<>();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			
			allList = session.selectList(prefix + ".getAllDetail",sno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allList;
	}
	
	public int countMenu(int sno){
		int count = 0;
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			
			count = session.selectOne(prefix + ".getCount",sno);
			System.out.println("++++++++++++"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
