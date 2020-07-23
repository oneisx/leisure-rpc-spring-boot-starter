package wang.leisure.rpc.common.protocol;

/**
 * 消息协议，定义编组请求、解组请求、编组响应、解组响应规范
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public interface MessageProtocol {

    /**
     * 编组请求
     *
     * @param req 请求信息
     * @return 请求字节数组
     * @throws Exception 编组请求异常
     */
    byte[] marshallingRequest(LeisureRequest req) throws Exception;

    /**
     * 解组请求
     *
     * @param data 请求字节数组
     * @return 请求信息
     * @throws Exception 解组请求异常
     */
    LeisureRequest unmarshallingRequest(byte[] data) throws Exception;

    /**
     * 编组响应
     *
     * @param rsp 响应信息
     * @return 响应字节数组
     * @throws Exception 编组响应异常
     */
    byte[] marshallingResponse(LeisureResponse rsp) throws Exception;

    /**
     * 解组响应
     *
     * @param data 响应字节数组
     * @return 响应信息
     * @throws Exception 解组响应异常
     */
    LeisureResponse unmarshallingResponse(byte[] data) throws Exception;
}
