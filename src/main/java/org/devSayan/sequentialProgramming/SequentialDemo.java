package org.devSayan.sequentialProgramming;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class SequentialDemo {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Initial heap memory: " + heapMemoryUsage.getInit()/(1024*1024) + "MB");
        System.out.println("Memory used: " + heapMemoryUsage.getUsed()/(1024*1024) + "MB");
        System.out.println("Memory committed: " + heapMemoryUsage.getCommitted()/(1024*1024) + "MB");
        System.out.println("Memory max: " + heapMemoryUsage.getMax()/(1024*1024) + "MB");


        demo1();
        demo2();

        System.gc();

    }
    private static void demo1(){
        for (int i = 0; i < 10; i++) {
            System.out.println("demo1: "+ i);
        }
    }
    private static void demo2(){
        for (int i = 0; i < 10; i++) {
            System.out.println("demo2: "+ i);
        }
    }
}
