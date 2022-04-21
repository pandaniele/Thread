/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    
        DataOutputStream out;
          BufferedReader in;
    Socket client;
     BufferedReader tastiera;
    String stringaRicevuta;
    CountDown cd;
    public Client(InetAddress a, int porta){
            try {
                
                
                  tastiera=new BufferedReader(new InputStreamReader(System.in));
                  
                client= new Socket(a,porta);
                System.out.println(" 2) RICHIESTA CONNESSIONE DEL CLIENT IN CORSO \n");
                
                //stream di scrittura del socket
                out= new DataOutputStream( client.getOutputStream());
                
                //stream di scrittura del socket
                in= new BufferedReader( new InputStreamReader(client.getInputStream()));
            } catch (UnknownHostException ex) {
                  System.out.println(" CLIENT: HOST SCONOSCIUTO \n");
            }
            catch(IOException ex){
                System.out.println(" CLIENT: ERRORE GENERALE IN FASE DI CONNESSIONE  \n");
            }
    }
    
    public void scrivi(){
            try {
                 System.out.println(" CLIENT: COSA VUOI MANDARE AL SERVER?  \n");
               // String messaggioBenevnuto="MI DAI DATA E ORA?";
                out.writeBytes(tastiera.readLine()+"\r\n");
                System.out.println("6) INVIO MESSAGGIO:" +"\n");
                out.flush();
            } catch (IOException ex) {
               System.out.println(" CLIENT: ERORE DI SCRITTURA  \n");
            }
    }
    
      public void leggi(){
            try {
                stringaRicevuta=in.readLine();
                 System.out.println("5 OR 9) CLIENT: IL MESSAGGIO DEL SERVER E' : " +stringaRicevuta+"\n");
            } catch (IOException ex) {
               System.out.println(" CLIENT: ERRORE DI RICEVIMENTO"+ "\n");
            }
                     
                   /*  stringaRicevuta=in.readLine();
                      System.out.println("9) LA DATA RICEVUTA E': " +stringaRicevuta+"\n");*/
    }
        
      public void chiudi(){        
            try {
                client.close();  
                System.out.println("10)CONNESSIONE TERMINATA \n");
            } catch (Exception ex) {
               System.out.println("CLIENT: ERRORE DI CHIUSURA \n");
            }
           }
      
  public void leggiData(){
            try {
                stringaRicevuta=in.readLine();
                int intero = Integer.parseInt(stringaRicevuta);
                cd=new CountDown(intero);
                cd.start();
                client.setSoTimeout(intero);
                 System.out.println("5) CLIENT: IL MESSAGGIO DEL SERVER E' : " +stringaRicevuta+"\n");
                 
            }catch (IOException ex) {
               System.out.println(" CLIENT: ERRORE DI RICEVIMENTO"+ "\n");
            }
            //NON SI CHIUDE IL SERVER IN GENERALE?
        
              
    }
    
}
