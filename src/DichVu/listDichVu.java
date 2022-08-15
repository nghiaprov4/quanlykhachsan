package DichVu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import KhachHang.ThongTinKhachHang;
import Main.Database;
import QuanLyPhong.ThongTinPhong;
import QuanLyPhong.listQuanLyPhong;

public class listDichVu {

	Database database = new Database();
	ArrayList<ThongTinDichVu> list = new ArrayList<ThongTinDichVu>();
//	ArrayList<ThongTinPhong> listPhongBan = new ArrayList<ThongTinPhong>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("select maDichVu, tenDichVu from dichVu");
    	while (rs.next()) {
    		String maDichVu = rs.getString(1);
    		String tenDichVu = rs.getString(2);
    		
    	    ThongTinDichVu dv = new ThongTinDichVu(maDichVu,  tenDichVu);
    	    list.add(dv);
    	}
    	con.close();
	}
	
	public boolean addData(String maDichVu, String tenDichVu) throws SQLException {
		for(ThongTinDichVu i : list) {
			if(maDichVu == i.getMaDichVu()) {
				return false;
			}
		}
		ThongTinDichVu kh = new ThongTinDichVu(maDichVu,  tenDichVu);
		Connection con = database.getConnect();
		String sql = "INSERT INTO dichVu(maDichVu,  tenDichVu) "
				+ "VALUES(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, maDichVu);
		//stmt.setString(2, maPhong);
		stmt.setString(2, tenDichVu);
		stmt.executeUpdate();
    	list.add(kh);
    	con.close();
		return true;
	}
    	
    	
    	public void Remove(String maKhachHang) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM dichVu WHERE maDichVu = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maKhachHang);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(String maDichVu, ThongTinDichVu dv) throws SQLException{
    		int index = 0;
    		for(ThongTinDichVu i : list){
    			if(maDichVu == i.getMaDichVu()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, dv);
    				Connection con = database.getConnect();
    				String sql = "UPDATE dichVu SET  tenDichVu = ? WHERE maDichVu = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, dv.getMaDichVu());
    				stmt.setString(2, dv.getTenDichVu());
 
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
    	
    	public ThongTinDichVu getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}
    	
    	public ThongTinDichVu search(String maDichVu){
    		for(ThongTinDichVu dv : list){
    			if(maDichVu == dv.getMaDichVu()){
    				return dv;
    			}
    		}
    		return null;
    	}
    	
//    	public void LoadDataPhong() throws SQLException{
//    		listPhongBan.clear();
//    		Connection con = database.getConnect();
//    		Statement stmt = con.createStatement();
//        	ResultSet rs = stmt.executeQuery("SELECT * FROM quanLyPhong");
//        	while (rs.next()) {
//        		String maPhong = rs.getString(1);
//        		String maTrangThai = rs.getString(2);
//        		String tenPhong = rs.getString(3);
//        		String giaPhong = rs.getString(4);
//        	    String loaiPhong = rs.getString(5);
//        	    String maDichVu = rs.getString(6);
//        	    String tinhTrangPhong = rs.getString(7);
//        	    ThongTinPhong phong = new ThongTinPhong( maPhong,  maTrangThai,  tenPhong,  giaPhong,  loaiPhong, maDichVu,  tinhTrangPhong);
//        	    listPhongBan.add(phong);
//        	}
//
//        	con.close();
//        	
//    	}

    	
//    	public int getSizeDataMaPhong() {
//    		return listQuanLyPhong.size();
//    	}
//  	
//    	public ThongTinPhong getPhongBanElement(int index) {
//    		if(index < 0 || index >= listQuanLyPhong.size()) {
//    			return null;
//    		}
//    		return listQuanLyPhong.get(index);
//    	}
//
//		public ThongTinNhanVien getElement1(int i) {
//			
//			return null;
//		}

		public Object get(int i) {
			return null;
		}


}
