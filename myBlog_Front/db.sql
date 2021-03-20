-- 创建用户表
create table article
(
  id int auto_increment comment '主键' primary key,
  username varchar(255) not null comment '用户名',
  password varchar(255) not null comment '密码',
  email varchar(255) not null comment '邮箱',
  role varchar(30) default '普通用户' not null comment '角色权限',
  state tinyint default '1' not null comment '角色状态',
  createTime timestamp default CURRENT_TIMESTAMP not null comment '注册时间'
)
  comment '用户'
;

-- 创建文章表
create table article
(
  id int auto_increment comment '主键' primary key,
  user_id varchar(50) not null comment '博文作者',
  title varchar(50) not null comment '文章标题',
  category_id int not null comment '博文分类类别',
  tag varchar(200) not null comment '博文标签',
  type int not null comment '发布形式',
  content longtext null comment '文章内容',
  content_format longtext null comment 'html的content',
  read_num int default '0' null comment '阅读量',
  comment_num int default '0' null comment '评论量',
  like_num int default '0' null comment '点赞量',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '更新时间',
  recommend tinyint(1) default '0' not null comment '是否推荐文章',
  publish tinyint default '1' null comment '发布状态',
  top tinyint(1) default '0' null comment '是否置顶'
)
  comment '文章'
;