package demo.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: zhouchao
 * @Date: 2021/07/19 15:55
 * @Description:
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(9999);
        channelFuture.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("端口绑定成功!");
            } else {
                System.out.println("端口绑定失败!");
            }
        });
        System.out.println("服务端启动成功.");
        //10. 关闭通道(并不是真正意义上关闭,而是监听通道关闭的状态)和关闭连接池
        channelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
