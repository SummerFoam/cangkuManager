package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.Managers;

public interface ManaFace {
	//登录界面查询
	public Managers selManLogin(Managers mana) throws SQLException;
	//查询全部用户
	public List<Managers> SelManagers() throws Exception;
	//添加新用户查询
	public boolean InSelManager(Managers mana) throws SQLException;
	//添加新用户
	public String addManagers(Managers mana) throws SQLException;
	//根据id查询修改用户
	public Managers QueryManagersById(String id) throws Exception;
	//修改用户
	public boolean updateMana(Managers mana) throws SQLException;
	//删除用户
	public  boolean delMana(String id) throws SQLException;
}
