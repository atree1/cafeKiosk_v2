package org.zerock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.OwnerVO;

public class OwnerDAO {

	private final String prefix = "org.zerock.mapper.OwnerMapper";

	public OwnerVO getOwner(String owid) {

		OwnerVO vo = new OwnerVO();

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			vo = session.selectOne(prefix + ".getOwner", owid);

		} catch (Exception e) {
			e.getMessage();
		}
		return vo;
	}

	public OwnerVO getLogin(String owid, String owpw) {
		Map<String, Object> paramMap = new HashMap<>();
//		System.out.println("owid: "+owid);
//		System.out.println("owpw: "+owpw);
		paramMap.put("owid", owid);
		paramMap.put("owpw", owpw);

		OwnerVO vo = new OwnerVO();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			vo = session.selectOne(prefix + ".getLogin", paramMap);

		} catch (Exception e) {
			e.getMessage();
		}
		return vo;
	}
}
