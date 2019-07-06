package demo.pattern.singleton.lazy;

/**
 * 2019/3/13
 * zhouchao
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazy == null) {
            synchronized (lazy) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }
}
