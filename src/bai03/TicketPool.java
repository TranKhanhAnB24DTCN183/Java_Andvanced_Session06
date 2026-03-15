package bai03;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    String roomName;
    Queue<Ticket> tickets = new LinkedList<>();
    int ticketIndex = 1;

    public TicketPool(String roomName, int total) {

        this.roomName = roomName;

        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-00" + i));
            ticketIndex++;
        }
    }

    public synchronized Ticket sellTicket(String counterName) {

        if (tickets.isEmpty()) {
            return null;
        }

        Ticket t = tickets.poll();

        System.out.println(counterName + " đã bán vé " + t.id);

        return t;
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            tickets.add(new Ticket(roomName + "-00" + ticketIndex));
            ticketIndex++;
        }

        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
