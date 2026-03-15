package bai02;

public class BookingCounter extends Thread {
    String name;
    TicketPool pool;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    public void run() {
        while (true) {
            pool.sellTicket(name);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
