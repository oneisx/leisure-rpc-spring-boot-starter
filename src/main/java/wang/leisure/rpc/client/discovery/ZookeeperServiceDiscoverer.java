package wang.leisure.rpc.client.discovery;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.ZkClient;
import wang.leisure.rpc.common.constants.LeisureConstant;
import wang.leisure.rpc.common.serializer.ZookeeperSerializer;
import wang.leisure.rpc.common.service.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Zookeeper服务发现者，定义以Zookeeper为注册中心的服务发现细则
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public class ZookeeperServiceDiscoverer implements ServiceDiscoverer {

    private ZkClient zkClient;

    public ZookeeperServiceDiscoverer(String zkAddress) {
        zkClient = new ZkClient(zkAddress);
        zkClient.setZkSerializer(new ZookeeperSerializer());
    }

    /**
     * 使用Zookeeper客户端，通过服务名获取服务列表
     * 服务名格式：接口全路径
     *
     * @param name 服务名
     * @return 服务列表
     */
    @Override
    public List<Service> getServices(String name) {
        String servicePath = LeisureConstant.ZK_SERVICE_PATH + LeisureConstant.PATH_DELIMITER + name + "/service";
        List<String> children = zkClient.getChildren(servicePath);
        return Optional.ofNullable(children).orElse(new ArrayList<>()).stream().map(str -> {
            String deCh = null;
            try {
                deCh = URLDecoder.decode(str, LeisureConstant.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return JSON.parseObject(deCh, Service.class);
        }).collect(Collectors.toList());
    }
}
