package com.penninkhof.odata.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.penninkhof.odata.annotations.SAPLineItem;

@Entity
@Table(name="view_persons")
public class Person {
	
	@Id
	private int id;
	
	@SAPLineItem
	private String name;
	
	@ManyToOne// 指定多对一关系 
	@JoinColumn(name="company_id")
	private Company company;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
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
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Person() {
		super();
	}
	
	
	
	
}
