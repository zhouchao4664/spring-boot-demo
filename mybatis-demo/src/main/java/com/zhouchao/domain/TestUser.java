package com.zhouchao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhouchao
 * @since 2023-02-20
 */
@ToString
@Data
@TableName("test_user")
public class TestUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 身高
     */
    @TableField("height")
    private Double height;

    /**
     * 体重
     */
    @TableField("weight")
    private Double weight;


}
