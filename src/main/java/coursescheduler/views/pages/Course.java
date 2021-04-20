package coursescheduler.views.pages;

/**
 * TODO: Javadoc.
 */
public class Course {
  String uuid;
  String deptAbbrev;
  String id;
  String section;

  Course(String uuid, String deptAbbrev, String id, String section) {
    this.uuid = uuid;
    this.deptAbbrev = deptAbbrev;
    this.id = id;
    this.section = section;
  }
}
