CREATE DATABASE JVP
GO
USE JVP
GO
CREATE TABLE tblUser(
	TaiKhoan NVARCHAR(10) PRIMARY KEY,
	MatKhau NVARCHAR(10)
)
CREATE TABLE tblKhoa(
	MaKhoa INT PRIMARY KEY IDENTITY,
	TenKhoa NVARCHAR(50),
)
CREATE TABLE tblHeDaoTao(
	MaHDT INT PRIMARY KEY IDENTITY,
	TenHDT NVARCHAR(50),
)
CREATE TABLE tblBacDaoTao(
	MaBDT INT PRIMARY KEY IDENTITY,
	TenBDT NVARCHAR(50)
)
CREATE TABLE tblLop(
	MaLop INT PRIMARY KEY IDENTITY,
	TenLop NVARCHAR(50) NOT NULL,
	idKhoa INT FOREIGN KEY (idKhoa) REFERENCES tblKhoa(MaKhoa),
	idHDT INT FOREIGN KEY (idHDT) REFERENCES tblHeDaoTao(MaHDT),
	idBDT INT FOREIGN KEY (idBDT) REFERENCES tblBacDaoTao(MaBDT)
)
CREATE TABLE tblGiangVien(
	MaGV INT PRIMARY KEY IDENTITY,
	TenGV NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	Email VARCHAR(50),
	SoDT VARCHAR(11),
	DiaChi NVARCHAR(200),
	HocVi NVARCHAR(50),
	ChucVu NVARCHAR(50),
	idKhoa INT FOREIGN KEY (idKhoa) REFERENCES tblKhoa(MaKhoa)
)
CREATE TABLE tblSinhVien(
	MaSV INT PRIMARY KEY IDENTITY,
	TenSV NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	Email VARCHAR(50),
	SoDT VARCHAR(11),
	DiaChi NVARCHAR(200),
	idLop INT FOREIGN KEY (idLop) REFERENCES tblLop(MaLop)
)
CREATE TABLE tblDeTai(
	MaDT INT PRIMARY KEY IDENTITY,
	TenDT NVARCHAR(50),
	SoSV INT,
	Nam INT
)
CREATE TABLE tblDiem(
	idDT INT FOREIGN KEY (idDT) REFERENCES tblDeTai(MaDT),
	idGV INT FOREIGN KEY (idGV) REFERENCES tblGiangVien(MaGV),
	Diem FLOAT,
	NhanXet NVARCHAR(200)
)
CREATE TABLE tblDangKi(
	idDT INT FOREIGN KEY (idDT) REFERENCES tblDeTai(MaDT),
	idGV INT FOREIGN KEY (idGV) REFERENCES tblGiangVien(MaGV),
	idSV INT FOREIGN KEY (idSV) REFERENCES tblSinhVien(MaSV)
)

INSERT INTO tblKhoa VALUES (N'Công nghệ thông tin')
INSERT INTO tblKhoa VALUES (N'Kinh tế')
INSERT INTO tblKhoa VALUES (N'Khoa học tự nhiên')
INSERT INTO tblKhoa VALUES (N'Kỹ thuật điện')

INSERT INTO tblUser VALUES ('admin01','12345')

INSERT INTO tblHeDaoTao VALUES (N'Chất lượng cao')
INSERT INTO tblHeDaoTao VALUES (N'Chính quy')
INSERT INTO tblHeDaoTao VALUES (N'Tại chức')

INSERT INTO tblBacDaoTao VALUES (N'Trung cấp')
INSERT INTO tblBacDaoTao VALUES (N'Cao đẳng')
INSERT INTO tblBacDaoTao VALUES (N'Đại học')
INSERT INTO tblBacDaoTao VALUES (N'Sau đại học')

INSERT INTO tblGiangVien VALUES(N'Phạm Thùy Linh',0,'1999-09-04','TL@gmail.com','0969340098',N'Liên Hà',N'Tiến sĩ',N'Trưởng khoa',2)
SELECT gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa
FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa
SELECT gv.TenGV,gv.GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa
FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa

select maGV ,tenGV  , gioiTinh ,ngaySinh ,email,soDT ,diaChi ,hocVi ,chucVu  ,p.idKhoa, tenKhoa  from tblGiangVien p, tblKhoa c where p.idKhoa=c.MaKhoa
SELECT * FROM tblLop
INSERT INTO tblLop VALUES('D12CNPM1',1,2,3)
INSERT INTO tblLop VALUES('KTDN1',2,2,3)
INSERT INTO tblLop VALUES('H1',4,2,3)
SELECT l.MaLop,l.TenLop,l.idKhoa,k.TenKhoa,l.idHDT,hdt.TenHDT,l.idBDT,bdt.TenBDT FROM tblLop l, tblKhoa k, tblHeDaoTao hdt, tblBacDaoTao bdt WHERE l.idKhoa = k.MaKhoa AND l.idHDT = hdt.MaHDT AND l.idBDT = bdt.MaBDT

DELEtE FROM tblLop WHERE MaLop = 