package coursescheduler;

import coursescheduler.infrastructure.database.ExcelImportUtil;

/**
 * @author Kyle Nishimuta
 * Date: 4/7/21
 */

public class ExcelImportTest {
    public static void main(String... args){
        ExcelImportUtil newExcelData = new ExcelImportUtil();

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
