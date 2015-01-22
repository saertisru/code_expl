package com.simple;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener implements AsyncListener {

  public MyAsyncListener() {    }
  public void onComplete(AsyncEvent ae) {
    System.out.println("Complete");
  }
  public void onTimeout(AsyncEvent ae) {
    System.out.println("Timeout");
  }
  public void onError(AsyncEvent ae) {
    System.out.println("Error");
  }
  public void onStartAsync(AsyncEvent ae) {
    System.out.println("Start");
  }
}