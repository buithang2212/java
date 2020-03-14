CREATE DATABASE JV_Project
GO
USE JV_Project
GO
CREATE TABLE tblGiangVien(
	MaGV VARCHAR(10) PRIMARY KEY,
	TenGV NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	Email VARCHAR(50),
	SoDT VARCHAR(11),
	DiaChi NVARCHAR(200),
	HocVi NVARCHAR(50),
	ChucVu NVARCHAR(50),
	idKhoa VARCHAR(10) FOREIGN KEY (idKhoa) REFERENCES tblKhoa(MaKhoa)
)
CREATE TABLE tblSinhVien(
	MaSV VARCHAR(10) PRIMARY KEY,
	TenSV NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	Email VARCHAR(50),
	SoDT VARCHAR(11),
	DiaChi NVARCHAR(200),
	idLop VARCHAR(10) FOREIGN KEY (idLop) REFERENCES tblLop(MaLop)
)
CREATE TABLE tblUser(
	TaiKhoan NVARCHAR(10) PRIMARY KEY,
	MatKhau NVARCHAR(10)
)
CREATE TABLE tblKhoa(
	MaKhoa VARCHAR(10) PRIMARY KEY,
	TenKhoa NVARCHAR(50),
)
CREATE TABLE tblHeDaoTao(
	MaHDT VARCHAR(10) PRIMARY KEY,
	TenHDT NVARCHAR(50),
)
CREATE TABLE tblBacDaoTao(
	MaBDT VARCHAR(10) PRIMARY KEY,
	TenBDT NVARCHAR(50)
)
CREATE TABLE tblLop(
	MaLop VARCHAR(10) PRIMARY KEY,
	TenLop NVARCHAR(50) NOT NULL,
	idKhoa VARCHAR(10) FOREIGN KEY (idKhoa) REFERENCES tblKhoa(MaKhoa),
	idHDT VARCHAR(10) FOREIGN KEY (idHDT) REFERENCES tblHeDaoTao(MaHDT),
	idBDT VARCHAR(10) FOREIGN KEY (idBDT) REFERENCES tblBacDaoTao(MaBDT)
)
CREATE TABLE tblDeTai(
	MaDT VARCHAR(10) PRIMARY KEY,
	TenDT NVARCHAR(50),
	SoSV INT,
	Nam INT
)
CREATE TABLE tblDiem(
	idDT VARCHAR(10) FOREIGN KEY (idDT) REFERENCES tblDeTai(MaDT),
	idGV VARCHAR(10) FOREIGN KEY (idGV) REFERENCES tblGiangVien(MaGV),
	Diem FLOAT,
	NhanXet NVARCHAR(200)
)
CREATE TABLE tblDangKi(
	idDT VARCHAR(10) FOREIGN KEY (idDT) REFERENCES tblDeTai(MaDT),
	idGV VARCHAR(10) FOREIGN KEY (idGV) REFERENCES tblGiangVien(MaGV),
	idSV VARCHAR(10) FOREIGN KEY (idSV) REFERENCES tblSinhVien(MaSV)
)

INSERT INTO tblUser VALUES ('admin01','12345')
SELECT * FROM tblKhoa
INSERT INTO tblKhoa VALUES ('K01',N'Công nghệ thông tin')
INSERT INTO tblKhoa VALUES ('K02',N'Kỹ thuật điện')
INSERT INTO tblKhoa VALUES ('K03',N'Kinh tế')
INSERT INTO tblKhoa VALUES ('K04',N'Công nghệ năng lượng')
INSERT INTO tblKhoa VALUES ('K05',N'Khoa học tự nhiên')

INSERT INTO tblHeDaoTao VALUES ('HDT01',N'Chất lượng cao')
INSERT INTO tblHeDaoTao VALUES ('HDT02',N'Chính quy')
INSERT INTO tblHeDaoTao VALUES ('HDT03',N'Tại chức')

INSERT INTO tblBacDaoTao VALUES ('BDT01',N'Trung cấp')
INSERT INTO tblBacDaoTao VALUES ('BDT02',N'Cao đẳng')
INSERT INTO tblBacDaoTao VALUES ('BDT03',N'Đại học')
INSERT INTO tblBacDaoTao VALUES ('BDT04',N'Sau đại học')

INSERT INTO tblGiangVien VALUES ('GV01',N'Phạm Thùy Linh',0,'04-09-1999','thuylinh@gmail.com','0987654432',N'Liên Hà',N'Tiến sĩ',N'Trưởng khoa','K03')
INSERT INTO tblGiangVien(MaGV,TenGV,GioiTinh,NgaySinh,Email,SoDT,DiaChi,HocVi,ChucVu,idKhoa) VALUES ('GV02',N'Ngyễn Công Phượng',1,'1995-04-16','CP@gmail.com','0988376452',N'Nghệ An',N'Thạc sĩ',N'Phó khoa','K01')
INSERT INTO tblGiangVien(MaGV,TenGV,GioiTinh,NgaySinh,Email,SoDT,DiaChi,HocVi,ChucVu,idKhoa) VALUES ('GV03',N'Nguyễn Quang Hải',1,'1997-03-22','QH@gmail.com','0987354632',N'Đông Anh',N'Giáo sư',N'Trưởng khoa','K04')
INSERT INTO tblGiangVien(MaGV,TenGV,GioiTinh,NgaySinh,Email,SoDT,DiaChi,HocVi,ChucVu,idKhoa) VALUES ('GV04',N'Đỗ Hùng Dũng',1,'1996-11-05','HD@gmail.com','0936752416',N'Hà Nội',N'Tiến sĩ',N'Phó khoa','K02')

INSERT INTO tblLop VALUES ('L01',N'Công nghệ phần mền','K01','HDT02','BDT03')
INSERT INTO tblLop VALUES ('L02',N'Kế toán doanh nghiệp','K03','HDT02','BDT03')
INSERT INTO tblLop VALUES ('L03',N'Hệ thống điện','K02','HDT01','BDT03')
INSERT INTO tblLop VALUES ('L04',N'Điện tử viễn thông','K02','HDT01','BDT03')


SELECT sv.MaSV,sv.TenSV,CASE WHEN sv.GioiTinh = 1 THEN 'Nam' WHEN sv.GioiTinh = 0 THEN N'Nữ' END AS GioiTinh,sv.NgaySinh,sv.Email,sv.SoDT,sv.DiaChi,l.TenLop
FROM tblSinhVien sv INNER JOIN tblLop l ON sv.idLop = l.MaLop

SELECT l.MaLop,l.TenLop,k.TenKhoa AS TenKhoa,hdt.TenHDT AS TenHDT,bdt.TenBDT AS TenBDT FROM tblLop l INNER JOIN tblKhoa k ON l.idKhoa = k.MaKhoa INNER JOIN tblHeDaoTao hdt ON l.idHDT = hdt.MaHDT INNER JOIN tblBacDaoTao bdt ON l.idBDT = bdt.MaBDT

SELECT gv.MaGV,gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa
FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa