package demo.netty.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @Author: zhouchao
 * @Date: 2021/07/13 11:59
 * @Description:
 */
public class CreateBufferDemo {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(allocate.get());
        }
        // 会报错
//        System.out.println(allocate.get());

        ByteBuffer wrap = ByteBuffer.wrap("zhouchao".getBytes());
        for (int i = 0; i < 8; i++) {
            System.out.println(wrap.get());
        }
    }
}
