package vn.edu.vnua.fita.creadit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Human {
	private List<Subject> subjectList = new ArrayList<Subject>();
	private String class_;
	public Student(String address, String code, String fullName, String class_) {
		super(address, code, fullName);
		this.class_ = class_;
	}
	public Student() {
		
	}
	public Student(String code) {
		super(code);
	}
	public Student(String code, String fullName) {
		super(code,fullName);
	}
	public Student(String code,String fullName, String class_) {
		super(code,fullName);
		this.class_ = class_;
	}
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	public float calTermAverageMark() {
		float ts = 0;
		float ms = 0;
		for(Subject subject : subjectList) {
			ts += subject.getCredit()*subject.calSubjectMark();
			ms += subject.getCredit();
		}
		return ts/ms;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	@Override
	public void enterInfor(Scanner sc) {
		super.enterInfor(sc);
		System.out.print("Nhap lop: ");
		class_ = sc.nextLine();  
	}
	@Override
	public String toString() {
		return "Student [subjectList=" + subjectList + ", class_=" + class_ + ", calTermAverageMark()="
				+ calTermAverageMark() + ", getClass_()=" + getClass_() + ", getAddress()=" + getAddress()
				+ ", getCode()=" + getCode() + ", getFullName()=" + getFullName() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
