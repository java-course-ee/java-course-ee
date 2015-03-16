package ru.gs.zk;

import java.util.Date;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyEntity {
	private long id;
	private String name;
	private String surname;
	private Date birthDate;
	private double salary;

	public MyEntity(long id, String name, String surname, Date birthDate, double salary) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
