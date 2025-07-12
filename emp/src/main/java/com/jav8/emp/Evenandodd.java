package com.jav8.emp;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Evenandodd {

    public static Object object=new Object();

    public static IntPredicate evennumber=n->n%2==0;
    public static IntPredicate oddnumber=n->n%2==1;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->Evenandodd.printNumber(evennumber));
        CompletableFuture.runAsync(()->Evenandodd.printNumber(oddnumber));
        Thread.sleep(1000);
    }

    public static void printNumber(IntPredicate condition){
        IntStream.rangeClosed(1,10).filter(condition).forEach(Evenandodd::execute);
    }

    public static void execute(int no){
        synchronized (object){

            try {
                System.out.println(Thread.currentThread().getName()+" : "+no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
