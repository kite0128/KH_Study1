##############################################
게시판 만들기
##############################################

1. 테이블생성 
create table board(
   	num number,
   	writer varchar2(20),
 	email varchar2(30),
	subject varchar2(50),
	passwd varchar2(10),
	reg_date date,
	readcount number default 0, 
	ref number, 
	re_step number, 
	re_level number, 
	content varchar2(100),
	ip varchar2(20),
        upload varchar2(300)
);

2. 시퀀스 생성
create sequence board_seq
  start with 1
  increment by 1
  nocache
  nocycle; 

3. 임의 내용 넣기
insert into board 
values(board_seq.nextval, '홍길동','young@aaaa.com','제목1','1111',sysdate,0,board_seq.nextval,
0,0,'내용 테스트.......','127.0.0.1','sample.txt')

select b.* from 
(select rownum as rm, a.* from(
  select num, ref, re_step,re_level from board
  order by ref desc, re_step asc) a)b
where b.rm >=1  and b.rm<=5

delete from board where num=23;

WebServlet("/board/*")


webContent             /boardview/list.jsp
boardview
  list.jsp

select count(*) from board where subject like '%w%'
select count(*) from board where writer like '%3%'



insert into board(num,reg_date,writer,email,subject,content,upload,ref,re_step,re_level) values(board_seq.nextval,sysdate,'','','','','',board_seq.nextval,0,0)
select * from board

select num, ref, re_step, re_level from board order by num

drop sequence board_seq
delete from board

select * from board order by ref desc, re_step asc

select rownum, b.* from(select rownum as rm, a.* from(select * from board order by ref desc, re_step asc)a)b
where b.rm>=? and b.rm>=?









