package DangNhap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import DanhMuc.FormKhachHang;
import DanhMuc.FormNhanVien;
import TrangChu.Menu;
public class FormDangNhap extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8620325138008490177L;
	JLabel l1;
	private  JLabel lblTitle;
	private  JLabel userLabel;
	public   JLabel passwordLabel = new JLabel("MẬT KHẨU");
	  private  JTextField userTextField = new JTextField();
	  private  JPasswordField passwordField = new JPasswordField();
	  private  JButton loginButton = new JButton("ĐĂNG NHẬP");
	  private  JButton resetButton = new JButton("XÓA");
	    
	  private  JButton exitButton = new JButton("THOÁT");
	  private  JCheckBox showPassword = new JCheckBox("Hiển thị mật khẩu");
	  
	
	public FormDangNhap() {
		setSize(700, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("hinh/dang-nhap.jpg")));
		//setLayout(new FlowLayout());
		
		l1 = new JLabel();
		add(l1);
		setSize(800, 550);	
		lblTitle = new JLabel("ĐĂNG NHẬP");
        lblTitle.setForeground(Color.red);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(350, 10, 300, 40);
        add(lblTitle);
        
        userLabel = new JLabel("TÀI KHOẢN");
        userLabel.setBounds(180, 140, 90, 30);
        userLabel.setForeground(Color.red);
        
        passwordLabel = new JLabel("MẬT KHẨU");
        passwordLabel.setBounds(180, 200, 150, 30);
        passwordLabel.setForeground(Color.red);
        userTextField.setBounds(270, 140, 400, 30);
        passwordField.setBounds(270, 200, 400, 30);
        
        showPassword.setBounds(270, 230, 150, 30);
        
        
        add(userLabel);
        add(passwordField);
        add(passwordLabel);
        add(showPassword);
        add(loginButton);
        add(exitButton);
        add(resetButton);
        add(userTextField);
        
        loginButton.setBounds(200, 330, 130, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(new Color(255, 255, 255));
        
        
        resetButton.setBounds(390, 330, 120, 30);
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(new Color(255, 255, 255));
        
        exitButton.setBounds(580, 330, 120, 30);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(new Color(255, 255, 255));
        
        
        
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        exitButton.addActionListener(this);
        
        
	}
	public static void main(String args[])
	{
		new FormDangNhap();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == loginButton) {
	        	KiemTraDN();

	        }
		 if (e.getSource() == resetButton) {
	            userTextField.setText("");
	            passwordField.setText("");
	        }
		
		  if (e.getSource() == resetButton) { userTextField.setText("");
		  passwordField.setText(""); }
		 
	        if (e.getSource() == showPassword) {
	            if (showPassword.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }
	        }
	        if(e.getSource() == exitButton) {
	        	this.dispose();
	        }
	}
	public void KiemTraDN()
	{
		
		try {			
			String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyKhachSan10";
			String user = "sa";
			String pass = "1234";
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "SELECT * FROM taiKhoan where tenDangNhap = ? and matKhau = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userTextField.getText());
			ps.setString(2, passwordField.getText());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String userType = rs.getString("isAdmin");
                if (userType.equals("ADMIN")){
                    this.setVisible(false);
//                    FormNhanVien ap = new FormNhanVien();
//                    ap.setVisible(true);
                    
                    Menu ap = new Menu();
                    ap.setVisible(true);
//                    JTabbedPane tabbedPane = new JTabbedPane();
//                     tabbedPane.setEnabledAt(1, true);
                     
                } else{
                    this.setVisible(false);
                    Menu ap = new Menu();
                    ap.setVisible(true);
                    
                    FormNhanVien nhanVien = new FormNhanVien();
                    nhanVien.setVisible(false);
                    JTabbedPane tabbedPane = new JTabbedPane();
                    tabbedPane.setEnabledAt(1, false);                    
                }

				JOptionPane.showMessageDialog(this, "ĐĂNG NHẬP THÀNH CÔNG");
				dispose();
				new Menu();
				
			}
			else {
				con.close();
				JOptionPane.showMessageDialog(this, "TÊN ĐĂNG NHẬP HOẶC MÂT KHẨU KHÔNG TỒN TẠI !");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
	}
	
}
