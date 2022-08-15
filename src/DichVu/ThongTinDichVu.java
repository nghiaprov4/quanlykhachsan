package DichVu;

public class ThongTinDichVu {
	private String maDichVu;
	private String tenDichVu;
	public ThongTinDichVu(String maDichVu, String tenDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	@Override
	public String toString() {
		return "ThongTinDichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu ;
	}
	
	
}
