/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Tavera;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
 public class ServidorCESSA extends UnicastRemoteObject
        implements IPendientes {

    public ServidorCESSA() throws RemoteException {
        super();
    }

  public static void main(String[] args) {
       ServidorCESSA servidor;  
      try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    servidor=new ServidorCESSA(); 
	    Naming.bind("CESSA", servidor); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }

    @Override
    public Factura[] facturasPendientes(int idCliente) throws RemoteException {
        Factura f[]=new Factura[2];
        switch(idCliente){
            case 1:
                f[0] = new Factura("Cessa", 154, 150);
                f[1] = new Factura("Cessa", 326, 701);
                break;
            case 2:
                f[0] = new Factura("Cessa", 325, 610);
                f[1] = new Factura("Cessa", 457, 801);
            default:
                f[0] = null;
                       
        }
        return f;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
