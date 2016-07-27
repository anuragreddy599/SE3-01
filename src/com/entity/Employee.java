package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Employee {

	 @Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 
	//private int id;
	private String name;
	 private String title;
	 private int billRate;
	 private String role;
	 private String status;
	/**
	 * @return the id
	 *//*
	public int getId() {
		return id;
	}
	*//**
	 * @param id the id to set
	 *//*
	public void setId(int id) {
		this.id = id;
	}*/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the billRate
	 */
	public int getBillRate() {
		return billRate;
	}
	/**
	 * @param billRate the billRate to set
	 */
	public void setBillRate(int billRate) {
		this.billRate = billRate;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
