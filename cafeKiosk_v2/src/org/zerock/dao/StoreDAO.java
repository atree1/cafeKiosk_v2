package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OwnerVO;

public class StoreDAO {
	private String prefix ="org.zerock.mapper.StoreMapper";
	
	public void getOwner(OwnerVO vo) {
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			session.insert(prefix + ".getOwner",vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
