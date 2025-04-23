package org.devSayan.BasicMultiThreading;

public class JoinMethodExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread1: "+ i);
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i=0;i<30;i++){
                System.out.println("Thread2: "+i);
            }
        });
        System.out.println("Beforre execution..");
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(Exception e){
            e.getStackTrace();
        }
        System.out.println("Completed execution..");
    }
}
