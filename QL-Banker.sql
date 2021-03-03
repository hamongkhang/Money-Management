create database Banker;
use Banker;

CREATE TABLE Banker_information(
id VARCHAR(20) not null primary key ,
name varchar(20),
email varchar(20),
username varchar(20),
password  varchar(20)
);


insert into Banker_information(id,name,email,username,password) values
('001','Nguyen Hong Quan', 'viettin@gmail.com','Quan','Quan'),
('002','Nguyen Hoang Huan', 'vietcom@gmail.com','Huan','Huan'),
('003','Tran Van Phat', 'vietha@gmail.com','Phat','Phat');

CREATE TABLE Customer (
Cus_ID int(3) primary key auto_increment,
firstname varchar(50),
lastname varchar(50),
username varchar(70),
upassword varchar(50),
phonenumber varchar(20),
adresst varchar(100),
gender varchar(10),
dateofbirth varchar(20),
loanamout varchar(12)
);

insert into customer ( Cus_ID,firstname, lastname,username,upassword ,phonenumber,adresst,gender,dateofbirth,loanamout) value
(1,'Quan','Nguyen','QuanNguyen','Quan','0966624800','QB','Female','24/10/2000','0.0'),
(2,'Huan','Nguyen','HuanNguyen','2432000','0966624800','BD','Female','24/03/2000','0.0'),
(3,'Phat','Tran','PhatTran','2432000','0966624800','QT','Female','24/03/2000','0.0');
CREATE TABLE CreditCard(
Card_number varchar(30) PRIMARY KEY,
limits decimal check(limits<1000000),
expireddate datetime
);

insert into CreditCard(Card_number,limits,expireddate)values
('0000-1111-1111',50000,'2020-03-18'),
('0000-1111-2222',10000,'2019-04-19'),
('0000-1212-2222',50000,'2020-05-20'),
('0000-2323-1111',30000,'2022-08-21'),
('0000-2424-1010',20000,'2019-03-18');

 CREATE TABLE Account(
Account_number VARCHAR(20) not null  PRIMARY KEY,
Balance decimal,
category varchar(20)
);

 insert into account ( Account_number ,category,Balance) values
 ('0-1-2222-3333','Da Nang VND',10000),
 ('0-1-3333-3333','TP HCM VND',10000),
('0-1-2222-2222','HN VND',10000),
('0-1-5555-5555','QB Nang VND',10000),
('0-1-2222-3331','QB Nang VND',10000);

CREATE TABLE Branch(
branch_name varchar(20) primary key,
branch_city nvarchar(10),
assets decimal
);

insert into branch( branch_name,branch_city,assets) values
('Peter','Đà Nẵng',6000000),
('Heli','TP HCM',12000000),
('Athur','Đồng Hới',9000000),
('Lisa','Quy Nhơn',6000000),
('Sara','Hà Nội ',8000000);

CREATE TABLE Loan(
branch_name varchar(20),
loan_number varchar(40) primary key,
amount decimal

);

insert into Loan( branch_name,loan_number,amount) values
('Peter',1,150000),
('Lisa',2,600000),
('Sara',3,80000),
('Heli',4,90000),
('Athur',5,20000),
('Athur',6,20000);

/* Các bảng liên kết */

CREATE TABLE cus_loa(
Cus_ID	int(3) ,	
loan_number	varchar(20) 

);

insert into  cus_loa (Cus_ID,loan_number) values
(1,1),
(2,3),
(3,2);

create table  cus_crcard_ac(
Cus_ID int(3) ,
Card_Number	varchar(20) 	, 
Account_number	varchar(20) 

);

insert into cus_crcard_ac(Cus_ID,Card_Number,Account_number)values
(1,'0000-1111-1111','0-1-2222-3333'),
(2,'0000-1111-2222','0-1-3333-3333'),
(3,'0000-2424-1010','0-1-5555-5555');

CREATE TABLE ban_cus(
branch_name	Varchar(30),
Cus_ID	int(3),
Banker_ID	varchar(20)
);

insert into ban_cus (branch_name,Cus_ID,Banker_ID) values 
('Peter',1,'001'),
('Lisa',2,'002'),

('Sara',3,'003');


CREATE TABLE LOANTB(
userb varchar(20) not null ,
firstname varchar(30),
idcard varchar(15),
limits varchar(3),
loanamount varchar(20),
thechap varchar(50),
typel varchar(15)
);
insert into LOANTB (userb,firstname, idcard,limits,loanamount,thechap,typel) values
('HuanNguyen','Huan','215441817','5','100000000','House','Person');

select*from LOANTB;






/*Xem  khách hàng số tiền vay và ngân hàng khách đang sử dụng
select c.name as 'Tên khách',
       ifb.banker_name as 'Tên Ngân Hàng',
       l.amount as 'số tiền'
       
from Banker_information as ifb,
	 Customer as c,
	 ban_cus as bc,
	 loan as l, cus_loa as cl
    
where c.cus_id = bc.Cus_id and 
      ifb.banker_id = bc.banker_id and 
      c.cus_id=cl.cus_id and 
      l.loan_number=cl.loan_number ;
 
  xem số thẻ và mã account của khách hàng
 select c.name as 'Tên Khách Hàng',
		ac.Account_number As 'Số Tài Khoản',
        cr.Card_Number as'Số Thẻ'	
from customer as c,
     cus_crcard_ac as ca,
     Account as ac,
     CreditCard as cr
 
 where c.cus_id=ca.cus_id and
       cr.Card_Number=ca.Card_Number and 
       ac.Account_number=ca.Account_number;
 
 Hiển thị tên khách hàng và tên ngân hàng và số tiền hiện có trong tài khoảng 
 
 select c.name as 'Tên Khách Hàng',
        c.street as'Đường ', c.city'Thành Phố' , 
		bi.banker_name as 'Tên Ngân Hàng' , 
		a.Balance as 'Số Dư (VND)'
 from Banker_information as bi,
	  customer as c,ban_cus as bc,
	  Account as a,
      cus_crcard_ac as ca
 where
  c.cus_id = bc.cus_id and
  bi.banker_id = bc.banker_id and
  c.cus_id =ca.cus_id and a.Account_number=ca.Account_number;*/
  
create table  badmin(
username varchar(20),
password  varchar(20)
);

insert into badmin(username,password) values(
'admin','admin');
select* from customer;
