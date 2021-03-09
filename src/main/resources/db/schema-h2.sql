DROP TABLE IF EXISTS user;

create table user
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    name         varchar(30) null comment '姓名',
    age          int null comment '年龄',
    email        varchar(50) null comment '邮箱',
    logic_flag   int default 0 null comment '逻辑删除属性',
    version      int default 1 null,
    creator      varchar(50) null comment 'creator',
    gmt_create   datetime null comment 'gmtCreate',
    gmt_modified datetime null
);
