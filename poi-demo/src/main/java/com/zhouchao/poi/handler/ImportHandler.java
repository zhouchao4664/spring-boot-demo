package com.zhouchao.poi.handler;

import cn.afterturn.easypoi.handler.inter.IReadHandler;
import com.zhouchao.poi.entity.QtConfigDevice;
import com.zhouchao.poi.mapper.QtConfigDeviceMapper;
import com.zhouchao.poi.pojo.ExcConfigDeviceVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import sun.rmi.runtime.Log;

/**
 * @Author zhouchao
 * @Date 2022/5/31 18:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ImportHandler implements IReadHandler<ExcConfigDeviceVO> {

    private QtConfigDeviceMapper qtConfigDeviceMapper;

    @Override
    public void handler(ExcConfigDeviceVO excConfigDeviceVO) {
        excConfigDeviceVO.checkSelf();
        QtConfigDevice qtConfigDevice = new QtConfigDevice();
        BeanUtils.copyProperties(excConfigDeviceVO, qtConfigDevice);
        qtConfigDeviceMapper.insert(qtConfigDevice);
        log.info("{},入库成功", qtConfigDevice.getVendorName());
    }

    @Override
    public void doAfterAll() {

    }
}
