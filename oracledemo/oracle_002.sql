--'Lex'와 동일한 직업(job_id)을 가진 사원의 이름(first_name),
-- 직업(job_title), 입사일(hire_date)을 출력하시오.


select e.first_name, j.job_title, e.hire_date 
from employees e ,jobs j 
where e.job_id=j.job_id and j.job_id=(select job_id from employees where first_name = 'Lex');
                         
--IT에 근무하는 사원의 이름, 부서번호를 출력하시오.
select first_name, department_id
from employees
where department_id = (select department_id
                         from departments
                         where department_name= 'IT');


					
--Bruce보다 연봉을  많이 받은 사원이름(first_name), 부서명을 출력하시오.


select e.first_name, d.department_id
from employees e, departments  d
where department_id =d.department_id and 
e.salary>(select salary from employees where first_name= 'Bruce');
                         
                         
--Steven와 같은 부서에서 근무하는 사원의 이름 , 급여 , 입사일 을 출력하시요 (in)

select first_name,salary, hire_date
from employees
where department_id in(select department_id from employees where first_name= 'Steven');


--부서별로 가장 급여를 많이받는 사원의 이름, 급여 , 부서번호를 출력하시요(in) 

select first_name ,salary,department_id
from EMPLOYEES
where (department_id, salary)
in (
select department_id,  max(salary)
from employees
group by department_id
)
order by department_id;

--30소속된 사원들중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를  받는 사원의 이름, 급여, 입사일을 출력하시오.(all)
--(서브쿼리에서 max()함수를 사용하지 않는다.) 

select first_name,salary,hire_date
from employees
where salary > all(
select salary
from employees
where department_id =30
);

--부서번호가 30번인 사원들이 받는 최저급여보다  높은 급여를 받는 사원의 이름,급여, 입사일을 출력하시오.(any)	
-- (min( )함수를 사용하지 않는다)

select first_name, salary, hire_date
from employees
where salary > any(
select salary
from employees
where department_id=30
);

                         
--20번 부서에 속한 사원이 있으면 사원들의 사원명, 입사일, 급여, 부서번호를 출력하시오.(exists)                 
                         
select first_name, salary, hire_date
from employees
where exists(
select department_id
from employees
where department_id=20
);

------------------------------------------------------
Top-N 서브쿼리
   상위의 값을 추출할때 사용된다.
   <, <=연산자를 사용할수 있다. 단 비교되는 값이 1일때는 =도 가능하다.
   order by절을 사용할 수 있다.
------------------------------------------------------

-- 급여가 가장 높은 상위 3명을 검색하시오.

 select b.*
 from(
 select rownum as rm, a.first_name, a.salary
 from(select first_name, salary
 from employees
 order by salary desc) a) b
 
where b.rm <=3;

컬럼이나 행의 개수에 따라서
1. 단일행 서브쿼리
2. 다중행 서브쿼리
3. 단일 컬럼 서브쿼리
4. 다중 컬럼 서브쿼리

--부서명에 IT가 포함이된 사람이 속한 사원명, 부서번호, 부서명을 출력하시오(in)
select e.first_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id=d.department_id
   and d.department_id in (
						select department_id
						from departments
						where department_name like '%IT%');
						
select e.first_name, d.department_id, d.department_name
from  employees e, departments d
where e.department_id = d.department_id 
and d.department_id in (
                         select department_id
                         from departments
                         where department_name= like '%IT%');



--Toronto 사원들보다 많은 연봉을 받는 first_name, city, salary을 출력하시오  (any연산자) 단 부서가 있는 사원의 정보만 출력한다.
--Toronto은 제외한다. 
select e.first_name, l.city, e.salary
from employees e, departments d, locations l
where e.department_id=d.department_id
    and d.location_id=l.location_id
    and e.salary > any(
					select  e.salary
					from employees e, departments d, locations l
					where e.department_id=d.department_id
					    and d.location_id=l.location_id
					    and l.city='Toronto')
   and l.city <>'Toronto'
   and e.department_id is not null;
                         
