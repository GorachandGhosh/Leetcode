# Write your MySQL query statement below
select
machine_id, round(avg(end-start),3) as processing_time
from
(
    select machine_id, process_id,
    max(case when activity_type = 'start' then timestamp end) as start,
    max(case when activity_type = 'end' then timestamp end) as end
    from activity group by machine_id, process_id
) as proess_seq
group by machine_id;