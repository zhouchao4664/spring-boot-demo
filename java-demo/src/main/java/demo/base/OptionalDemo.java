package demo.base;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

/**
 * @Author zhouchao
 * @Description OptionalDemo
 * @Date 2023/3/8 16:15
 */
public class OptionalDemo {

    public static void main(String[] args) {
        OptionalUser user = null;
        user = Optional.ofNullable(user).orElseGet(() -> {
            OptionalUser u = new OptionalUser();
            u.setAddress("国贸");
            u.setAge(18);
            u.setName("大聪明");
            return u;
        });
        System.out.println(user);

        OptionalUser user2 = null;
        user2 = Optional.ofNullable(user2).orElseGet(OptionalDemo::initUser);
        System.out.println(user2);
    }

    @Data
    @ToString
    public static class OptionalUser {
        private String name;
        private String address;
        private Integer age;
    }

    public static OptionalUser initUser(){
        OptionalUser u = new OptionalUser();
        u.setAddress("国贸");
        u.setAge(18);
        u.setName("大聪明");
        return u;
    }
}
