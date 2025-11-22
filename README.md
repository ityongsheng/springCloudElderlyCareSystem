<p align="center">
 <img src="https://img.shields.io/badge/Spring%20Cloud-2024-blue.svg" alt="Coverage Status">
 <img src="https://img.shields.io/badge/Spring%20Boot-3.4.5-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/badge/Vue-3.2-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/github/license/YunaiV/star-cloud" alt="Downloads" />
</p>

**严肃声明：现在、未来都不会有商业版本，所有代码全部开源!！**

**「我喜欢写代码，乐此不疲」**  
**「我喜欢做开源，以此为乐」**

我 🐶 在上海艰苦奋斗，早中晚在 top3 大厂认真搬砖，夜里为开源做贡献。

如果这个项目让你有所收获，记得 Star 关注哦，这对我是非常不错的鼓励与支持。

## 🐶 新手必读

* 演示地址【Vue3 + element-plus】：<http://dashboard-vue3.star.iocoder.cn>
* 演示地址【Vue3 + vben(ant-design-vue)】：<http://dashboard-vben.star.iocoder.cn>
* 演示地址【Vue2 + element-ui】：<http://dashboard.star.iocoder.cn>

## 🐰 版本说明

| 版本                                                                    | JDK 8 + Spring Boot 2.7                                                  | JDK 17/21 + Spring Boot 3.2                                                          |
|-----------------------------------------------------------------------|--------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| 【完整版】[star-cloud](https://gitee.com/zhijiantianya/star-cloud)       | [`master`](https://gitee.com/zhijiantianya/star-cloud/tree/master/) 分支  | [`master-jdk17`](https://gitee.com/zhijiantianya/star-cloud/tree/master-jdk17/) 分支  |
| 【精简版】[star-cloud-mini](https://gitee.com/starcode/star-cloud-mini) | [`master`](https://gitee.com/starcode/star-cloud-mini/tree/master/) 分支 | [`master-jdk17`](https://gitee.com/starcode/star-cloud-mini/tree/master-jdk17/) 分支 |

* 【完整版】：包括系统功能、基础设施、会员中心、数据报表、工作流程、商城系统、微信公众号、CRM、ERP 等功能
* 【精简版】：只包括系统功能、基础设施功能，不包括会员中心、数据报表、工作流程、商城系统、微信公众号、CRM、ERP 等功能

## 🐯 平台简介

**芋道**，以开发者为中心，打造中国第一流的快速开发平台，全部开源，个人与企业可 100% 免费使用。

> 有任何问题，或者想要的功能，可以在 _Issues_ 中提给艿艿。
> 😜 给项目点点 Star 吧，这对我们真的很重要！

![架构图](/.image/common/star-cloud-architecture.png)

* Java 后端：`master` 分支为 JDK 8 + Spring Boot 2.7，`master-jdk17` 分支为 JDK 17/21 + Spring Boot 3.2
* 管理后台的电脑端：Vue3 提供 [element-plus](https://gitee.com/starcode/star-ui-admin-vue3)、[vben(ant-design-vue)](https://gitee.com/starcode/star-ui-admin-vben) 两个版本，Vue2 提供 [element-ui](https://gitee.com/zhijiantianya/ruoyi-vue-pro/tree/master/star-ui-admin) 版本
* 管理后台的移动端：采用 [uni-app](https://github.com/dcloudio/uni-app) 方案，一份代码多终端适配，同时支持 APP、小程序、H5！
* 后端采用 Spring Cloud Alibaba 微服务架构，注册中心 + 配置中心 Nacos，定时任务 XXL-Job，服务保障 Sentinel，服务网关 Gateway，分布式事务 Seata
* 数据库可使用 MySQL、Oracle、PostgreSQL、SQL Server、MariaDB、国产达梦 DM、TiDB 等，基于 MyBatis Plus、Redis + Redisson 操作
* 消息队列可使用 Event、Redis、RabbitMQ、Kafka、RocketMQ 等
* 权限认证使用 Spring Security & Token & Redis，支持多终端、多种用户的认证系统，支持 SSO 单点登录
* 支持加载动态权限菜单，按键级别权限控制，Redis 缓存提升性能
* 支持 SaaS 多租户，可自定义每个租户的权限，提供透明化的多租户底层封装
* 工作流使用 Flowable，支持动态表单、在线设计流程、会签 / 或签、多种任务分配方式
* 高效率开发，使用代码生成器可以一键生成 Java、Vue 前后端代码、SQL 脚本、接口文档，支持单表、树表、主子表
* 实时通信，采用 Spring WebSocket 实现，内置 Token 身份校验，支持 WebSocket 集群
* 集成微信小程序、微信公众号、企业微信、钉钉等三方登陆，集成支付宝、微信等支付与退款
* 集成阿里云、腾讯云等短信渠道，集成 MinIO、阿里云、腾讯云、七牛云等云存储服务
* 集成报表设计器、大屏设计器，通过拖拽即可生成酷炫的报表与大屏

##  🐳 项目关系

![架构演进](/.image/common/star-roadmap.png)

### 后端项目

| 项目                                                              | Star                                                                                                                                                                                                                                                                                             | 简介                          |
|-----------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| [ruoyi-vue-pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro)  | [![Gitee star](https://gitee.com/zhijiantianya/ruoyi-vue-pro/badge/star.svg?theme=white)](https://gitee.com/zhijiantianya/ruoyi-vue-pro) [![GitHub stars](https://img.shields.io/github/stars/YunaiV/ruoyi-vue-pro.svg?style=social&label=Stars)](https://github.com/YunaiV/ruoyi-vue-pro)       | 基于 Spring Boot 多模块架构        |
| [star-cloud](https://gitee.com/zhijiantianya/star-cloud)      | [![Gitee star](https://gitee.com/zhijiantianya/star-cloud/badge/star.svg?theme=white)](https://gitee.com/zhijiantianya/star-cloud) [![GitHub stars](https://img.shields.io/github/stars/YunaiV/star-cloud.svg?style=social&label=Stars)](https://github.com/YunaiV/star-cloud)               | 基于 Spring Cloud 微服务架构       |
| [Spring-Boot-Labs](https://gitee.com/starcode/SpringBoot-Labs) | [![Gitee star](https://gitee.com/starcode/SpringBoot-Labs/badge/star.svg?theme=white)](https://gitee.com/zhijiantianya/star-cloud) [![GitHub stars](https://img.shields.io/github/stars/starcode/SpringBoot-Labs.svg?style=social&label=Stars)](https://github.com/starcode/SpringBoot-Labs) | 系统学习 Spring Boot & Cloud 专栏 |

### 前端项目

| 项目                                                                         | Star                                                                                                                                                                                                                                                                                                                     | 简介                                     |
|----------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| [star-ui-admin-vue3](https://gitee.com/starcode/star-ui-admin-vue3)     | [![Gitee star](https://gitee.com/starcode/star-ui-admin-vue3/badge/star.svg?theme=white)](https://gitee.com/starcode/star-ui-admin-vue3) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-ui-admin-vue3.svg?style=social&label=Stars)](https://github.com/starcode/star-ui-admin-vue3)         | 基于 Vue3 + element-plus 实现的管理后台         |
| [star-ui-admin-vben](https://gitee.com/starcode/star-ui-admin-vben)     | [![Gitee star](https://gitee.com/starcode/star-ui-admin-vben/badge/star.svg?theme=white)](https://gitee.com/starcode/star-ui-admin-vben) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-ui-admin-vben.svg?style=social&label=Stars)](https://github.com/starcode/star-ui-admin-vben)         | 基于 Vue3 + vben(ant-design-vue) 实现的管理后台 |
| [star-mall-uniapp](https://gitee.com/starcode/star-mall-uniapp)         | [![Gitee star](https://gitee.com/starcode/star-mall-uniapp/badge/star.svg?theme=white)](https://gitee.com/starcode/star-mall-uniapp) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-mall-uniapp.svg?style=social&label=Stars)](https://github.com/starcode/star-mall-uniapp)                 | 基于 uni-app 实现的商城小程序                    |
| [star-ui-admin-vue2](https://gitee.com/starcode/star-ui-admin-vue2)     | [![Gitee star](https://gitee.com/starcode/star-ui-admin-vue2/badge/star.svg?theme=white)](https://gitee.com/starcode/star-ui-admin-vue2) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-ui-admin-vue2.svg?style=social&label=Stars)](https://github.com/starcode/star-ui-admin-vue2)         | 基于 Vue2 + element-ui 实现的管理后台           |
| [star-ui-admin-uniapp](https://gitee.com/starcode/star-ui-admin-uniapp) | [![Gitee star](https://gitee.com/starcode/star-ui-admin-uniapp/badge/star.svg?theme=white)](https://gitee.com/starcode/star-ui-admin-uniapp) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-ui-admin-uniapp.svg?style=social&label=Stars)](https://github.com/starcode/star-ui-admin-uniapp) | 基于 Vue2 + element-ui 实现的管理后台           |
| [star-ui-go-view](https://gitee.com/starcode/star-ui-go-view)           | [![Gitee star](https://gitee.com/starcode/star-ui-go-view/badge/star.svg?theme=white)](https://gitee.com/starcode/star-ui-go-view) [![GitHub stars](https://img.shields.io/github/stars/starcode/star-ui-go-view.svg?style=social&label=Stars)](https://github.com/starcode/star-ui-go-view)                     | 基于 Vue3 + naive-ui 实现的大屏报表             |

## 😎 开源协议

采用 [MIT License](https://gitee.com/zhijiantianya/ruoyi-vue-pro/blob/master/LICENSE) 协议，个人与企业可 100% 免费使用。

---

> 已移除外部教程与文档链接，保留核心项目说明。
