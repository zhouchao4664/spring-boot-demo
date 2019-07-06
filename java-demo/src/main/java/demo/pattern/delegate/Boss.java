package demo.pattern.delegate;

/**
 * 2019/3/13
 * zhouchao
 *
 * 委派模式
 */
public class Boss {

    public void commend(String command, Leader leader) {
        leader.doing(command);
    }

}
