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
                 
                 cd=new CountDown(50);
                 
                 serverSocket = new ServerSocket(porta);
                  System.out.println("1) SERVER IN ASCOLTO AVVIATO CORRETTAMEMTE \n");
               serverSocket.setSoTimeout(50000);
                 cd.start();
                  
         int x=1;
         while(x!=0){
                socket=serverSocket.accept();
                Threa cl=new Threa(socket, cd);
                    cl.start();
                
         }
       
             } 
                    catch(SocketTimeoutException e){
      System.out.println(" SERVER: TEMPO SCADUTO \n");
        cd.setX(0);
        chiudiConnessione();
        //NON SI CHIUDE IL SERVER IN GENERALE?
                                                    }

                  catch (BindException ex) {
              System.out.println(" SERVER: ERRORE, LA PORTA E' GIA' OCCUPATA \n");
        }
             catch (Exception ex) {
               System.out.println("SERVER: ERRORE INIZIALE DEL SERVER \n");
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
                 
                
    }
    
