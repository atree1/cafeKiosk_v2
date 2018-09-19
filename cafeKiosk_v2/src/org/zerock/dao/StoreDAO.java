package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OwnerVO;
import org.zerock.domain.StoreVO;

public class StoreDAO {
	private String prefix ="org.zerock.mapper.StoreMapper";
	
	public void getStore(StoreVO vo) {
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			session.insert(prefix + ".getStore",vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
