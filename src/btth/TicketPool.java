package btth;
import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets;
    private int counter = 1;

    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            String id = roomName + "-" + String.format("%03d", counter++);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        while (getAvailableCount() == 0) {
            try {
                System.out.println("Hết vé phòng " + roomName + " -> chờ thêm vé...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", counter++);
            tickets.add(new Ticket(id, roomName));
        }

        System.out.println("Nhà cung cấp: thêm " + count + " vé vào phòng " + roomName);

        notifyAll();
    }

    public synchronized int getAvailableCount() {

        int count = 0;

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                count++;
            }
        }

        return count;
    }
}
