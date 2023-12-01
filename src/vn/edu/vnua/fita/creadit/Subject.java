package vn.edu.vnua.fita.creadit;

import java.util.Scanner;

public class Subject {
	
	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;//chuyên cần
	private float midExamMark;// giữa kì
	private float finalExamMark;// cuối kì
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public float getAttendanceMark() {
		return attendanceMark;
	}
	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}
	public float getMidExamMark() {
		return midExamMark;
	}
	public void setMidExamMark(float midExamMark) {
		this.midExamMark = midExamMark;
	}
	public float getFinalExamMark() {
		return finalExamMark;
	}
	public void setFinalExamMark(float finalExamMark) {
		this.finalExamMark = finalExamMark;
	}
	public Subject(String subjectCode, String subjectName, int credit, float attendanceMark, float midExamMark,
			float finalExamMark) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
		this.attendanceMark = attendanceMark;
		this.midExamMark = midExamMark;
		this.finalExamMark = finalExamMark;
	}
	public Subject() {
		
	}
	public Subject(String subjectCode, String subjectName, int credit) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	
	public float calSubjectMark() {
		return attendanceMark*0.1f + midExamMark*0.4f + finalExamMark*0.5f;
	}
	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		
		if(subjectMark <= 3.9) {
			conversionMark = 0;
		}else if(subjectMark <= 4.9) {
			conversionMark = 1;
		}else if(subjectMark <= 5.4) {
			conversionMark = (float) 1.5;
		}else if(subjectMark <= 6.4) {
			conversionMark = 2;
		}else if(subjectMark <= 6.9) {
			conversionMark = (float) 2.5;
		}else if(subjectMark <= 7.4) {
			conversionMark = 3;
		}else if(subjectMark <= 8.4) {
			conversionMark = (float) 3.5;
		}else if(subjectMark <= 10) {
			conversionMark = 4;
		}
		return conversionMark;
	}
	public float calConversionMark(String grade) {
		float conversionMark = -1;
		switch (grade) {
		case "F":
			conversionMark = 0;
			break;
		case "D":
			conversionMark = 1;
			break;	
		case "D+":
			conversionMark = (float) 1.5;
			break;
		case "C":
			conversionMark = 2;
			break;
		case "C+":
			conversionMark = (float) 2.5;
			break;
		case "B":
			conversionMark = 3;
			break;
		case "B+":
			conversionMark = (float) 3.5;
			break;
		case "A":
			conversionMark = 4;
			break;
		}
		
		return conversionMark;
	}
	public String calGrade() {
		float subjectMark = calSubjectMark();
		String  grade = null;
		if(subjectMark < 0) {
			grade = "Error ";
		}else if(subjectMark <= 3.9) {
			grade = "F";
		}else if(subjectMark <= 4.9) {
			grade = "D";
		}else if(subjectMark <= 5.4) {
			grade = "D+";
		}else if(subjectMark <= 6.4) {
			grade = "C";
		}else if(subjectMark <= 6.9) {
			grade = "C+";
		}else if(subjectMark <= 7.4) {
			grade = "B";
		}else if(subjectMark <= 8.4) {
			grade = "B+";
		}else if(subjectMark <= 10) {
			grade = "A";
		}
		return grade;
	}
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", credit=" + credit
				+ ", attendanceMark=" + attendanceMark + ", midExamMark=" + midExamMark + ", finalExamMark="
				+ finalExamMark + "]";
	}
	
	public void Input(Scanner sc) {
		System.out.print("Nhap ma mon hoc: ");
		this.subjectCode = sc.nextLine();
		
		System.out.print("Nhap ten mon hoc: ");
		this.subjectName = sc.nextLine();
		
		System.out.print("Nhap diem chuyen can: ");
		this.attendanceMark = Float.parseFloat(sc.nextLine());
		
		System.out.print("Nhap diem giua ki: ");
		this.midExamMark = Float.parseFloat(sc.nextLine());
		
		System.out.print("Nhap diem cuoi ki: ");
		this.finalExamMark = Float.parseFloat(sc.nextLine());
	}
}
