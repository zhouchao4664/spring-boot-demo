package demo.netty.unpacking;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @Author: zhouchao
 * @Date: 2021/07/22 10:35
 * @Description:
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LineBasedFrameDecoder(2048));
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();
        channelFuture.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}
