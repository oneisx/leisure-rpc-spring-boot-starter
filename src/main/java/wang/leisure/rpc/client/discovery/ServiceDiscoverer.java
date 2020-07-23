package wang.leisure.rpc.client.discovery;


import wang.leisure.rpc.common.service.Service;

import java.util.List;

/**
 * 服务发现抽象类，定义服务发现规范
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public interface ServiceDiscoverer {
    List<Service> getServices(String name);
}
