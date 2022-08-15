package DanhMuc;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import NhanVien.ThongTinNhanVien;
import NhanVien.listNhanVien;
import SoDoPhong.FormTrangThaiPhong;
import KhachHang.*;

public class FormKhachHang extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnNorth, pnCenter, pnSouth, pnWest;
	private JLabel lblMaKH, lblTenKH, lblQuocTich, lblSDT_KH, lblGioiTinh, lblCMND_KH, lblNgaySinh;
	private JTextField txtMaKH, txtTenKH, txtQuocTich, txtSDT_KH, txtCMND_KH, txtNgaySinh;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JComboBox<String> cbbGioiTinh;
	private DefaultComboBoxModel<String> cbbModel, cbbModele;
	private DefaultComboBoxModel<String> cbbModelGioiTinh;
	private JLabel lblTitle, lblTimKiem;
	private JTextField txtTimKiem;
	private JTable tbQLKhachHang;
	private listKhachHang list; 
	private DefaultTableModel tbKhachHangModel;

	public FormKhachHang() throws SQLException{
		
		JFrame frmKH = new JFrame();
		frmKH.setTitle("HỆ THỐNG QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
		frmKH.setVisible(true);
		frmKH.setLocationRelativeTo(null);
		frmKH.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmKH.setBounds(0, 0, 1300, 680);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panelNhanVien, panelKhachHang, panelDichVu, panelPhong, panelHoaDon;
		panelNhanVien = new JPanel();
		panelKhachHang = new JPanel();
		panelDichVu = new JPanel();
		panelPhong = new JPanel();
		panelHoaDon = new JPanel();
		
		tabbedPane.addTab("QUẢN LÝ NHÂN VIÊN", panelNhanVien);
//		tabbedPane.addTab("QUẢN LÝ KHÁCH HÀNG ", panel2);
		tabbedPane.addTab("QUẢN LÝ DỊCH VU", panelDichVu);
		tabbedPane.addTab("QUẢN LÝ PHÒNG ", panelPhong);
		tabbedPane.addTab("QUẢN LÝ HÓA ĐƠN", panelHoaDon);
		
		frmKH.getContentPane().add(tabbedPane);

		JPanel jPanel = new JPanel();
		
//		pnNorth = new JPanel();
//		pnNorth.add(lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG"));
//		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
//		lblTitle.setForeground(Color.BLUE);
//		add(pnNorth, BorderLayout.NORTH);
//		jPanel.add(pnNorth);

		pnWest = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;

		lblMaKH = new JLabel("MÃ KHÁCH HÀNG");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnWest.add(lblMaKH, c);
		

		txtMaKH = new JTextField(15);
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnWest.add(txtMaKH, c);

		lblTenKH = new JLabel("TÊN KHÁCH HÀNG");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnWest.add(lblTenKH, c);

		txtTenKH = new JTextField(15);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnWest.add(txtTenKH, c);

		lblQuocTich = new JLabel("QUỐC TỊCH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnWest.add(lblQuocTich, c);

		txtQuocTich = new JTextField(15);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnWest.add(txtQuocTich, c);


		lblSDT_KH = new JLabel("SỐ ĐIỆN THOẠI");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnWest.add(lblSDT_KH, c);

		txtSDT_KH = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnWest.add(txtSDT_KH, c);

		lblGioiTinh = new JLabel("GIỚI TÍNH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnWest.add(lblGioiTinh, c);

		cbbGioiTinh = new JComboBox<String>();
		cbbModel = new DefaultComboBoxModel<String>();
		cbbModel.addElement("NAM");  
		cbbModel.addElement("NỮ");  
		cbbGioiTinh.setModel(cbbModel);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnWest.add(cbbGioiTinh, c);

		lblCMND_KH = new JLabel("CMND_KH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnWest.add(lblCMND_KH, c);

		txtCMND_KH = new JTextField(15);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnWest.add(txtCMND_KH, c);

		lblNgaySinh = new JLabel("NGÀY SINH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 6;
		pnWest.add(lblNgaySinh, c);

		txtNgaySinh = new JTextField(15);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 6;
		pnWest.add(txtNgaySinh, c);

		c.weighty = 1;
		c.weightx = 1;

		pnWest.add(new JLabel(""), c);
		pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		add(pnWest, BorderLayout.WEST);
		jPanel.add(pnWest);

		pnCenter = new JPanel();
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Quản lý khách hàng"));

		String[] header = "MÃ, TÊN, QUỐC TỊCH, SĐT, GIỚI TÍNH, SỐ CMND, NGÀY SINH".split(",");
		tbKhachHangModel = new DefaultTableModel(header,0);
		tbQLKhachHang = new JTable(tbKhachHangModel);
		JScrollPane scroll = new JScrollPane(tbQLKhachHang);
		tbQLKhachHang.setDefaultEditor(Object.class, null); //KhÃ´ng cho sá»­a dá»¯ liáº¹u trÃªn báº£ng
		tbQLKhachHang.setRowHeight(20);
		tbQLKhachHang.setAutoCreateColumnsFromModel(rootPaneCheckingEnabled);

		scroll.getViewport().add(tbQLKhachHang);
		scroll.setPreferredSize(new Dimension(930,500));
		pnCenter.add(scroll);

		add(pnCenter, BorderLayout.CENTER);
		jPanel.add(pnCenter);

		pnSouth = new JPanel(new GridBagLayout());

		pnSouth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints cs= new GridBagConstraints();
		cs.anchor = GridBagConstraints.NORTHWEST;
		cs.fill = GridBagConstraints.HORIZONTAL;


		cs.fill = GridBagConstraints.HORIZONTAL;


		lblTimKiem = new JLabel("TÌM KIẾM");
		cs.insets = new Insets(5, 30, 5, 0);
		cs.gridx = 0;
		cs.gridy = 0;
		pnSouth.add(lblTimKiem, cs);

		txtTimKiem = new JTextField(15);
		cs.insets = new Insets(5, 5, 5, 30);
		cs.gridx = 1;
		cs.gridy = 0;
		pnSouth.add(txtTimKiem, cs);


		btnTimKiem = new JButton("TÌM KIẾM");
		cs.insets = new Insets(5, 5, 5, 0);
		cs.gridx = 2;
		cs.gridy = 0;
		pnSouth.add(btnTimKiem, cs);


		btnThem = new JButton("THÊM");
		cs.insets = new Insets(5, 5, 5, 30);
		cs.gridx = 3;
		cs.gridy = 0;
		pnSouth.add(btnThem, cs);

		btnXoa = new JButton("XÓA");
		cs.insets = new Insets(5, 5, 5, 30);
		cs.gridx = 4;
		cs.gridy = 0;
		pnSouth.add(btnXoa, cs);

		btnXoaTrang = new JButton("XÓA TRẮNG");
		cs.insets = new Insets(5, 5, 5, 30);
		cs.gridx = 5;
		cs.gridy = 0;
		pnSouth.add(btnXoaTrang, cs);



		cs.weighty = 1;
		cs.weightx = 1;

		add(pnSouth, BorderLayout.SOUTH);
		jPanel.add(pnSouth);
		
		tabbedPane.addTab("QUẢN LÝ KHÁCH HÀNG", jPanel);
		
		frmKH.getContentPane( ).add(tabbedPane);
	    frmKH.setVisible(true);
		
		LoadDatabase();
		txtTimKiem.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if(txtTimKiem.getText().trim().length() == 0) {
					try {
						LoadDatabase();
						ClearAll();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				if(txtTimKiem.getText().trim().length() == 0) {
					try {
						LoadDatabase();
						ClearAll();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

				if(txtTimKiem.getText().trim().length() == 0) {
					try {
						LoadDatabase();
						ClearAll();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});


		tbQLKhachHang.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {


			}

			@Override
			public void mousePressed(MouseEvent e) {

				int rowClicked = tbQLKhachHang.getSelectedRow();
				txtMaKH.setText(tbKhachHangModel.getValueAt(rowClicked, 0).toString());
				//				txtMaPhong.setText(tbKhachHangModel.getValueAt(rowClicked, 1).toString());
				txtTenKH.setText(tbKhachHangModel.getValueAt(rowClicked, 1).toString());
				txtQuocTich.setText(tbKhachHangModel.getValueAt(rowClicked, 2).toString());
				txtCMND_KH.setText(tbKhachHangModel.getValueAt(rowClicked, 3).toString());
				Object gender = tbKhachHangModel.getValueAt(rowClicked, 4).toString();
				cbbGioiTinh.setSelectedItem(gender);
				txtSDT_KH.setText(tbKhachHangModel.getValueAt(rowClicked, 5).toString());
				txtNgaySinh.setText(tbKhachHangModel.getValueAt(rowClicked, 6).toString());

			}

			@Override
			public void mouseExited(MouseEvent e) {


			}

			@Override
			public void mouseEntered(MouseEvent e) {


			}

			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});




		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

								if(validData() == true) {
				String maKhachHang = txtMaKH.getText();
				String tenKhachHang = txtTenKH.getText();
				String quocTich = txtQuocTich.getText();
				int soDienThoai = Integer.parseInt(txtSDT_KH.getText());
				String gioiTinh = cbbModel.getSelectedItem().toString();
				int CMND_KH = Integer.parseInt(txtCMND_KH.getText());
				String ngaySinh = txtNgaySinh.getText();		
				String sodienthoai1 = txtSDT_KH.getText();
				String cmnd = txtCMND_KH.getText();

				try {
					if(list.addData(maKhachHang,  tenKhachHang, quocTich,  soDienThoai,  gioiTinh,  CMND_KH,  ngaySinh) == true) {

						String data []= {maKhachHang,  tenKhachHang, quocTich,  sodienthoai1,  gioiTinh,  cmnd,  ngaySinh}; 
						tbKhachHangModel.addRow(data);
						tbQLKhachHang.setModel(tbKhachHangModel);
					}
					else {
						JOptionPane.showMessageDialog(null, "THÊM THÔNG TIN BỊ THẤT BẠI.");
					}
				} catch (HeadlessException | SQLException e1) {

						JOptionPane.showMessageDialog(null, "MÃ KHÁCH HÀNG ĐÃ TỒN TẠI !");
//					 e1.printStackTrace();
				}


								}else {
				return;
								}

			}

			//			private void reloadComboBox() {
			//
			//			}
		});


		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ClearAll();
			}
		});


		btnXoa.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String maKhachHang = txtMaKH.getText();
						int ret=JOptionPane.showConfirmDialog(null,
								"Bạn muốn xoá khách hàng này?", "Xoá",
								JOptionPane.YES_NO_OPTION);
						if(ret==JOptionPane.YES_OPTION) {	
						try {
							list.Remove(maKhachHang);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							LoadDatabase();
							ClearAll();
							//lblsoLuongNV.setText("Số lượng nhân viên: "+ list.getSize());
							
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Không thể xoá khách hàng !");
		//					ex.printStackTrace();
							
						}
						
						}
						else {
							return;
						}
					}
				});



