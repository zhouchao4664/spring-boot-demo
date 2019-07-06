package demo.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/3/13
 * zhouchao
 *
 * 委派模式
 */
public class Leader {

    private static Map<String ,IEmployee> register = new HashMap<>();

    static{
        register.put("架构",new EmployeeA());
        register.put("架构",new EmployeeB());
    }

    public void doing (String command){
        register.get(command).doing(command);
    }
}
