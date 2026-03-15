package bai04;
import java.util.Random;

public class BookingCounter implements Runnable {

    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    int soldCount = 0;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public void run() {

        while (roomA.hasAvailableTicket() || roomB.hasAvailableTicket()) {

            int choice = random.nextInt(2);

            Ticket ticket = null;

            if (choice == 0) {

                ticket = roomA.sellTicket();

                if (ticket == null) {
                    ticket = roomB.sellTicket();
                }

            } else {

                ticket = roomB.sellTicket();

                if (ticket == null) {
                    ticket = roomA.sellTicket();
                }
            }

            if (ticket != null) {

                soldCount++;

                System.out.println(counterName + " đã bán vé " + ticket.ticketId);
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {}
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}
