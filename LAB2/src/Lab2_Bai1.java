import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab2_Bai1 {

	public static void main(String[] args) {
		int a, b;
		double nghiem;
		Scanner banphim = new Scanner(System.in);
		System.out.print("Nhập a: ");
		a = banphim.nextInt();
		System.out.print("Nhập b: ");
		b = banphim.nextInt();
		if (a==0) {
			if (b==0) {
				System.out.println("Phương trình này có vô số nghiệm.");
			}
			else {
				System.out.println("Phương trình vô nghiệm.");
				}
			}
		else {
			nghiem = (double) -b/a; //ép kiểu cho ra nghiệm chính xác 
			System.out.println("Phương trình có nghiệm x= " +nghiem);
		}
	}

}
