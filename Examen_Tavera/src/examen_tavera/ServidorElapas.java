/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Tavera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Javier Tavera
 */
public class ServidorElapas {

    public static void main(String[] args) {
        int port = 5001;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            //System.out.println(fromClient.readLine());
            toClient = new PrintStream(client.getOutputStream());
            String datos = fromClient.readLine();
            String[] separador = datos.split("-");
            String[] ids = separador[1].split(",");
            String res = "";
            if("2256".equals(ids[0]) || "3216".equals(ids[1]) || "4547".equals(ids[1])) res = "2256-362,3216-263,4547-441";
            if("1354".equals(ids[0]) || "3252".equals(ids[1])) res = "1354-215,3252-172";
            /*
            switch (ids[0]) {
                case "1":
                    res = new String("2256-362,3216-263,4547-441");
                    break;
                case "2":
                    res = new String("1354-215,3252-172");
                    break;
                default:
                    res = "no hay el id solicitado";
            }*/
            

            toClient.println(res);
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
