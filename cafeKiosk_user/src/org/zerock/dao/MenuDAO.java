package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.MenuVO;
import org.zerock.domain.PageDTO;

public class MenuDAO {
	private String prefix = "org.zerock.mapper.menuMapper";

	public List<MenuVO> getDrinkList(int sno) {

		List<MenuVO> list = new ArrayList<>();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			list = session.selectList(prefix + ".getDrinkList", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<MenuVO> getDessertList(int sno) {

		List<MenuVO> list = new ArrayList<>();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			list = session.selectList(prefix + ".getDessertList", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public MenuVO getMenu(int mno) {
		MenuVO vo=new MenuVO();
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			vo = session.selectOne(prefix + ".getMenu", mno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}