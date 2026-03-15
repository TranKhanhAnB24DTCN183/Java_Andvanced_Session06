package bai01;

public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 3);
        TicketPool roomB = new TicketPool("B", 3);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB, true);

        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB, false);

        counter1.start();
        counter2.start();
    }
}
