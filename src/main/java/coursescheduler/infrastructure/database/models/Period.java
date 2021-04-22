package coursescheduler.infrastructure.database.models;
/**
 * @author https://www.csodom.com
 */
public class Period {

    private final int periodIndex;
    private final String daySection;
    private final String timeSection;

    public Period(int periodIndex, String daySection, String timeSection){
        this.periodIndex = periodIndex;
        this.daySection = daySection;
        this.timeSection = timeSection;
    }

    public String getTimeSection() {
        return timeSection;
    }

    public String getDaySection() {
        return daySection;
    }

    public int getPeriodIndex() {
        return periodIndex;
    }
}
