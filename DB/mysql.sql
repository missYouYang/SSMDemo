/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/10/9                           */
/*==============================================================*/


drop index idx_ad_user_id on ad_user;

drop table if exists ad_user;

/*==============================================================*/
/* Table: ad_user                                           */
/*==============================================================*/
create table ad_user
(
   user_id              varchar(32) not null comment '用户Id',
   user_name            varchar(50) not null comment '用户名',
   user_password        varchar(50) not null comment '用户密码',
   user_phone           varchar(15) comment '用户电话',
   user_sex             varchar(255) comment '用户性别',
   status               int not null default 0 comment '用户状态 -1:删除 0:正常 1:禁用',
   create_user          varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   update_user          varchar(50) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (user_id)
);

alter table ad_user comment '用户信息表';

/*==============================================================*/
/* Index: idx_ad_user_id                                  */
/*==============================================================*/
create index idx_ad_user_id on ad_user
(
   user_id
);