package bai06;
import java.util.*;

public class BookingCounter implements Runnable {

    String name;
    List<TicketPool> pools;

    boolean running = true;

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void stop() {
        running = false;
    }

    public void run() {

        Random random = new Random();

        while (running) {

            TicketPool pool = pools.get(random.nextInt(pools.size()));

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {

                System.out.println(name + " bán vé " + ticket.id);
            }

            try {
                Thread.sleep(300);
            } catch (Exception e) {}
        }
    }
}
