package br.com.valid.bio.agreement.model.partner.kairos.enroll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageAttribute {

	private String lips;
	
	private double asian;
	
	private int age;
	
	private double hispanic;
	
	private double other;
	
	private double black;
	
	private double white;
	
	private String glasses;
	
	
	public ImageAttribute() {
	}


	public String getLips() {
		return lips;
	}


	public void setLips(String lips) {
		this.lips = lips;
	}


	public double getAsian() {
		return asian;
	}


	public void setAsian(double asian) {
		this.asian = asian;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getHispanic() {
		return hispanic;
	}


	public void setHispanic(double hispanic) {
		this.hispanic = hispanic;
	}


	public double getOther() {
		return other;
	}


	public void setOther(double other) {
		this.other = other;
	}


	public double getBlack() {
		return black;
	}


	public void setBlack(double black) {
		this.black = black;
	}


	public double getWhite() {
		return white;
	}


	public void setWhite(double white) {
		this.white = white;
	}


	public String getGlasses() {
		return glasses;
	}


	public void setGlasses(String glasses) {
		this.glasses = glasses;
	}


	@Override
	public String toString() {
		return "ImageAttribute [lips=" + lips + ", asian=" + asian + ", age=" + age + ", hispanic=" + hispanic
				+ ", other=" + other + ", black=" + black + ", white=" + white + ", glasses=" + glasses + "]";
	}

}
