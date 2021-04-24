package coursescheduler.client.importer;

import coursescheduler.Room;
import coursescheduler.views.pages.Course;
import coursescheduler.views.pages.CourseEvent;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.types.ObjectId;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ExcelService {

    private String departmentAbr;
    private String path;
    private static ExcelService instance = null;
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

    static final String ROOMS_SHEET = "ROOMS";
    static final int CLASSROOM_LOCATION = 0;
    static final int CAPACITY = 1;

    private ExcelService() {
    }

    public static ExcelService getService() {
        return (instance == null) ? instance = new ExcelService() : instance;
    }

    public void setCurrentWorkbook(String path) {
        this.path = path;
        try {
            this.currentWorkbook = new XSSFWorkbook(new FileInputStream(new File(path)));
        } catch (IOException e) {
            this.currentWorkbook = null;
            e.printStackTrace();
        }
    }

    public void setDepartmentAbbreviation(String departmentAbr) {
        this.departmentAbr = departmentAbr;
    }

    private Course fetchCourseByLocalID(int localCourseId, List<Course> allCourses) {
        for (Course course : allCourses) {
            // if course has same id as passed, return course;
        }
        return null;
    }

    private Room fetchRoomByLocalID(String localRoomId, List<Room> allRooms) {
        for (Room room : allRooms) {
            // if room has same id as passed, return room;
        }
        return null;
    }

    protected List<CourseEvent> fetchAllFacultyPreferences(List<Course> allCourses, List<Room> allRooms) {
        List<CourseEvent> facultyPreferenceTable = new ArrayList<CourseEvent>();
        Sheet sheet = currentWorkbook.getSheet(FACULTY_SHEET);
        if (sheet == null) {
            return null;
        }
        for (Row row : sheet) {
            if (row.getRowNum() != 0) { // skip header
                // TODO add course fetcher below
                Course course = fetchCourseByLocalID((int) row.getCell(COURSE_LISTING_ID).getNumericCellValue(), allCourses);
                Room room = fetchRoomByLocalID(row.getCell(ROOM_ID).getStringCellValue(), allRooms);
                facultyPreferenceTable.add(new CourseEvent(
                        row.getCell(PROFESSOR_EMAIL).getStringCellValue(),
                        room,
                        course,
                        false
                ));
            }
        }
        return facultyPreferenceTable;
    }

    protected List<Course> fetchAllCoursesOffered() {
        List<Course> coursesOffered = new ArrayList<Course>();
        Sheet sheet = currentWorkbook.getSheet(COURSES_SHEET);
        if (sheet == null) {
            return null;
        }
        for (Row row : sheet) {
            if (row.getRowNum() != 0) { // skip header
                // Course(ObjectId _id, String deptAbbrev, String id, String section, int preliminaryEnrollment) {
                coursesOffered.add(new Course(
                        new ObjectId(),
                        this.departmentAbr,
                        row.getCell(COURSE_ID).getStringCellValue(),
                        row.getCell(SECTION_ID).getStringCellValue(),
                        (int) row.getCell(PRELIM_ENR).getNumericCellValue()
                ));
            }
        }

        return coursesOffered;
    }


    protected List<Room> fetchAllRooms() {
        List<Room> roomInformationTable = new ArrayList<Room>();
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

