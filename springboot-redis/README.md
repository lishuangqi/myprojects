# redisLock

#### Description
一个应用于springboot项目的，基于redis的分布式锁
可用于多节点项目防重复业务调用

通过方法注解开启
简单、易用

#### how to use

1. 在SpringBootApplication上添加@EnableLock注解引入redisLock。
2. 在需要开启分布式锁的方法上添加@Lock注解。
3. 分布式锁支持粒度为方法参数的级别，通过@LockKey注解到方法参数上，被注解的参数会添加作为redis key的后缀。 具有相同redis key的方法调用会竞争同一把锁。一个方法可以添加多个@LockKey。

![使用示例](https://images.gitee.com/uploads/images/2018/0707/103713_96df9dc4_119335.png "Snip20180707_2.png")

#### Contribution
lishuangq


一个应用于springboot项目的，基于redis的缓存标签注入功能