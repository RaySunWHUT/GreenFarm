# green farm

## 前言

`green farm` 项目致力于打造一个汇集了全国CSA（社区支持农业模式）和有机生态农场的的电商平台。用户只要打开该应用，即可查看所在城市居住地周边的农场，可以方便快捷地对农场品进行浏览、下单、结算等操作。



## 项目介绍

`green farm` 是一款食材生鲜配送及农场租赁的平台，为良知守卫餐桌上的最后一道健康，好农场精选原生态菜品，为菜农与消费者构造对接的理想平台，让健康菜惠及到千万家庭，同时也扩大了菜农的商路，提高了收入，只需一键点击，点击下单，我们将送货上门,用户也可通过商家提供的农场进行租赁，种植自己所需的农产品，通过消费端拉动生产端转型的模式，可以为解决国内食品安全与农业污染问题提供创造性的解决思路。绿色农场致力于一方面服务消费者，一方面扶持生产者，为我国的农业和食品安全而贡献我们的价值。

电商平台包括前台用户系统、商家系统以及电商后台管理系统，基于Springboot+Mybatis实现。



### 功能介绍

1. **前台用户系统**:

   1. **用户登录**:

      ![user_login](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/user_login.png)

   2. **用户注册**:

      ![user_register](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/user_register.png)

   3. **用户界面**:

      ![index](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/index.png)

   4. **商品展示**:

      ![sell](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/sell.png)

   5. **用户评论**:

      ![comment](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/comment.png)

2. **电商后台管理系统**:

   1. 用户管理

   2. 商家管理

      1. **入驻申请**:

         ![supply](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/back.png)	

   3. 农场管理

   4. 农产品管理

      1. **上架申请**:

         ![supply](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/back.png)

      



3. **商家管理系统**:

   1. **商家登录**:

      ![商家登录](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/greenfarm.png)

   2. **商家入驻**:

      ![商家注册](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/register.png)

   3. **租赁信息管理**:

      ![租赁信息管理](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/rend_manager.png)

   4. **产品信息管理**:

      ![产品信息管理](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/product_manager.png)

   5. **个人信息管理**:

      ![个人信息管理](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/person_manager.png)

   6. **订单信息**:

      ![pay](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/pay.png)

   7. **订单支付**:

      ![pay](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/pay1.png)

      ![pay](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/pay2.png)

   8. **订单派送**:

      ![订单](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/map.png)



### 组织结构

``` lua
greenfarm
├── sun-dao -- 后端数据对象访问层
├── sun-service -- 后端业务层
├── sun-controller -- 后端系统接口层
├── sun-domain -- 后端实例对象
├── sun-exception -- 全局异常检测层
├── sun-shiro -- Apache Shiro封装公用模块
└── sun-util -- 工具类及通用代码
```

### 技术选型

#### 后端技术

| 技术       | 说明           | 官网                                           |
| ---------- | -------------- | ---------------------------------------------- |
| SpringBoot | 容器+MVC框架   | https://spring.io/projects/spring-boot         |
| Shiro      | 认证和授权框架 | http://shiro.apache.org/                       |
| MyBatis    | ORM框架        | http://www.mybatis.org/mybatis-3/zh/index.html |
| Swagger-UI | 文档生产工具   | https://github.com/swagger-api/swagger-ui      |
| Druid      | 数据库连接池   | https://github.com/alibaba/druid               |
| JWT        | JWT登录支持    | https://jwt.io/                                |



#### 前端技术

| 技术       | 说明                  | 官网                           |
| ---------- | --------------------- | ------------------------------ |
| Vue        | 前端框架              | https://vuejs.org/             |
| Vue-router | 路由框架              | https://router.vuejs.org/      |
| Vuex       | 全局状态管理框架      | https://vuex.vuejs.org/        |
| Element    | 前端UI框架            | https://element.eleme.io       |
| Axios      | 前端HTTP框架          | https://github.com/axios/axios |
| v-charts   | 基于Echarts的图表框架 | https://v-charts.js.org/       |



## 架构图

**系统架构图**

![architecture](https://github.com/RaySunWHUT/GreenFarm/blob/master/assets/achitecture.png)

## 模块介绍

### 开发工具

| 工具            | 说明             | 官网                                    |
| --------------- | ---------------- | --------------------------------------- |
| IntelliJ IDEA   | 后端开发IDE      | https://www.jetbrains.com/idea/download |
| Navicat Premium | 数据库连接工具   | http://www.formysql.com/xiazai.html     |
| PowerDesigner   | 数据库设计工具   | http://powerdesigner.de/                |
| InVision Studio | 原型设计工具     | https://www.invisionapp.com/            |
| XMind           | 思维导图设计工具 | https://www.xmind.cn/                   |
| ScreenToGif     | gif录制工具      | https://www.screentogif.com/            |
| Postman         | API接口调试工具  | https://www.postman.com/                |
| Typora          | Markdown编辑器   | https://typora.io/                      |



### 开发环境

| 工具  | 版本号 | 下载                                                         |
| ----- | ------ | ------------------------------------------------------------ |
| JDK   | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql | 5.7.21 | https://www.mysql.com/                                       |
| Vue   | 2.6.0  | https://www.elastic.co/downloads                             |



