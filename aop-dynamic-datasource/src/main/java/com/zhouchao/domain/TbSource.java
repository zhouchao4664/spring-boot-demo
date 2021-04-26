package com.zhouchao.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
* @author zhouchao
* @since 2021-04-25
*/
@Data
@ToString
@TableName("tb_source")
public class TbSource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("code")
    private Integer code;

    @TableField("des")
    private String des;


}
