package bai05;

public class TimeoutManager implements Runnable {
    TicketPool[] pools;

    public TimeoutManager(TicketPool[] pools) {
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            for (TicketPool pool : this.pools) {

                pool.releaseExpiredTickets();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
