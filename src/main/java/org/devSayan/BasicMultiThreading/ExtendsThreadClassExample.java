package org.devSayan.BasicMultiThreading;

public class ExtendsThreadClassExample {
    public static void main(String[] args) {
        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();
        one.start();
        two.start();

    }
}
class ThreadOne extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("ThreadOne: " + Thread.currentThread().getName()+" value="+i);
        }
    }
}
class ThreadTwo extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("ThreadTwo: " + Thread.currentThread().getName()+" value="+i);
        }
    }
}
