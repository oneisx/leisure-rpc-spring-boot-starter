package wang.leisure.rpc.common.service;

/**
 * 服务信息，记录注册的服务信息
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public class Service {

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务协议
     */
    private String protocol;

    /**
     * 服务地址，格式：IP:Port
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