select e.first_name, 1.city, e.salary
from employees e ,departments d, locations 1
where e.department_id=d.department_id
and d.location_id=1.location_id
and e.salary > any(
select e.salary
from employees e, departments d, locations 1
where  e.department_id=d.department_id
and d.location_id=1.location_id
and 1.city='Toronto')
and 1.city <> 'Toronto'
and e.department_id is not null;


--연봉이 상위 5~10사이의 사원명, 입사일, 연봉을 출력하시오.(Top-N)


select b.*
 from(
 select rownum as rm, a.*
 from(select first_name, salary
 from employees
 order by salary desc) a) b
 
where b.rm >=5 and b.rm<=10;

                          


-- 연봉이 2500이하인 사원의 사원번호, 사원명,연봉을 검색하시오

select first_name, employee_id, salary
from employees
where salary <=2500;

--사원테이블에서 'Lex'인 사원의 사원번호 ,사원명 ,연봉을 검색하시오

select employee_id, first_name, salary
from employees
where first_name= 'Lex';

--사원번호가 132이거나 140 이거나 148인 사원의 사원번호,연봉을 검색하시오

select employee_id, salary
from employees
where employee_id in(132,140,148);

--연봉이 20000이상인 사원들의 사원명(first_name),입사년도,연봉를 출력하시오

select first_name,hire_date,salary
from employees
where salary >=20000;

-- 사원들의 사원명(first_name),사원명 길이를 출력하시오

select first_name,length(first_name)
from employees, dual;

--"Steven님은 2003년 06월 17일 입사한 사원입니다" 처럼 각 사원을 출력하시오

select first_name||'님은'|| hire_date ||'입사한 사원입니다' as  from employees;

--모든사원에게는 상관(Manager)이 있다. 하지만 employees테이블에 유일하게 상관이
--없는 로우가 있는데 그 사원(CEO)의 MGR컬럼값이 NULL이다. 상관이 없는 사원한
--출력하되 MGR컬럼값 NULL 대신 CEO로 출력하시오

  select manager_id, nvl(to_char(manager_id),'CEO') as "MGR" from employees
  order by manager_id desc;


--가장최근에 입사한 사원의 입사일과 가장오래된 사원의 입사일을 구하시오

select  max(hire_date), min(hire_date)
from employees;

--부서별로 커미션을 받는 사원의 수를 구하시오

select count(commission_pct), department_id
from employees
group by department_id
order by department_id;

--부서별 최대급여가 10000이상이 부서만 출력하시오

select department_id, max(salary)
from employees
where salary >=10000
group by department_id
order by department_id;
 
-- employees 테이블에서 직종이 'IT_PROG'인 사원들의 급여평균을 구하는 SELECT문장을 기술하시오

select  avg(salary)
from employees
where job_id = 'IT_PROG'

-- employees 테이블에서 직종이 'FI_ACCOUNT' 또는 'AC_ACCOUNT' 인 사원들 중 최대연봉을  구하는    SELECT문장을 기술하시오   

select max(salary*12)
from employees
where job_id = 'FI_ACCOUNT' ||  'AC_ACCOUNT';




--employees 테이블에서 50부서의 최소급여를 출력하는 SELECT문장을 기술하시오

select min(salary)
from employees
where department_id =50;

-- employees 테이블에서 아래의결과처럼 입사인원을 출력하는 SELECT문장을 작성하여라         
select sum(decode(to_char(hire_date, 'YYYY'), '2001',1,0)) as "2001",
sum(decode(to_char(hire_date, 'YYYY'), '2002',1,0)) as "2002",
sum(decode(to_char(hire_date, 'YYYY'), '2003',1,0)) as "2003",
sum(decode(to_char(hire_date, 'YYYY'), '2004',1,0)) as "2004"
from employees;
                 
     
--employees 테이블에서 각 부서별 인원이 10명 이상인 부서의 부서코드,인원수,급여의 합을 구하는  SELECT문장을 작성하여라
   SELECT department_id, COUNT(*), SUM(salary) 
   FROM employees
   GROUP BY department_id
   HAVING COUNT(*) >= 10;

                         

