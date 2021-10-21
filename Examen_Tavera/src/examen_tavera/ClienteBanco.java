/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Tavera;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ClienteBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFactura factura;
        Scanner sc = new Scanner(System.in);
        int opc;
        Factura f1 = new Factura("Elapas",2256,362);
        Factura f2 = new Factura("Elapas",3216,263); 
        Factura f[] = new Factura[2];
        String str = "";
        do {
            System.out.println("---------Primer parcial-----------");
            System.out.println("Javier Andres Tavera Sandoval");
            System.out.println("1. Calcular facturas");
            System.out.println("2. Pagar Facturas");
            System.out.println("3. Salir");
            System.out.println("Ingrese opcion: ");
            opc = sc.nextInt();

            try {
                factura = (IFactura) Naming.lookup("rmi://localhost/Banco");

                switch (opc) {

                    case 1:
                        System.out.println("Ingrese id del cliente: ");
                        int idc = sc.nextInt();
                        f = factura.facturasCalcular(idc);
                        System.out.println("Empresa: " + f[0].getEmpresa());
                        System.out.println("idCliente: " + idc);
                        System.out.println("idFactura: " + f[0].getIdFactura());
                        System.out.println("Monto: " + f[0].getMonto());
                        System.out.println("idCliente: " + idc);
                        System.out.println("idFactura: " + f[1].getIdFactura());
                        System.out.println("Monto: " + f[1].getMonto());
                        break;
                    case 2:
                        f[0] = f1;
                        f[1] = f2;
                        str = factura.Pagar(f);
                        String[] res = str.split(",");
                        String[] resultado1 = res[0].split(",");
                        String[] resultado2 = res[1].split(",");
                        System.out.println("Pagado: "+resultado1[1]+" idFactura: "+resultado1[0]);
                        System.out.println("Pagado: "+resultado2[1]+" idFactura: "+resultado2[0]);
                        break;
                    default:
                        System.out.println("opcion no valida");
                }

            } catch (NotBoundException ex) {
                Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (opc != 3);

    }
}