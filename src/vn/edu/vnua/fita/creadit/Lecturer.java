package vn.edu.vnua.fita.creadit;

import java.util.Scanner;

public class Lecturer extends Human {
	String password;

	public Lecturer() {
	}
	
	public Lecturer(String code, String password) {
		super(code);
		this.password = password;
	}

	public Lecturer(String address, String code, String fullName) {
		super(address, code, fullName);
	}

	@Override
	public void enterInfor(Scanner sc) {
		super.enterInfor(sc);
		System.out.print("Nhap password: ");
		password = sc.nextLine();
		
	}

	@Override
	public String toString() {
		return "Lecturer [password=" + password + ", getAddress()=" + getAddress() + ", getCode()=" + getCode()
				+ ", getFullName()=" + getFullName() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
