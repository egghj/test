package cn.longyt.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

public class QueueUtilsTest {
    
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
    //private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
    
    @Test
    public void test01(){
        Thread t1 = new Thread(new producer());
        Thread t2 = new Thread(new consumer());
        t2.start();
        t1.start();
    }
    
    class producer implements Runnable{

        public void run() {
            while(true){
                try {
                    int product = (int) (Math.random() * 100);
                    queue.put(product + "");
                    System.out.println("生产了产品："+ product);
                    System.out.println("还有"+ queue.size() + "个产品");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    class consumer implements Runnable{

        public void run() {
            while(true){
                try {
                    String product = queue.take();
                    System.out.println("消费了一个产品"+ product);
                    System.out.println("还有"+ queue.size() + "个产品");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}


