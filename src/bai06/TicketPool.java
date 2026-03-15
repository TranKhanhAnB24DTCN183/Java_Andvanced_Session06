package bai06;
import java.util.*;

public class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int total) {

        this.roomName = roomName;

        for (int i = 1; i <= total; i++) {

            String id = roomName + "-" + String.format("%03d", i);

            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.sold) {
                t.sold = true;
                return t;
            }
        }

        return null;
    }

    public int getSoldCount() {

        int c = 0;

        for (Ticket t : tickets) {
            if (t.sold) c++;
        }

        return c;
    }

    public int getTotal() {
        return tickets.size();
    }
}
