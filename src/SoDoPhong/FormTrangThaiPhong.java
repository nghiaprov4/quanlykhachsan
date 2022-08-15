package SoDoPhong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DanhMuc.FormQuanLyPhong;
import TrangChu.listNhanVien;

public class FormTrangThaiPhong extends JFrame implements ActionListener{
	
	private JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblMaNV, lblHoNV, lblTenNV, lblNgaySinh, lblNgayVaoLam, lblCMND_NV, lblGioiTinh, lblDiaChi, lblSDT_NV, lblChucVu, lblGhiChu;
	private JTextField txtMaNV, txtHoNV, txtTenNV, txtNgaySinh, txtNgayVaoLam, txtCMND_NV, txtDiaChi, txtSDT_NV, txtChucVu, txtGhiChu;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JComboBox<String> cbbGioiTinh, cbbChucVu;
	private DefaultComboBoxModel cbbModel, cbbModele;
	private DefaultComboBoxModel<String> cbbModelGioiTinh, cbbModelChucVu;
	private JLabel lblTitle, lblTimKiem;
	private JTextField txtTimKiem;
	private JTable tbThemNhanVien;
	private DefaultTableModel tbNhanVienModel;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuNhanVien, menuQLPhong, menuDichVu, menuKhachHang, menuHoaDon, menuTrangChu, menuDatPHong, menuTrangThaiPhong;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemPhong, itemXoaPhong, itemSuaThongTinPhong, itemTimKiemPhong;
	private JMenuItem itemThemDichVu, itemXoaDichVu, itemSuaDichVu, itemTimKiemDichVu;
	private JMenuItem itemThemKhachHang, itemXoaKhachHang, itemSuaThongTinKH, itemTimKiemKhachHang;
	private JMenuItem itemDanhSachHD, itemTimKiemHD;	
	
	public FormTrangThaiPhong() throws SQLException{
	listTrangThaiPhong list = new listTrangThaiPhong();
	
	menuTrangChu = new JMenu("TRANG CHỦ");
	
	
	menuNhanVien = new JMenu("QUẢN LÝ NHÂN VIÊN");

	
	menuQLPhong = new JMenu("QUẢN LÝ PHÒNG");
	

	
	menuDichVu = new JMenu("QUẢN LÝ DỊCH VỤ");

	
	menuKhachHang = new JMenu("QUẢN LÝ KHÁCH HÀNG");

	
	menuHoaDon = new JMenu("QUẢN LÝ HÓA ĐƠN");

	
	menuTrangThaiPhong = new JMenu("TRẠNG THÁI PHÒNG");
	
	menuDatPHong = new JMenu("ĐẶT PHÒNG");
	
	menubar.add(menuTrangChu).addActionListener(this);
	menubar.add(menuQLPhong).addActionListener(this);;
	menubar.add(menuNhanVien).addActionListener(this);;
	menubar.add(menuDichVu).addActionListener(this);;
	menubar.add(menuKhachHang).addActionListener(this);;
	menubar.add(menuHoaDon).addActionListener(this);;
	menubar.add(menuTrangThaiPhong).addActionListener(this);
	menubar.add(menuDatPHong).addActionListener(this);
	
	
	setJMenuBar(menubar);

	
	JPanel jpanel = new JPanel();
	jpanel.setBorder(BorderFactory.createTitledBorder("Trạng thái phòng"));
	
	add(jpanel, BorderLayout.PAGE_START);
	}

	
	public static void main(String[] args) throws SQLException {
		new FormTrangThaiPhong();
		FormTrangThaiPhong frmTTP = new FormTrangThaiPhong();
		frmTTP.setTitle("HỆ THỐNG QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
		frmTTP.setVisible(true);
		frmTTP.setLocationRelativeTo(null);
		frmTTP.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmTTP.setBounds(0, 0, 1300, 680);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
