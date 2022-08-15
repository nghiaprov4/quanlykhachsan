package TrangChu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DangNhap.FormDangNhap;
import DanhMuc.FormDanhMuc;
import DanhMuc.FormHoaDon;
import DanhMuc.FormKhachHang;
import DanhMuc.FormNhanVien;
import SoDoPhong.FormTrangThaiPhong;

public class Menu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton soDoPhongButton, thongKeButton, danhMucButton, troGiupButton, dangXuatButton;
	private JLabel lable;
	public  Menu() {
		setBounds(0, 0, 1300, 680);
		setTitle("QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("hinh/hotel.jpg")));
		
		soDoPhongButton = new JButton("SƠ ĐỒ PHÒNG");
		soDoPhongButton.setBackground(Color.black);
		soDoPhongButton.setForeground(Color.white);
		soDoPhongButton.setBounds(60, 40, 150, 60);
		add(soDoPhongButton);
		setSize(1300, 680);	
		
		thongKeButton = new JButton("THỐNG KÊ");
		thongKeButton.setBackground(Color.black);
		thongKeButton.setForeground(Color.white);
		thongKeButton.setBounds(60, 120, 150, 60);
		add(thongKeButton);
		
		danhMucButton = new JButton("DANH MỤC");
		danhMucButton.setBackground(Color.black);
		danhMucButton.setForeground(Color.white);
		danhMucButton.setBounds(60, 200, 150, 60);
		add(danhMucButton);
		
		troGiupButton = new JButton("TRỢ GIÚP");
		troGiupButton.setBackground(Color.black);
		troGiupButton.setForeground(Color.white);
		troGiupButton.setBounds(60, 280, 150, 60);
		add(troGiupButton);
		
		dangXuatButton = new JButton("ĐĂNG XUẤT");
		dangXuatButton.setBackground(Color.black);
		dangXuatButton.setForeground(Color.white);
		dangXuatButton.setBounds(60, 360, 150, 60);
		add(dangXuatButton);
		

		soDoPhongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				FormTrangThaiPhong trangThaiPhong = new FormTrangThaiPhong();
				trangThaiPhong.setVisible(true);
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		
		thongKeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				FormHoaDon hoaDon = new FormHoaDon();
				hoaDon.setVisible(true);
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		danhMucButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FormDanhMuc danhMuc = new FormDanhMuc();
					danhMuc.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		troGiupButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FormNhanVien nhanVien = new FormNhanVien();
					nhanVien.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		dangXuatButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "BẠN MUỐN THOÁT CHƯƠNG TRÌNH ?","EXIT",JOptionPane.YES_NO_OPTION);
		        if(confirmed == JOptionPane.YES_OPTION)
		        {
		            dispose();
		        }
			}
		});
        
	}
	public static void main(String args[])
	{
		new Menu();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
