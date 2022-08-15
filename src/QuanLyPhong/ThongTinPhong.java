package QuanLyPhong;

public class ThongTinPhong {
	private String maPhong;
	private String maTrangThai;
	private String tenPhong;
	private String giaPhong;
	private String loaiPhong;
	private String maDichVu;
	private String tinhTrangPhong;
	public ThongTinPhong(String maPhong, String maTrangThai, String tenPhong, String giaPhong, String loaiPhong,
			String maDichVu, String tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.maTrangThai = maTrangThai;
		this.tenPhong = tenPhong;
		this.giaPhong = giaPhong;
		this.loaiPhong = loaiPhong;
		this.maDichVu = maDichVu;
		this.tinhTrangPhong = tinhTrangPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaTrangThai() {
		return maTrangThai;
	}
	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(String giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTinhTrangPhong() {
		return tinhTrangPhong;
	}
	public void setTinhTrangPhong(String tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}
	@Override
	public String toString() {
		return "ThongTinPhong [maPhong=" + maPhong + ", maTrangThai=" + maTrangThai + ", tenPhong=" + tenPhong
				+ ", giaPhong=" + giaPhong + ", loaiPhong=" + loaiPhong + ", maDichVu=" + maDichVu + ", tinhTrangPhong="
				+ tinhTrangPhong + "]";
	}
	
	
}
