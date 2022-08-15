package KhachHang;

public class ThongTinKhachHang {
	private String maKhachHang;
	//private String maPhong;
	private String tenKhachHang;
//	private String ngayThuePhong;
//	private String ngayTraPhong;
	private String ngaySinh;
	private int CMND_KH;
	private String gioiTinh;
	private int soDienThoai;
	private String quocTich;
	public ThongTinKhachHang(String maKhachHang, String tenKhachHang, String quocTich,
	  int cMND_KH, String gioiTinh, int soDienThoai, String ngaySinh) {
		super();
		this.maKhachHang = maKhachHang;
		//this.maPhong = maPhong;
		this.tenKhachHang = tenKhachHang;
//		this.ngayThuePhong = ngayThuePhong;
//		this.ngayTraPhong = ngayTraPhong;
		this.ngaySinh = ngaySinh;
		this.CMND_KH = cMND_KH;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.quocTich = quocTich;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getNgaySihn() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getCMND_KH() {
		return CMND_KH;
	}
	public void setCMND_KH(int cMND_KH) {
		CMND_KH = cMND_KH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String quocTich) {
		this.quocTich = quocTich;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	@Override
	public String toString() {
		return "ThongTinKhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang="
				+ tenKhachHang +  ", quoctich="	+ quocTich 
				+ ", CMND_KH=" + CMND_KH + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + ngaySinh +"]";
	}
	
	
	
}
