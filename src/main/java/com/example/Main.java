package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito");
        Socket s = new Socket("localhost", 3000); // può esserci una eccezione se il serve non c'è
        System.out.println("il client si è collegato");
        Scanner scanner = new Scanner(System.in);
        String risposta = "";
        String indovinato = "";
        String numeroTentativi="";
        String scelta = "";
    
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        //do{
            do{
                System.out.println("scrivi il numero da indovinare");
                String numeroDaIndovinare = scanner.nextLine();
                //() fare i giusti controlli )
                
                //spedisco imput
                out.writeBytes(numeroDaIndovinare + "\n");
    
                //ricevo se è giusto o < >
    
                risposta = in.readLine();
                System.out.println(risposta);
                if(risposta.equals("!!!<") ||risposta.equals("!!!>") ){
                    System.out.println(" numero non  valido");
                }
                // se indovinato
               if(risposta.equals("=")){
                 System.out.println("indovinato");
                 numeroTentativi = in.readLine();
                 System.out.println( "numero tentativi " + numeroTentativi);
               }
            
            }while(!(risposta.equals("="))); // ciclo che chiede un numero fino a che la risposta del servere sia "=";
            
            //System.out.println("vuoi continuare ? digita y se si o x se no");
            //scelta = scanner.nextLine();
            
           // if (scelta.equals("x"))
            //break;

        //}while(scelta.equals("y"));
        
       System.out.println("terminato");


    }
}