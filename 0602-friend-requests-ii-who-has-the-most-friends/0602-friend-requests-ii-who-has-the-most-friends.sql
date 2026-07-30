# Write your MySQL query statement 
SELECT id,COUNT(id)as num
from 
(Select requester_id as id
from RequestAccepted

UNION ALL

Select accepter_id as id
from RequestAccepted 
) as friend_pair
group by id
order by num desc limit 1

