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
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ServidorBanco extends UnicastRemoteObject
        implements IFactura {

    public ServidorBanco() throws RemoteException {
        super();
    }

    ;
  public static void main(String[] args) {
        ServidorBanco servidor;
        try {
            LocateRegistry.createRegistry(1098); // registrar el servidor e rmi register
            servidor = new ServidorBanco();
            Naming.bind("Banco", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Factura[] facturasCalcular(int idCliente) throws RemoteException {
        IPendientes pendiente;
        Factura f[] = new Factura[2];
        try {
            pendiente = (IPendientes) Naming.lookup("rmi://localhost/CESSA");
            f = pendiente.facturasPendientes(idCliente);
            //System.out.print("La suma es");

        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Pagar(Factura[] facturas) throws RemoteException {
        int port = 5001;
        String txt= new String("pag-" + facturas[0].getIdFactura() + "," + facturas[1].getIdFactura());
        String result = "";
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println(txt);
            result = fromServer.readLine();  
            //System.out.println("cadena devuelta es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
