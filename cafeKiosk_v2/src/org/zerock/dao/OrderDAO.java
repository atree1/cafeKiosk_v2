package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OrderVO;

public class OrderDAO {
	private String prefix="org.zerock.mapper.OrderMapper";
	public void create() {
		
		try(SqlSession session=MyBatisLoader.sqlSessionFactory.openSession(true)){
			session.insert(prefix+".create");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<OrderVO> getList(){
		List<OrderVO> list=new ArrayList<>();
		try(SqlSession session=MyBatisLoader.sqlSessionFactory.openSession(true)){
			list=session.selectList(prefix+".getList");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int getOno() {
		int ono=0;
		try(SqlSession session=MyBatisLoader.sqlSessionFactory.openSession(true)){
			ono=session.selectOne(prefix+".getOno");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ono;
	}
}
