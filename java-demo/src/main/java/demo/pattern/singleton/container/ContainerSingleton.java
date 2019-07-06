package demo.pattern.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2019/3/14
 * zhouchao
 */
public class ContainerSingleton {

    private ContainerSingleton(){

    }

    private static Map<String ,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className){
        if (!ioc.containsKey(className)){
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }

    public static void main(String[] args) {
        Object obj = ContainerSingleton.getBean("com.zhouchao.springbootdemo.ContainerSingleton");
        System.out.println(obj);
    }

}
