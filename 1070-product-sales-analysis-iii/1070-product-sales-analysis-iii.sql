# Write your MySQL query statement below
select product_id,
year as first_year, quantity ,price
from Sales
where(product_id,year) IN
(Select product_id,MIN(year) as fYear
from Sales
group by product_id
) 

