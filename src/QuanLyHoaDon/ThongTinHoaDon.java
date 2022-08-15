package QuanLyHoaDon;

public class ThongTinHoaDon{
	private String maHoaDon;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayLapHoaDon;
	private String gioDat;
	private String gioTra;
	public ThongTinHoaDon(String maHoaDon, String maKhachHang, String maNhanVien, String ngayLapHoaDon, String gioDat,
			String gioTra) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.gioDat = gioDat;
		this.gioTra = gioTra;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public String getGioDat() {
		return gioDat;
	}
	public void setGioDat(String gioDat) {
		this.gioDat = gioDat;
	}
	public String getGioTra() {
		return gioTra;
	}
	public void setGioTra(String gioTra) {
		this.gioTra = gioTra;
	}
	@Override
	public String toString() {
		return "ThongTinHoaDon [maHoaDon=" + maHoaDon + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
				+ ", ngayLapHoaDon=" + ngayLapHoaDon + ", gioDat=" + gioDat + ", gioTra=" + gioTra + "]";
	}
	
	
	
}
