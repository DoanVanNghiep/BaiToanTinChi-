package Exemple;

public class Bai2_javacore {
	public static void main(String[] args) {

		
		String hoTen = " Doan Van Nghiep ";
		
		// xóa dấu cách đầu và cuối
		hoTen = hoTen.trim();
		
		System.out.println(" ------ cách 1: ");
		// cách 1:
		// tìm vị trí khoảng trắng
		String[] vt1 = hoTen.split(" ");
		
		System.out.println(" Họ: " + vt1[0]);
		System.out.println(" Đệm: "+ vt1[1]);
		System.out.println(" Tên: " + vt1[2]);
		
		
		System.out.println(" --------- cách 2:");
		
		// cách 2:
		
		// tìm vị trí kí tự khoảng đầu tiên
		int vtri1 = hoTen.indexOf(' ');
		
		// tìm trị trí khoảng trắng cuối cùng
		int vtri2 = hoTen.lastIndexOf(' ');
		
		// in ra màn hình 
		System.out.println(" Họ: "+ hoTen.substring(0,vtri1));
		System.out.println(" Đệm: "+ hoTen.substring(vtri1,vtri2));
		System.out.println(" Tên: "+ hoTen.substring(vtri2+1));
		
	}
}
