package coursescheduler.infrastructure.database.models;

public final class Room {
    private final int capacity;
    private final String roomId;

    public Room(String roomId, int capacity){
        this.capacity = capacity;
        this.roomId = roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomId() {
        return roomId;
    }
}
