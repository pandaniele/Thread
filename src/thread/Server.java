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

public class Server {
       //  DataOutputStream out;
         BufferedWriter bf;
         BufferedReader in;
            
                 BufferedReader tastiera;
                 String stringaRicevuta;
                 
                  ServerSocket serverSocket;
                    Socket socket;
                    CountDown cd;
                    //
                          
                    
  public Server(int porta){
             try {
                 cd=new CountDown(10);
                 
                 serverSocket = new ServerSocket(porta);
                 
                 serverSocket.setSoTimeout(10000);
                 cd.start();
                  System.out.println("1) SERVER IN ASCOLTO AVVIATO CORRETTAMEMTE \n");
           //
         //  serverSocket.setSoTimeout(10000);
             } 
                    catch(SocketTimeoutException e){
      System.out.println(" SERVER: TEMPO SCADUTO \n");
        cd.setX(0);
        chiudiServer();
        //NON SI CHIUDE IL SERVER IN GENERALE?
                                                    }

                  catch (BindException ex) {
              System.out.println(" SERVER: ERRORE, LA PORTA E' GIA' OCCUPATA \n");
        }
             catch (Exception ex) {
               System.out.println("SERVER: ERRORE INIZIALE DEL SERVER \n");
             }
           
  }
                
public void attendi(){
             try {
                 tastiera=new BufferedReader(new InputStreamReader(System.in));
                   
                 socket=serverSocket.accept();
            
                 System.out.println("TEMPO DISPONIBILE: "+ cd.getX()+"\n");
                 
                  System.out.println("3) SERVER: NUOVO CANALE DI COMUNICAZIONE CON IL CLIENT \n");
              //stream di scrittura del socket
             bf=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
             }
    catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }
             catch (Exception ex) {
                    System.out.println(" SERVER: ERRORE DI ACCETTAZIONE \n");
             }
}
    
          
        public void scrivi(){
              try {
                 System.out.println(" SERVER: COSA VUOI MANDARE AL CLIENT?  \n");
               // String messaggioBenevnuto="MI DAI DATA E ORA?";
               String hh=tastiera.readLine();
               if("0".equals(hh)){
                   
                   SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
                   
         bf.write(timeStamp+"\r\n");
              System.out.println("8) INVIO DATA E ORA \n");
              
               }
               else{
                   bf.write(hh+"\r\n");
                //messaggio di saluto
                System.out.println("4) INVIO MESSAGGIO:"+ hh +"\n");
               }
                
                bf.flush();
            }
   catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }
              catch (IOException ex) {
               System.out.println(" SERVER: ERORE DI SCRITTURA  \n");
            }
        }
        
        public void leggi(){
            try {
                stringaRicevuta=in.readLine();
                 System.out.println("7) SERVER: IL MESSAGGIO DEL CLIENT E' : " +stringaRicevuta+"\n");
            }
               catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }catch (IOException ex) {
               System.out.println(" SERVER: ERRORE DI RICEVIMENTO"+ "\n");
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
        
        public void chiudiServer(){
             try {
                 serverSocket.close();
                  System.out.println(" SERVER: SPENTO"+ "\n");
             } 
                catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }catch (IOException ex) {
                  System.out.println(" SERVER: IMPOSSIBILE SPEGNERE IL SERVER"+ "\n");
             }
        }
                 
             public void scriviData(){
              try {
          
                   
         bf.write(cd.getX()+"\r\n");
       
      
                bf.flush();    
                System.out.println("4) ORARIO LIMITE INVIATO \n");
            }
   catch (NullPointerException ex) {
               System.out.println(" OGGETTO DI TIPO NULL  \n");
            }
              catch (IOException ex) {
               System.out.println(" SERVER: ERORE DI SCRITTURA  \n");
            }
        }        
    }
    
