package Lab3;

import java.util.Scanner;

public class Lab3_Bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n;
		
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập n:  ");
		n = nhap.nextInt();
		
		Boolean ok = true;
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				ok=false;
				break;
			}
		}
		
		if(ok==true)
		{
			System.out.println(n +" là số nguyên tố");
		}else
		{
			System.out.println(n +" không phải là số nguyên tố");
		}
	}

}
