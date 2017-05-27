
/* Drop Triggers */

DROP TRIGGER TRI_MEMBER_NUM;
DROP TRIGGER TRI_HISTORY_NUM;
DROP TRIGGER TRI_MEMBERS_NUM;
DROP TRIGGER TRI_RESERVATION_NUM;



/* Drop Tables */

DROP TABLE RESERVATION CASCADE CONSTRAINTS;
DROP TABLE MEMBERS CASCADE CONSTRAINTS;
DROP TABLE Manager CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_MEMBER_NUM;
DROP SEQUENCE SEQ_HISTORY_NUM;
DROP SEQUENCE SEQ_MEMBERS_NUMS;
DROP SEQUENCE SEQ_RESERVATION_NUM;




/* Create Sequences */

CREATE SEQUENCE SEQ_MEMBER_NUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_HISTORY_NUM INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_MEMBERS_NUMS INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_RESERVATION_NUM INCREMENT BY 1 START WITH 1;



/* Create Tables */

/*환자 테이블*/
CREATE TABLE MEMBERS
(
	NUMS number(3,0),
	NAME varchar2(20) NOT NULL,
	JUMIN varchar2(20) NOT NULL ,
	PHONE varchar2(20) NOT NULL UNIQUE,
	ADDR varchar2(100) NOT NULL,
	Gender varchar2(10) NOT NULL,
	PRIMARY KEY (JUMIN)
);



insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'김환자','900101-1234567','01013589654','경기도 고양시 일산동구','남');

insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'김환자','900101-1598654','01045408144','경기도 청주시 ','여');

insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'박환자','900807-2345678','01041254754','서울특별시 중구 태평로1가','여');

insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'장환자','930827-1345678','01035758527','서울특별시 종로구 평창동','남');

insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'남궁환자','941024-2456789','01056987412','서울특별시 중구  을지로2가','여');

insert into MEMBERS(NUMS,NAME,JUMIN,PHONE,ADDR,Gender)
values(SEQ_MEMBERS_NUMS.nextval,'백환자','940529-2567891','01041258963','서울특별시 서대문구 홍제동 ','여');


/*테이블 내용 확인, 삭제*/
select * from members;
delete table members;


/*관리자 테이블*/
CREATE TABLE Manager
(
	M_code varchar2(15) NOT NULL,
	M_job varchar2(15) NOT NULL,
	M_name varchar2(15) NOT NULL,
	M_phone number(20) NOT NULL UNIQUE,
	M_subject varchar2(15) NOT NULL,
	M_password number(20) NOT NULL UNIQUE,
	PRIMARY KEY (M_code)
);

insert into Manager(M_code, M_job, M_name, M_phone, M_subject, M_password)
values('d연성','의사','김연성',01012341234,'외과',11111);

insert into Manager(M_code, M_job, M_name, M_phone, M_subject, M_password)
values('d두리','의사','박두리',01023452345,'내과',22222);

insert into Manager(M_code, M_job, M_name, M_phone, M_subject, M_password)
values('d성일','의사','장성일',01034563456,'신경외과',33333);

insert into Manager(M_code, M_job, M_name, M_phone, M_subject, M_password)
values('d은지','의사','남궁은지',01045674567,'소아과',55555);

insert into Manager(M_code, M_job, M_name, M_phone, M_subject, M_password)
values('d나연','의사','백나연',01056785678,'정형외과',66666);


/*테이블 내용 확인, 삭제*/
select * from Manager;
delete table Manager;


/*환자 예약 테이블*/
CREATE TABLE RESERVATION
(
	Dates varchar2(20) NOT NULL,
	Today date NOT NULL,
	Disease varchar2(100) NOT NULL,
	JUMIN varchar2(20) NOT NULL,
	NAME varchar2(20) NOT NULL,
	NUM number(3,0) NOT NULL,
	M_code varchar2(15) NOT NULL,
	Time varchar2(20) NOT NULL,
	PRIMARY KEY (NUM)
);


/*테이블 내용 확인, 삭제*/
select * from Reservation;
delete from Reservation;

delete from emp01 where first_name = 'candy';

<!-- 8월 17일 모든시간 다 찼을 때 마감 판별 용 -->
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오전9시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오전10시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오전11시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오전12시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오후1시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오후2시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오후3시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오후4시');
insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-30',sysdate, '외과','900101-1234567', '김환자', SEQ_RESERVATION_NUM.nextval,'d연성','오후5시');





insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-22',sysdate, '외과','900101-1234567','김환자',SEQ_RESERVATION_NUM.nextval,'d연성','오전09시');

insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-23',sysdate, '신경외과','930827-1345678','장환자',SEQ_RESERVATION_NUM.nextval,'d성일','오전10시');

insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-24',sysdate, '내과','930827-1345678','박환자',SEQ_RESERVATION_NUM.nextval,'d두리','오전11시');

insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-25',sysdate, '소아과','941024-2456789','남궁환자',SEQ_RESERVATION_NUM.nextval,'d은지','오후1시');

insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
values('2016-8-26',sysdate, '정형외과','940529-2567891','백환자',SEQ_RESERVATION_NUM.nextval,'d나연','오후2시');

delete from RESERVATION;
select * from RESERVATION;


/* Create Foreign Keys */

ALTER TABLE RESERVATION
	ADD FOREIGN KEY (JUMIN)
	REFERENCES MEMBERS (JUMIN)
;


ALTER TABLE RESERVATION
	ADD FOREIGN KEY (M_code)
	REFERENCES Manager (M_code)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_MEMBER_NUM BEFORE INSERT ON MEMBER
FOR EACH ROW
BEGIN
	SELECT SEQ_MEMBER_NUM.nextval
	INTO :new.NUM
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_HISTORY_NUM BEFORE INSERT ON HISTORY
FOR EACH ROW
BEGIN
	SELECT SEQ_HISTORY_NUM.nextval
	INTO :new.NUM
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_MEMBERS_NUM BEFORE INSERT ON MEMBERS
FOR EACH ROW
BEGIN
	SELECT SEQ_MEMBERS_NUM.nextval
	INTO :new.NUM
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_RESERVATION_NUM BEFORE INSERT ON RESERVATION
FOR EACH ROW
BEGIN
	SELECT SEQ_RESERVATION_NUM.nextval
	INTO :new.NUM
	FROM dual;
END;

/




