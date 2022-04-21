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
    public CountDown(){
        x=1;
    }
    
    public void run(){
        int x=1;
        while(x>0){
            try {
                Thread.sleep(1000);
           System.out.print(x+'\n');
            x++;
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    }
    
    public void setX(int c){
        x=c;
    
}
}