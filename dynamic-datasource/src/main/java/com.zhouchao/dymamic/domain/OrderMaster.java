package com.zhouchao.dymamic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
    * 
    * </p>
*
* @author zhouchao
* @since 2020-11-26
*/
@Data
@TableName("order_master")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("order_name")
    private String orderName;

    @TableField("create_time")
    private LocalDateTime createTime;


    /**
     * <p>
     *  Mapper 接口
     * </p>
     *
     * @author zhouchao
     * @since 2020-11-26
     */
    public static interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    }
}
