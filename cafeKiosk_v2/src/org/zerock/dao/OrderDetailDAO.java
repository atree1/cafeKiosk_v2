package org.zerock.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<OrderDetailVO> printOrder(int ono, int sno){
		List<OrderDetailVO> List = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ono", ono);
		paramMap.put("sno", sno);

		OrderDetailVO vo = new OrderDetailVO();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			 List = session.selectList(prefix + ".printOrder", paramMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
	}
}
