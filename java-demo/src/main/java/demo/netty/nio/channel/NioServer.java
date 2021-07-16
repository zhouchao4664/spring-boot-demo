package demo.netty.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zhouchao
 * @Date: 2021/07/13 14:58
 * @Description:
 */
public class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务端启动成功");
        while (true) {
            // 检查是否有客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                System.out.println("没有客户端连接...我去做别的事情");
                Thread.sleep(2000);
                continue;
            }
            // 获取客户端传过来的数据，并把数据放到缓冲区里
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //返回值
            //正数: 表示本地读到有效字节数
            //0: 表示本次没有读到数据
            //-1: 表示读到末尾
            int read = socketChannel.read(byteBuffer);
            System.out.println("客户端消息：" + new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8));
            socketChannel.write(ByteBuffer.wrap("没钱".getBytes(StandardCharsets.UTF_8)));
            serverSocketChannel.close();
        }
    }
}
