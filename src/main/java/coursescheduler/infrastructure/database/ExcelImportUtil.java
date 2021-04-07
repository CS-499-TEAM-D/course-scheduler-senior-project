package coursescheduler.infrastructure.database;

/**
 * @author Kyle Nishimuta
 */
public class ExcelImportUtil {
    // Variable declarations
    private boolean DEBUG;
    private String filename;
    private int filetype;

    // Constructor
    public ExcelImportUtil(){
        this.DEBUG = true;
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
