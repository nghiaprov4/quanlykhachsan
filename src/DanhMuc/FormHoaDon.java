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

import KhachHang.ThongTinKhachHang;
import QuanLyHoaDon.ThongTinHoaDon;
import QuanLyHoaDon.listHoaDon;

public class FormHoaDon extends JFrame implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel pnNorth, pnCenter, pnSouth, pnWest;
		private JLabel lblMaHD, lblNgayLapHD, lblMaKhachHang, lblMaNhanVien, lblGioDat, lblGioTra;
		private JTextField txtMaHD, txtNgayLapHD, txtMaKhachHang, txtMaNhanVien, txtGioDat, txtGioTra;
		private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
		private JLabel lblTitle, lblTimKiem;
		private listHoaDon list;
		private JTextField txtTimKiem;
		private JTable tbThemHoaDon;
		private DefaultTableModel tbHoaDonModel;
		private JMenuBar menubar = new JMenuBar();
		private JMenu menuNhanVien, menuQLPhong, menuDichVu, menuKhachHang, menuHoaDon, menuTrangChu, menuDatPHong, menuTrangThaiPhong;
		
		public FormHoaDon() throws SQLException{
											
			list = new listHoaDon();
			
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
			pnNorth.add(lblTitle = new JLabel("QUẢN LÝ HÓA ĐƠN"));
			lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
			lblTitle.setForeground(Color.BLUE);
			add(pnNorth, BorderLayout.NORTH);
			
			pnWest = new JPanel(new GridBagLayout());
			
			pnWest.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.NORTHWEST;
			c.fill = GridBagConstraints.HORIZONTAL;
			
			lblMaHD = new JLabel("MÃ HÓA ĐƠN");
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(20, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 0;
			pnWest.add(lblMaHD, c);
			
			txtMaHD = new JTextField(15);
			c.insets = new Insets(20, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 0;
			pnWest.add(txtMaHD, c);
			
			lblMaKhachHang = new JLabel("MÃ KHÁCH HÀNG");

			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(20, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 1;
			pnWest.add(lblMaKhachHang, c);

			txtMaKhachHang = new JTextField(15);
			c.insets = new Insets(20, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 1;
			pnWest.add(txtMaKhachHang, c);
			
			lblMaNhanVien = new JLabel("MÃ NHÂN VIÊN");

			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(20, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 2;
			pnWest.add(lblMaNhanVien, c);

			txtMaNhanVien = new JTextField(15);
			c.insets = new Insets(20, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 2;
			pnWest.add(txtMaNhanVien, c);
			
			lblNgayLapHD = new JLabel("NGÀY LẬP HÓA ĐƠN");
			c.insets = new Insets(5, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 3;
			pnWest.add(lblNgayLapHD, c);
			
			txtNgayLapHD = new JTextField(15);
			c.insets = new Insets(5, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 3;
			pnWest.add(txtNgayLapHD, c);
			
			lblGioDat = new JLabel("GIỜ ĐẶT PHÒNG");
			c.insets = new Insets(5, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 4;
			pnWest.add(lblGioDat, c);
			
			txtGioDat = new JTextField(15);
			c.insets = new Insets(5, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 4;
			pnWest.add(txtGioDat, c);
			
			lblGioTra = new JLabel("GIỜ TRẢ PHÒNg");
			c.insets = new Insets(5, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 5;
			pnWest.add(lblGioTra, c);
			
			txtGioTra = new JTextField(15);
			c.insets = new Insets(5, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 5;
			pnWest.add(txtGioTra, c);
						
			

			c.weighty = 1;
			c.weightx = 1;
			pnWest.add(new JLabel(""), c);
			pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
			add(pnWest, BorderLayout.WEST);
			
			pnCenter = new JPanel();
			pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			pnCenter.setBorder(BorderFactory.createTitledBorder("Quản lý hóa đơn"));
			
			String[] header = "MÃ HÓA ĐƠN, MÃ KHÁCH HÀNG, MÃ NHÂN VIÊN, NGÀY LẬP HÓA ĐƠN, GIỜ ĐẶT PHÒNG, GIỜ TRẢ PHÒNG".split(",");
			tbHoaDonModel = new DefaultTableModel(header,0);
			tbThemHoaDon = new JTable(tbHoaDonModel);
			JScrollPane scroll = new JScrollPane(tbThemHoaDon);
			tbThemHoaDon.setDefaultEditor(Object.class, null); //KhÃ´ng cho sá»­a dá»¯ liáº¹u trÃªn báº£ng
			tbThemHoaDon.setRowHeight(25);
			tbThemHoaDon.setAutoCreateColumnsFromModel(rootPaneCheckingEnabled);
	
			scroll.getViewport().add(tbThemHoaDon);
			scroll.setPreferredSize(new Dimension(900,500));
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


			tbThemHoaDon.addMouseListener((MouseListener) new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {


				}

				@Override
				public void mousePressed(MouseEvent e) {

					int rowClicked = tbThemHoaDon.getSelectedRow();
					txtMaHD.setText(tbHoaDonModel.getValueAt(rowClicked, 0).toString());
					//				txtMaPhong.setText(tbKhachHangModel.getValueAt(rowClicked, 1).toString());
					txtMaKhachHang.setText(tbHoaDonModel.getValueAt(rowClicked, 1).toString());
					txtMaNhanVien.setText(tbHoaDonModel.getValueAt(rowClicked, 2).toString());
					txtNgayLapHD.setText(tbHoaDonModel.getValueAt(rowClicked, 3).toString());
					txtGioDat.setText(tbHoaDonModel.getValueAt(rowClicked, 4).toString());
					txtGioTra.setText(tbHoaDonModel.getValueAt(rowClicked, 5).toString());

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
					String maHoaDon = txtMaHD.getText();
					String maKhachHang = txtMaKhachHang.getText();
					String maNhanVien = txtMaNhanVien.getText();
					String ngayLapHoaDon = txtNgayLapHD.getText();
					String gioDat = txtGioDat.getText();		
					String gioTra = txtGioTra.getText();

					try {
						if(list.addData(maHoaDon, maKhachHang, maNhanVien, ngayLapHoaDon, gioDat, gioTra) == true) {

							String data []= {maHoaDon, maKhachHang, maNhanVien, ngayLapHoaDon, gioDat, gioTra}; 
							tbHoaDonModel.addRow(data);
							tbThemHoaDon.setModel(tbHoaDonModel);
						}
						else {
							JOptionPane.showMessageDialog(null, "THÊM THÔNG TIN BỊ THẤT BẠI.");
						}
					} catch (HeadlessException e1) {

							JOptionPane.showMessageDialog(null, "MÃ KHÁCH HÀNG ĐÃ TỒN TẠI !");
//						 e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
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
							
							String maHoaDon = txtMaHD.getText();
							int ret=JOptionPane.showConfirmDialog(null,
									"Bạn muốn xoá hóa đơn này?", "Xoá",
									JOptionPane.YES_NO_OPTION);
							if(ret==JOptionPane.YES_OPTION) {	
							try {
								list.Remove(maHoaDon);
								JOptionPane.showMessageDialog(null, "Xoá thành công");
								LoadDatabase();
								ClearAll();
								//lblsoLuongNV.setText("Số lượng nhân viên: "+ list.getSize());
								
							}catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "Không thể xoá hóa đơn này !");
			//					ex.printStackTrace();
								
							}
							
							}
							else {
								return;
							}
						}
					});



//					btnSua.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							int ret=JOptionPane.showConfirmDialog(null,
//									"Bạn muốn sửa khách hàng này?", "Sửa",
//									JOptionPane.YES_NO_OPTION);
//							if(ret==JOptionPane.YES_OPTION) {	
//								if(validData() == true) {
//									int rowClicked = tbQLKhachHang.getSelectedRow();
//			
//			
//									String maKhachHang = txtMaKH.getText();
//									String tenKhachHang = txtTenKH.getText();
//									String quocTich = txtQuocTich.getText();
//									int soDienThoai = Integer.parseInt(txtSDT_KH.getText());
////									String gioiTinhTemp[] = cbbGioiTinh.getSelectedItem().toString().split("-");
//									String gioiTinh = cbbModel.getSelectedItem().toString();
//									int cMND_KH = Integer.parseInt(txtCMND_KH.getText());
//									String ngaySinh = txtNgaySinh.getText();
//									//		    	    String diaChi = txtdiaChi.getText();
//									//		    	    String maPBtemp[] = cbbModelPhongBan.getSelectedItem().toString().split("-");
//									//		    	    int maPB = Integer.parseInt(maPBtemp[0].trim());
//									ThongTinKhachHang kh = new ThongTinKhachHang(maKhachHang, tenKhachHang, ngaySinh, cMND_KH, gioiTinh, soDienThoai, quocTich);
//									try {
//										if(list.editElement(maKhachHang, kh) == true) {
//											JOptionPane.showMessageDialog(null, "Sửa thành công");
//											LoadDatabase();
//											tbQLKhachHang.setRowSelectionInterval(rowClicked, rowClicked);
//										}else {
//											JOptionPane.showMessageDialog(null, "Không được sửa mã khách hàng");
//											txtMaKH.selectAll();
//											txtMaKH.requestFocus();
//										}
//									} catch (SQLException e1) {
//										JOptionPane.showMessageDialog(null, "MÃ KHÁCH HÀNG KHÔNG TỒN TẠI !");
//										//e1.printStackTrace();
//									}
//								}
//								return;
//							}
//						}
//					});

			btnTimKiem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Search();
					ClearAll();
				}
			});


		}	
		public void ClearAll() {
			txtMaHD.setText("");
			txtMaKhachHang.setText("");
			txtMaNhanVien.setText("");
			txtNgayLapHD.setText("");
			txtGioDat.setText("");
			txtGioTra.setText("");
		}



		///////////////////////////////////////////////////////



		public void LoadDatabase() throws SQLException {
			tbHoaDonModel.setRowCount(0);
			list.LoadData();

			ArrayList arrRows = new ArrayList();

			for(int i = 0; i < list.getSize(); i++) {
				ThongTinHoaDon hd = list.getElement(i);
				//			tbKhachHangModel.addRow(kh.toString().split(","));

				arrRows.add(list.getElement(i).getMaHoaDon());
				arrRows.add(list.getElement(i).getMaKhachHang());
				arrRows.add(list.getElement(i).getMaNhanVien());
				arrRows.add(list.getElement(i).getNgayLapHoaDon());
				arrRows.add(list.getElement(i).getGioDat());
				arrRows.add(list.getElement(i).getGioTra());


				tbHoaDonModel.addRow(arrRows.toArray());
				arrRows.clear();
			}
			tbHoaDonModel.addRow(arrRows.toArray());

		}
		public boolean validData() {
			String maHoaDon = txtMaHD.getText().trim();
			String maKhachHang = txtMaKhachHang.getText().trim();
			String maNhanVien = txtMaNhanVien.getText().trim();
			String ngayLapHoaDon = txtNgayLapHD.getText().trim();
			String gioDat = txtGioDat.getText().trim();
			String gioTra = txtGioTra.getText().trim();

			if(maHoaDon.length() > 0){
				try {
					String maHoaDon1 = txtMaHD.getText();
					if(maHoaDon1.length() <= 0) {
						JOptionPane.showMessageDialog(null, "MÃ HÓA ĐƠN KHÔNG HỢP LỆ.");
						return false;
					}
				}catch (Exception e) {

					JOptionPane.showMessageDialog(null, "MÃ HÓA ĐƠN NHẬP KHÔNG ĐÚNG CÚ PHÁP !.");
					return false;
				}
			}

			if(maKhachHang.length() == 0) {
				JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
				return false;
			}

			if(maNhanVien.length() == 0) {
							JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
							return false;
			}
			
			if(ngayLapHoaDon.length() == 0) {
				JOptionPane.showMessageDialog(null, "NGÀY LẬP HÓA ĐƠN KHÔNG ĐƯỢC ĐỂ TRỐNG.");
				return false;
			}
			
			if(gioDat.length() == 0) {
				JOptionPane.showMessageDialog(null, "GIỜ ĐẶT PHÒNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
				return false;
			}
			
			if(gioTra.length() == 0) {
				JOptionPane.showMessageDialog(null, "GIỜ TRẢ PHÒNG KHÔNG ĐƯỢC ĐỂ TRỐNG.");
				return false;
			}
			

			return true;
		}


		public void Search() {
			String str = txtTimKiem.getText();
			if(str != null && str.trim().length() > 0) {
				try {
					String maHoaDon = String.valueOf(str);
					ThongTinHoaDon hd = list.search(maHoaDon);
					if(hd != null) {
						tbHoaDonModel.setRowCount(0);
						tbHoaDonModel.addRow(hd.toString().split(","));
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
			new FormHoaDon();
			FormHoaDon frmNV = new FormHoaDon();
			frmNV.setTitle("HỆ THỐNG QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
			frmNV.setVisible(true);
			frmNV.setLocationRelativeTo(null);
			frmNV.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frmNV.setBounds(0, 0, 1300, 680);
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

