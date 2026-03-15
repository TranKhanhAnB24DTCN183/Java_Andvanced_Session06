package bai06;

import java.lang.management.*;
public class DeadlockDetector implements Runnable {

    public void run() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.findDeadlockedThreads();

        if (ids != null) {

            System.out.println("⚠ DEADLOCK DETECTED!");

        } else {

            System.out.println("Không phát hiện deadlock.");
        }
    }
}
