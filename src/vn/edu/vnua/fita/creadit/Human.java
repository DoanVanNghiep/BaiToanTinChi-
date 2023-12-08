package vn.edu.vnua.fita.creadit;

import java.util.Scanner;

public class Human {
	private String address;
	private String code;
	private String fullName;
	public Human(String address, String code, String fullName) {
		this.address = address;
		this.code = code;
		this.fullName = fullName;
	}
	public Human(String code, String fullName) {
		this.code = code;
		this.fullName = fullName;
	}
	public Human(String fullName) {
		this.fullName = fullName;
	}
	public Human() {
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "address=" + address + ", code=" + code + ", fullName=" + fullName;
	}
	
	public void enterInfor(Scanner sc) {
		System.out.print("Nhap ma: ");
		code = sc.nextLine();sc.nextLine();
		
		System.out.print("Nhap ho ten: ");
		fullName = sc.nextLine();
		
		System.out.print("Nhap dia chi: ");
		address = sc.nextLine();
	}
	
	public boolean equals(Object object) {
		Human human = (Human)object;
		return this.code.equals(human.code);
	}
}