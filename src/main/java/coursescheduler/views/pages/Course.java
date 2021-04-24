package coursescheduler.views.pages;

import org.bson.types.ObjectId;

/** TODO: Javadoc. */
public class Course {
  ObjectId _id;
  String deptAbbrev;
  String id;
  String section;

  Course(ObjectId _id, String deptAbbrev, String id, String section) {
    this._id = _id;
    this.deptAbbrev = deptAbbrev;
    this.id = id;
    this.section = section;
  }
}
