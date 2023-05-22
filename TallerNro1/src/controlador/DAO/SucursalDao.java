/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author andy
 */
public class SucursalDao extends AdaptadorDao<Sucursal>{
    private Sucursal sucursal;
    public SucursalDao(){
        super(Sucursal.class);
    }

    public Sucursal getSucursal() {
        if(sucursal == null)
            this.sucursal = new Sucursal();
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public static void main(String[] args){
        SucursalDao sd = new SucursalDao();
        
        sd.getSucursal().setNombre("Alice");
        sd.getSucursal().setVentas(new Venta[4]);
        sd.sucursal.getVentas()[1] = new Venta();
        sd.sucursal.getVentas()[1].setMes(EnumMes.MAYO);
        sd.sucursal.getVentas()[1].setValor(567.9);
        
        try {
            sd.guardar(sd.getSucursal());
        } catch (Exception e) {
        }
        
    }
    
}
