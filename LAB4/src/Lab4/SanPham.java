import java.util.Scanner;

public class SanPham {
private String tenSP;
private double donGia;
private double giamGia;

public SanPham(String _tenSP, double _donGia, double _giamGia) {
	tenSP = _tenSP;
	donGia = _donGia;
	giamGia = _giamGia;
}

public SanPham(String _tenSP, double _donGia) {
	tenSP = _tenSP;
	donGia = _donGia;
	giamGia = 0;
}




//10% gia
private double getThueNhapKhau() {
	return donGia*0.1;	
}
//Nhap du lieu
public void nhap() {
	Scanner bp = new Scanner(System.in);
	System.out.print("Nhap ten SP: ");
	tenSP = bp.nextLine();
	System.out.print("Nhap don gia SP: ");
	donGia = bp.nextDouble();
	System.out.print("Nhap giam gia SP: ");
	giamGia = bp.nextDouble();
}
public void xuat() {
	System.out.println("Tên sản phẩm: "+ tenSP);
	System.out.println("Giá sản phẩm : " + String.valueOf(donGia) );
	System.out.println("Tên sản phẩm: " + String.valueOf(giamGia));
	System.out.println("Thuế nhập khẩu: " + String.valueOf(getThueNhapKhau()));

}
}
