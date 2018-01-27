package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.Managers;

public interface ManaFace {
	//��¼�����ѯ
	public Managers selManLogin(Managers mana) throws SQLException;
	//��ѯȫ���û�
	public List<Managers> SelManagers() throws Exception;
	//������û���ѯ
	public boolean InSelManager(Managers mana) throws SQLException;
	//������û�
	public String addManagers(Managers mana) throws SQLException;
	//����id��ѯ�޸��û�
	public Managers QueryManagersById(String id) throws Exception;
	//�޸��û�
	public boolean updateMana(Managers mana) throws SQLException;
	//ɾ���û�
	public  boolean delMana(String id) throws SQLException;
}
