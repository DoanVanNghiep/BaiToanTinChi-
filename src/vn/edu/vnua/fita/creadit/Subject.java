package vn.edu.vnua.fita.creadit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subject {
	
	private String subjectCode;
	private String subjectName;
	private int credit;
	private float numberOfPoint;
	private Student student;
	int startingNumber;
	private List<Float> weights = new ArrayList<Float>();
//	private float attendanceMark;//chuyên cần
//	private float midExamMark;// giữa kì
//	private float finalExamMark;// cuối kì
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
	public Subject(String subjectCode, String subjectName, int credit,float numberOfPoint) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
		this.numberOfPoint = numberOfPoint;
	}
	public Subject() {
		
	}
	public Subject(String subjectCode, String subjectName, int credit) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	
	public float calSubjectMark(List<Float> grades) {
		 if (grades.size() != weights.size()) {
	            throw new IllegalArgumentException("Number of grades and weights must be the same");
	        }

	        float weightedSum = 0;
	        float totalWeight = 0;

	        for (int i = 0; i < grades.size(); i++) {
	            float grade = grades.get(i);
	            float weight = weights.get(i);

	            weightedSum += grade * weight;
	            totalWeight += weight;
	        }

	        if (totalWeight == 0.0) {
	            return 0; // To avoid division by zero
	        }

	        return weightedSum / totalWeight;
	}
	public float calConversionMark() {
		float subjectMark = calSubjectMark(student.getGrades());
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
		float subjectMark = calSubjectMark(student.getGrades());
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
		return  "\nsubjectCode=" + subjectCode + ", subjectName=" + subjectName + ", credit=" + credit
				+ ", calConversionMark()=" + calConversionMark() + ", calGrade()=" + calGrade();
	}
	public void Input(Scanner sc) {
		System.out.print("\nNhap ma mon hoc: ");
		this.subjectCode = sc.nextLine();
		
		System.out.print("Nhap ten mon hoc: ");
		this.subjectName = sc.nextLine();
		
		System.out.print("Nhap so tin chi: ");
		this.credit = Integer.parseInt(sc.nextLine());
		
		// Số đầu điểm và tỉ lệ phần trăm
		int sumPersent = 0;
        System.out.print("Nhập số đầu điểm: ");
        startingNumber = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= startingNumber; i++) {
        	System.out.print("Nhập tỉ lệ phần trăm cho đầu điểm thứ "+ i +": ");
        	numberOfPoint = Float.parseFloat(sc.nextLine());
        	weights.add(numberOfPoint);
        	// kiểm tra xem có đủ 100% chưa
        	sumPersent += numberOfPoint;
        }
    	if(sumPersent != 100) {
    		System.out.println("Vẫn chưa đủ 100%.");
    		return;
    	}
        Student student = new Student();
        // nhập điểm
        List<Double> pointOfStudent = new ArrayList<Double>();
        for (int j = 0; j < startingNumber; j++) {
			System.out.print("Nhập điểm thứ " + (j+1) + ": ");
			float grade = Float.parseFloat(sc.nextLine());
			student.addGrade(grade);
		}
	}
}