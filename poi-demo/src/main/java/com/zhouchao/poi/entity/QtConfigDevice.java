package com.zhouchao.poi.entity;

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
    * 设备报价配置表
    * </p>
*
* @author zhouchao
* @since 2022-05-31
*/
@Data
@TableName("qt_config_device")
public class QtConfigDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 设备报价配置表ID
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 企业ID
    */
    @TableField("tenant_id")
    private Integer tenantId;

    /**
    * 厂商英文名
    */
    @TableField("vendor_en_name")
    private String vendorEnName;

    /**
    * 厂商中文名
    */
    @TableField("vendor_ch_name")
    private String vendorChName;

    /**
    * 所属系列
    */
    @TableField("series_name")
    private String seriesName;

    /**
    * 设备名称
    */
    @TableField("device_name")
    private String deviceName;

    /**
    * 设备级别（本期不使用）
    */
    @TableField("device_level")
    private String deviceLevel;

    /**
    * 所属分类1级
    */
    @TableField("type_a")
    private String typeA;

    /**
    * 所属分类2级
    */
    @TableField("type_b")
    private String typeB;

    /**
    * 所属分类3级
    */
    @TableField("type_c")
    private String typeC;

    /**
    * 整机价格
    */
    @TableField("device_price")
    private BigDecimal devicePrice;

    /**
    * MA标准报价
    */
    @TableField("standard_price")
    private BigDecimal standardPrice;

    /**
    * 标配驱动器数量
    */
    @TableField("number_of_drives")
    private Integer numberOfDrives;

    /**
    * 标配CPU数量
    */
    @TableField("number_of_cpu")
    private Integer numberOfCpu;

    /**
    * 标配内存数量
    */
    @TableField("number_of_memory")
    private Integer numberOfMemory;

    /**
    * 标配存储容量（TB，支持两位小数）
    */
    @TableField("number_of_storage")
    private BigDecimal numberOfStorage;

    /**
    * 标配存储拓展柜数量
    */
    @TableField("number_of_storage_expansion")
    private Integer numberOfStorageExpansion;

    /**
    * 市场存量（台），0或负数表示已停产
    */
    @TableField("stock")
    private Integer stock;

    /**
    * 上市时间
    */
    @TableField("time_to_market")
    private LocalDateTime timeToMarket;

    /**
    * 设备故障率（%），0-100
    */
    @TableField("fault_rate")
    private Integer faultRate;

    /**
    * 设备档次（汉字：低、中、高）
    */
    @TableField("level_flag")
    private String levelFlag;

    /**
    * 删除标识（0正常；1删除）
    */
    @TableField("del_yn")
    private Integer delYn;

    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField("create_by")
    private Integer createBy;

    @TableField("update_date")
    private LocalDateTime updateDate;

    @TableField("update_by")
    private Integer updateBy;

    @TableField("remark")
    private String remark;

    /**
    * 厂商名称（格式：中文/英文）
    */
    @TableField("vendor_name")
    private String vendorName;


}
