package demo.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 10:18
 * @Description:
 */
public class NettyChatClient {
    private String ip;
    private int port;

    public NettyChatClient(String ip, int port) {
        this.port = port;
        this.ip = ip;
    }

    public void run() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new NettyChatClientHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
        Channel channel = channelFuture.channel();
        System.out.println("-------" + channel.localAddress().toString().substring(1) + "--------");
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            String msg = input.nextLine();
            channel.writeAndFlush(msg);
        }
        channel.closeFuture().sync();
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatClient("127.0.0.1", 9999).run();
    }
}
