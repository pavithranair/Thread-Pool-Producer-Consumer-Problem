package com.company;

public class Consumer implements Runnable{
    Buffer buffer;
    String name;

    public Consumer(Buffer buffer,String name){
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {
            //int i = 0;
            while(true) {
                    Buffer.full.acquire();
                    Buffer.access.acquire();
                    Thread.sleep(100);
                    int data = buffer.removeItem();
                    System.out.println("Consumer " + this.name + " consumed data : " + data);
                    Buffer.access.release();
                    Buffer.empty.release();
                    //i++;
            }
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}