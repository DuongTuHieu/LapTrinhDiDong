import java.util.Scanner;
public class PhuongTrinhBac2 {
	static int a,b,c;
	static float delta;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner banphim = new Scanner(System.in);
		System.out.print("Nhập a: ");
		a = banphim.nextInt();
		System.out.print("Nhập b: ");
		b = banphim.nextInt();
		System.out.print("Nhập c: ");
		c = banphim.nextInt();
		delta = (int) Math.pow(b,2) - 4*a*c;
		System.out.println("Delta là " +delta + "\nCăn bậc 2 của delta là " +Math.sqrt(delta));
	}

}