--문제개요 : EMPLOYEES 테이블에서 입사한 달(hire_date) 별로 인원수를 조회하시오 . 

select to_char(hire_date, 'MM')||'월' as “월”, count(employee_id) 직원수 from employees 
group by to_char(hire_date, 'MM') order by to_char(hire_date, 'MM');                        
                         
    
--문제 개요 : 각 부서에서 근무하는 직원수를 조회하는 SQL 명령어를 작성하시오. 단, 직원수가 5명 이하인 부서 정보만 출력되어야 하며 부서정보가 없는 직원이 있다면 부서명에 “<미배치인원>” 이라는 문자가 출력되도록 하시오. 그리고 출력결과는 직원수가 많은 부서먼저 출력되어야 합니다.
select nvl(department_name, '<미배치인원>') 부서명, count(*) 직원수
from employees e, departments d
where e.department_id = d.department_id(+)
group by d.department_name
having count(*) <= 5
order by count(*) desc

--각 부서 이름 별로 2003년 이전에 입사한 직원들의 인원수를 조회하시오.
select d.department_name 부서명, to_char(e.hire_date,'YYYY') 입사일, count(e.employee_id) 인원수 from employees e, departments d 
where e.department_id = d.department_id and e.hire_date < '01/01/2003' group by d.department_name, to_char(e.hire_date,'YYYY');


--문제 개요 : 직책(job_title)이 'manager' 인 사람의 이름(first_name), 직책(job_title), 부서명(department_name)을 조회하시오.
SELECT E.FIRST_NAME, J.JOB_TITLE, D.DEPARTMENT_NAME
FROM EMPLOYEES E, JOBS J, DEPARTMENTS D
WHERE E.JOB_ID = J.JOB_ID  AND  E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND J.JOB_TITLE LIKE '%Manager' 

--문제 개요 : 'Executive' 부서에 속에 있는 직원들의 관리자 이름을 조회하시오. 단, 관리자가 없는 직원이 있다면 그 직원 정보도 출력결과에 포함시켜야 합니다.
SELECT E.DEPARTMENT_ID 부서, E.FIRST_NAME 직원명, E2.FIRST_NAME 관리자명
FROM EMPLOYEES E, EMPLOYEES E2, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND D.DEPARTMENT_NAME = 'Executive' AND E2.EMPLOYEE_ID (+)= E.MANAGER_ID  order by 관리자명


--문제개요 : department_id가 60인 부서의 도시명을 알아내는 SELECT문장을 기술하시오
SELECT city
    FROM locations
    WHERE location_id = (SELECT location_id
    FROM departments
    WHERE department_id = 60);


--문제개요 : 사번이 107인 사람과 부서가같고,167번의 연봉보다 많은 사람들의 사번,이름,성,연봉를 출력하시오

    SELECT employee_id, last_name, first_name, department_id, salary
    FROM employees
    WHERE department_id = (SELECT department_id 
                                       FROM employees 
                                       WHERE employee_id = 107)
   AND salary > (SELECT salary 
                        FROM employees 
                        WHERE employee_id = 167)
                        
                        

--문제개요 :  급여평균보다 연봉을 적게받는 사람들중 커미션을 받는 사람들의 사번,이름,성,급여,커미션 퍼센트를 출력하시오


     SELECT employee_id, last_name, first_name, salary, commission_pct
     FROM employees
     WHERE salary < (SELECT avg(salary) 
                              FROM employees) 
    AND commission_pct is not null;
    
 
--문제개요 :  각 부서의 최소연봉가 20번 부서의 최소연봉보다 많은 부서의 번호와 그부서의 최소연봉를 출력하시오

    SELECT department_id, min(salary)
    FROM employees
    GROUP BY department_id
    HAVING min(salary) > (SELECT min(salary) 
                FROM employees 
                WHERE department_id = 20);
order by department_id;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
 
 
 
 
 