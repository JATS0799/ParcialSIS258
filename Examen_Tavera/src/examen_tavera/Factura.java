/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Tavera;

/**
 *
 * @author Javier Tavera
 */
public class Factura {
    String Empresa;
    int idFactura;
    float monto;

    public Factura(String Empresa, int idFactura, float monto) {
        this.Empresa = Empresa;
        this.idFactura = idFactura;
        this.monto = monto;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    
    
}
