package coursescheduler;

import java.util.List;

public interface Queryable {
        List<String> findByDepartment(String department); // schedule.stream().filter(event -> event.getDeparment() == dept)
        List<String> findByFaculty(String email);
        List<String> findByRoom(String roomId);
}
