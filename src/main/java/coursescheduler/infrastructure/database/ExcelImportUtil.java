package coursescheduler.infrastructure.database;

import coursescheduler.infrastructure.database.models.Course;
import coursescheduler.infrastructure.database.models.CourseEvent;
import coursescheduler.infrastructure.database.models.Room;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Kyle Nishimuta
 */

public class ExcelImportUtil {
    // Variable declarations
    private boolean DEBUG;
    private String filename;
    private FileType fileType;
    private static ExcelImportUtil instance = null;
    private Workbook currentWorkbook = null;


    private final int PROFESSOR_EMAIL = 0;
    private final int COURSE_PREFERENCE = 1;
    private final int ROOM_ID = 2;
    private final int PERIOD_ID = 3;

    private final String FACULTY_SHEET = "FACULTY";

    /**
     * A listing of the four possible file types that the excel import utility will handle
     */
    enum FileType{
        FACULTY,
        COURSES,
        ROOMS,
        PERIODS
    }

    /**
     * Builds singleton object of the excel import utility
     */
    private ExcelImportUtil(){
        this.DEBUG = true;
    }

    /**
     * @return a singleton instance of the excel import utility
     */
    public static ExcelImportUtil getInstance() {
        return (instance == null) ? instance = new ExcelImportUtil() : instance;
    }


    /**
     * @param path sets the new workbook that the utility will work on from the given path
     * @param fileType sets the filetype of the current workbook that the utility is working on
     */
    public void setCurrentWorkbook(String path, FileType fileType) throws IOException {
        this.fileType = fileType;
        this.currentWorkbook = new HSSFWorkbook(new FileInputStream(new File(path)));
    }

    /**
     * @return returns the current workbook that the utlity is working on
     */
    public Workbook getCurrentWorkbook(){
        return this.currentWorkbook;
    }

    /**
     * @return returns the enum value for the current file
     */
    public FileType getFileType(){
        return this.fileType;
    }

    /**
     * @param index get the course event from the faculty sheet
     *              the index needs to be in 2th notation, where
     *              the first index value is 2 to skip the header
     *              located in the first row
     * @return course event object from faculty preference sheet
     */
    public List<CourseEvent> getFacultyPreferences(){
        List<CourseEvent> listOfCourseEvents = new ArrayList<>();
        Sheet sheet = currentWorkbook.getSheet(FACULTY_SHEET);
        if(sheet == null){
            return null;
        }
        for( Row row : sheet ) {
            CourseEvent courseEvent = new CourseEvent(
                    row.getCell(PROFESSOR_EMAIL).toString(),
                    row.getCell(COURSE_PREFERENCE),
                    row.getCell(ROOM_ID).toString(),
                    row.getCell(PERIOD_ID)
            );
            listOfCourseEvents.add(courseEvent);
        }
        return listOfCourseEvents;
    }

    public Course getCourseAtIndex(){
        return null;
    }

    public Room getRoomAtIndex(){
        return null;
    }


    public Vector<Object> getFacultyPreferenceDataTable(){
        return null;
    }

    public Vector<Object> getCourseListingDataTable(){
        return null;
    }

    public Vector<Object> getRoomInformationDataTable(){
        return null;
    }


    // Clear old data (if applicable), run class processes
    public void importFile(String filenameToImportFrom){
        this.filename = filenameToImportFrom;
    }

    // Open file for reading
    private void openFile(String filename){
        ;
    }

    // Check header for information type
    private int getFileDataType(){
        /**
         * Retval based on Schema:
         * 0 -> Faculty preference
         * 1 -> Course offering
         * 2 -> Physical room
         * 3 -> Time period
         */
        ;
        return 0;
    }

    // Parse data based on header line

    // Return info as relevant object

    // Print data for debugging
    public void printData(){
        ;
    }
}
