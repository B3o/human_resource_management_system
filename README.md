#### 前言
**简易人事管理系统**
使用SSM(Spring + Spring MVC + MyBatis)开发
前端使用easyUI框架

#### 界面预览

![登录界面](https://raw.githubusercontent.com/bbbemore/human_resource_management_system/master/src/main/resources/Project_screenshots/login.jpg)
<p align="center">
    登录界面
</p>

![主要界面](https://raw.githubusercontent.com/bbbemore/human_resource_management_system/master/src/main/resources/Project_screenshots/main.jpg)
<p align="center">
    主要界面
</p>

![添加员工](https://raw.githubusercontent.com/bbbemore/human_resource_management_system/master/src/main/resources/Project_screenshots/add.jpg)
<p align="center">
    添加员工
</p>






#### 数据库设计实现
```sql

create table admin_tb ( 
    admin_id int(11) not null auto_increment, 
    username varchar(20) not null, 
    password varchar(20) not null,
    role_name varchar(20) not null default 'normaladmin', 
    primary key(admin_id)
    );
    
    create table post_tb(
    post_id int(11) not null auto_increment,
    title varchar(50) not null,
    content text not null,
    admin_id int(11) not null,
    create_date date not null,
    primary key(post_id),
    foreign key(admin_id) references admin_tb(admin_id)
);

create table dept_tb(
    dept_id int(11) not null auto_increment,
    dept_name varchar(50) not null,
    dept_description varchar(200) not null,
    primary key(dept_id)
);

create table position_tb(
    pos_id int(11) not null auto_increment,
    pos_name varchar(50) not null,
    pos_description varchar(200) not null,
    primary key(pos_id)
);

create table employee_tb(
    emp_id varchar(20) not null,
    emp_name varchar(50) not null,
    sex varchar(10) not null,
    phone varchar(20) not null,
    email varchar(50) not null,
    address varchar(100) not null,
    education varchar(50) not null,
    birthday date not null,
    dept_id int(11) not null,
    pos_id int(11) not null,
    primary key(emp_id),
    foreign key(dept_id) references dept_tb(dept_id),
    foreign key(pos_id) references position_tb(pos_id)
);
```

