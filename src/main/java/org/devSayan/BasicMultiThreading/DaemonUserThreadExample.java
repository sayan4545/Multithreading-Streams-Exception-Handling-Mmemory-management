package org.devSayan.BasicMultiThreading;

public class DaemonUserThreadExample {
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            int count =0;
            while(count<1000){
                try{
                    Thread.sleep(1000);
                    System.out.println("Thread 1 : "+count++);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            try{
                Thread.sleep(5000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("Completed exexcution of user thread");
        });

        t1.setDaemon(true);
        t1.start();
        t2.start();
    }


}
