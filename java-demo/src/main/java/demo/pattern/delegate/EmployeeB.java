package demo.pattern.delegate;

/**
 * 2019/3/13
 * zhouchao
 *
 * 委派模式
 */
public class EmployeeB implements IEmployee {

    @Override
    public void doing(String command) {
        System.out.println("我是B工作是"+command);
    }
}
