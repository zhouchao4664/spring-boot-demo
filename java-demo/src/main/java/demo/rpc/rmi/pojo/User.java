package demo.rpc.rmi.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 19:12
 * @Description:
 */
@Data
@ToString
public class User implements Serializable {
    private int id;
    private String name;
}
