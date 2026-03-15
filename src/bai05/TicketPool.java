package bai05;
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

    public synchronized Ticket holdTicket(boolean vip) {

        for (Ticket t : tickets) {

            if (!t.isSold && !t.isHeld) {

                t.isHeld = true;
                t.isVIP = vip;

                t.holdExpiryTime = System.currentTimeMillis() + 5000;

                return t;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket, String counterName) {

        if (ticket != null && ticket.isHeld) {

            ticket.isSold = true;
            ticket.isHeld = false;

            System.out.println(counterName + ": Thanh toán thành công vé " + ticket.ticketId);
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld && !t.isSold && now > t.holdExpiryTime) {

                t.isHeld = false;

                System.out.println("TimeoutManager: Vé " + t.ticketId + " hết hạn giữ, đã trả lại kho");
            }
        }
    }
}
