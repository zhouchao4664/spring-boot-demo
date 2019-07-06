package demo.pattern.singleton.hungrySingleton;

/**
 * 2019/3/13
 * zhouchao
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungrySingleton;

    static{
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return hungrySingleton;
    }
}
