# icloud-center （Eureka 注册中心）

> 配置优化

#### 背景
>  默认的Spring Eureka服务器，服务提供者和服务调用者配置不够灵敏，总是服务提供者在停掉很久之后，服务调用者很长时间并没有感知到变化。或者是服务已经注册上去了，但是服务调用方很长时间还是调用不到，发现不了这个服务。

![输入图片说明](https://images.gitee.com/uploads/images/2018/1229/105457_76ab99b3_111383.png "屏幕截图.png")

#### 描述如下：
- EurekaServer默认有两个缓存，一个是ReadWriteMap，另一个是ReadOnlyMap。有服务提供者注册服务或者维持心跳时时，会修改ReadWriteMap。当有服务调用者查询服务实例列表时，默认会从ReadOnlyMap读取（这个在原生Eureka可以配置，SpringCloud Eureka中不能配置，一定会启用ReadOnlyMap读取），这样可以减少ReadWriteMap读写锁的争用，增大吞吐量。EurekaServer定时把数据从ReadWriteMap更新到ReadOnlyMap中。
ReadWriteMap是一个Guava Cache，过期时间是可以配置的。
- 服务提供者注册服务后，会定时心跳。这个根据服务提供者的Eureka配置中的服务刷新时间决定。还有个配置是服务过期时间，这个配置在服务提供者配置但是在EurekaServer使用了，但是默认配置EurekaServer不会启用这个字段。需要配置好EurekaServer的扫描失效时间，才会启用EurekaServer的主动失效机制。在这个机制启用下：每个服务提供者会发送自己服务过期时间上去，EurekaServer会定时检查每个服务过期时间和上次心跳时间，如果在过期时间内没有收到过任何一次心跳，同时没有处于保护模式下（参考第一篇的Eureka自我保护机制），则会将这个实例从ReadWriteMap中去掉。
- 在默认没有启用EurekaServer主动失效服务实例的情况下，服务过期是利用ReadWriteMap超时缓存失效实现的，只有发送心跳的实例缓存不会失效。
- 服务调用者有本地缓存，定时从Eureka服务器上增量拉取所有服务实例列表

#### 原因分析
服务提供者和服务调用者配置不够灵敏，总是服务提供者在停掉很久之后，服务调用者很长时间并没有感知到变化的原因：
EurekaServer自己的ReadWriteMap缓存失效延迟，刷新到ReadOnlyMap的延迟，服务调用者自己本地缓存刷新的延迟。

服务已经注册上去了，但是服务调用方很长时间还是调用不到，发现不了这个服务：
刷新到ReadOnlyMap的延迟，服务调用者自己本地缓存刷新的延迟

#### 配置优化
> EurekaServer修改如下配置

```
eureka:
    server:
        eviction-interval-timer-in-ms: 3000
        responseCacheAutoExpirationInSeconds: 180
        responseCacheUpdateIntervalMs: 3000
```

        
> Eureka服务提供方修改如下配置：

```
eureka:
    instance:
        lease-expiration-duration-in-seconds: 15
        lease-renewal-interval-in-seconds: 5
```


> Eureka服务调用方修改如下配置：

```
eureka:
    client:
        registryFetchIntervalSeconds: 5
ribbon:
    ServerListRefreshInterval: 5000
```

        


 







 