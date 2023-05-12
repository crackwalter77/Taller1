/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Dao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EnumMes;
import model.Sucursal;
import model.Venta;

/**
 *
 * @author miguel
 */
public class SucursalDao extends AdaptadorDao<Sucursal>{
    private Sucursal sucursal = null;

    public SucursalDao() {
        super(Sucursal.class);
    }
    
    
    public static void main(String[] args) {
        SucursalDao sd = new SucursalDao();
        sd.getSucursal().setNombre("MIguel");
        sd.getSucursal().setVentas(new Venta[4]);
        sd.sucursal.getVentas()[1] = new Venta();
        sd.sucursal.getVentas()[1].setMes(EnumMes.MAYO);
        sd.sucursal.getVentas()[1].setValor(21.3);
        
        try {
            sd.guardar(sd.getSucursal());
        } catch (IOException ex) {
            Logger.getLogger(SucursalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
