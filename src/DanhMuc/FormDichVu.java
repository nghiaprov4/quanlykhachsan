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

import DichVu.ThongTinDichVu;
import DichVu.listDichVu;
import KhachHang.ThongTinKhachHang;

public class FormDichVu extends JFrame implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel pnNorth, pnCenter, pnSouth, pnWest;
		private JLabel lblMaDV, lblTenDV;
		private JTextField txtMaDV, txtTenDV;
		private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
		private JLabel lblTitle, lblTimKiem;
		private JTextField txtTimKiem;
		private JTable tbThemDichVu;
		private DefaultTableModel tbDichVuModel;
		private JMenuBar menubar = new JMenuBar();
		private listDichVu list;
		private JMenu menuNhanVien, menuQLPhong, menuDichVu, menuKhachHang, menuHoaDon, menuTrangChu, menuDatPHong, menuTrangThaiPhong;
		
		public FormDichVu() throws SQLException{
											
			list = new listDichVu();
			
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
			pnNorth.add(lblTitle = new JLabel("QUẢN LÝ DỊCH VỤ"));
			lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
			lblTitle.setForeground(Color.BLUE);
			add(pnNorth, BorderLayout.NORTH);
			
			pnWest = new JPanel(new GridBagLayout());
			
			pnWest.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.NORTHWEST;
			c.fill = GridBagConstraints.HORIZONTAL;
			
			lblMaDV = new JLabel("MÃ DỊCH VỤ");
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(20, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 0;
			pnWest.add(lblMaDV, c);
			
			txtMaDV = new JTextField(15);
			c.insets = new Insets(20, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 0;
			pnWest.add(txtMaDV, c);
			
			lblTenDV = new JLabel("TÊN DỊCH VỤ");
			c.insets = new Insets(5, 30, 5, 0);
			c.gridx = 0;
			c.gridy = 1;
			pnWest.add(lblTenDV, c);
			
			txtTenDV = new JTextField(15);
			c.insets = new Insets(5, 5, 5, 30);
			c.gridx = 1;
			c.gridy = 1;
			pnWest.add(txtTenDV, c);
			

			c.weighty = 1;
			c.weightx = 1;
			pnWest.add(new JLabel(""), c);
			pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin dịch vụ"));
			add(pnWest, BorderLayout.WEST);
			
			pnCenter = new JPanel();
			pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			pnCenter.setBorder(BorderFactory.createTitledBorder("Quản lý dịch vụ"));
			
			String[] header = "MÃ DỊCH VỤ, TÊN DỊCH VỤ".split(",");
			tbDichVuModel = new DefaultTableModel(header,0);
			tbThemDichVu = new JTable(tbDichVuModel);
			JScrollPane scroll = new JScrollPane(tbThemDichVu);
			tbThemDichVu.setDefaultEditor(Object.class, null); //KhÃ´ng cho sá»­a dá»¯ liáº¹u trÃªn báº£ng
			tbThemDichVu.setRowHeight(25);
			tbThemDichVu.setAutoCreateColumnsFromModel(rootPaneCheckingEnabled);
	
			scroll.getViewport().add(tbThemDichVu);
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


			tbThemDichVu.addMouseListener((MouseListener) new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {


				}

				@Override
				public void mousePressed(MouseEvent e) {

					int rowClicked = tbThemDichVu.getSelectedRow();
					txtMaDV.setText(tbDichVuModel.getValueAt(rowClicked, 0).toString());
					//				txtMaPhong.setText(tbKhachHangModel.getValueAt(rowClicked, 1).toString());
					txtTenDV.setText(tbDichVuModel.getValueAt(rowClicked, 1).toString());
					

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
					String maDichVu = txtMaDV.getText();
					String tenDichVu = txtTenDV.getText();
					
					try {
						if(list.addData(maDichVu,  tenDichVu) == true) {

							String data []= {maDichVu,  tenDichVu}; 
							tbDichVuModel.addRow(data);
							tbThemDichVu.setModel(tbDichVuModel);
						}
						else {
							JOptionPane.showMessageDialog(null, "THÊM THÔNG TIN BỊ THẤT BẠI.");
						}
					} catch (HeadlessException e1) {

							JOptionPane.showMessageDialog(null, "MÃ DỊCH VỤ ĐÃ TỒN TẠI !");
//						 e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
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
							
							String maDichVu = txtMaDV.getText();
							int ret=JOptionPane.showConfirmDialog(null,
									"Bạn muốn xoá khách hàng này?", "Xoá",
									JOptionPane.YES_NO_OPTION);
							if(ret==JOptionPane.YES_OPTION) {	
							try {
								list.Remove(maDichVu);
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
			txtMaDV.setText("");
			txtTenDV.setText("");
		
		}



		///////////////////////////////////////////////////////



		public void LoadDatabase() throws SQLException {
			tbDichVuModel.setRowCount(0);
			list.LoadData();

			ArrayList arrRows = new ArrayList();

			for(int i = 0; i < list.getSize(); i++) {
				ThongTinDichVu dv = list.getElement(i);
				//			tbKhachHangModel.addRow(kh.toString().split(","));

				arrRows.add(list.getElement(i).getMaDichVu());
				arrRows.add(list.getElement(i).getTenDichVu());
		
				


				tbDichVuModel.addRow(arrRows.toArray());
				arrRows.clear();
			}
			tbDichVuModel.addRow(arrRows.toArray());

		}

		public boolean validData() {
			String maDichVu = txtMaDV.getText().trim();
			String tenDichVu = txtTenDV.getText().trim();

			if(maDichVu.length() > 0){
				try {
					String maDichVu1 = txtMaDV.getText();
					if(maDichVu1.length() <= 0) {
						JOptionPane.showMessageDialog(null, "MÃ DỊCH VỤ KHÔNG HỢP LỆ.");
						return false;
					}
				}catch (Exception e) {

					JOptionPane.showMessageDialog(null, "MÃ DỊCH VỤ NHẬP KHÔNG ĐÚNG CÚ PHÁP !.");
					return false;
				}
			}

			if(maDichVu.length() == 0) {
				JOptionPane.showMessageDialog(null, "MÃ DỊCH VỤ KHÔNG ĐƯỢC ĐỂ TRỐNG.");
				return false;
			}

			if(tenDichVu.length() == 0) {
							JOptionPane.showMessageDialog(null, "TÊN DỊCH VỤ KHÔNG ĐƯỢC ĐỂ TRỐNG.");
							return false;
			}
			
			return true;
		}


		public void Search() {
			String str = txtTimKiem.getText();
			if(str != null && str.trim().length() > 0) {
				try {
					String  maDichVu = String.valueOf(str);
					ThongTinDichVu dv = list.search(maDichVu);
					if(dv != null) {
						tbDichVuModel.setRowCount(0);
						tbDichVuModel.addRow(dv.toString().split(","));
					}
					else {
						JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY MÃ DỊCH VỤ CẦN TÌM.");
						
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
			new FormDichVu();
			FormDichVu frmNV = new FormDichVu();
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

