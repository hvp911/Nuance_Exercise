package com.nuance.model;

public class InputFileModel {
	// Input model
	public InputFileModel(String province, String city, String school, String grade, int population) {
		super();
		this.province = province;
		this.city = city;
		this.school = school;
		this.grade = grade;
		this.population = population;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	private String province;
	private String city;
	private String school;
	private String grade;
	private int population;
}
