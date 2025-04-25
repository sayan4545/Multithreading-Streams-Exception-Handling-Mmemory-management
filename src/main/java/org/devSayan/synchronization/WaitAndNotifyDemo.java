package org.devSayan.synchronization;
public class WaitAndNotifyDemo {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            try{
                m1();
            }catch(Exception e){
                throw new RuntimeException("Runtime exception occured");
            }
        });
        Thread two = new Thread(()->{
            try{
                m2();
            }catch(Exception e){
                throw new RuntimeException("Runtime exception occured");
            }
        });
        one.start();
        two.start();
        try{
            one.join();
            two.join();
        }catch(Exception e){
            throw new RuntimeException("Runtime exception occured");
        }
    }
    private static void m1(){
        try{
            synchronized (LOCK){
                System.out.println("From m1.."); //1
                LOCK.wait();
                System.out.println("Back in m1"); //4
            }
        }catch(InterruptedException e){
            throw new RuntimeException("Runtime exception occured");
        }
    }
    private static void m2(){
        try{
            synchronized (LOCK){
                System.out.println("In m2"); //2
                LOCK.notify();
                System.out.println("Lets complete m2"); //3
            }
        }catch(Exception e){
            throw new RuntimeException("Runtime exception occured");
        }
    }
}
