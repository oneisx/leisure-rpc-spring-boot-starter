package wang.leisure.rpc.server;

/**
 * RPC服务端抽象类
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public abstract class RpcServer {

    /**
     * 服务端口
     */
    protected int port;

    /**
     * 服务协议
     */
    protected String protocol;

    /**
     * 请求处理者
     */
    protected RequestHandler handler;

    public RpcServer(int port, String protocol, RequestHandler handler) {
        super();
        this.port = port;
        this.protocol = protocol;
        this.handler = handler;
    }

    /**
     * 开启服务
     */
    public abstract void start();

    /**
     * 停止服务
     */
    public abstract void stop();

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public RequestHandler getHandler() {
        return handler;
    }

    public void setHandler(RequestHandler handler) {
        this.handler = handler;
    }

}
