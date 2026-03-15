package btth;
import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;

    private int totalSold = 0;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public int getTotalSold() {
        return totalSold;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (true) {

            Ticket ticket;

            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }

            if (ticket != null) {
                totalSold++;

                System.out.println(counterName +
                        " bán vé " +
                        ticket.getTicketId() +
                        " (" + ticket.getRoomName() + ")");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (roomA.getAvailableCount() == 0 && roomB.getAvailableCount() == 0) {
                break;
            }
        }

        System.out.println(counterName + " kết thúc. Tổng bán: " + totalSold);
    }
}
