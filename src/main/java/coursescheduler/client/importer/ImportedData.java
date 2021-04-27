package coursescheduler.client.importer;

import coursescheduler.client.objects.Course;
import coursescheduler.client.objects.CourseEvent;
import coursescheduler.client.objects.FacultyPreference;
import coursescheduler.client.objects.Room;

import java.util.List;

public class ImportedData {

    private static List<Course> coursesOffered;
    private static List<Room> sanctionedRooms;
    private static List<FacultyPreference> facultyPreferences;

    private static ExcelService service;
    private static ImportedData instance;

    /**
     * An object that contains three lists, each lists of objects from the Excel file imported by the user
     * List of Faculty Preferences {@link CourseEvent}
     * List of Courses {@link Course}
     * List of Rooms {@link Room}
     */
    private ImportedData() {
        service = ExcelService.getService();
    }

    public static ImportedData getInstance(){
        return (instance == null) ? instance = new ImportedData() : instance;
    }

    /**
     * Makes a call to the Excel Service to update the ImportedData fields, with the data
     * from the excel file at the path passed.
     * @param path this is the path of the excel file that the parser fetches the data from
     */
    public static void update(String path){
        service.setCurrentWorkbook(path);
        coursesOffered = service.fetchAllCoursesOffered();
        sanctionedRooms = service.fetchAllRooms();
        facultyPreferences = service.getFacultyPreferences();
    }

    /**
     * @return the current list of all the courses offered from the imported excel file
     */
    public List<Course> getCoursesOffered(){
        return coursesOffered;
    }

    /**
     * @return the current list of all the rooms sanctioned from the imported excel file
     */
    public List<Room> getSanctionedRooms(){
        return sanctionedRooms;
    }

    /**
     * @return the current list of all the faculty preferences from the imported excel file
     */
    public List<FacultyPreference> getFacultyPreferences(){
        return facultyPreferences;
    }
}
