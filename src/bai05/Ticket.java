package bai05;

public class Ticket {
    String ticketId;
    String roomName;

    boolean isSold = false;
    boolean isHeld = false;

    boolean isVIP = false;

    long holdExpiryTime = 0;

    public Ticket(String id, String room) {
        this.ticketId = id;
        this.roomName = room;
    }
}
