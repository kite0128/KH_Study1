select * from departments;
select * from mem order by num;
delete from mem where num>=4;

select e.employee_id, e.first_name, e.salary,
d.department_id, d.department_name,
l.location_id, l.city
from employees e, departments d, locations l
where e.department_id=d.department_id 
and d.location_id=l.location_id