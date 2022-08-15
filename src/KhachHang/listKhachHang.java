package KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.Database;
import QuanLyPhong.ThongTinPhong;
import QuanLyPhong.listQuanLyPhong;

public class listKhachHang {

	Database database = new Database();
	ArrayList<ThongTinKhachHang> list = new ArrayList<ThongTinKhachHang>();
	ArrayList<ThongTinPhong> listPhongBan = new ArrayList<ThongTinPhong>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT maKhachHang, tenKhachHang, quocTich, soDienThoai_KH, gioiTinh, cmnd_KH,  ngaySinh FROM QLkhachHang");
    	while (rs.next()) {
    		String maKhachHang = rs.getString(1);
    		String tenKhachHang = rs.getString(2);
    		String quocTich = rs.getString(3);
    		int soDienThoai = rs.getInt(4);
    		String gioiTinh = rs.getString(5);
    		int CMND_KH = rs.getInt(6);
    		String ngaySinh = rs.getString(7);
    	    ThongTinKhachHang kh = new ThongTinKhachHang(maKhachHang,  tenKhachHang, quocTich,  CMND_KH,  gioiTinh,  soDienThoai, ngaySinh);
    	    list.add(kh);
    	}
    	con.close();
	}
	
	public boolean addData(String maKhachHang, String tenKhachHang, String quocTich, int soDienThoai,
			String gioiTinh, int cMND_KH, String ngaySinh) throws SQLException {
		for(ThongTinKhachHang i : list) {
			if(maKhachHang == i.getMaKhachHang()) {
				return false;
			}
		}
		ThongTinKhachHang kh = new ThongTinKhachHang(maKhachHang,  tenKhachHang, ngaySinh,  cMND_KH,  gioiTinh,  soDienThoai,  quocTich);
		Connection con = database.getConnect();
		String sql = "INSERT INTO QLkhachHang(maKhachHang, tenKhachHang, quocTich, soDienThoai_KH, gioiTinh, cmnd_KH, ngaySinh) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, maKhachHang);
		//stmt.setString(2, maPhong);
		stmt.setString(2, tenKhachHang);
		stmt.setString(3, quocTich);
		stmt.setInt(4, soDienThoai);
		stmt.setString(5, gioiTinh);
		stmt.setInt(6, cMND_KH);
		stmt.setString(7, ngaySinh); 
		stmt.executeUpdate();
    	list.add(kh);
    	con.close();
		return true;
	}
    	
    	
    	public void Remove(String maKhachHang) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM QLkhachHang WHERE maKhachHang = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maKhachHang);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(String maKhachHang, ThongTinKhachHang kh) throws SQLException{
    		int index = 0;
    		for(ThongTinKhachHang i : list){
    			if(maKhachHang == i.getMaKhachHang()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, kh);
    				Connection con = database.getConnect();
    				String sql = "UPDATE QLkhachHang SET  tenKhachHang = ?, quocTich = ?, soDienThoai_KH = ?, gioiTinh = ?, cmnd_KH = ?, ngaySinh = ? WHERE maKhachHang = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, kh.getMaKhachHang());
    				stmt.setString(2, kh.getTenKhachHang());
    				stmt.setString(3, kh.getQuocTich());
    				stmt.setInt(4, kh.getSoDienThoai());
    				stmt.setString(5, kh.getGioiTinh());
    				stmt.setInt(6, kh.getCMND_KH());
    				stmt.setString(7, kh.getNgaySihn());
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
    	
    	public ThongTinKhachHang getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}
    	
    	public ThongTinKhachHang search(String maKhachHang){
    		for(ThongTinKhachHang kh : list){
    			if(maKhachHang == kh.getMaKhachHang()){
    				return kh;
    			}
    		}
    		return null;
    	}
    	
    	public void LoadDataPhong() throws SQLException{
    		listPhongBan.clear();
    		Connection con = database.getConnect();
    		Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT * FROM quanLyPhong");
        	while (rs.next()) {
        		String maPhong = rs.getString(1);
        		String maTrangThai = rs.getString(2);
        		String tenPhong = rs.getString(3);
        		String giaPhong = rs.getString(4);
        	    String loaiPhong = rs.getString(5);
        	    String maDichVu = rs.getString(6);
        	    String tinhTrangPhong = rs.getString(7);
        	    ThongTinPhong phong = new ThongTinPhong( maPhong,  maTrangThai,  tenPhong,  giaPhong,  loaiPhong, maDichVu,  tinhTrangPhong);
        	    listPhongBan.add(phong);
        	}

        	con.close();
        	
    	}

    	
    	public int getSizeDataMaPhong() {
    		return listQuanLyPhong.size();
    	}
  	
    	public ThongTinPhong getPhongBanElement(int index) {
    		if(index < 0 || index >= listQuanLyPhong.size()) {
    			return null;
    		}
    		return listQuanLyPhong.get(index);
    	}
//
//		public ThongTinNhanVien getElement1(int i) {
//			
//			return null;
//		}

		public Object get(int i) {
			return null;
		}




}



