package demo.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/07/26 20:31
 * @Description:
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static final List<Channel> CHANNEL_LIST = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        CHANNEL_LIST.add(channel);
        System.out.println("[Server]:" +
                channel.remoteAddress().toString().substring(1) + "上线.");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        CHANNEL_LIST.remove(channel);
        System.out.println("[Server]:" +
                channel.remoteAddress().toString().substring(1) + "下线.");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        for (Channel c : CHANNEL_LIST) {
            if (c != channel) {
                ctx.writeAndFlush("[" + ctx.channel().remoteAddress().toString().substring(1) +
                        "]说：" + msg);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        CHANNEL_LIST.remove(channel);
        System.out.println("[Server]:" +
                channel.remoteAddress().toString().substring(1) + "异常.");
    }
}
