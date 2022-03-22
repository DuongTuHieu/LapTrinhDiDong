
public class ChuongTrinhChinh {

	public static void main(String[] args) {
	HangHoa hh1=new HangHoa("Bút bi", 2000);
	HangHoa hh2=new HangHoa("Bút mực", 12000, 0.1);
	System.out.println("Tên sản phẩm 1: " + hh1.getTenHH());
	System.out.println("Giá sản phẩm 1: " + hh1.donGia());
	System.out.println("Giảm giá: " + hh1.getTenHH());
	System.out.println("Thuế nhập khẩu: " + hh1.getTenHH());

	}

}
