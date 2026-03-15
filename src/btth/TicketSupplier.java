package btth;
public class TicketSupplier implements Runnable {

    private TicketPool roomA;
    private TicketPool roomB;

    private int supplyCount;
    private int rounds;
    private int interval;

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int rounds, int interval) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.rounds = rounds;
        this.interval = interval;
    }

    @Override
    public void run() {

        for (int i = 0; i < rounds; i++) {

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            roomA.addTickets(supplyCount);
            roomB.addTickets(supplyCount);
        }

        System.out.println("Nhà cung cấp kết thúc");
    }
}
