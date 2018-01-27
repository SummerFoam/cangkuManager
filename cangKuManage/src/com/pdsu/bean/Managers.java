package com.pdsu.bean;

public class Managers {
	private int id;
	private String name;
	private String password;
	private String position;
	
	
	public Managers() {
		super();
	}
	public Managers(int id, String name, String password, String position) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Managers [id=" + id + ", name=" + name + ", password="
				+ password + ", position=" + position + "]";
	}
	
	
}
