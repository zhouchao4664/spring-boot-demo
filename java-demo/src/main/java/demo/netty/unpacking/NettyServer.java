package demo.netty.unpacking;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.util.CharsetUtil;

/**
 * @Author: zhouchao
 * @Date: 2021/07/22 10:04
 * @Description:
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ByteBuf byteBuf = Unpooled.copiedBuffer("$", CharsetUtil.UTF_8);
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(2048, byteBuf));
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
        channelFuture.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("端口绑定成功!");
            } else {
                System.out.println("端口绑定失败!");
            }
        });
    }
}
