package top.takefly.boot.frame.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import top.takefly.boot.frame.annotation.ExportField;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cp on 2018/1/29.
 */
@Slf4j
public class ExcelUtil {
    private SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
    private String title;
    private String[] heads;
    private List message;
    private String fileName = "excel.xlsx";

    public ExcelUtil(String title, String[] heads, List message) {
        this.title = title;
        this.heads = heads;
        this.message = message;
    }

    public ExcelUtil(String title, String[] heads, List message, String fileName) {
        this.title = title;
        this.heads = heads;
        this.message = message;
        this.fileName = fileName;
    }

    public void export(HttpServletResponse response) throws IOException {
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setContentType("application/vnd.ms-excel");
        if (CollectionUtils.isEmpty(message)) {
            throw new RuntimeException("导出的数据为空！！");
        }

        Workbook wbs = null;
        OutputStream outputStream = null;
        try {
            wbs = new XSSFWorkbook();
            outputStream = response.getOutputStream();
            XSSFSheet sheet = (XSSFSheet) wbs.createSheet(title);
            XSSFRow row = null;
            XSSFCell cell = null;

            row = sheet.createRow(0); //创建sheet名称
            for (int i = 0; i < heads.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(heads[i]);
            }

            //填充值
            for (int i = 0; i < message.size(); i++) {
                row = sheet.createRow(i + 1);
                Object object = message.get(i);
                Class c = object.getClass();
                Field[] fields = c.getDeclaredFields();

                for (int j = 0; j < fields.length; j++) {
                    Field field = fields[j];
                    ExportField exportField = field.getAnnotation(ExportField.class);
                    if (exportField != null && !exportField.needExport()) {
                        continue;
                    }

                    cell = row.createCell(j);
                    field.setAccessible(true);

                    Object value = field.get(object);
                    if (value == null) {
                        value = "";
                    }
                    if (value instanceof Date) {
                        cell.setCellValue(format.format(value));
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            }
            wbs.write(outputStream);
        } catch (Exception e) {
            log.error("写入数据到excel异常！", e);
        } finally {
            wbs.close();
            outputStream.close();
        }
    }

}
