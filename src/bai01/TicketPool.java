package bai01;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    String roomName;
    Queue<Ticket> tickets = new LinkedList<>();

    public TicketPool(String roomName, int total) {
        this.roomName = roomName;

        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-00" + i));
        }
    }

    public Ticket getTicket() {
        return tickets.poll();
    }

    public boolean hasTicket() {
        return !tickets.isEmpty();
    }
}
