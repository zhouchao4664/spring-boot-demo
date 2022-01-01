package com.zhouchao.domain;

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
* @since 2022-01-01
*/
@Data
@TableName("shop")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("shop_name")
    private String shopName;

    @TableField("address")
    private String address;

    @TableField("price")
    private String price;


}
