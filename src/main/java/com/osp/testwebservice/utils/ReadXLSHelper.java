package com.osp.testwebservice.utils;

import com.osp.testwebservice.model.CompanyInfoItem;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Log4j2
public class ReadXLSHelper {
    public static List<CompanyInfoItem> readXLSCompanyInfo(InputStream xlsCompanyInfo, int companyId) {
        List<CompanyInfoItem> companyInfoItems = new ArrayList<>();
        try {
            Workbook wb = WorkbookFactory.create(xlsCompanyInfo);
            Sheet sheet = wb.getSheetAt(0);

            Iterator iter = sheet.iterator();
            Row row = null;
            Cell cell = null;
            while (iter.hasNext()) {
                row = (Row) iter.next();
                try {
                    CompanyInfoItem companyInfoItem = new CompanyInfoItem();
                    int xx = 0;
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                            companyInfoItem.setStt((int) cell.getNumericCellValue());
                        }
                    }
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.STRING == cell.getCellTypeEnum()) {
                            companyInfoItem.setCompanyName(cell.getStringCellValue());
                        }
                    }
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                            companyInfoItem.setFromYear(cell.getDateCellValue());
                        } else if (CellType.STRING == cell.getCellTypeEnum()) {
                            companyInfoItem.setFromYear(null);
                        }

                    }
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                            companyInfoItem.setToYear(cell.getDateCellValue());
                        } else if (CellType.STRING == cell.getCellTypeEnum()) {
                            companyInfoItem.setToYear(null);
                        }
                    }
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.STRING == cell.getCellTypeEnum()) {
                            companyInfoItem.setLicNumber(cell.getStringCellValue());
                        }
                    }
                    cell = row.getCell(xx++);
                    if (Objects.nonNull(cell)) {
                        if (CellType.STRING == cell.getCellTypeEnum()) {
                            companyInfoItem.setTypeLic(cell.getStringCellValue());
                        }
                    }

                    cell = row.getCell(xx++);
                    companyInfoItem.setCompanyId(companyId);

                    companyInfoItems.add(companyInfoItem);
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return companyInfoItems;
    }
}
