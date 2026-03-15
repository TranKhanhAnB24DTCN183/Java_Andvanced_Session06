package bai05;
import java.util.Random;

public class BookingCounter implements Runnable {

    String name;
    TicketPool[] pools;

    Random random = new Random();

    public BookingCounter(String name, TicketPool[] pools) {
        this.name = name;
        this.pools = pools;
    }

    public void run() {

        while (true) {

            int roomIndex = random.nextInt(pools.length);

            boolean vip = random.nextBoolean();

            Ticket ticket = pools[roomIndex].holdTicket(vip);

            if (ticket != null) {

                if (vip)
                    System.out.println(name + ": Đã giữ vé VIP " + ticket.ticketId);
                else
                    System.out.println(name + ": Đã giữ vé " + ticket.ticketId);

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {}

                pools[roomIndex].sellHeldTicket(ticket, name);
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
