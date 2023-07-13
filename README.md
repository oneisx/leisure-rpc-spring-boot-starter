# Leisure RPC
Leisure RPC是基于Spring Boot Starter的小型RPC框架。编写这个RPC框架并不是为了重复造轮子，而是出于学习的目的，通过手写一款RPC框架来达到知识的学习和应用目的。

## 快速上手
(1) 生成本地Maven依赖
```
# 进入源码pom文件目录，执行命令
mvn clean install
```

(2) 服务提供者、消费者同时引入Maven依赖
```
<dependency>
    <groupId>wang.leisure</groupId>
    <artifactId>leisure-rpc-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

(3) 服务提供者、消费者同时配置注册中心(请更换为自己的ZK地址)
```
leisure.rpc.register-address=192.168.199.241:2181
```

(4) 服务提供者注解服务示例(@Service)
```java
import wang.leisure.rpc.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public ApiResult<User> getUser(Long id) {
        User user = getFromDbOrCache(id);
        return ApiResult.success(user);
    }

    private User getFromDbOrCache(Long id) {
        return new User(id, "东方雨倾", 1, "https://leisure.wang");
    }
}
```

(5) 服务消费者注入服务示例(@InjectService)
```java
@RestController
@RequestMapping("/index/")
public class IndexController {

    @InjectService
    private UserService userService;

    /**
     * 获取用户信息
     * http://localhost:8080/index/getUser?id=1
     *
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("getUser")
    public ApiResult<User> getUser(Long id) {
        return userService.getUser(id);
    }
}
```

可通过项目[leisure-rpc-example](https://github.com/OakWang/leisure-rpc-example)快速获取展示示例。

