package DanhMuc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JToggleButton;

public class FormDanhMuc {

	private JFrame frmQunLt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable table_1;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table_2;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDanhMuc window = new FormDanhMuc();
					window.frmQunLt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormDanhMuc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLt = new JFrame();
		frmQunLt.setAlwaysOnTop(true);
		frmQunLt.setForeground(Color.LIGHT_GRAY);
		frmQunLt.setIconImage(Toolkit.getDefaultToolkit().getImage("hinh/icon-hotel.png"));
		frmQunLt.setTitle("QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN MỸ LINH");
		frmQunLt.setBounds(0, 0, 1300, 680);
		frmQunLt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunLt.getContentPane().setLayout(null);
		frmQunLt.setVisible(true);
		
		JPanel panelNhanVien = new JPanel();
		panelNhanVien.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelNhanVien.setBounds(0, 0, 1278, 624);
		frmQunLt.getContentPane().add(panelNhanVien);
		panelNhanVien.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1300, 680);
		panelNhanVien.add(tabbedPane);
		
		Panel panelNV = new Panel();
		panelNV.setBackground(Color.LIGHT_GRAY);
		panelNV.setFont(new Font("Arial", Font.PLAIN, 12));
		tabbedPane.addTab("QUẢN LÝ NHÂN VIÊN", null, panelNV, null);
		panelNV.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "TH\u00D4NG TIN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(15, 27, 410, 329);
		panelNV.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenNhanVien = new JLabel("TÊN NHÂN VIÊN");
		lblTenNhanVien.setBounds(15, 55, 129, 29);
		panel.add(lblTenNhanVien);
		
		JLabel lblNgySinh = new JLabel("NGÀY SINH");
		lblNgySinh.setBounds(15, 91, 129, 29);
		panel.add(lblNgySinh);
		
		JLabel lblGiiTnh = new JLabel("GIỚI TÍNH");
		lblGiiTnh.setBounds(15, 127, 129, 29);
		panel.add(lblGiiTnh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(15, 163, 129, 29);
		panel.add(lblCmnd);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setBounds(15, 199, 129, 29);
		panel.add(lblSt);
		
		JLabel lblaCh = new JLabel("ĐỊA CHỈ");
		lblaCh.setBounds(15, 235, 129, 29);
		panel.add(lblaCh);
		
		JLabel lblChcV = new JLabel("CHỨC VỤ");
		lblChcV.setBounds(15, 271, 129, 29);
		panel.add(lblChcV);
		
		textField = new JTextField();
		textField.setBounds(184, 56, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 94, 146, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(184, 164, 146, 26);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(184, 200, 146, 26);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(184, 236, 146, 26);
		panel.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NAM", "NỮ"}));
		comboBox.setBounds(184, 128, 146, 26);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"QUẢN LÝ", "NHÂN VIÊN"}));
		comboBox_1.setBounds(184, 272, 146, 26);
		panel.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "T\u1EA0O T\u00C0I KHO\u1EA2N ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(15, 372, 410, 133);
		panelNV.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÊNĐĂNG NHẬP");
		lblNewLabel.setBounds(15, 42, 129, 29);
		panel_5.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("MẬT KHẨU");
		lblMtKhu.setBounds(15, 89, 129, 29);
		panel_5.add(lblMtKhu);
		
		textField_5 = new JTextField();
		textField_5.setBounds(188, 43, 146, 26);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(188, 90, 146, 26);
		panel_5.add(textField_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "QU\u1EA2N L\u00DD NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(468, 27, 796, 486);
		panelNV.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 30, 766, 440);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00C3 NV", "T\u00CAN", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "CMND", "S\u0110T", "\u0110\u1ECAA CH\u1EC8", "CH\u1EE8C V\u1EE4", "T\u00CAN \u0110\u0102NG NH\u1EACP", "M\u1EACT KH\u1EA8U"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(15, 523, 1249, 61);
		panelNV.add(panel_7);
		panel_7.setLayout(null);
		
		textField_7 = new JTextField();
		textField_7.setBounds(117, 19, 178, 26);
		panel_7.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnTimKiem = new JButton("TÌM KIẾM");
		btnTimKiem.setBounds(329, 18, 115, 29);
		panel_7.add(btnTimKiem);
		
		JButton btnThem = new JButton("THÊM ");
		btnThem.setBounds(482, 18, 115, 29);
		panel_7.add(btnThem);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setBounds(640, 18, 115, 29);
		panel_7.add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBounds(794, 18, 115, 29);
		panel_7.add(btnSua);
		
		JButton btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrang.setBounds(940, 18, 150, 29);
		panel_7.add(btnXoaTrang);
		
		JButton btnQuayLai = new JButton("QUAY LẠI");
		btnQuayLai.setBounds(1119, 18, 115, 29);
		panel_7.add(btnQuayLai);
		
		JPanel panelKH = new JPanel();
		panelKH.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("QUẢN LÝ KHÁCH HÀNG", null, panelKH, null);
		panelKH.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "TH\u00D4NG TIN KH\u00C1CH H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 16, 441, 439);
		panelKH.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTenKH = new JLabel("TÊN KHÁCH HÀNG");
		lblTenKH.setBounds(15, 55, 142, 29);
		panel_1.add(lblTenKH);
		
		JLabel lblQuocTich = new JLabel("QUỐC TỊCH");
		lblQuocTich.setBounds(15, 108, 134, 29);
		panel_1.add(lblQuocTich);
		
		JLabel lblSDT_KH = new JLabel("SĐT");
		lblSDT_KH.setBounds(15, 169, 142, 29);
		panel_1.add(lblSDT_KH);
		
		JLabel lblGioiTinh = new JLabel("GIỚI TÍNH");
		lblGioiTinh.setBounds(15, 231, 142, 29);
		panel_1.add(lblGioiTinh);
		
		JLabel lblCMND_KH = new JLabel("CMND");
		lblCMND_KH.setBounds(15, 295, 142, 29);
		panel_1.add(lblCMND_KH);
		
		JLabel lblNgaySinh = new JLabel("NGÀY SINH");
		lblNgaySinh.setBounds(15, 361, 142, 29);
		panel_1.add(lblNgaySinh);
		
		textField_8 = new JTextField();
		textField_8.setBounds(235, 56, 146, 26);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(235, 109, 146, 26);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(235, 170, 146, 26);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(235, 296, 146, 26);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(235, 362, 146, 26);
		panel_1.add(textField_12);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"NAM", "NỮ"}));
		comboBox_2.setBounds(235, 232, 146, 26);
		panel_1.add(comboBox_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "QU\u1EA2N L\u00DD KH\u00C1CH H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(471, 16, 792, 439);
		panelKH.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 26, 762, 397);
		panel_8.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00C3 ", "T\u00CAN KH\u00C1CH H\u00C0NG", "QU\u1ED0C T\u1ECACH", "S\u0110T", "GI\u1EDAI T\u00CDNH", "CMND", "NG\u00C0Y SINH"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(101);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setForeground(Color.WHITE);
		panel_9.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(15, 497, 1248, 88);
		panelKH.add(panel_9);
		panel_9.setLayout(null);
		
		textField_13 = new JTextField();
		textField_13.setBounds(120, 35, 146, 26);
		panel_9.add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnTimKiemKH = new JButton("TÌM KIẾM");
		btnTimKiemKH.setBounds(308, 34, 115, 29);
		panel_9.add(btnTimKiemKH);
		
		JButton btnThemKH = new JButton("THÊM");
		btnThemKH.setBounds(474, 34, 115, 29);
		panel_9.add(btnThemKH);
		
		JButton btnXoaKH = new JButton("XÓA");
		btnXoaKH.setBounds(636, 34, 115, 29);
		panel_9.add(btnXoaKH);
		
		JButton btnSuaKH = new JButton("SỬA");
		btnSuaKH.setBounds(802, 34, 115, 29);
		panel_9.add(btnSuaKH);
		
		JButton btnXoaTrangKH = new JButton("XÓA TRẮNG");
		btnXoaTrangKH.setBounds(962, 34, 123, 29);
		panel_9.add(btnXoaTrangKH);
		
		JButton btnQuayLaiKH = new JButton("QUAY LẠI");
		btnQuayLaiKH.setForeground(Color.BLACK);
		btnQuayLaiKH.setBackground(Color.WHITE);
		btnQuayLaiKH.setBounds(1118, 34, 115, 29);
		panel_9.add(btnQuayLaiKH);
		
		JPanel panelDichVu = new JPanel();
		panelDichVu.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("QUẢN LÝ DỊCH VỤ", null, panelDichVu, null);
		panelDichVu.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "TH\u00D4NG TIN D\u1ECACH V\u1EE4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(15, 16, 405, 438);
		panelDichVu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTenDichVu = new JLabel("TÊN DỊCH VỤ");
		lblTenDichVu.setBounds(15, 52, 129, 29);
		panel_2.add(lblTenDichVu);
		
		textField_14 = new JTextField();
		textField_14.setBounds(220, 53, 146, 26);
		panel_2.add(textField_14);
		textField_14.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "QU\u1EA2N L\u00DD D\u1ECACH V\u1EE4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(438, 16, 828, 438);
		panelDichVu.add(panel_10);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 26, 798, 396);
		panel_10.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {{null, null},},
			new String[] {
				"M\u00C3 D\u1ECACH V\u1EE4", "T\u00CAN D\u1ECACH V\u1EE4"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(105);
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(15, 494, 1251, 87);
		panelDichVu.add(panel_11);
		panel_11.setLayout(null);
		
		textField_15 = new JTextField();
		textField_15.setBounds(103, 32, 146, 26);
		panel_11.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnTimKiemDV = new JButton("TÌM KIẾM");
		btnTimKiemDV.setBounds(309, 31, 115, 29);
		panel_11.add(btnTimKiemDV);
		
		JButton btnThemDV = new JButton("THÊM");
		btnThemDV.setBounds(474, 31, 115, 29);
		panel_11.add(btnThemDV);
		
		JButton btnXoaDV = new JButton("XÓA");
		btnXoaDV.setBounds(637, 31, 115, 29);
		panel_11.add(btnXoaDV);
		
		JButton btnSuaDV = new JButton("SỬA");
		btnSuaDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuaDV.setBounds(804, 31, 115, 29);
		panel_11.add(btnSuaDV);
		
		JButton btnXoaTrangDV = new JButton("XÓA TRẮNG");
		btnXoaTrangDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrangDV.setBounds(959, 31, 128, 29);
		panel_11.add(btnXoaTrangDV);
		
		JButton btnQuayLaiDV = new JButton("QUAY LẠI");
		btnQuayLaiDV.setBounds(1121, 31, 115, 29);
		panel_11.add(btnQuayLaiDV);
		
		JPanel panelPhong = new JPanel();
		panelPhong.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("QUẢN LÝ PHÒNG", null, panelPhong, null);
		panelPhong.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "TH\u00D4NG TIN PH\u00D2NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(15, 16, 376, 449);
		panelPhong.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(15, 45, 69, 20);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("QUẢN LÝ HÓA ĐƠN", null, panel_4, null);
		
//		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.addTab("QUẢN LÝ HÓA ĐƠN", null, tabbedPane_5, null);
		
	}

	public void setVisible(boolean b) {
		
	}

	

}
