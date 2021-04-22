package coursescheduler.infrastructure.database;

import coursescheduler.infrastructure.database.models.Course;
import coursescheduler.infrastructure.database.models.FacultyPreference;
import coursescheduler.infrastructure.database.models.Room;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author https://www.csodom.com
 */

public class ExcelImportUtil {
    // Variable declarations
    private boolean DEBUG;
    private String path;
    private static ExcelImportUtil instance = null;
    private Workbook currentWorkbook = null;


    static final String FACULTY_SHEET = "FACULTY";
    static final int PROFESSOR_EMAIL = 0;
    static final int COURSE_PREFERENCE = 1;
    static final int ROOM_ID = 2;
    static final int PERIOD_ID = 3;

    static final String COURSES_SHEET = "COURSES";
    static final int COURSE_LISTING_ID = 0;
    static final int COURSE_ID = 1;
    static final int SECTION_ID = 2;
    static final int PRELIM_ENR = 3;
    static final int MAX_ENR = 4;

    static final String ROOMS_SHEET = "ROOMS";
    static final int CLASSROOM_LOCATION = 0;
    static final int CAPACITY = 1;


    /**
     * Builds singleton object of the excel import utility
     */
    private ExcelImportUtil() {

        this.DEBUG = true;

        if (this.DEBUG) {
            try {
                setCurrentWorkbook("C:/Users/Chris/Desktop/Software/Java/CS499SeniorProject/course-scheduler-senior-project/src/main/resources/test.xlsx");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return a singleton instance of the excel import utility
     */
    public static ExcelImportUtil getInstance() {
        return (instance == null) ? instance = new ExcelImportUtil() : instance;
    }


    /**
     * @param path sets the new workbook that the utility will work on from the given path
     */
    public void setCurrentWorkbook(String path) throws IOException {
        this.path = path;
        this.currentWorkbook = new XSSFWorkbook(new FileInputStream(new File(path)));
    }

    /**
     * @param index the index of the faculty preference in the excel file, where 2 is the first entry, as to skip the header in (1-based)
     * @return a faculty preference object containing data of the course at that index
     */
    public FacultyPreference getFacultyPreferenceAt(int index) {
        Sheet sheet = currentWorkbook.getSheet(FACULTY_SHEET);
        if (sheet == null) {
            return null;
        }
        Row row = sheet.getRow(index);
        return new FacultyPreference(row.getCell(PROFESSOR_EMAIL).getStringCellValue(),
                (int) row.getCell(COURSE_PREFERENCE).getNumericCellValue(),
                row.getCell(ROOM_ID).getStringCellValue(),
                (int) row.getCell(PERIOD_ID).getNumericCellValue()
        );
    }

    /**
     * @param index the index of the course in the excel file, where 2 is the first entry, as to skip the header in (1-based)
     * @return a course object containing data of the course at that index
     */
    public Course getCourseAt(int index) {
        Sheet sheet = currentWorkbook.getSheet(COURSES_SHEET);
        if (sheet == null) {
            return null;
        }
        Row row = sheet.getRow(index);
        return new Course((int) row.getCell(COURSE_LISTING_ID).getNumericCellValue(),
                (int) row.getCell(COURSE_ID).getNumericCellValue(),
                (int) row.getCell(SECTION_ID).getNumericCellValue(),
                (int) row.getCell(PRELIM_ENR).getNumericCellValue(),
                (int) row.getCell(MAX_ENR).getNumericCellValue()
        );
    }

    /**
     * @param index the index of the room in the excel file, where 2 is the first entry, as to skip the header in (1-based)
     * @return a room object containing data of the room at that index
     */
    public Room getRoomAt(int index) {
        Sheet sheet = currentWorkbook.getSheet(ROOMS_SHEET);
        if (sheet == null) {
            return null;
        }
        Row row = sheet.getRow(index);
        return new Room(row.getCell(CLASSROOM_LOCATION).getStringCellValue(),
                (int) row.getCell(CAPACITY).getNumericCellValue()
        );
    }


    /**
     * @return returns all the faculty preferences from the excel file
     */
    public List<FacultyPreference> getFacultyPreferenceDataTable() {
        List<FacultyPreference> facultyPreferenceTable = new ArrayList<>();
        Sheet sheet = currentWorkbook.getSheet(FACULTY_SHEET);
        if (sheet == null) {
            return null;
        }
        for (Row row : sheet) {
            if (row.getRowNum() != 0) { // skip header
                facultyPreferenceTable.add(new FacultyPreference(row.getCell(PROFESSOR_EMAIL).getStringCellValue(),
                        (int) row.getCell(COURSE_PREFERENCE).getNumericCellValue(),
                        row.getCell(ROOM_ID).getStringCellValue(),
                        (int) row.getCell(PERIOD_ID).getNumericCellValue()
                ));
            }
        }
        return facultyPreferenceTable;
    }

    /**
     * @return returns all the offered courses from the excel file
     */
    public List<Course> getCourseListingDataTable() {
        List<Course> courseListingTable = new ArrayList<>();
        Sheet sheet = currentWorkbook.getSheet(COURSES_SHEET);
        if (sheet == null) {
            return null;
        }
        for (Row row : sheet) {
            if (row.getRowNum() != 0) { // skip header
                courseListingTable.add(new Course((int) row.getCell(COURSE_LISTING_ID).getNumericCellValue(),
                        (int) row.getCell(COURSE_ID).getNumericCellValue(),
                        (int) row.getCell(SECTION_ID).getNumericCellValue(),
                        (int) row.getCell(PRELIM_ENR).getNumericCellValue(),
                        (int) row.getCell(MAX_ENR).getNumericCellValue()
                ));
            }
        }
        return courseListingTable;
    }

    /**
     * @return returns all the room objects from the excel file
     */
    public List<Room> getRoomInformationDataTable() {
        List<Room> roomInformationTable = new ArrayList<>();
        Sheet sheet = currentWorkbook.getSheet(ROOMS_SHEET);
        if (sheet == null) {
            return null;
        }
        for (Row row : sheet) {
            if (row.getRowNum() != 0) { // skip header
                roomInformationTable.add(new Room(row.getCell(CLASSROOM_LOCATION).getStringCellValue(),
                        (int) row.getCell(CAPACITY).getNumericCellValue()
                ));
            }
        }
        return roomInformationTable;
    }
}