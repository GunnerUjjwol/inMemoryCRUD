package com.verscend.employee;

public class Employee {
	private int id;
	private String fullname;
	private String address;

	public Employee() {
	}

	public Employee(int id, String fullname, String address) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", address=" + address + "]";
	}

}
