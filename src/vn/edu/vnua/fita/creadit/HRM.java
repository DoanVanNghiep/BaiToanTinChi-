package vn.edu.vnua.fita.creadit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class HRM {
	private List<Human> hrm = new ArrayList<Human>();

	public HRM() {
	}
	public void addHR(Human human) {
		
	}
	public void addHR(Scanner sc ) {
		
	}
	public void printHRList() {
		
	}
	public void printLecturerInfor() {
		
	}
	public void printStudentIntor() {
		
	}
	public void sreachHuman(String code) {
		List<Human> humans = new ArrayList<Human>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap code human tim kiem: ");
		code = sc.nextLine();
		
		
		boolean sreach = false;
		for (int i = 0; i < humans.size(); i++) {
			if(humans.get(i).getCode().equals(code)) {
				sreach = true;
				humans.get(i).toString();
				break;
			}
		}
		if(sreach = false)
			System.out.println(" Không tìm thấy code tuong ung.!");
		
	}
	public void initDemoData() {
		
	}
	public void innitDemoData(Scanner sc) {
		
	}
	public static void main(String[] args) {
		
		
		
	}
}

