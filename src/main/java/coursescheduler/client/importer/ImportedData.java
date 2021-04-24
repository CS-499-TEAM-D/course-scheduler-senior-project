package coursescheduler.client.importer;

import coursescheduler.Room;
import coursescheduler.views.pages.Course;
import coursescheduler.views.pages.CourseEvent;

import java.util.List;

public class ImportedData {
    
    private List<Course> coursesOffered;
    private List<Room> sanctionedRooms;
    private List<CourseEvent> facultyPreferences;

    private final ExcelService service;

    /**
     * An object that contains three lists, each lists of objects from the Excel file imported by the user
     * List of Faculty Preferences {@link CourseEvent}
     * List of Courses {@link Course}
     * List of Rooms {@link Room}
     * @param service this is the excel parser that is used to fetch the data
     * @param path this is the path of the excel file that the parser fetches the data from
     */
    public ImportedData(ExcelService service, String path) {
        this.service = service;
        update(path);
    }


    /**
     * Makes a call to the Excel Service to update the ImportedData fields, with the data
     * from the excel file at the path passed.
     * @param path this is the path of the excel file that the parser fetches the data from
     */
    public void update(String path){
        this.service.setCurrentWorkbook(path);
        this.coursesOffered = service.fetchAllCoursesOffered();
        this.sanctionedRooms = service.fetchAllRooms();
        this.facultyPreferences = service.fetchAllFacultyPreferences(this.coursesOffered, this.sanctionedRooms);
    }

    /**
     * @return the current list of all the courses offered from the imported excel file
     */
    public List<Course> getCoursesOffered(){
        return this.coursesOffered;
    }

    /**
     * @return the current list of all the rooms sanctioned from the imported excel file
     */
    public List<Room> getSanctionedRooms(){
        return this.sanctionedRooms;
    }

    /**
     * @return the current list of all the faculty preferences from the imported excel file
     */
    public List<CourseEvent> getFacultyPreferences(){
        return this.facultyPreferences;
    }
}




