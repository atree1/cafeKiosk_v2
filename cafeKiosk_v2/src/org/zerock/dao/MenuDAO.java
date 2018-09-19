package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.MenuVO;

public class MenuDAO {
	private String prefix ="org.zerock.mapper.menuMapper";
	
	public MenuVO getMenu(int mno) {
		
		MenuVO vo = new MenuVO();
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			vo = session.selectOne(prefix + ".getMenu",mno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public void modifyMenu(MenuVO vo){
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			session.update(prefix +".modifyMenu", vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		
	}
}
	
	
	public void deleteMenu(int mno) {
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			session.delete(prefix+".deleteMenu", mno);
			
		}catch(Exception e) {e.printStackTrace();}
	
	}
	
	public List<MenuVO> getList(){ 
		
		List<MenuVO> list = new ArrayList<>();
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
		list = session.selectList(prefix+".getList");
			
		}catch(Exception e) {e.printStackTrace();}
		
		return list;
	} 
	
	
	public void addMenu(MenuVO vo) {
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			session.insert(prefix+".addMenu",vo);
			
		}catch(Exception e) {e.printStackTrace();}
		
	}
}