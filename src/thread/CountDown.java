/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pandl
 */
public class CountDown extends Thread{
    int x;
    public CountDown(int y){
        x=y;
    }
    
    public void run(){
        System.out.print(x);
   
        while(x>0){
            try {
                Thread.sleep(1000);
         
            x--;
              System.out.print(x);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    }
    
    public void setX(int c){
        x=c;
    
}
    public int getX(){
        return x;
    }
}