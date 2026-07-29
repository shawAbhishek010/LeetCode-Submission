# Write your MySQL query statement below
(Select name as results from Users u
INNER JOIN MovieRating m
on u.user_id = m.user_id
group by  u.user_id
order by COUNT(rating) DESC, name
LIMIT 1)

UNION ALL

(Select title as results from Movies
INNER JOIN MovieRating 
using (movie_id)
where MONTH(created_at) ='02' AND YEAR(created_at) ='2020'
group by  movie_id
order by AVG(rating) DESC, title
LIMIT 1
)