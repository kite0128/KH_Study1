 create table mem(
 num number,
 name varchar2(20),
 age  number(3),
 loc varchar2(10));
 
  create sequence mem_num_seq
 start with 1
 increment by 1
 nocache
 nocycle;


insert into mem values(mem_num_seq.nextval,'홍길동',30,'서울');
insert into mem values(mem_num_seq.nextval,'kong',25,'경기');
insert into mem values(mem_num_seq.nextval,'이영희',20,'부산');
insert into mem values(mem_num_seq.nextval,'고사영',30,'대전');

select * from mem;
