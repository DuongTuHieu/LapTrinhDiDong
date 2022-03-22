import java.util.Scanner;

public class Lab2_Bai2 {

	static float a, b, c;
	static double nghiem;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner banphim = new Scanner(System.in);
		System.out.print("Nhập vào số a: ");
		a = banphim.nextInt();
		System.out.print("Nhập vào số b: ");
		b = banphim.nextInt();
		System.out.print("Nhập vào số c: ");
		c = banphim.nextInt();
		//PTB1(a, b);
		PTB2(a, b, c);
	}
	//---------------------------------------------
	public static void PTB1(float a, float b) {
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
	//--------------------------------------------
	public static void PTB2(float a, float b, float c) {
		if (a==0) {
			PTB1(a, b);
		}
		else { //a!=0
			float delta = (float) Math.pow(b, 2) -4*a*c;
			if(delta <0) {
				System.out.println("Phương trình vô nghiệm");
			} else if (delta == 0) {
				float x = -b/2*a;
				System.out.println("Phương trình có nghiệm kép:" +x);
			}
			else { //delta >0
				System.out.println("Phương trình có 2 nghiệm phân biệt: ");
				float x1 = (-b +(float) Math.sqrt(delta))/2*a;
				float x2 = (-b -(float) Math.sqrt(delta))/2*a;
				System.out.printf("Nghiệm x1: %.2f \n", x1);
				System.out.printf("Nghiệm x1: %.2f \n", x2);
			}
		}
	}
}
