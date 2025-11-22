# star-module-elderly-server

独立养老服务微服务启动模块。

## 功能
聚合 `star-module-elderly-biz` 的所有 REST 接口：档案、健康监测、服务项目、服务订单。

## 启动
```bash
mvn -pl star-module-elderly/star-module-elderly-server -am spring-boot:run -DskipTests
```
或打包：
```bash
mvn -pl star-module-elderly/star-module-elderly-server -am clean package -DskipTests
java -jar star-module-elderly/star-module-elderly-server/target/star-module-elderly-server-*.jar
```

## 默认端口
- 8095

## 必要准备
- MySQL 数据库 & 表结构 (elderly_profile / elderly_health_record / elderly_service_item / elderly_service_order)
- 角色权限：elderly:profile:* / elderly:health:* / elderly:item:* / elderly:order:*

## 后续扩展
- 注册中心(Nacos) & 配置中心集成
- 增加链路追踪、熔断限流、观察性 (Prometheus, SkyWalking)

