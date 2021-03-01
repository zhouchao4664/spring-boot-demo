package demo.spring_boot.application.spring.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @Author zhouchao
 * @Date 2021/2/1 15:59
 * @Description
 **/
@Data
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private String address;

    public static User createUser() {
        User user = new User();
        user.setId(1);
        user.setName("小孤枫");
        user.setAge(32);
        user.setAddress("北京");
        return user;
    }
}
