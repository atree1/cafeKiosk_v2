package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.StoreVO;

public class StoreDAO {
	private String prefix ="org.zerock.mapper.StoreMapper";
	
	public StoreVO getStore(int sno) {
		StoreVO vo = new StoreVO();

		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){

			vo = session.selectOne(prefix + ".getStore",sno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
}
