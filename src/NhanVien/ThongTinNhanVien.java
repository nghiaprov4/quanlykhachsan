package NhanVien;


public class ThongTinNhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String ngaySinh;
	private String gioiTinh;
	private int CMND_NV;
	private String diaChi;
	private int soDienThoai_NV;
	private String chucVu;
	private String tenDangNhap;
	private String matKhau;
	
	public ThongTinNhanVien(String maNhanVien, String tenNhanVien, String ngaySinh, String gioiTinh,int cMND_NV, int soDienThoai_NV, String diaChi, String chucVu, String tenDangNhap, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.CMND_NV = cMND_NV;
		this.diaChi = diaChi;
		this.soDienThoai_NV = soDienThoai_NV;
		this.chucVu = chucVu;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getCMND_NV() {
		return CMND_NV;
	}
	public void setCMND_NV(int cMND_NV) {
		CMND_NV = cMND_NV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoDienThoai_NV() {
		return soDienThoai_NV;
	}
	public void setSoDienThoai_NV(int soDienThoai_NV) {
		this.soDienThoai_NV = soDienThoai_NV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "ThongTinNhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", CMND_NV=" + CMND_NV + ", diaChi=" + diaChi + ", soDienThoai_NV="
				+ soDienThoai_NV + ", chucVu=" + chucVu + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + "]";
	}
	
	
	
}
