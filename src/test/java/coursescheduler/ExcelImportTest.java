package coursescheduler;

import coursescheduler.infrastructure.database.ExcelImportUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Kyle Nishimuta
 * Date: 4/7/21
 */

public class ExcelImportTest {
    public static void main(String... args) {
        ExcelImportUtil newExcelData = ExcelImportUtil.getInstance();

        String testfilename1 = "facultypreference.xlsx";
        newExcelData.importFile(testfilename1);
        newExcelData.printData();

        String testfilename2 = "courseoffering.xlsx";
        newExcelData.importFile(testfilename2);
        newExcelData.printData();

        String testfilename3 = "physicalroom.xlsx";
        newExcelData.importFile(testfilename3);
        newExcelData.printData();

        String testfilename4 = "timeperiod.xlsx";
        newExcelData.importFile(testfilename4);
        newExcelData.printData();
    }
}
