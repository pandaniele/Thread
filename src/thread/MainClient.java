/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pandl
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Client cc=new Client(InetAddress.getLocalHost(), 2000);
            
        
            cc.leggiData();
            cc.scrivi();
            //   cc.chiudi();
           //     cc.scrivi();
              
               //     cc.leggi();
            
                
           
               
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
