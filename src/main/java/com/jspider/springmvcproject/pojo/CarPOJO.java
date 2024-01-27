package com.jspider.springmvcproject.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
//this annotation it can be used to marks the class as entity class
public class CarPOJO {
	@Id
	//this anotation it can be uesd to marks the property as the primary key of the tables it corresponding entity cass
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//it cab =n be uesd to genaret the automaticalyy interger valure
	private int id;
	private String name;
	private String brand;
	private String fuielType;
	private long price;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFuielType() {
		return fuielType;
	}
	public void setFuielType(String fuielType) {
		this.fuielType = fuielType;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarPOJO [id=" + id + ", name=" + name + ", brand=" + brand + ", fuielType=" + fuielType + ", price="
				+ price + ", getId()=" + getId() + ", getName()=" + getName() + ", getBrand()=" + getBrand()
				+ ", getFuielType()=" + getFuielType() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
