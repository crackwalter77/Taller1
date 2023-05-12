/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exception.SpaceException;
import model.EnumMes;
import model.Sucursal;
import model.Venta;

/**
 *
 * @author danny
 */
public class SucursalController {

    private Sucursal sucursales[];
    private Sucursal sucursal;
    private Venta venta;

    public SucursalController() {
        sucursales = new Sucursal[4];
//        for (Sucursal s: sucursales) {
//            s = new Sucursal();
//            s.setVentas(new Venta[EnumMes.values().length]);
//            for (int i = 0; i < EnumMes.values().length; i++) {
//                Venta venta = new Venta();
//                venta.setId(i+1);
//                venta.setMes(EnumMes.values()[i]);
//                venta.setValor(0.0);
//                s.getVentas()[i] = venta;
//            }
//        }
    }
    
    public SucursalController(String nombre){
        getSucursal().setNombre(nombre);  
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal[] getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursal[] sucursales) {
        this.sucursales = sucursales;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean registrar() throws SpaceException {
        int pos = -1;
        int cont = -1;
        for (Sucursal s : sucursales) {
            cont++;
            if (s == null) {
                pos = cont;
                break;
            }

        }
        if (pos == -1) {
            throw new SpaceException();
        }

        sucursal.setVentas(new Venta[EnumMes.values().length]);
        for (int i = 0; i < EnumMes.values().length; i++) {
            Venta venta = new Venta();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;
        }

        sucursales[pos] = sucursal;
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws SpaceException{
//        Venta venta = new Venta();
//        venta.setId(posVenta);
//        venta.setMes(EnumMes.values()[posVenta]);
//        venta.setValor(valor);
//        sucursal.getVentas()[posVenta] = venta;
        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.getVentas().length-1) {
                sucursal.getVentas()[posVenta].setValor(valor);
            }else{
                throw new SpaceException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        return true;
    }

}
