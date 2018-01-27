package com.pdsu.bean;

public class GoodsCategoryBean {
private String	categoryId;
private String  categoryName;
private String ofRackid;
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getOfRackid() {
	return ofRackid;
}
public void setOfRackid(String ofRackid) {
	this.ofRackid = ofRackid;
}
@Override
public String toString() {
	return "GoodsCategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + ", ofRackid=" + ofRackid
			+ "]";
}

	
}
