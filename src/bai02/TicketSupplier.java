package bai02;

public class TicketSupplier extends Thread {
    TicketPool pool;
    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

            this.pool.addTickets(3);

        } catch (Exception e) {}
    }
}
