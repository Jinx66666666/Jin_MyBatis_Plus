DROP TABLE IF EXISTS user;

create table user
(
    id           bigint not null comment '主键ID'
        auto_increment primary key,
    name         varchar(30) null comment '姓名',
    age          int null comment '年龄',
    email        varchar(50) null comment '邮箱',
    logic_flag   int null comment '逻辑删除属性',
    creator      varchar(50) null comment 'creator',
    gmt_create   varchar(50) null comment 'gmtCreate',
    gmt_modified varchar(50) null comment 'gmtModified'
);