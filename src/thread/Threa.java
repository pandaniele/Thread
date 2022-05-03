/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author pandl
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Threa extends Thread {
    ClientHandler http;
  public Threa(ClientHandler h){
     http=h;
  }
    @Override
  public void run(){
      http.run();
  }
  
}