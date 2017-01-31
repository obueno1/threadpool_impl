package com.fieldlens.ThreadPool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by oebueno on 1/29/17.
 */
public class PoolThread extends Thread{

    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            }
            catch(Exception e){
                System.out.println("Worker Thread could not start");
            }
        }
    }

    public void stopThread() {
        isStopped = true;
        this.interrupt();
    }

    public boolean isStopped(){
        return isStopped;
    }
}
