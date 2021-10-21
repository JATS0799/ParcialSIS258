/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Tavera;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Javier Tavera
 */
public interface IFactura  extends Remote {
    Factura[] facturasCalcular(int idCliente) throws RemoteException;
    String Pagar(Factura[] facturas) throws RemoteException;
    
}
