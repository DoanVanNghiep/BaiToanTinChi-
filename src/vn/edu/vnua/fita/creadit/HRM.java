package vn.edu.vnua.fita.creadit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class HRM {
	static List<Human> hrm = new ArrayList<Human>();
    private Subject subject;
    private List<Student> students;

	public HRM() {
	}
	public void addHR(Human human) {
		hrm.add(human);
		
	}

	public List<Human> getHrList(){
		return hrm;
	}
	public void printHRList() {
		System.out.println("\n----------------------");
		System.out.println("\nDanh sach nhan su:");
		for (Human human : hrm) {
			System.out.println(human.getCode() + ";" + human.getFullName());
		}
	}
	public void printLecturerInfor() {
		System.out.println("\n----------------------");
		System.out.println("\nDanh sach giang vien:");
		Lecturer lecturer = null;
		for (Human human : hrm) {
			if(human instanceof Lecturer) {
				lecturer = (Lecturer)human;// ep kieu student de truy xuat ten lop hoc
				System.out.print("\n"+human.toString());
			}
		}
	}
	public void printStudentInfor() {
		System.out.println("\n----------------------");
		System.out.println("\nDanh sach sinh vien:");
		Student student = null;
		for (Human human : hrm) {
			if(human instanceof Student) {
				student = (Student)human;// ep kieu student de truy xuat ten lop hoc
				System.out.print("\n" + student.getFullName() + "; " + student.getCode() + "; " + student.getClass_() + "; " + student.toString() );
			}
		}
	}
	public void sreachHuman() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap code human tim kiem: ");
		String code = sc.nextLine();
		
		
		boolean sreach = false;
		for (int i = 0; i < hrm.size(); i++) {
			if(hrm.get(i).getCode().equals(code)) {
				sreach = true;
				hrm.get(i).toString();
				break;
			}
		}
		if(sreach = false)
			System.out.println(" Không tìm thấy code tuong ung.!");
		
	}
	public void initDemoData() {
		Student std1 = new Student("634593", "Nguyen Van Hai", "Khoa CNTT", "K63CNTTA");
		Subject sub11= new Subject("TH03111", "Lap trinh Java", 3);
		
		Subject sub12 = new Subject("TH03046", "Kiem thu phan mem", 2);
		std1.addSubject(sub11);
		std1.addSubject(sub12);
		
		Lecturer lec1 = new Lecturer("cnp02", "Nguyen Van Quan", "Khoa CNTT");
		Lecturer lec2 = new Lecturer("cnp09", "Dang Tuan Anh", "Khoa CNTT");
		
		addHR(std1);
		addHR(lec1);
		addHR(lec2);
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		HRM h = new HRM();
		Human human = null;

        int x;
        do {
            System.out.println("1. Nhập sinh viên");
            System.out.println("2. Nhập giảng viên");
            System.out.println("3. Danh sách nhân sự");
            System.out.println("4. In ra số sinh viên");
            System.out.println("5. In ra số giảng viên");
            System.out.println("6. Tìm kiếm nhân sự");
            System.out.println("7. Sửa môn học của sinh viên ");
            System.out.println("8. Xóa môn học");
            System.out.println("9. Exit");
            System.out.print("Your choice:");
            x = sc.nextInt();
            switch (x){
                case 1:
    				human = new Student();
    				human.enterInfor(sc);
    				hrm.add(human);
    				System.out.println("Nhập thành công!\n");
                    break;
                case 2:
    				human = new Lecturer();
    				human.enterInfor(sc);
    				hrm.add(human);
    				System.out.println("Nhập thành công!\n");
                    break;
                case 3:
                	h.printHRList();
                    break;
                case 4:
                	h.printStudentInfor();
                    break;
                default:
                    System.out.println(" Exit successfully!");
                    sc.close();
                    break;
            }
        }while (x!=5);System.out.println("Không tìm thấy chức năng trên. xin nhập lại!");
	}
}