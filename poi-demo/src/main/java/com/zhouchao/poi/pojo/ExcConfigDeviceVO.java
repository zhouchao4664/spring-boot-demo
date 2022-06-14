package com.zhouchao.poi.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.zhouchao.poi.core.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <维保价格管理导入模板对象>
 *
 * @author ZhangYang
 * @version 1.0.0
 * @date 2021/8/12 19:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ExcConfigDeviceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Excel(name = "*厂商名称", orderNum = "0") // width = 10.0
    private String vendorName;

    @Excel(name = "*设备型号", orderNum = "1")
    private String deviceName;

    @Excel(name = "设备系列", orderNum = "2")
    private String seriesName;

    @Excel(name = "设备类型", orderNum = "3")
    private String type;

    @Excel(name = "*整机价格", orderNum = "4", numFormat = "0.00")
    private BigDecimal devicePrice;

    @Excel(name = "驱动器数量", orderNum = "5")
    private Integer numberOfDrives;

    @Excel(name = "CPU数量", orderNum = "6")
    private Integer numberOfCpu;

    @Excel(name = "内存数量", orderNum = "7")
    private Integer numberOfMemory;

    @Excel(name = "存储容量(TB)", orderNum = "8", numFormat = "0.00")
    private BigDecimal numberOfStorage;

    @Excel(name = "存储拓展柜数量", orderNum = "9")
    private Integer numberOfStorageExpansion;

    @Excel(name = "市场数量", orderNum = "10")
    private Long stock;

    @Excel(name = "设备故障率(0-100)", orderNum = "11")
    private Integer faultRate;

    @Excel(name = "上市时间(yyyy-MM-dd)", orderNum = "12", format = "yyyy-MM-dd")
    private LocalDateTime timeToMarket;

    @Excel(name = "设备档次", orderNum = "13")
    private String levelFlag;

    @Excel(name = "结果", orderNum = "14")
    private String result;

    private String typeA;
    private String typeB;
    private String typeC;

    /**
     * <对自身数据做校验，如果校验失败，将原因存入结果result属性中>
     *
     * @return boolean
     * @author ZhangYang
     * @date 2021/8/17 14:52
     * @version 1.0.0
     */
    public boolean checkSelf() {
        if (StringUtils.isBlank(vendorName)) {
            this.setResult("厂商名不能为空");
            return false;
        }
        if (StringUtils.isBlank(deviceName)) {
            this.setResult("设备名称不能为空");
            return false;
        }
        if (deviceName.length() > 200) {
            this.setResult("设备名称最多200字");
            return false;
        }
        if (StringUtils.isNotBlank(seriesName) && seriesName.length() > 50) {
            this.setResult("系列名称最多50字");
            return false;
        }
        if (StringUtils.isNotBlank(type)) { //如果分类不为空
            String[] types = type.split(Constants.TYPE_SEPARATOR);
            if (types.length > 3) {
                this.setResult("设备类型格式错误，“-”分隔，最多3级");
            }
            this.splitType();
            if (StringUtils.isNotBlank(typeA) && typeA.length() > 50) {
                this.setResult("1级分类名称最多50字");
                return false;
            }
            if (StringUtils.isNotBlank(typeB) && typeB.length() > 50) {
                this.setResult("2级分类名称最多50字");
                return false;
            }
            if (StringUtils.isNotBlank(typeC) && typeC.length() > 50) {
                this.setResult("3级分类最多50字");
                return false;
            }
        }
        if (devicePrice == null || devicePrice.doubleValue() == 0) {
            this.setResult("整机价格不能为空");
            return false;
        }
        if (devicePrice.doubleValue() < 0 || devicePrice.doubleValue() > 9999999999D) {
            this.setResult("整机价格不合法，合法范围：0-9999999999");
            return false;
        }
        if (numberOfDrives != null && (numberOfDrives.doubleValue() < 0 || numberOfDrives.doubleValue() > 99999D)) {
            this.setResult("标配驱动器数量不合法，合法范围：0-99999");
            return false;
        }
        if (numberOfCpu != null && (numberOfCpu.doubleValue() < 0 || numberOfCpu.doubleValue() > 99999D)) {
            this.setResult("标配cpu数量不合法，合法范围：0-99999");
            return false;
        }
        if (numberOfMemory != null && (numberOfMemory.doubleValue() < 0 || numberOfMemory.doubleValue() > 99999D)) {
            this.setResult("标配内存数量不合法，合法范围：0-99999");
            return false;
        }
        if (numberOfStorage != null && (numberOfStorage.doubleValue() < 0 || numberOfStorage.doubleValue() > 9999999999D)) {
            this.setResult("标配存储容量，合法范围：0.01-9999999999.99");
            return false;
        }
        if (numberOfStorageExpansion != null && (numberOfStorageExpansion.doubleValue() < 0 || numberOfStorageExpansion.doubleValue() > 99999D)) {
            this.setResult("标配存储拓展柜数量不合法，合法范围：0-99999");
            return false;
        }
        if (stock != null && (stock.doubleValue() < 0 || stock.doubleValue() > 9999999999D)) {
            this.setResult("市场存量不合法，合法范围：0-9999999999");
            return false;
        }
        if (faultRate != null && (faultRate < 0 || faultRate > 9999999999D)) {
            this.setResult("设备故障率不合法，合法范围：0-99");
            return false;
        }
        if (StringUtils.isNotBlank(levelFlag) && !("低").equals(levelFlag)
                && !("中").equals(levelFlag) && !("高").equals(levelFlag)) {
            this.setResult("设备档次不合法，设备档次：低、中、高");
            return false;
        }
        return true;
    }

    /**
     * <拆分分类信息>
     *
     * @author ZhangYang
     * @date 2021/8/17 15:10
     * @version 1.0.0
     */
    private void splitType() {
        String[] types = type.split(Constants.TYPE_SEPARATOR);
        this.typeA = types[0];
        if (types.length == 2) {
            this.typeB = types[1];
        } else if (types.length == 3) {
            this.typeB = types[1];
            this.typeC = types[2];
        }
    }

}
