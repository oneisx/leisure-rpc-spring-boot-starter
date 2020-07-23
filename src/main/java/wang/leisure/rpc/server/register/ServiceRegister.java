package wang.leisure.rpc.server.register;

/**
 * 服务注册器，定义服务注册规范
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public interface ServiceRegister {

    void register(ServiceObject so) throws Exception;

    ServiceObject getServiceObject(String name) throws Exception;
}
