create database QuanLyKhachSan10

go

use QuanLyKhachSan10

go
-- bang nhan vien
create table nhanVien
(
	maNhanVien int identity(1,1) primary key not null,
	tenNhanVien nvarchar(30), 
	ngaySinh varchar(30),
	gioiTinh varchar(10),
	cmnd_NV varchar(30),
	soDienThoai_NV varchar(30),
	diaChi nvarchar(100),
	chucVu nvarchar(50),	
)
insert into nhanVien values ('Thao Dep Gai', '16/11/2000', N'Nữ', 025997675, 0933236140, 'ádfgreytgbvcfgv', 'Quan Ly')
go
-- bang dang nhap
create table taiKhoan
( 
	tenDangNhap varchar(50) primary key,
	matKhau varchar(10),
	isAdmin bit,
	maNhanVien int foreign key (maNhanVien) references nhanVien(maNhanVien)
)
go
--bang dich vu
create table dichVu
(
	maDichVu int identity(1,1) primary key not null,
	tenDichVu nvarchar(50)
)
go

--bang quan ly phong
create table Phong	
(
	maPhong int identity(1,1) primary key not null,
	giaPhongGio varchar(10),
	giaPhong varchar(10),
	loaiPhong nvarchar(50),
	maDichVu int foreign key (maDichVu) references dichVu(maDichVu),
	isBooked bit
	
)

go
--bang quan ly khach hang
create table khachHang
(
	maKhachHang int identity(1,1) primary key not null, 
	tenKhachHang nvarchar(50),
	quocTich nvarchar(50),
	soDienThoai_KH varchar(30),
	gioiTinh varchar(20),
	cmnd_KH varchar(30),
	ngaySinh varchar(30)
)

go
--bang hoa don
create table hoaDon
(
	maHoaDon int identity(1,1) primary key not null, 
	maNhanVien int foreign key(maNhanVien) references nhanVien(maNhanVien),
	maPhong int foreign key(maPhong) references Phong(maPhong),
	maKhachHang int foreign key (maKhachHang) references khachHang(maKhachHang),
	ngayLapHoaDon varchar(20)

)
go
--bang chi tiet hoa don
create table CT_hoadon
(
	maHoaDon int foreign key(maHoaDon) references hoaDon(maHoaDon),
	ngayDen varchar(30) ,
	ngayDi varchar(30), 
	gioDatPhong varchar(30),
	gioTraPhong varchar(30),
	giaPhongTheoGio varchar(30),
	giaPhongTheoNgay varchar(30),
	hinhThucThuePhong nvarchar(255),
	loaiPhong nvarchar(50),
	tongTien varchar(30),
)

insert into taiKhoan values ('QL001', '123456', 1, 1)

insert into taiKhoan values ('NV001', '123456', 0, 1)

--select * from nhanVien
select * from CT_hoadon