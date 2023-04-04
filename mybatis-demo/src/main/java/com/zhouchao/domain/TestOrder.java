package com.zhouchao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* <p>
    * 
    * </p>
*
* @author zhouchao
* @since 2023-04-04
*/
@Data
@TableName("test_order")
public class TestOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 订单表id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 用户id
    */
    @TableField("user_id")
    private Integer userId;

    /**
    * 订单标题
    */
    @TableField("order_title")
    private String orderTitle;

    /**
    * 订单支付金额
    */
    @TableField("payment_price")
    private BigDecimal paymentPrice;

    /**
    * 订单支付时间
    */
    @TableField("payment_date")
    private LocalDateTime paymentDate;

    /**
    * 订单总金额
    */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
    * 订单创建时间
    */
    @TableField("create_date")
    private LocalDateTime createDate;


}
