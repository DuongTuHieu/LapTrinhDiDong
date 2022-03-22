import java.util.Scanner;
public class KhoiLapPhuong {
	static int a, thetich;
	public static void main(String[] args) {
		Scanner banphim = new Scanner(System.in); 
		System.out.print("Nhập cạnh khối lập phương: ");
		a= banphim.nextInt();
		thetich = a*a*a;
		//thetich = (int) Math.pow(a,3);
		System.out.println("Thế tích khối lập phương là: " +thetich );	}
}
