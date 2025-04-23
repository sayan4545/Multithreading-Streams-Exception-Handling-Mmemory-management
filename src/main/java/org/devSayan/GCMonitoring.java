package org.devSayan;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.List;
import java.lang.management.*;


public class GCMonitoring {
    public static void main(String[] args) {
        // Get the memory bean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Get garbage collectors
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

        // Print initial memory stats
        System.out.println("Initial heap: " + formatMemory(memoryBean.getHeapMemoryUsage()));

        // Create garbage
        List<byte[]> garbage = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            garbage.add(new byte[1000000]);
        }

        // Clear half the list to create garbage
        for (int i = 0; i < 50; i++) {
            garbage.remove(0);
        }

        // Request GC
        System.gc();

        // Sleep to give GC time to run
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print GC stats
        System.out.println("\nGarbage Collection Statistics:");
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println(gcBean.getName() + " - Collections: " +
                    gcBean.getCollectionCount() + ", Time: " +
                    gcBean.getCollectionTime() + "ms");
        }

        // Print current memory stats
        System.out.println("\nCurrent heap: " + formatMemory(memoryBean.getHeapMemoryUsage()));
    }

    private static String formatMemory(MemoryUsage usage) {
        return String.format("Used: %dMB, Committed: %dMB, Max: %dMB",
                usage.getUsed() / (1024 * 1024),
                usage.getCommitted() / (1024 * 1024),
                usage.getMax() / (1024 * 1024));
    }
}

// Required imports:
