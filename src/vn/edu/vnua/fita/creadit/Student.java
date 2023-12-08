package vn.edu.vnua.fita.creadit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Student extends Human {
	private List<Subject> subjectList = new ArrayList<Subject>();
	private String class_;
	private List<Float> grades = new ArrayList<Float>();
	public Student(String address, String code, String fullName, String class_) {
		super(address, code, fullName);
		this.class_ = class_;
	}
	public Student() {
		
	}
    public List<Float> getGrades() {
        return grades;
    }
    public void addGrade(float grade) {
        grades.add(grade);
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
			ts += subject.getCredit()*subject.calSubjectMark(grades);
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
		
		Subject subject = new Subject();
		
		super.enterInfor(sc);
		System.out.print("Nhap lop: ");
		class_ = sc.nextLine();
		
		System.out.print("Nhap so mon hoc: ");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0;i < n; i++) {
			System.out.print("Nhập môn học thứ "+(i+1)+": ");
			subject.Input(sc);
			addSubject(subject);
		}
	}
	@Override
	public String toString() {
		String s = super.toString() + "; Class: " + class_ + "\n";
		for(Subject subject : subjectList) {
			s += "\t\t" + subject.toString();
		}if(!subjectList.isEmpty())
			s += "\n\t\tTerm average mark: " + calTermAverageMark() + "; ";
		
		return s;
	}
}