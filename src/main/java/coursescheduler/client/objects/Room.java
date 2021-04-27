package coursescheduler.client.objects;

/** Holds information for a physical university room. */
public class Room {
    private final String id;
    private final Integer seatCount;

    public Room(String id, Integer seatCount) {
        this.id = id;
        this.seatCount = seatCount;
    }

    public int getCapacity() {
        return this.seatCount;
    }

    public String getRoomId() {
        return this.id;
    }
}