package org.devSayan.BasicMultiThreading;

public class RunnableImplementation {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<30;i++){
                System.out.println("Thread1: " + Thread.currentThread().getName()+" value="+i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<15;i++){
                System.out.println("Thread2: " + Thread.currentThread().getName()+" value="+i);
            }
        });

        t1.start();
        t2.start();
    }


}
