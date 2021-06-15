package com.zhouchao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author zhouchao
* @since 2021-06-15
*/
@Data
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 搜索词
    */
    @TableField("keyword")
    private String keyword;

    /**
    * 标题
    */
    @TableField("title")
    private String title;

    /**
    * 语义相似度
    */
    @TableField("similarity")
    private float similarity;

    /**
    * 文本匹配度
    */
    @TableField("matching")
    private float matching;


}
