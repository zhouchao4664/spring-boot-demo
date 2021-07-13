package demo.netty.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @Author: zhouchao
 * @Date: 2021/07/13 12:17
 * @Description:
 */
public class GetBufferDemo {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("zhouchao".getBytes());
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
        System.out.println(allocate.remaining());

        System.out.println("==================读取数据");
        allocate.flip();

        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
        System.out.println(allocate.remaining());

        System.out.println("----------------");
        System.out.println(allocate.get());

        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
        System.out.println(allocate.remaining());

        // 读取指定索引
        System.out.println(allocate.get(1));

        // 读取多个字节
        // 重复读取
        allocate.rewind();
        byte[] bytes = new byte[8];
        allocate.get(bytes);
        System.out.println(new String(bytes));

        // 将缓冲区转换为数组返回
        byte[] array = allocate.array();
        System.out.println(new String(array));

        // 重复写入
        allocate.clear();
        allocate.put("顺义".getBytes());
        System.out.println(new String(allocate.array()));
        allocate.flip();
        byte[] b = new byte[6];
        allocate.get(b);
        System.out.println(new String(b));


    }

}