//				btnSua.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						int ret=JOptionPane.showConfirmDialog(null,
//								"Bạn muốn sửa khách hàng này?", "Sửa",
//								JOptionPane.YES_NO_OPTION);
//						if(ret==JOptionPane.YES_OPTION) {	
//							if(validData() == true) {
//								int rowClicked = tbQLKhachHang.getSelectedRow();
//		
//		
//								String maKhachHang = txtMaKH.getText();
//								String tenKhachHang = txtTenKH.getText();
//								String quocTich = txtQuocTich.getText();
//								int soDienThoai = Integer.parseInt(txtSDT_KH.getText());
////								String gioiTinhTemp[] = cbbGioiTinh.getSelectedItem().toString().split("-");
//								String gioiTinh = cbbModel.getSelectedItem().toString();
//								int cMND_KH = Integer.parseInt(txtCMND_KH.getText());
//								String ngaySinh = txtNgaySinh.getText();
//								//		    	    String diaChi = txtdiaChi.getText();
//								//		    	    String maPBtemp[] = cbbModelPhongBan.getSelectedItem().toString().split("-");
//								//		    	    int maPB = Integer.parseInt(maPBtemp[0].trim());
//								ThongTinKhachHang kh = new ThongTinKhachHang(maKhachHang, tenKhachHang, ngaySinh, cMND_KH, gioiTinh, soDienThoai, quocTich);
//								try {
//									if(list.editElement(maKhachHang, kh) == true) {
//										JOptionPane.showMessageDialog(null, "Sửa thành công");
//										LoadDatabase();
//										tbQLKhachHang.setRowSelectionInterval(rowClicked, rowClicked);
//									}else {
//										JOptionPane.showMessageDialog(null, "Không được sửa mã khách hàng");
//										txtMaKH.selectAll();
//										txtMaKH.requestFocus();
//									}
//								} catch (SQLException e1) {
//									JOptionPane.showMessageDialog(null, "MÃ KHÁCH HÀNG KHÔNG TỒN TẠI !");
//									//e1.printStackTrace();
//								}
//							}
//							return;
//						}
//					}
//				});

		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Search();
				ClearAll();
			}
		});


	}	
	public void ClearAll() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtNgaySinh.setText("");
		txtCMND_KH.setText("");
		cbbGioiTinh.setSelectedItem("Nam");
		txtSDT_KH.setText("");
		txtQuocTich.setText("");
	}

	public void LoadDatabase() throws SQLException {
		tbKhachHangModel.setRowCount(0);
		list.LoadData();

		ArrayList arrRows = new ArrayList();

		for(int i = 0; i < list.getSize(); i++) {
			ThongTinKhachHang kh = list.getElement(i);
			//			tbKhachHangModel.addRow(kh.toString().split(","));

			arrRows.add(list.getElement(i).getMaKhachHang());
			arrRows.add(list.getElement(i).getTenKhachHang());
			arrRows.add(list.getElement(i).getQuocTich());
			arrRows.add(list.getElement(i).getSoDienThoai());
			arrRows.add(list.getElement(i).getGioiTinh());
			arrRows.add(list.getElement(i).getCMND_KH());
			arrRows.add(list.getElement(i).getNgaySihn());


			tbKhachHangModel.addRow(arrRows.toArray());
			arrRows.clear();
		}
		tbKhachHangModel.addRow(arrRows.toArray());

	}

	public boolean validData() {
		String maKhachHang = txtMaKH.getText().trim();
		String tenKhachHang = txtTenKH.getText().trim();
		String quocTich = txtQuocTich.getText().trim();
		String ngaySinh = txtNgaySinh.getText().trim();
		String cMND_KH = txtCMND_KH.getText().trim();
		String gioiTinhTemp[] = cbbGioiTinh.getSelectedItem().toString().trim().split("-");
		String soDienThoai_KH = txtSDT_KH.getText().trim();

		if(maKhachHang.length() > 0){
			try {
				String maKhachHang1 = txtMaKH.getText();
				if(maKhachHang1.length() <= 0) {
					JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG HỢP LỆ.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN NHẬP KHÔNG ĐÚNG CÚ PHÁP !.");
				return false;
			}
		}

		if(maKhachHang.length() == 0) {
			JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(tenKhachHang.length() == 0) {
						JOptionPane.showMessageDialog(null, "TÊN KHÁCH HÀNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
						return false;
		}
		
		if(quocTich.length() == 0) {
			JOptionPane.showMessageDialog(null, "QUỐC TỊCH KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}
		
		
		if(!(soDienThoai_KH.length() > 0 )){
			try {
				int x = Integer.parseInt(soDienThoai_KH);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC NHẬP SỐ ÂM.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC NHẬP SỐ.");
				return false;
			}
		}

		if(soDienThoai_KH.length() == 0) {
			JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}
		if(!(soDienThoai_KH.length() > 0 && soDienThoai_KH.matches("^(03|07|08|09|01[2|6|8|9])+([0-9]{8})\\b$"))){
			JOptionPane.showMessageDialog(this, "SỐ  ĐIỆN THOẠI KHÔNG ĐÚNG CÚ PHÁP ! VUI LÒNG NHẬP LẠI.");
			return false;
		}
		


		if(!(cMND_KH.length() > 0 )){
			try {
				int x = Integer.parseInt(cMND_KH);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC NHẬP SỐ ÂM.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC NHẬP CHỮ.");
				return false;
			}
		}

		if(cMND_KH.length() == 0) {
			JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(!(ngaySinh.length() > 0 && ngaySinh.matches("(([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4})"))){
			JOptionPane.showMessageDialog(this, "NGÀY SINH PHẢI THEO CÚ PHÁP: DD/MM/YYYY.");
			return false;
		}

		return true;
	}


	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				String maKhachHang = String.valueOf(str);
				ThongTinKhachHang kh = list.search(maKhachHang);
				if(kh != null) {
					tbKhachHangModel.setRowCount(0);
					tbKhachHangModel.addRow(kh.toString().split(","));
				}
				else {
					JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY MÃ NHÂN VIÊN CẦN TÌM.");
					
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "DỮ LIỆU KHÔNG HỢP LỆ.");
				txtTimKiem.selectAll();
				txtTimKiem.requestFocus();
				//ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws SQLException {
		new FormKhachHang();		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

