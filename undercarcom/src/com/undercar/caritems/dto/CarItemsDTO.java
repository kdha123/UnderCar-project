package com.undercar.caritems.dto;

public class CarItemsDTO {

	int no;
	String brand, carclass, model, year, grade, spec;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarclass() {
		return carclass;
	}
	public void setCarclass(String carclass) {
		this.carclass = carclass;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	@Override
	public String toString() {
		return "CarItemsDTO [no=" + no + ", brand=" + brand + ", carclass=" + carclass + ", model=" + model + ", year="
				+ year + ", grade=" + grade + ", spec=" + spec + "]";
	}
	
	
}
