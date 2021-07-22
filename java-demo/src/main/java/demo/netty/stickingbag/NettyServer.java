package demo.netty.stickingbag;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @Author: zhouchao
 * @Date: 2021/07/21 15:34
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
                        //添加解码器
                        ch.pipeline().addLast(new LineBasedFrameDecoder(102400));

                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
        System.out.println("服务端启动成功.");
        channelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
