package wang.leisure.rpc.client.net.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 发送处理类，定义Netty入站处理细则
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public class SendHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SendHandler.class);

    private CountDownLatch cdl;
    private Object readMsg = null;
    private byte[] data;

    public SendHandler(byte[] data) {
        cdl = new CountDownLatch(1);
        this.data = data;
    }

    /**
     * 当连接服务端成功后，发送请求数据
     *
     * @param ctx 通道上下文
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("Successful connection to server：{}", ctx);
        ByteBuf reqBuf = Unpooled.buffer(data.length);
        reqBuf.writeBytes(data);
        logger.info("Client sends message：{}", reqBuf);
        ctx.writeAndFlush(reqBuf);
    }

    /**
     * 读取数据，数据读取完毕释放CD锁
     *
     * @param ctx 上下文
     * @param msg ByteBuf
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("Client reads message: {}", msg);
        ByteBuf msgBuf = (ByteBuf) msg;
        byte[] resp = new byte[msgBuf.readableBytes()];
        msgBuf.readBytes(resp);
        readMsg = resp;
        cdl.countDown();
    }

    /**
     * 等待读取数据完成
     *
     * @return 响应数据
     * @throws InterruptedException 异常
     */
    public Object rspData() throws InterruptedException {
        cdl.await();
        return readMsg;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        logger.error("Exception occurred：{}", cause.getMessage());
        ctx.close();
    }
}
