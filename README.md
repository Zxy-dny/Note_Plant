# 第一个实战项目（ XXX 用户中心系统 )

<img width="1727" height="951" alt="image" src="https://github.com/user-attachments/assets/40146357-3d36-4f8e-b5c7-bbfa3f24fa16" />

## 需求分析

1. **登录 / 注册**
2. **用户管理（仅管理员可见）对用户的查询或者修改**
3. 用户校验（**仅系统用户**）

## 技术选型

前端：三件套 + React + 组件库 Ant Design + Umi + Ant Design Pro (现成的管理系统)

后端:

- java
- spring ( 依赖注入框架，帮助你管理 Java 对象，集成一些其他的内容) 
- springmvc (web 框架,提供接口访问、restful 接口等能力)
- mybatis ( Java 操作数据库的框架，持久层框架，对 jdbc 的封装) 
- mybatis-plus (对 mybatis 的增强，不用写 sql 也能实现增删改查)
- springboot ( **快速启动** / 快速集成项目。不用自己管理 spring 配置，不用自己整合各种框架)
- junit 单元测试库
- mysql 数据库

部署: 服务器 / 容器 (平台)

## 数据库设计

### 用户表设计

```text
id（主键）bigint

username 昵称  varchar

userAccount 登录账号

avatarUrl 头像 varchar

gender 性别 tinyint

userPassword 密码  varchar

phone 电话 varchar

email 邮箱 varchar

userStatus 用户状态 int  0 - 正常

createTime 创建时间（数据插入时间）datetime

updateTime 更新时间（数据更新时间）datetime

isDelete 是否删除 0 1（逻辑删除）tinyint

userRole 用户角色 0 - 普通用户 1 - 管理员

```

### 自动生成器的使用

MyBatisX 插件，自动根据数据库生成 :

- domain: 实体对象

- mapper: 操作数据库的对象

- mapperxml: 定义了 mapper 对象和数据库的关联 ，可 以 在 里 面 自己 写 SQL

- service: 包含 常用 的 增删 改 查

- servicelmpl: 具体 实现 service

## 注册逻辑设计

1. 用户在前端输入账户和密码、以及校验码(todo)

2. 校验用户的账户、密码、校验密码，是否符合要求
   1. 非空
   2. 账户长度不小于4位
   3. 密码就不小于8位吧
   4. 账户不能重复
   5. 账户不包含特殊字符
   6. 密码和校验密码相同

3. 对密码进行加密(密码千万不要直接以明文存储到数据库中)

4. 向数据库插入用户数据

## 登录功能

**接口设计**

接受参数: 用户账户、密码

请求类型: POST

请求体: JSON 格式的数据  JSON RPC

```text
请求参数很长时不建议用 get
```

返回值: 用户信息 (脱敏)

**登录逻辑**

1. 校验用户账户和密码是否合法

2. 非空

3. 账户长度不小于4位

4. 密码就不小于8位

5. 账户不包含特殊字符

6. 校验密码是否输入正确，要和数据库中的密文密码去对比

7. 用户信息脱敏，隐藏敏感信息，防止数据库中的字段泄露

8. 我们要记录用户的登录态(session)，将其存到服务器上 (用后端SpringBoot框架封装的服务器tomcat去记录)

cookie

5.返回脱敏后的用户信息
