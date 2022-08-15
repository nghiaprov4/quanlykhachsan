package DanhMuc;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.SQLException;

import java.util.*;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import NhanVien.ThongTinNhanVien;
import NhanVien.listNhanVien;
import SoDoPhong.FormTrangThaiPhong;

public class FormNhanVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final int String = 0;
	private JPanel pnNorth, pnCenter, pnSouth, pnWest;
	private JLabel lblMaNV, lblTenNV, lblNgaySinh, lblNgayVaoLam, lblCMND_NV, lblGioiTinh, lblDiaChi, lblSDT_NV, lblChucVu;
	private JTextField txtMaNV, txtTenNV, txtNgaySinh, txtNgayVaoLam, txtCMND_NV, txtDiaChi, txtSDT_NV;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JComboBox<String> cbbGioiTinh, cbbChucVu;
	private DefaultComboBoxModel cbbModel, cbbModele;
	private DefaultComboBoxModel<String> cbbModelGioiTinh, cbbModelChucVu;
	private JLabel lblTitle, lblTimKiem, lblTenDangNhap, lblMatKhau;
	private JTextField txtTimKiem, txtTenDangNhap, txtMatKhau;
	private JTable tbThemNhanVien;
	private DefaultTableModel tbNhanVienModel;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuNhanVien, menuQLPhong, menuDichVu, menuKhachHang, menuHoaDon, menuTrangChu, menuDatPHong, menuTrangThaiPhong;
	protected JComboBox<String> cbbGender;
	//	protected java.lang.String diaChi;
	private listNhanVien list;

	public FormNhanVien() throws SQLException{

		list = new listNhanVien();

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

		pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		add(pnNorth, BorderLayout.NORTH);

		pnWest = new JPanel(new GridBagLayout());

		pnWest.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;

		lblMaNV = new JLabel("MÃ NHÂN VIÊN");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnWest.add(lblMaNV, c);

		txtMaNV = new JTextField();
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnWest.add(txtMaNV, c);

		lblTenNV = new JLabel("TÊN NHÂN VIÊN");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnWest.add(lblTenNV, c);

		txtTenNV = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnWest.add(txtTenNV, c);

		lblNgaySinh = new JLabel("NGÀY SINH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnWest.add(lblNgaySinh, c);

		txtNgaySinh = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnWest.add(txtNgaySinh, c);

		lblGioiTinh = new JLabel("GIỚI TÍNH");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnWest.add(lblGioiTinh, c);

		JComboBox<String> cbbGioiTinh = new JComboBox<String>();
		DefaultComboBoxModel<String> cbbModel = new DefaultComboBoxModel<String>();
		cbbModel.addElement("NAM");  
		cbbModel.addElement("NỮ");  
		cbbGioiTinh.setModel(cbbModel);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnWest.add(cbbGioiTinh, c);

//		lblNgayVaoLam = new JLabel("NGÀY VÀO LÀM");
//		c.insets = new Insets(5, 30, 5, 0);
//		c.gridx = 0;
//		c.gridy = 4;
//		pnWest.add(lblNgayVaoLam, c);
//
//		txtNgayVaoLam = new JTextField();
//		c.insets = new Insets(5, 5, 5, 30);
//		c.gridx = 1;
//		c.gridy = 4;
//		pnWest.add(txtNgayVaoLam, c);

		lblCMND_NV = new JLabel("SỐ CMND");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnWest.add(lblCMND_NV, c);

		txtCMND_NV = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnWest.add(txtCMND_NV, c);

		lblSDT_NV = new JLabel("SỐ ĐIỆN THOẠI");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnWest.add(lblSDT_NV, c);

		txtSDT_NV = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnWest.add(txtSDT_NV, c);

		lblDiaChi = new JLabel("ĐỊA CHỈ");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 6;
		pnWest.add(lblDiaChi, c);

		txtDiaChi = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 6;
		pnWest.add(txtDiaChi, c);

		lblChucVu = new JLabel("CHỨC VỤ");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 7;
		pnWest.add(lblChucVu, c);

		JComboBox<String> cbbChucVu = new JComboBox<String>();
		DefaultComboBoxModel<String> cbbModele = new DefaultComboBoxModel<String>();
		cbbModele.addElement("QUẢN LÝ");  
		cbbModele.addElement("NHÂN VIÊN LỄ TÂN");  
		cbbChucVu.setModel(cbbModele);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 7;
		pnWest.add(cbbChucVu, c);


		lblTenDangNhap = new JLabel("TÊN ĐĂNG NHẬP");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 8;
		pnWest.add(lblTenDangNhap, c);

		txtTenDangNhap = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 8;
		pnWest.add(txtTenDangNhap, c);


		lblMatKhau = new JLabel("MẬT KHẨU");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 9;
		pnWest.add(lblMatKhau, c);

		txtMatKhau = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 9;
		pnWest.add(txtMatKhau, c);


		c.weighty = 1;
		c.weightx = 1;

		pnWest.add(new JLabel(""), c);
		pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));
		add(pnWest, BorderLayout.WEST);

		pnCenter = new JPanel();
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Quản lý nhân viên"));

		String[] header = "MÃ, HỌ, TÊN, NGÀY SINH, GIỚI TÍNH, NGÀY VÀO LÀM, SỐ CMND, SĐT, ĐỊA CHỈ, CHỨC VỤ, GHI CHÚ".split(",");
		tbNhanVienModel = new DefaultTableModel(header,0);
		tbThemNhanVien = new JTable(tbNhanVienModel);
		JScrollPane scroll = new JScrollPane(tbThemNhanVien);
		tbThemNhanVien.setDefaultEditor(Object.class, null); //KhÃ´ng cho sá»­a dá»¯ liáº¹u trÃªn báº£ng
		tbThemNhanVien.setRowHeight(30);
		tbThemNhanVien.setAutoCreateColumnsFromModel(rootPaneCheckingEnabled);

		scroll.getViewport().add(tbThemNhanVien);
		scroll.setPreferredSize(new Dimension(950,500));
		pnCenter.add(scroll);

		add(pnCenter, BorderLayout.CENTER);

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


		tbThemNhanVien.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {


			}

			@Override
			public void mousePressed(MouseEvent e) {

				int rowClicked = tbThemNhanVien.getSelectedRow();
				txtMaNV.setText(tbNhanVienModel.getValueAt(rowClicked, 0).toString());
				txtTenNV.setText(tbNhanVienModel.getValueAt(rowClicked, 1).toString());
				txtNgaySinh.setText(tbNhanVienModel.getValueAt(rowClicked, 2).toString());
				Object gender = tbNhanVienModel.getValueAt(rowClicked, 4).toString();
				cbbGioiTinh.setSelectedItem(gender);
				txtCMND_NV.setText(tbNhanVienModel.getValueAt(rowClicked, 5).toString());
				txtSDT_NV.setText(tbNhanVienModel.getValueAt(rowClicked, 6).toString());
				txtDiaChi.setText(tbNhanVienModel.getValueAt(rowClicked, 7).toString());
				Object chucVu = tbNhanVienModel.getValueAt(rowClicked, 8).toString();
				cbbChucVu.setSelectedItem(chucVu);
				txtTenDangNhap.setText(tbNhanVienModel.getValueAt(rowClicked, 9).toString());
				txtMatKhau.setText(tbNhanVienModel.getValueAt(rowClicked, 10).toString());


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
				String maNhanVien = txtMaNV.getText();
				String tenNhanVien = txtTenNV.getText();
				String ngaySinh = txtNgaySinh.getText();
				String gioiTinh = cbbModel.getSelectedItem().toString();
				int CMND_NV = Integer.parseInt(txtCMND_NV.getText());
				String cmnd_nv = txtCMND_NV.getText();
				int soDienThoai_NV = Integer.parseInt(txtSDT_NV.getText());
				String sdt = txtSDT_NV.getText();
				String diaChi = txtDiaChi.getText();
				String chucVu = cbbModele.getSelectedItem().toString();
				String tenDN = txtTenDangNhap.getText().toString();
				String matKhau = txtMatKhau.getText().toString();

				try {
					if(list.addData(maNhanVien,  tenNhanVien, ngaySinh,  gioiTinh,  CMND_NV,  soDienThoai_NV,  diaChi, chucVu, tenDN, matKhau) == true) {

						String data []= {maNhanVien,  tenNhanVien, ngaySinh,  gioiTinh,  cmnd_nv,  sdt,  diaChi, chucVu, tenDN, matKhau}; 
						tbNhanVienModel.addRow(data);
						tbThemNhanVien.setModel(tbNhanVienModel);
					}
					else {
						JOptionPane.showMessageDialog(null, "THÊM THÔNG TIN BỊ THẤT BẠI.");
					}
				} catch (HeadlessException | SQLException e1) {

						JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN ĐÃ TỒN TẠI !");
//					 e1.printStackTrace();
				}


								}else {
				return;
								}

			}
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
				
				String maNhanVien = txtMaNV.getText();
				int ret=JOptionPane.showConfirmDialog(null,
						"Bạn muốn xoá nhân viên này?", "Xoá",
						JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION) {	
				try {
					list.Remove(maNhanVien);
					JOptionPane.showMessageDialog(null, "Xoá thành công");
					LoadDatabase();
					ClearAll();
					//lblsoLuongNV.setText("Số lượng nhân viên: "+ list.getSize());
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Không thể xoá nhân viên !");
//					ex.printStackTrace();
					
				}
				
				}
				else {
					return;
				}
			}
		});
		
		
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Search();
				ClearAll();
			}
		});
	}	
	public void ClearAll() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtNgaySinh.setText("");
		cbbGioiTinh.setSelectedItem("Nam");
		txtCMND_NV.setText("");
		txtSDT_NV.setText("");
		txtDiaChi.setText("");
		cbbChucVu.setSelectedItem("Nhân viên");
		txtMatKhau.setText("");
		txtTenDangNhap.setText("");
	}


	public void LoadDatabase() throws SQLException {
		tbNhanVienModel.setRowCount(0);
		list.LoadData();
		
		ArrayList arrRows = new ArrayList();
		for(int i = 0; i < list.getSize(); i++) {
			ThongTinNhanVien nv = list.getElement(i);
//			tbNhanVienModel.addRow(nv.toString().split(";"));
			arrRows.add(list.getElement(i).getMaNhanVien());
			arrRows.add(list.getElement(i).getTenNhanVien());
			arrRows.add(list.getElement(i).getNgaySinh());
			arrRows.add(list.getElement(i).getGioiTinh());
			arrRows.add(list.getElement(i).getCMND_NV());
			arrRows.add(list.getElement(i).getSoDienThoai_NV());
			arrRows.add(list.getElement(i).getDiaChi());
			arrRows.add(list.getElement(i).getChucVu());
			arrRows.add(list.getElement(i).getTenDangNhap());
			arrRows.add(list.getElement(i).getMatKhau());


			tbNhanVienModel.addRow(arrRows.toArray());
			arrRows.clear();
		}
		tbNhanVienModel.addRow(arrRows.toArray());
	}

	//		private void reloadComboBox() throws SQLException {
	//			list.LoadDataDangNhap();
	//			cbbModelPhongBan = new DefaultComboBoxModel();
	//			int maPB;
	//			String tenPB;
	//			cbbModelPhongBan.addElement("...");
	//		    for(int i = 0; i < list.getSizeDataMaPhongBan(); i++) {
	//		    	 maPB = list.getPhongBanElement(i).getMaPB();
	//		    	 tenPB = list.getPhongBanElement(i).getTenPB();
	//		    	 cbbModelPhongBan.addElement(maPB + " - " + tenPB);    
	//		     }
	//	         cbbPhongBan.setModel(cbbModelPhongBan);
	//		 }

	public boolean validData() {
		String maNhanVien = txtMaNV.getText().trim();
		String tenNhanVien = txtTenNV.getText().trim();
		String ngaySinh = txtNgaySinh.getText().trim();
		String gioiTinhTemp[] = cbbGioiTinh.getSelectedItem().toString().trim().split("-");
		String cMND_NV = txtCMND_NV.getText().trim();
		String soDienThoai_NV = txtSDT_NV.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String chucvuTemp[] = cbbChucVu.getSelectedItem().toString().trim().split("-");
		String tenDangNhap = txtTenDangNhap.getText().trim();
		String matkhau = txtMatKhau.getText().trim();

		if(maNhanVien.length() > 0){
			try {
				String maNhanVien1 = txtMaNV.getText();
				if(maNhanVien1.length() <= 0) {
					JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG HỢP LỆ.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN NHẬP KHÔNG ĐÚNG CÚ PHÁP !.");
				return false;
			}
		}

		if(maNhanVien.length() == 0) {
			JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(!(tenNhanVien.length()== 0)){
			JOptionPane.showMessageDialog(this, "TÊN NHÂN VIÊN KHÔNG ĐƯỢC ĐỂ TRỐNG ! VUI LÒNG NHẬP LẠI.");
			return false;
		}

		if(!(ngaySinh.length() > 0 && ngaySinh.matches("([0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4})"))){
			JOptionPane.showMessageDialog(this, "NGÀY SINH PHẢI THEO CÚ PHÁP: DD/MM/YYYY.");
			return false;
		}
		if(!(diaChi.length() > 0 && diaChi.matches("^([a-zA-Z0-9/.,-]\\s*)*[a-zA-Z0-9]$"))){
			JOptionPane.showMessageDialog(this, "ĐỊA CHỈ KHÔNG ĐƯỢC ĐỂ TRỐNG ! VUI LÒNG ĐIỀN THÔNG TIN ĐỊA CHỈ NHÂN VIÊN.");
			return false;
		}


		if(!(cMND_NV.length() > 0 )){
			try {
				int x = Integer.parseInt(cMND_NV);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC NHẬP SỐ ÂM.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC NHẬP CHỮ.");
				return false;
			}
		}

		if(cMND_NV.length() == 0) {
			JOptionPane.showMessageDialog(null, "CHỨNG MINH NHÂN DÂN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(!(soDienThoai_NV.length() > 0 )){
			try {
				int x = Integer.parseInt(soDienThoai_NV);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC NHẬP SỐ ÂM.");
					return false;
				}
			}catch (Exception e) {

				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC NHẬP SỐ.");
				return false;
			}
		}

		if(soDienThoai_NV.length() == 0) {
			JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}
		if(!(soDienThoai_NV.length() > 0 && soDienThoai_NV.matches("^(03|07|08|09|01[2|6|8|9])+([0-9]{8})\\b$"))){
			JOptionPane.showMessageDialog(this, "SỐ  ĐIỆN THOẠI KHÔNG ĐÚNG CÚ PHÁP ! VUI LÒNG NHẬP LẠI.");
			return false;
		}

		if(!(diaChi.length() > 0 && diaChi.matches("^([0-9A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ']+\\\\s?\\\\b){2,}$"))){
			JOptionPane.showMessageDialog(this, "ĐỊA CHỈ NHẬP SAI CÚ PHÁP ! VUI LÒNG NHẬP LẠI.");
			return false;
		}

		if(diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "ĐỊA CHỈ KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(!(tenDangNhap.length() > 0 && tenDangNhap.matches("^[a-zA-Z\\-]+$"))){
			JOptionPane.showMessageDialog(this, "TÊN ĐĂNG NHẬP SAI CÚ PHÁP ! VUI LÒNG NHẬP LẠI.");
			return false;
		}

		if(tenDangNhap.length() == 0) {
			JOptionPane.showMessageDialog(null, "TÊN ĐĂNG NHẬP KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		if(!(matkhau.length() > 0 && matkhau.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8})$"))){
			JOptionPane.showMessageDialog(this, "MẬT KHẨU SAI CÚ PHÁP ! VUI LÒNG NHẬP LẠI.");
			return false;
		}

		if(matkhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "MẬT KHẨU KHÔNG ĐƯỢC ĐỂ TRỐNG.");
			return false;
		}

		return true;
	}


	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				Integer maNhanVien = Integer.parseInt(str);
				ThongTinNhanVien nv = list.search(maNhanVien);
				if(nv != null) {
					tbNhanVienModel.setRowCount(0);
					tbNhanVienModel.addRow(nv.toString().split(","));
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


	public void actionPerformed1(ActionEvent e) {

		Object o = e.getSource();
		if(o.equals(menuTrangChu)) {
			try {
				new FormTrangChu_NV().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(o.equals(menuTrangChu)) {
			try {
				new FormTrangChu_QL().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(o.equals(menuQLPhong)) {
			try {
				new FormQuanLyPhong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(o.equals(menuNhanVien)) {
			try {
				new FormNhanVien().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(o.equals(menuDichVu)) {
			try {
				new FormDichVu().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(o.equals(menuKhachHang)) {
			try {
				new FormKhachHang().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		//		if(o.equals(menuHoaDon)) {
		//			try {
		//				new FormHoaDon().setVisible(true);
		//				setVisible(false);
		//			} catch (SQLException e1) {
		//				// TODO Auto-generated catch block
		//				e1.printStackTrace();
		//			}
		//		}

		if(o.equals(menuTrangThaiPhong)) {
			try {
				new FormTrangThaiPhong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//		if(o.equals(menuDatPHong)) {
	//			try {
	//				new FormDatPhong().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}

	//		if(o.equals(itemThemCongTrinh)) {
	//			try {
	//				new ThemCongTrinh().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemXoaCongTrinh)) {
	//			try {
	//				new XoaCongTrinh().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemSuaCongTrinh)) {
	//			try {
	//				new SuaCongTrinh().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemTimKiemCongTrinh)) {
	//			try {
	//				new TimKiemCongTrinh().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemThemPhanCong)) {
	//			try {
	//				new ThemPhanCong().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemXoaPhanCong)) {
	//			try {
	//				new XoaPhanCong().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemSuaPhanCong)) {
	//			try {
	//				new SuaPhanCong().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		}
	//
	//		if(o.equals(itemTimKiemPhanCong)) {
	//			try {
	//				new TimKiemPhanCong().setVisible(true);
	//				setVisible(false);
	//			} catch (SQLException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//
	//		}



	public static void main(String[] args) throws SQLException {
		new FormNhanVien();
		FormNhanVien frmNV = new FormNhanVien();
		frmNV.setTitle("HỆ THỐNG QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
		frmNV.setVisible(true);
		frmNV.setLocationRelativeTo(null);
		frmNV.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmNV.setBounds(0, 0, 1300, 680);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

