package coursescheduler.client.daos;

import java.util.List;

import coursescheduler.infrastructure.database.models.Room;

/** TODO: javadoc. */
public interface RoomDao {
  List<Room> getRooms();

  Room getRoomById(String id);
}
