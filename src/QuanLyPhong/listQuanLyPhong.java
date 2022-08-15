package QuanLyPhong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DichVu.ThongTinDichVu;
import DichVu.listDichVu;
import KhachHang.ThongTinKhachHang;
import Main.Database;

public class listQuanLyPhong {

	Database database = new Database();
	ArrayList<ThongTinPhong> list = new ArrayList<ThongTinPhong>();
	ArrayList<ThongTinDichVu> listPhongBan = new ArrayList<ThongTinDichVu>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * from quanLyPhong");
    	while (rs.next()) {
    		String maPhong = rs.getString(1);
    		String maTrangThai = rs.getString(2);
    		String tenPhong = rs.getString(3);
    		String giaPhong = rs.getString(4);
    		String loaiPhong = rs.getString(5);
    		String maDichVu = rs.getString(6);
    		String tinhTrangPhong = rs.getString(7);
    	    ThongTinPhong phong = new ThongTinPhong(maPhong,  maTrangThai, tenPhong,  giaPhong,  loaiPhong,  maDichVu, tinhTrangPhong);
    	    list.add(phong);
    	}
    	con.close();
	}
	
	public boolean addData(String maPhong, String maTrangThai, String tenPhong, String giaPhong, String loaiPhong,
			String maDichVu, String tinhTrangPhong) throws SQLException {
		for(ThongTinPhong i : list) {
			if(maPhong == i.getMaPhong()) {
				return false;
			}
		}
		ThongTinPhong phong = new ThongTinPhong(maPhong,  maTrangThai, tenPhong,  giaPhong,  loaiPhong,  maDichVu, tinhTrangPhong);
		Connection con = database.getConnect();
		String sql = "INSERT INTO quanLyPhong (maPhong,  maTrangThai, tenPhong,  giaPhong,  loaiPhong,  maDichVu, tinhTrangPhong) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, maPhong);
		stmt.setString(2, maTrangThai);
		stmt.setString(3, tenPhong);
		stmt.setString(4, giaPhong);
		stmt.setString(5, loaiPhong);
		stmt.setString(6, maDichVu);
		stmt.setString(7, tinhTrangPhong); 
		stmt.executeUpdate();
    	list.add(phong);
    	con.close();
		return true;
	}
    	
    	
    	public void Remove(String maPhong) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM quanLyPhong WHERE maPhong = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maPhong);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(String maPhong, ThongTinPhong phong) throws SQLException{
    		int index = 0;
    		for(ThongTinPhong i : list){
    			if(maPhong == i.getMaPhong()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, phong);
    				Connection con = database.getConnect();
    				String sql = "UPDATE QLkhachHang SET  maTrangThai = ?, tenPhong = ?,  giaPhong = ?,  loaiPhong = ?,  maDichVu = ?, tinhTrangPhong = ? WHERE maPhong = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, phong.getMaPhong());
    		    	stmt.setString(2, phong.getMaTrangThai());
    				stmt.setString(3, phong.getTenPhong());
    				stmt.setString(4, phong.getGiaPhong());
    				stmt.setString(5, phong.getLoaiPhong());
    				stmt.setString(6, phong.getMaDichVu());
    				stmt.setString(7, phong.getTinhTrangPhong());
    				
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
    	
    	public ThongTinPhong getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}
    	
    	public ThongTinPhong search(String maPhong){
    		for(ThongTinPhong phong : list){
    			if(maPhong == phong.getMaPhong()){
    				return phong;
    			}
    		}
    		return null;
    	}
    	
    	public void LoadDataDichVu() throws SQLException{
    		listPhongBan.clear();
    		Connection con = database.getConnect();
    		Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT * FROM quanLyPhong");
        	while (rs.next()) {
        		String maDichVu = rs.getString(1);
        	    String tenDichVu = rs.getString(2);
        	    ThongTinDichVu dv = new ThongTinDichVu(maDichVu, tenDichVu);
        	    listPhongBan.add(dv);
        	}

        	con.close();
        	
    	}

    	
    	public int getSizeDataDichVu() {
    		return listPhongBan.size();
    	}
  	
    	public ThongTinDichVu getPhongBanElement(int index) {
    		if(index < 0 || index >= listDichVu.size()) {
    			return null;
    		}
    		return listDichVu.get(index);
    	}
//
//		public ThongTinNhanVien getElement1(int i) {
//			
//			return null;
//		}

		public static int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static ThongTinPhong get(int i) {
			return null;
		}

}
