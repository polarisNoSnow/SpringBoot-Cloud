# SpringBoot-Cloud
#springboot+cloud开发

##---SpringCloud---
1.服务调度：Eureka注册中心（server端），其它服务的生产者消费者都属于Client

2.负载均衡：(ribbon+RestTemplate)和feign都作为远程服务调用可以负载均衡，后者在前者的基础上做了更好的处理（使用HTTP请求远程服务时能与调用本地方法一样的编码体验）

3.断路器：Hystrix，熔断机制，提高服务的可用率，防止雪崩效应

4.网关路由：zuul，可作为对外网关，类似于nginx（zuul不仅只是路由，并且还能过滤，做一些安全验证）

5.分布式配置中心：Spring Cloud Config，为分布式服务提供统一配置，可从指定位置获取（目前从git获取）
问题：server是实时从github获取，client只会在启动时候获取一次

6.服务链路追踪：Spring Cloud Sleuth（Sleuth）实现了一种分布式追踪解决方案，其兼容了Zipkin（分布式链路调用监控系统，聚合各业务系统调用延迟数据，达到链路调用监控跟踪）, HTrace和log-based追踪
