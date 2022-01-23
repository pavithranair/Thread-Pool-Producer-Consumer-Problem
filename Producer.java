package com.company;

public class Producer implements Runnable{

    Buffer buffer;
    String name;

    public Producer(Buffer buffer,String name){
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {   //int i = 0;
            while(true) {
                Buffer.empty.acquire();
                Buffer.access.acquire();

                int item = (int) (Math.random()*100);
                System.out.println("Producer " + this.name + " produced: " + item);
                Thread.sleep(100);
                buffer.addItem(item);

                Buffer.access.release();
                Buffer.full.release();
                //i++;
            }
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}
