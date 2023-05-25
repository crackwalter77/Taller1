/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author walter
 */
public class SucursalControl {
    
    public Sucursal [] sucursales;
    private Sucursal sucursal;
    private Venta venta;

    
    public SucursalControl() {
        sucursales = new Sucursal[4];
        for(Sucursal s:sucursales){
            s = new Sucursal();
        }
    }

    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    public Sucursal getSucursal() {
        if(sucursal == null)
            sucursal = new Sucursal();
        
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
    
    
    public boolean registrar() throws EspacioException {
        int pos = -1;
        int cont = -1;
        for(Sucursal s : sucursales){
            cont++;
            
            if(s == null){
                pos = cont;
                break;
            }
        }
        if(pos == -1){
            throw new EspacioException();
        }
        
        sucursal.setVentas(new Venta[EnumMes.values().length]);
        for (int i = 0; i < EnumMes.values().length; i++) {
            Venta venta = new Venta();
            venta.setId((i + 1));
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;
        }
        
        sucursales[pos] = sucursal;
        return true;
    }
    
    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException{
        
        if(this.sucursal != null){
            if(posVenta <= this.sucursal.getVentas().length-1){
                sucursal.getVentas()[posVenta].setValor(valor);
            }else{
                throw new EspacioException();
            }
            
        }else{
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        
        return true;
    }
    
    
}
