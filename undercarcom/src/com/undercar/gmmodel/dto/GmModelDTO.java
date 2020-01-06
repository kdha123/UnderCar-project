package com.undercar.gmmodel.dto;

public class GmModelDTO {

	int no;
	String model;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "GmModelDTO [no=" + no + ", model=" + model + "]";
	}
	
}
