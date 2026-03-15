package btth;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB);
        BookingCounter counter3 = new BookingCounter("Quầy 3", roomA, roomB);

        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 5, 2, 5000);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(counter3);
        Thread supplierThread = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();
        supplierThread.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n===== KẾT QUẢ =====");

        System.out.println("Quầy 1 bán: " + counter1.getTotalSold());
        System.out.println("Quầy 2 bán: " + counter2.getTotalSold());
        System.out.println("Quầy 3 bán: " + counter3.getTotalSold());

        System.out.println("Vé còn phòng A: " + roomA.getAvailableCount());
        System.out.println("Vé còn phòng B: " + roomB.getAvailableCount());
    }
}
