/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap8bai5;

import java.net.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Lap8bai5 {

    public final static int echoPort = 7;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket theServerSocket;
        Socket theConnectionSocket;
        BufferedReader in;
        PrintWriter out;

        try {
            theServerSocket = new ServerSocket(echoPort);
            System.out.println("EchoServer ready at port " + echoPort);
            while (true) {
                theConnectionSocket = theServerSocket.accept();
                try {
                    System.out.println("Request arrived!");
                    in = new BufferedReader(new InputStreamReader(theConnectionSocket.getInputStream()));
                    out = new PrintWriter(theConnectionSocket.getOutputStream(), true);
                    while (true) {
                        String readText = in.readLine();
                        out.println(readText);
                    }
                } catch (IOException e) {
                    theConnectionSocket.close();
                }
            }
        } catch (IOException e) {
            InterruptedException(e);
        }
    }

    private static void InterruptedException(IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}