package bai02;
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

        while (tickets.isEmpty()) {

            System.out.println(counterName + ": Hết vé phòng " + roomName + ", đang chờ...");

            try {
                wait();
            } catch (Exception e) {}
        }

        Ticket ticket = tickets.poll();

        System.out.println(counterName + " bán vé " + ticket.id);

        return ticket;
    }

    public synchronized void addTickets(int amount) {

        for (int i = 0; i < amount; i++) {

            tickets.add(new Ticket(roomName + "-00" + ticketIndex));
            ticketIndex++;
        }

        System.out.println("Nhà cung cấp: Đã thêm " + amount + " vé vào phòng " + roomName);

        notifyAll();
    }
}