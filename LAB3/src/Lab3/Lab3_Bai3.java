package Lab3;
import java.util.Arrays;
import java.util.Scanner;

public class Lab3_Bai3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		
		int n;
		System.out.print("Nhập số phần tử của mảng: ");
		n = nhap.nextInt();
		int mang[] = new int [n];
		
		for(int i=0;i<n;i++)
		{
			System.out.printf("Giá trị phần tử thứ  "+i + " là: ");
			mang[i] = nhap.nextInt();
		}
		Arrays.sort(mang);
		System.out.println("Mảng vừa nhập đã sắp xếp là : "+Arrays.toString(mang));
		
		int min=mang[0];
		for(int i=0;i<n;i++)
		{
			if(min>mang[i]) {
				min=mang[i];
			}
		}
		System.out.println("Phần tử nhỏ nhất của mảng là "+min);
		
		float count=0;
		int tong=0;
		for(int i=0;i<n;i++)
		{
			if(mang[i]%3==0) {
				tong +=mang[i];
				count++;
			}
		}
		float trungbinh = (float) tong/count;
		System.out.println("Trung bình cộng các số chia hết cho 3 là "+trungbinh);
	}
}
