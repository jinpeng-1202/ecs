//
SELECT
  b.*
FROM
  t_sys_user a,
  t_sys_role b,
  t_role_user c
WHERE a.`id` = c.`user_id`
  AND b.`id` = c.`role_id`
  AND a.`username` = 'jinpeng';

//
SELECT
  d.*,b.`role_name`,b.`name`
FROM
  t_sys_user a,
  t_sys_role b,
  t_role_user c ,
t_sys_menu d,
t_role_menu e
WHERE a.`id` = c.`user_id`
  AND b.`id` = c.`role_id`
  AND b.`id`=e.`role_id`
  AND d.`id`=e.`menu_id`
  AND a.`username` = 'jinpeng' ;