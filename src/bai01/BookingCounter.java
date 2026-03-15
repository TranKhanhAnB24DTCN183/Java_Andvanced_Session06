package bai01;

public class BookingCounter extends Thread {

    String name;
    TicketPool roomA;
    TicketPool roomB;
    boolean lockAFirst;

    public BookingCounter(String name, TicketPool roomA, TicketPool roomB, boolean lockAFirst) {
        this.name = name;
        this.roomA = roomA;
        this.roomB = roomB;
        this.lockAFirst = lockAFirst;
    }

    public void sellCombo() {
        synchronized (roomA) {
            synchronized (roomB) {
                if (roomA.hasTicket() && roomB.hasTicket()) {
                    Ticket t1 = roomA.getTicket();
                    Ticket t2 = roomB.getTicket();
                    System.out.println(name + " bán combo: " + t1.id + " & " + t2.id);
                } else {
                    System.out.println(name + " hết vé, bán combo thất bại");
                }
            }
        }
    }

    public void run() {

        while (true) {

            sellCombo();

            try {
                Thread.sleep(200);
            } catch (Exception e) {}
        }
    }
}