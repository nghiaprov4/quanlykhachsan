package QuanLyHoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DangNhap.ThongTinDangNhap;
import KhachHang.ThongTinKhachHang;
import Main.Database;
import NhanVien.ThongTinNhanVien;
import QuanLyPhong.ThongTinPhong;
import QuanLyPhong.listQuanLyPhong;

public class listHoaDon {

	Database database = new Database();
	ArrayList<ThongTinHoaDon> list = new ArrayList<ThongTinHoaDon>();
	ArrayList<ThongTinPhong> listPhongBan = new ArrayList<ThongTinPhong>();
	ArrayList<ThongTinNhanVien> listNhanVien = new ArrayList<ThongTinNhanVien>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM hoaDon");
    	while (rs.next()) {
    		String maHoaDon = rs.getString(1);
    		String MaKhachHang = rs.getString(2);
    		String maNhanVien = rs.getString(3);
    		String ngayLapHoaDon = rs.getString(4);
    		String gioDat = rs.getString(5);
    		String gioTra = rs.getString(6);
    	    ThongTinHoaDon hd = new ThongTinHoaDon(maHoaDon,  MaKhachHang, maNhanVien,  ngayLapHoaDon,  gioDat,  gioTra);
    	    list.add(hd);
    	}
    	con.close();
	}
	
	public boolean addData(String maHoaDon,  String MaKhachHang, String maNhanVien,  String ngayLapHoaDon,  String gioDat,  String gioTra) throws SQLException {
		for(ThongTinHoaDon i : list) {
			if(maHoaDon == i.getMaHoaDon()) {
				return false;
			}
		}
		ThongTinHoaDon hd = new ThongTinHoaDon(maHoaDon,  MaKhachHang, maNhanVien,  ngayLapHoaDon,  gioDat,  gioTra);
		Connection con = database.getConnect();
		String sql = "INSERT INTO hoaDon((maHoaDon,  maKhachHang, maNhanVien,  ngayLapHoaDon,  gioDatPhong,  gioTraPhong) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, maHoaDon);
		//stmt.setString(2, maPhong);
		stmt.setString(2, MaKhachHang);
		stmt.setString(3, maNhanVien);
		stmt.setString(4, ngayLapHoaDon);
		stmt.setString(5, gioDat);
		stmt.setString(6, gioTra);
		stmt.executeUpdate();
    	list.add(hd);
    	con.close();
		return true;
	}
    	
    	
    	public void Remove(String maHoaDon) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM hoaDon WHERE maHoaDon = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maHoaDon);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(String maHoaDon, ThongTinHoaDon hd) throws SQLException{
    		int index = 0;
    		for(ThongTinHoaDon i : list){
    			if(maHoaDon == i.getMaKhachHang()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, hd);
    				Connection con = database.getConnect();
    				String sql = "UPDATE hoaDon SET  maKhachHang = ?, maNhanVien = ?,  ngayLapHoaDon = ?,  gioDatPhong = ?,  gioTraPhong = ? WHERE maHoaDon = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, hd.getMaKhachHang());
    				stmt.setString(2, hd.getMaKhachHang());
    				stmt.setString(3, hd.getMaNhanVien());
    				stmt.setString(4, hd.getNgayLapHoaDon());
    				stmt.setString(5, hd.getGioDat());
    				stmt.setString(6, hd.getGioTra());
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
    	
    	public ThongTinHoaDon getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}
    	
    	public ThongTinHoaDon search(String maHoaDon){
    		for(ThongTinHoaDon hd : list){
    			if(maHoaDon == hd.getMaHoaDon()){
    				return hd;
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
