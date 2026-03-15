package bai03;

public class BookingCounter extends Thread {

    String name;
    TicketPool pool;
    int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    public void run() {

        while (true) {

            Ticket ticket = pool.sellTicket(name);

            if (ticket != null) {
                soldCount++;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}
