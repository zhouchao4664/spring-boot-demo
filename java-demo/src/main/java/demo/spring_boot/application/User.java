package demo.spring_boot.application;

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

}
