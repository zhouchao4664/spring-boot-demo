package com.zhouchao.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhouchao
 * @Date: 2021/06/15 17:56
 * @Description:
 */
public class ExcelDemo {

    private static String fileInputPath = "C:/Users/Administrator/Desktop/tbl_goods_202106151748.xls";
    private static String fileOutputPath = "C:/Users/Administrator/Desktop/tbl_goods_out_202106151748.xls";

    public static void main(String[] args) {
        FileInputStream fis = null;
        HSSFWorkbook hssfWorkbook = null;
        try {
            fis = new FileInputStream(fileInputPath);
            hssfWorkbook = new HSSFWorkbook(fis);
            HSSFSheet HSSFSheet = hssfWorkbook.getSheetAt(0);
            for (Row row : HSSFSheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                row.getCell(8).setCellValue(0f);
            }

            FileOutputStream fileOut = new FileOutputStream(fileOutputPath);
            hssfWorkbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                hssfWorkbook.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
