package DanhMuc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import KhachHang.ThongTinKhachHang;
import QuanLyPhong.ThongTinPhong;
import QuanLyPhong.listQuanLyPhong;

public class FormQuanLyPhong extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel pnNorth, pnCenter, pnSouth, pnWest;
	private JLabel lblMaPhong, lblMaTrangThai, lblTenPhong, lblLoaiPhong, lblmaDichVu, lblTinhTrangPhong, lblGiaPhong;
	private JTextField txtMaPhong, txtMaTrangThai, txtTenPhong, txtmaDichVu, txtTinhTrangPhong;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JLabel lblTitle, lblTimKiem;
	private JTextField txtTimKiem;
	private JTable tbQuanLyPhong;
	private listQuanLyPhong list;
	private JComboBox<String> cbbGioiTinh, cbbGiaPhong;
	private DefaultComboBoxModel cbbModel, cbbModele;
	private DefaultComboBoxModel<String> cbbModelGioiTinh, cbbModelChucVu;
	private DefaultTableModel tbQuanLyPhongModel;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuNhanVien, menuQLPhong, menuDichVu, menuKhachHang, menuHoaDon, menuTrangChu, menuDatPHong, menuTrangThaiPhong;
	private JMenuItem itemTrangChu, itemNhanVien, itemQLPhong, itemDichVu;
	private JMenuItem itemKhachHang, itemHoaDon, itemTrangThaiPhong, itemDatPHong;

	public FormQuanLyPhong() throws SQLException{

		list = new listQuanLyPhong();

		menuTrangChu = new JMenu("TRANG CHỦ");


		menuNhanVien = new JMenu("QUẢN LÝ NHÂN VIÊN");

		menuQLPhong = new JMenu("QUẢN LÝ PHÒNG");

		menuDichVu = new JMenu("QUẢN LÝ DỊCH VỤ");

		menuKhachHang = new JMenu("QUẢN LÝ KHÁCH HÀNG");

		menuHoaDon = new JMenu("QUẢN LÝ HÓA ĐƠN");

		menuTrangThaiPhong = new JMenu("TRẠNG THÁI PHÒNG");

		menuDatPHong = new JMenu("ĐẶT PHÒNG");

		menubar.add(menuTrangChu).addActionListener(this);;
		menubar.add(menuQLPhong).addActionListener(this);;
		menubar.add(menuNhanVien).addActionListener(this);;
		menubar.add(menuDichVu).addActionListener(this);;
		menubar.add(menuKhachHang).addActionListener(this);;
		menubar.add(menuHoaDon).addActionListener(this);;
		menubar.add(menuTrangThaiPhong).addActionListener(this);;
		menubar.add(menuDatPHong).addActionListener(this);;

		setJMenuBar(menubar);

		menuTrangChu.add(itemTrangChu = new JMenuItem("Trang Chủ"));

		pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("QUẢN LÝ PHÒNG"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		add(pnNorth, BorderLayout.NORTH);

		pnWest = new JPanel(new GridBagLayout());

		pnWest.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;

		lblMaPhong = new JLabel("MÃ PHÒNG");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnWest.add(lblMaPhong, c);

		txtMaPhong = new JTextField();
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnWest.add(txtMaPhong, c);

		lblMaTrangThai = new JLabel("MÃ TRẠNG THÁI");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnWest.add(lblMaTrangThai, c);

		txtMaTrangThai = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnWest.add(txtMaTrangThai, c);

		lblTenPhong = new JLabel("TÊN PHÒNG");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnWest.add(lblTenPhong, c);

		txtTenPhong = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnWest.add(txtTenPhong, c);

		lblGiaPhong = new JLabel("GIÁ PHÒNG");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnWest.add(lblGiaPhong, c);

		JComboBox<String> cbbGiaPhong = new JComboBox<String>();
		DefaultComboBoxModel<String> cbbModel = new DefaultComboBoxModel<String>();
		cbbModel.addElement("GIÁ THEO GIỜ");  
		cbbModel.addElement("GIÁ THEO NGÀY"); 
		cbbGiaPhong.setModel(cbbModel);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnWest.add(cbbGiaPhong, c);

		lblLoaiPhong = new JLabel("LOẠI PHÒNG");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnWest.add(lblLoaiPhong, c);

		JComboBox<String> cbbGioiTinh = new JComboBox<String>();
		DefaultComboBoxModel<String> cbbModele = new DefaultComboBoxModel<String>();
		cbbModele.addElement("PHÒNG 1 GIƯỜNG");  
		cbbModele.addElement("PHÒNG 2 GIƯỜNG"); 
		cbbModele.addElement("PHÒNG 3 GIƯỜNG"); 
		cbbGioiTinh.setModel(cbbModele);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnWest.add(cbbGioiTinh, c);

		lblmaDichVu = new JLabel("MÃ DỊCH VỤ");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnWest.add(lblmaDichVu, c);

		txtmaDichVu = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnWest.add(txtmaDichVu, c);

		lblTinhTrangPhong = new JLabel("TÌNH TRẠNG PHÒNG");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 6;
		pnWest.add(lblTinhTrangPhong, c);

		txtTinhTrangPhong = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 6;
		pnWest.add(txtTinhTrangPhong, c);

		c.weighty = 1;
		c.weightx = 1;

		pnWest.add(new JLabel(""), c);
		pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		add(pnWest, BorderLayout.WEST);

		pnCenter = new JPanel();
		//		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Quản lý phòng"));

		String[] header = "MÃ PHÒNG, MÃ TRẠNG THÁI,TÊN PHÒNG, GIÁ PHÒNG, LOẠI PHÒNG, MÃ DỊCH VỤ, TÌNH TRẠNG".split(",");
		tbQuanLyPhongModel = new DefaultTableModel(header,0);
		tbQuanLyPhong = new JTable(tbQuanLyPhongModel);
		JScrollPane scroll = new JScrollPane(tbQuanLyPhong);
		tbQuanLyPhong.setDefaultEditor(Object.class, null); //KhÃ´ng cho sá»­a dá»¯ liáº¹u trÃªn báº£ng
		tbQuanLyPhong.setRowHeight(25);
		tbQuanLyPhong.setAutoCreateColumnsFromModel(rootPaneCheckingEnabled);

		scroll.getViewport().add(tbQuanLyPhong);
		scroll.setPreferredSize(new Dimension(930,480));
		pnCenter.add(scroll);

		add(pnCenter, BorderLayout.CENTER);

		pnSouth = new JPanel(new GridBagLayout());
		pnSouth.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		//		pnSouth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
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


		tbQuanLyPhong.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {


			}

			@Override
			public void mousePressed(MouseEvent e) {

				int rowClicked = tbQuanLyPhong.getSelectedRow();
				
				txtMaPhong.setText(tbQuanLyPhongModel.getValueAt(rowClicked, 0).toString());
				txtMaTrangThai.setText(tbQuanLyPhongModel.getValueAt(rowClicked, 1).toString());
				txtTenPhong.setText(tbQuanLyPhongModel.getValueAt(rowClicked, 2).toString());
				Object genderPhong = tbQuanLyPhongModel.getValueAt(rowClicked, 3).toString();
				cbbGiaPhong.setSelectedItem(genderPhong);				
				Object gender = tbQuanLyPhongModel.getValueAt(rowClicked, 4).toString();
				cbbGioiTinh.setSelectedItem(gender);
				txtmaDichVu.setText(tbQuanLyPhongModel.getValueAt(rowClicked, 5).toString());
				txtTinhTrangPhong.setText(tbQuanLyPhongModel.getValueAt(rowClicked, 6).toString());
		

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
					String maPhong = txtMaPhong.getText();
					String maTrangThai = txtMaTrangThai.getText();
					String tenPhong = txtTenPhong.getText();
					String giaPhong = cbbGiaPhong.getSelectedItem().toString();
					String loaiPhong = cbbGioiTinh.getSelectedItem().toString();
					String maDichVu = txtmaDichVu.getText();
					String tinhTrangPhong = txtTinhTrangPhong.getText();

					try {
						if(list.addData(maPhong,  maTrangThai, tenPhong,  giaPhong,  loaiPhong,  maDichVu,  tinhTrangPhong) == true) {

							String data []= {maPhong,  maTrangThai, tenPhong,  giaPhong,  loaiPhong,  maDichVu,  tinhTrangPhong}; 
							tbQuanLyPhongModel.addRow(data);
							tbQuanLyPhong.setModel(tbQuanLyPhongModel);
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

				String maPhong = txtMaPhong.getText();
				int ret=JOptionPane.showConfirmDialog(null,
						"Bạn muốn xoá phòng này?", "Xoá",
						JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION) {	
					try {
						list.Remove(maPhong);
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
		txtMaPhong.setText("");
		txtMaTrangThai.setText("");
		txtTenPhong.setText("");
		cbbGiaPhong.setSelectedItem("....");
		cbbGioiTinh.setSelectedItem("....");
		txtmaDichVu.setText("");
		txtTinhTrangPhong.setText("");
	}



	///////////////////////////////////////////////////////



	public void LoadDatabase() throws SQLException {
		tbQuanLyPhongModel.setRowCount(0);
		list.LoadData();

		ArrayList arrRows = new ArrayList();

		for(int i = 0; i < list.getSize(); i++) {
			ThongTinPhong phong = list.getElement(i);
			//			tbKhachHangModel.addRow(kh.toString().split(","));

			arrRows.add(list.getElement(i).getMaPhong());
			arrRows.add(list.getElement(i).getMaTrangThai());
			arrRows.add(list.getElement(i).getTenPhong());
			arrRows.add(list.getElement(i).getGiaPhong());
			arrRows.add(list.getElement(i).getLoaiPhong());
			arrRows.add(list.getElement(i).getMaDichVu());
			arrRows.add(list.getElement(i).getTinhTrangPhong());


			tbQuanLyPhongModel.addRow(arrRows.toArray());
			arrRows.clear();
		}
		tbQuanLyPhongModel.addRow(arrRows.toArray());

	}

	public boolean validData() {
		String maPhong = txtMaPhong.getText().trim();
		String maTrangThai = txtMaTrangThai.getText().trim();
		String tenPhong = txtTenPhong.getText().trim();
		String giaPhongTemp[] = cbbGiaPhong.getSelectedItem().toString().trim().split("-");
		String loaiPhongTemp[] = cbbGioiTinh.getSelectedItem().toString().trim().split("-");
		String maDichVu = txtmaDichVu.getText().trim();
		String tinhTrangPhong = txtTinhTrangPhong.getText().trim();

		if(maPhong.length() > 0){
			try {
				String maKhachHang1 = txtMaPhong.getText();
				if(maKhachHang1.length() <= 0) {
					JOptionPane.showMessageDialog(null, "MÃ PHÒNG KHÔNG HỢP LỆ.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "MÃ PHÒNG NHẬP KHÔNG ĐÚNG CÚ PHÁP !.");
				return false;
			}
		}

		if(maPhong.length() == 0) {
			JOptionPane.showMessageDialog(null, "MÃ PHÒNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(maTrangThai.length() == 0) {
			JOptionPane.showMessageDialog(null, "MÃ TRẠNG THÁI KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(tenPhong.length() == 0) {
			JOptionPane.showMessageDialog(null, "TÊN PHÒNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(maDichVu.length() == 0) {
			JOptionPane.showMessageDialog(null, "MÃ DỊCH VỤ KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(tinhTrangPhong.length() == 0) {
			JOptionPane.showMessageDialog(null, "TÌNH TRẠNG PHÒNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}
		return true;
	}


	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				String maPhong = String.valueOf(str);
				ThongTinPhong kh = list.search(maPhong);
				if(kh != null) {
					tbQuanLyPhongModel.setRowCount(0);
					tbQuanLyPhongModel.addRow(kh.toString().split(","));
				}
				else {
					JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY MÃ PHÒNG CẦN TÌM.");

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
	new FormQuanLyPhong();
	FormQuanLyPhong frmQLP = new FormQuanLyPhong();
	frmQLP.setTitle("HỆ THỐNG QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
	frmQLP.setVisible(true);
	frmQLP.setLocationRelativeTo(null);
	frmQLP.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frmQLP.setBounds(0, 0, 1300, 680);
	//		frmQLP.setSize(1300, 680);
	//frmQLP.setResizable(false);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

}

}

