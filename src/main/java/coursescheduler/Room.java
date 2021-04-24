package coursescheduler;

/** Holds information for a physical university room. */
public class Room {
  private final String id;
  private final Integer seatCount;

  public Room(String id, Integer seatCount) {
    this.id = id;
    this.seatCount = seatCount;
  }
}
