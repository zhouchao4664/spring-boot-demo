package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/8/27 12:30
 * @Description this 引用逃逸  在构造函数返回之前, 其他线程就通过this引用访问到了"未完成初始化"的对象,
 * 而调用尚未构造完全的对象就会不可预知的问题, 因此this 引用逃逸引发的问题是线程安全问题.
 **/

public class UnsafeThisEscapeDemo {
    private String id;

    public UnsafeThisEscapeDemo(String id) {
        new Thread(new EscapeRunnable()).start();
        // ...其他代码
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.id = id;
    }

    private class EscapeRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("id: " + UnsafeThisEscapeDemo.this.id);
            // 在这里通过UnsafeThisEscape.this就可以引用UnsafeThisEscape对象, 但是此时UnsafeThisEscape对象可能还没有构造完成, 即发生了this引用的逃逸.
        }
    }

    public static void main(String[] args) {
        new UnsafeThisEscapeDemo("abc");
    }
}
