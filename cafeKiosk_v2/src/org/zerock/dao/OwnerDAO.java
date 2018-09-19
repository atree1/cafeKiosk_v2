package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OwnerVO;

public class OwnerDAO {

	private final String prefix = "org.zerock.mapper.OwnerMapper";

	public OwnerVO getOwner(String owid) {

		OwnerVO vo = new OwnerVO();

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			vo= session.selectOne(prefix + ".getOwner", owid);

		} catch (Exception e) {
			e.getMessage();
		}
		return vo;
	}
}
