select *from NIKONNOTICE;
select *from NIKONPAYMENT;
select *from NIKONPRODUCT;
SELECT *FROM NIKONIN;
select *from Nikonmember;
select *from nikonpaytype;
ALTER TABLE nikonproduct ADD ptype VARCHAR(20);
INSERT INTO nikonproduct ptype VALUES PHONE;

ALTER TABLE nikonproduct RENAME COLUMN cnt TO pcnt;
insert into nikonmember values ('kkt09072', '4321', '김기태', '010-1234-1234', 'kkt09072@naver.com','121-10', '경기도 고양시 일산동구', '도내동 20');
insert into nikonmember values ('kwak', '1111', '곽규진', 'kwak@naver.com', '010-4321-4321','132-21', '경기도 고양시 일산동구', '화정동 382');
insert into nikonmember values ('sin1004', '2222', '신수석', 'sin1004@daum.net', '010-1278-3495','133-24', '경기도 파주시', '야당동 1148');
insert into nikonmember values ('daeho', '3333', '이대호', 'daeho@gmail.com', '010-8282-8282','138-81', '경기도 일산서구', '주엽동 324');
insert into nikonmember values ('geunhee', '4444', '김근희', 'geunhee@naver.com', '010-2424-2424','124-48', '경기도 고양시 일산동구', '정발산동 992');

