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
        BufferedWriter bf;
         BufferedReader in;
            
                 BufferedReader tastiera;
                 String stringaRicevuta;
                 
                 
                    Socket socket;
                    CountDown cd;
    
   public Threa(Socket data, CountDown c ){
       socket=data;
       cd=c;
   }
   
   public void run(){
      comunica();
       
   }
   
    public void comunica(){
           try {
                 tastiera=new BufferedReader(new InputStreamReader(System.in));
                        
                  System.out.println("4) SERVER: CONNESIONE CON CLIENT AVVENUTA \n");
                  System.out.println("TEMPO DISPONIBILE PER LA CONNESSIONE: "+ cd.getX()+"\n");
              //stream di scrittura del socket
             bf=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
                
                   scriviData();
                   leggi();
                   chiudiConnessione();
             }
    catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }
             catch (Exception ex) {
                    System.out.println(" SERVER: ERRORE DI ACCETTAZIONE \n");
             }
    }
   
        
        public void leggi(){
            try {
                stringaRicevuta=in.readLine();
                 System.out.println("6) SERVER: IL MESSAGGIO DEL CLIENT E' : " +stringaRicevuta+"\n");
            }
               catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }catch (IOException ex) {
               System.out.println(" SERVER: ERRORE DI RICEVIMENTO"+ "\n");
            } 
        }
    public void scriviData(){
              try {
          
                   
         bf.write((cd.getX()-10)+"\r\n");
       
      
                bf.flush();    
                System.out.println("5) TEMPO LIMITE COMUNICAZIONE INVIATO \n");
            }
   catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }
              catch (IOException ex) {
               System.out.println(" SERVER: ERORE DI SCRITTURA  \n");
            }
        }  
 
        public void chiudiConnessione(){
             try {
                 socket.close();
                    System.out.println("11)CONNESSIONE CON IL CLIENT TERMINATA \n");
             } 
                catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }catch (IOException ex) {
                 System.out.println(" SERVER: IMPOSSIBILE CHIUDERE LA CONNESSIONE CON IL CLIENT"+ "\n");
             }
        }
    
    
}