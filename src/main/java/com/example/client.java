package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class client{

    String nomeServer = "localhost";
    int porta = 3344;
    Socket miosocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){

        try{
            System.out.println("scrivi");
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            miosocket = new Socket(nomeServer , porta);
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader( new InputStreamReader(miosocket.getInputStream()));


        }

        catch(UnknownHostException e){

            System.out.println(e.getMessage());

            System.exit(1);



        }

        catch(Exception e){

            System.out.println(e.getMessage());

            System.exit(1);



        }



        return miosocket;
    }

    public void comunica(){



        try{
            System.out.println("inserisci stringa");
            stringaUtente = tastiera.readLine();
            System.out.println("invio");
            outVersoServer.writeBytes(stringaUtente + "\n");
            stringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("ricevuta" + stringaRicevutaDalServer);
            System.out.println("fine");
            miosocket.close();




        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }




    }













}