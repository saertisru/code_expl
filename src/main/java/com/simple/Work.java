package com.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.AsyncContext;

/**
 *
  */
public class Work implements Runnable {
  AsyncContext asyncContext;
  public volatile static AtomicInteger atomicInteger = new AtomicInteger(0);
  
  public Work(AsyncContext asyncContext) {
    super();
    this.asyncContext = asyncContext;
  }

  @Override
  public void run() {
    try {
      long rnd = (long)(Math.random() *5000);
        PrintWriter writer = asyncContext.getResponse().getWriter();

        Thread.currentThread().sleep(rnd);
        writer.println(atomicInteger.addAndGet(1)+" complet");
        writer.flush();
        writer.close();
        asyncContext.complete();
    }
    catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
