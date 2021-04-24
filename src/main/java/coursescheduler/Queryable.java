package coursescheduler;

import java.util.List;

/** Allows for querying of structures that support course scheduling. */
public interface Queryable {
  List<String> findByDepartment(String department);

  List<String> findByFaculty(String email);

  List<String> findByRoom(String roomId);
}
