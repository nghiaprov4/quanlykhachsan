package NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DangNhap.ThongTinDangNhap;
import DangNhap.listDangNhap;
import KhachHang.ThongTinKhachHang;
import Main.Database;



public class listNhanVien {
	Database database = new Database();
	ArrayList<ThongTinNhanVien> list = new ArrayList<ThongTinNhanVien>();
	ArrayList<ThongTinDangNhap> listTenDangNhap = new ArrayList<ThongTinDangNhap>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery(" SELECT manhanvien, tennhanvien, FORMAT (ngaysinh, 'dd/MM/yyyy') as ngaysinh, gioitinh, diachi, maphongban FROM nhanvien");
    	while (rs.next()) {
    		String maNV = rs.getString(1);
    	    String tenNV = rs.getString(2);
    	    String ngaySinh = rs.getString(3);
    	    String gioiTinh = rs.getString(4);
    	    int cmnd_nv = rs.getInt(5);
    	    String diaChi = rs.getString(6);
    	    int sdt_nv = rs.getInt(7);
    	    String chucVu = rs.getString(8);
    	    String tenDN = rs.getString(9);
    	    String matKhau = rs.getString(10);
    	    ThongTinNhanVien nv = new ThongTinNhanVien(maNV, tenNV, ngaySinh, gioiTinh, cmnd_nv, sdt_nv, diaChi, chucVu,tenDN, matKhau);
    	    list.add(nv);
    	}
    	con.close();
    	
	}
	
    	
    	public boolean addData(String maNhanVien, String tenNhanVien, String ngaySinh, String gioiTinh, int cMND_NV, int soDienThoai_NV, String diaChi, String chucVu, String tenDangNhap, String matKhau) throws SQLException {
    		for(ThongTinNhanVien i : list){
    			if(maNhanVien == i.getMaNhanVien()){
    				return false;
    			}
    		}
    		
    		ThongTinNhanVien nv = new ThongTinNhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, cMND_NV, soDienThoai_NV, diaChi, chucVu,tenDangNhap, matKhau);
    		Connection con = database.getConnect();
    		String sql = "INSERT INTO nhanvien(manhanvien, tennhanvien, ngaysinh, gioitinh, diachi, maphongban) VALUES(?,?,CONVERT(date, ?, 103),?,?,?)";
        	PreparedStatement stmt = con.prepareStatement(sql);
        	stmt.setString(1, maNhanVien);
        	stmt.setString(2, tenNhanVien);
        	stmt.setString(3, ngaySinh);
        	stmt.setString(4, gioiTinh);
        	stmt.setInt(5, cMND_NV);
        	stmt.setInt(6, soDienThoai_NV);
        	stmt.setString(7, diaChi);
        	stmt.setString(8, chucVu);
        	stmt.setString(9, tenDangNhap);
        	stmt.setString(10, matKhau);
        	stmt.executeUpdate();
        	list.add(nv);
        	con.close();
        	return true;
    	}
    	
    	public void Remove(String maNhanVien) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM nhanVien WHERE maNhanVien = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maNhanVien);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(String maNV, ThongTinNhanVien nv) throws SQLException{
    		int index = 0;
    		for(ThongTinNhanVien i : list){
    			if(maNV == i.getMaNhanVien()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, nv);
    				Connection con = database.getConnect();
    				String sql = "UPDATE nhanVien SET  tenNhanVien = ?, ngaySinh = ?, gioiTinh = ?, cmnd_NV = ?, soDienThoai_NV = ?, diaChi = ?, chucVu= ?, tenDangNhap = ?, matKhau = ? WHERE maNhanVien = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, nv.getMaNhanVien());
    	        	stmt.setString(3, nv.getTenDangNhap());    	        	
    	        	stmt.setString(4, nv.getNgaySinh());
    	        	stmt.setString(5, nv.getGioiTinh());
    	        	stmt.setInt(6, nv.getCMND_NV());
    	        	stmt.setInt(7, nv.getSoDienThoai_NV());
    	        	stmt.setString(8, nv.getDiaChi());
    	        	stmt.setString(9, nv.getChucVu());   	        	
    	        	stmt.setString(10, nv.getTenDangNhap());
    	        	stmt.setString(11, nv.getMatKhau());
    		    	stmt.executeUpdate();
    		    	con.close();
    				return true;
    				
    			}	
    		}	
    		return false;		
    	}
    	
    	public int getSize() {
    		return list.size();
    	}
    	
    	public ThongTinNhanVien getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}


		public ThongTinNhanVien search(String maNhanVien) {
			for(ThongTinNhanVien nv : list){
    			if(maNhanVien == nv.getMaNhanVien()){
    				return nv;
    			}
			}
			return null;
		}

    	
//    	public void LoadDataDangNhap() throws SQLException{
//    		listDangNhap.clear();
//    		Connection con = database.getConnect();
//    		Statement stmt = con.createStatement();
//        	ResultSet rs = stmt.executeQuery("SELECT * FROM dangNhap");
//        	while (rs.next()) {
//        		String tenDangNhap = rs.getString(1);
//        	    String matKhau = rs.getString(2);
//        	    ThongTinDangNhap dn = new ThongTinDangNhap(tenDangNhap, matKhau);
//        	    listDangNhap.add(dn);
//        	}
//
//        	con.close();
//        	
//    	}
//
//    	
//    	public int getSizeDataDangNhap() {
//    		return listDangNhap.size();
//    	}
//    	
//    	public ThongTinDangNhap getPhongBanElement(int index) {
//    		if(index < 0 || index >= listDangNhap.size()) {
//    			return null;
//    		}
//    		return listDangNhap.get(index);
//    	}
    	
    	
}
