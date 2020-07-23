package wang.leisure.rpc.common.serializer;

import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.StandardCharsets;

/**
 * Zookeeper序列化器
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public class ZookeeperSerializer implements ZkSerializer {

    /**
     * 反序列化
     *
     * @param bytes 字节数组
     * @return 对象
     */
    public Object deserialize(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * 序列化
     *
     * @param obj 对象
     * @return 字节数组
     */
    public byte[] serialize(Object obj) {
        return String.valueOf(obj).getBytes(StandardCharsets.UTF_8);
    }
}
