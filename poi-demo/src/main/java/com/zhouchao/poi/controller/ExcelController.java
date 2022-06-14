package com.zhouchao.poi.controller;

import com.zhouchao.poi.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author zhouchao
 * @Date 2022/5/31 18:29
 */
@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("import")
    public String importExcel(MultipartFile file){

        return "success";
    }

}
