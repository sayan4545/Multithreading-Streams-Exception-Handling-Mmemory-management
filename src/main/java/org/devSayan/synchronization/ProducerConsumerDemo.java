package org.devSayan.synchronization;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Worker worker = new Worker(5,0);
        Thread t1 = new Thread(()->{
            worker.produce();
        });
        Thread t2 = new Thread(()->{
            worker.consume();
        });
        t1.start();
        t2.start();
    }

}
class Worker{
    private int SEQUENCE = 0;
    private final Integer top;
    private final Integer bottom;
    private static final Object LOCK = new Object();
    private final List<Integer> container;
    public Worker(Integer top, Integer bottom){
        this.top = top;
        this.bottom = bottom;
        this.container = new ArrayList<>();
    }

    public void produce(){
        synchronized(LOCK){
            while(true){
                if(container.size() == top){
                    System.out.println("Container vis full .. waiting to get finished");
                    try{
                        LOCK.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Added to container.."+SEQUENCE);
                    container.add(SEQUENCE++);
                    LOCK.notifyAll();
                }
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public void consume(){
        synchronized(LOCK){
            while(true){
                if(container.size()==bottom){
                    System.out.println("Container empty.. waiting to be fuilled");
                    try{
                        LOCK.wait();
                    }catch(InterruptedException e){

                    }
                }
                else{
                    System.out.println("Removed from container.."+ container.removeFirst());
                    LOCK.notifyAll();
                }
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


}
