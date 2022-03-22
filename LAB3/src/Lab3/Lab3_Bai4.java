package Lab3;
import java.util.Scanner;

public class Lab3_Bai4 {
	static String Hoten[] = new String[30];
	static double Diem[] = new double[3];
	static int index = 0;
	static void inputs() {
		Scanner sc;
		String choice = "y";
		do {
			sc = new Scanner(System.in);
			System.out.print("Nhập họ và tên sinh viên: ");
			Hoten[index]= sc.nextLine();
			System.out.print("Nhập điểm sinh viên: ");
			Diem[index]= sc.nextDouble();
			index++;
			System.out.print("Bạn có  muốn nhập tiếp?(Y/N)");
			choice = sc.next();
		}
	while(choice.equalsIgnoreCase("y"));	
	}
	
	static void outputs() {
		for(int i =0;i< index; i++) {
		System.out.println("Sinh viên: "+Hoten[i] +"| " + Diem[i] + " Điểm | "+ "Học lực "+hocluc(Diem[i]) );
		
		}
		
	}
	static String hocluc(double Diem) {
		String xeploai = "";
		if(Diem < 5) {xeploai = "Yếu";}
			else  if(Diem < 6.5) { xeploai = "Trung Bình";}
				else  if(Diem < 7.5) { xeploai = "Khá";}
					else  if(Diem < 9) { xeploai = "Giỏi";}
						else  if(Diem <=10) { xeploai = "Xuất sắc";}
				
		return xeploai;	
	}
	public static void sapxep() {
		System.out.println("=========== Mảng sau khi sắp xếp giảm dần theo điểm ==============");
		for (int i =0;i<index -1;i++) {
			for(int j = i+1;j<index;j++) 
			{
				if(Diem[i]< Diem[j]) {
					double DiemTam = Diem[i];
					Diem[i] = Diem[j];
					Diem[j]= DiemTam;
					String TenTam = Hoten[i];
					Hoten[i]= Hoten[j];
					Hoten[j]= TenTam;
				}
			}
		}
		outputs();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputs();
		outputs();
		sapxep();
	}

}
