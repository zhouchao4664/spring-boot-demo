package com.zhouchao.security.domain;


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
* @since 2020-12-23
*/
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 唯一标识
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 用户名
    */
    @TableField("name")
    private String name;

    /**
    * 登录密码
    */
    @TableField("pwd")
    private String pwd;


}
