import java.util.Scanner;

public class HinhChuNhat {
	static int dai,rong, dientich, chuvi, canhnhonhat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner banphim = new Scanner(System.in);
		System.out.print("Mời bạn nhập chiều dài: ");
		dai = banphim.nextInt();
		System.out.print("Mời bạn nhập chiều rộng: ");
		rong = banphim.nextInt();
		// tính toán
		chuvi = (dai + rong)*2;
		dientich = (dai*rong);
		canhnhonhat = Math.min(dai, rong);
		// in ra màn hình 
		System.out.println("Chu vi hình chữ nhật là " +chuvi +"\nDiện tích hình chữ nhật là " +dientich +"\nCạnh nhỏ nhất là" +canhnhonhat);
	}

}
