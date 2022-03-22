
public class HangHoa {
	/**
	 * 
	 */

	private String tenHH;
	private double donGia;
	private double giamGia;
	
	
	
	public HangHoa(String tenHH, double donGia, double giamGia) {
		super();
		this.tenHH = tenHH;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public HangHoa(String tenHH, double donGia) {
		super();
		this.tenHH = tenHH;
		this.donGia = donGia;
		this.giamGia = 0;
	}
	
	// xây dựng các setter
	void setTenHH(String tenHH) {
		this.tenHH = tenHH;
	}
	//xây dựng các getter
	String getTenHH(){
		return this.tenHH;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
}
