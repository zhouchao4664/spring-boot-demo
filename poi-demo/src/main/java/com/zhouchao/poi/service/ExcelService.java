package com.zhouchao.poi.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.zhouchao.poi.handler.ImportHandler;
import com.zhouchao.poi.mapper.QtConfigDeviceMapper;
import com.zhouchao.poi.pojo.ExcConfigDeviceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author zhouchao
 * @Date 2022/5/31 18:40
 */
@Service
public class ExcelService {

    @Autowired
    private QtConfigDeviceMapper qtConfigDeviceMapper;


    @Transactional
    public String importExcel(MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setConcurrentTask(true);
        importParams.setTitleRows(0);
        importParams.setHeadRows(1);
        importParams.setNeedVerify(false);

        ExcelImportUtil.importExcelBySax(
                file.getInputStream(),
                ExcConfigDeviceVO.class,
                importParams,
                new ImportHandler(qtConfigDeviceMapper));

        return "success";
    }
}
