package bai06;
import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {

    List<TicketPool> rooms = new ArrayList<>();

    ExecutorService executor;

    List<BookingCounter> counters = new ArrayList<>();

    public void start(int roomCount, int ticketsPerRoom, int counterCount) {

        rooms.clear();
        counters.clear();

        for (int i = 0; i < roomCount; i++) {

            char name = (char) ('A' + i);

            rooms.add(new TicketPool("" + name, ticketsPerRoom));
        }

        executor = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {

            BookingCounter c = new BookingCounter("Quầy " + i, rooms);

            counters.add(c);

            executor.submit(c);
        }

        System.out.println("Đã khởi tạo hệ thống với " + roomCount + " phòng.");
    }

    public void stop() {

        for (BookingCounter c : counters) {
            c.stop();
        }

        executor.shutdown();

        System.out.println("Đã tạm dừng hệ thống.");
    }

    public void statistics() {

        System.out.println("=== THỐNG KÊ ===");

        for (TicketPool p : rooms) {

            System.out.println(
                    "Phòng " + p.roomName +
                            ": " + p.getSoldCount() +
                            "/" + p.getTotal());
        }
    }
}
