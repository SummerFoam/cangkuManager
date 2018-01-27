package com.pdsu.bean;



public class RackBean  {

	private String rackId;
	private String ofCangId;
	
	@Override
	public String toString() {
		return "RackBean [rackId=" + rackId + ", ofCangId=" + ofCangId + "]";
	}

	public String getRackId() {
		return rackId;
	}

	public void setRackId(String rackId) {
		this.rackId = rackId;
	}

	public String getOfCangId() {
		return ofCangId;
	}

	public void setOfCangId(String ofCangId) {
		this.ofCangId = ofCangId;
	}

	public RackBean(String rackId, String ofCangId) {
		super();
		this.rackId = rackId;
		this.ofCangId = ofCangId;
	}

	public RackBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
