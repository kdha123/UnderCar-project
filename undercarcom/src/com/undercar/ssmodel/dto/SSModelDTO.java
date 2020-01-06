package com.undercar.ssmodel.dto;

public class SSModelDTO {

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
		return "SSModelDTO [no=" + no + ", model=" + model + "]";
	}
	
}
