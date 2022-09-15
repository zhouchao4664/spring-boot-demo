package demo.base;

import lombok.Data;
import lombok.ToString;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2022/9/15 10:32
 * @Description 尝试获取参数里泛型的类型,通过匿名类去继承list里的泛型，然后获取父类的泛型，是一种取巧的方法，不推荐在公司项目中使用
 */
public class GenericParameterClassDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>(){};
        stringList.add("1");
        stringList.add("2");
        String actualType = getActualType(stringList, 0);
        System.out.println(actualType);
    }


    public static String getActualType(Object o,int index) {
        Type clazz = o.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)clazz;
        return pt.getActualTypeArguments()[index].toString();
    }

    @Data
    @ToString
    public class ObjectVO {
        private String name;
        private Integer age;
    }
}
