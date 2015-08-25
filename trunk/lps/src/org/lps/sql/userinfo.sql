/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2010-9-24 20:23:31                           */
/*==============================================================*/


/*alter table OM_EMPLOYEE
   drop primary key;*/

drop table if exists OM_EMPLOYEE;

/*==============================================================*/
/* User: CORDYS                                                 */
/*==============================================================*/
/*create user CORDYS;*/

/*==============================================================*/
/* Table: OM_EMPLOYEE                                           */
/*==============================================================*/
create table OM_EMPLOYEE
(
   EMP_ID               numeric(10,0) not null comment '人员编号',
   EMP_CODE             varchar(30) comment '人员代码',
   OPERATOR_ID          numeric(18,0) comment '操作员编号（对应操作员表的操作员编号，允许为空）',
   USER_ID              varchar(30) comment '操作员登录号（对应操作员表的操作员登录号，允许为空（冗余字段））',
   EMP_NAME             varchar(50) comment '人员姓名',
   REAL_NAME            varchar(50) comment '人员全名（英文全名）',
   SEX                  varchar(255) comment '性别',
   BIRTH_DATE           date comment '出生日期',
   POSITION             numeric(10,0) comment '基本岗位',
   STATUS               varchar(255) comment '状态',
   CERTIFICATE_TYPE     varchar(255) comment '证件类型',
   CERTIFICATE_NO       varchar(20) comment '证件号码',
   ENTRY_DATE           date comment '入职日期',
   DEPARTURE_DATE       date comment '离职日期',
   OFFICE_PHONE         varchar(12) comment '办公电话',
   OFFICE_ADDRESS       varchar(255) comment '办公地址',
   OFFICE_ZIPCODE       varchar(10) comment '办公邮编',
   OFFICE_EMAIL         varchar(128) comment '办公邮件',
   FAX_NO               varchar(14) comment '传真号码',
   MOBILE_NO            varchar(14) comment '手机号码',
   MSN_NO               varchar(16) comment 'MSN号码',
   HOME_PHONE           varchar(12) comment '家庭电话',
   HOME_ADDRESS         varchar(128) comment '家庭地址',
   HOME_ZIPCODE         varchar(10) comment '家庭邮编',
   PRIVATE_EMAIL        varchar(128) comment '私人电子邮箱',
   POLITICAL_LANDSCAPE  varchar(255) comment '政治面貌',
   DEGREE               varchar(255) comment '职级',
   DIRECT_SUPERVISOR    numeric(10,0) comment '直接主管',
   SPECIALTY            varchar(1024) comment '可授权角色',
   WORK_DESC            varchar(512) comment '工作描述',
   REG_DATE             date comment '注册日期',
   CREATE_DATE          timestamp comment '创建时间',
   LAST_MODIFY_DATE     date comment '最新更新时间',
   ORGID_LIST           varchar(128) comment '如果是多个机构，则机构编号之间用,分割',
   ORG_ID               numeric(10,0) comment '主机构编号',
   NOTES                varchar(512) comment '备注',
   DN                   varchar(250) comment 'DN'
);

alter table OM_EMPLOYEE comment '人员信息表';

alter table OM_EMPLOYEE
   add primary key (EMP_ID);

