package instantPolls.model;

import java.time.LocalDate;

public class Room {
	
	private String id;
	private String roomName;
	private LocalDate expirationDate;
	
	public Room(String id, String roomName, LocalDate expirationDate) {
		this.id=id;
		this.roomName = roomName;
		this.expirationDate = expirationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
}
