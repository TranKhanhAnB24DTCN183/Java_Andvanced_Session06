package bai03;
public class Main {

    public static void main(String[] args) throws Exception {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 3);

        Thread supplierThread = new Thread(supplier);

        counter1.start();
        counter2.start();
        supplierThread.start();

        Thread.sleep(15000);

        System.out.println("\n----- KẾT QUẢ -----");

        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount());
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount());

        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());

        System.exit(0);
    }
}
