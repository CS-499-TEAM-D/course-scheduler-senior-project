package coursescheduler.views.pages;

import org.bson.types.ObjectId;

/** Represents the form of a course offered by a department at a University. */
public final class Course {
  ObjectId _id;
  String deptAbbrev;
  String id;
  String section;
  int preliminaryEnrollment;

  public Course(ObjectId _id, String deptAbbrev, String id, String section, int preliminaryEnrollment) {
    this._id = _id;
    this.deptAbbrev = deptAbbrev;
    this.id = id;
    this.section = section;
    this.preliminaryEnrollment = preliminaryEnrollment;
  }
}
