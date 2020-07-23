package wang.leisure.rpc.common.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java序列化消息协议
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public class JavaSerializeMessageProtocol implements MessageProtocol {

    private byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(obj);
        return bout.toByteArray();
    }

    @Override
    public byte[] marshallingRequest(LeisureRequest req) throws Exception {
        return this.serialize(req);
    }

    @Override
    public LeisureRequest unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (LeisureRequest) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(LeisureResponse rsp) throws Exception {
        return this.serialize(rsp);
    }

    @Override
    public LeisureResponse unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (LeisureResponse) in.readObject();
    }
}
