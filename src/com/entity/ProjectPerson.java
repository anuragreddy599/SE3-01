package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ProjectPerson {

	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 	
        private int id;
        @Column(name="PROJECTNUMBER")
	private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	 /**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
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
        @Column(name="PROJECTNAME")
	private String name;
}
