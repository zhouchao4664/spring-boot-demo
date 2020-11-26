package com.zhouchao.dymamic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author zhouchao
* @since 2020-11-25
*/
@Data
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("passwd")
    private String passwd;

    @TableField("nickname")
    private String nickname;

    @TableField("age")
    private Integer age;


}
