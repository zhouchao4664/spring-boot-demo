package demo.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author zhouchao
 * @Date 2020/6/9 17:00
 * @Description
 **/
@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) {
        new ExceptionDemo().getException();
    }

    public void getException() {
        System.out.println("异常发生");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("出错了！！",e);
        }
    }

}
