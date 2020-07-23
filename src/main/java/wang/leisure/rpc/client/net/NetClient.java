package wang.leisure.rpc.client.net;

import wang.leisure.rpc.common.service.Service;

/**
 * 网络请求客户端，定义网络请求规范
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public interface NetClient {
    byte[] sendRequest(byte[] data, Service service) throws InterruptedException;
}
