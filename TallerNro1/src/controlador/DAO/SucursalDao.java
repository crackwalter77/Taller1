/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import java.io.IOException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;
//import javax.persistence.metamodel.ListAttribute;

/**
 *
 * @author walter
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
    
    public void guardar() throws IOException{
        this.guardar(sucursal);
        
    }
    
    public void modificar(Integer pos) throws IOException{
        this.modificar(sucursal, pos);
    }
    
    private Integer generateId(){
        return listar().size()+1;
    }
    
    public static void main(String[] args){
        SucursalDao sd = new SucursalDao();
        
        sd.getSucursal().setNombre("Alice");
        sd.getSucursal().setId(sd.generateId());
        //sd.getSucursal().setVentas(new Venta[4]);
        //sd.sucursal.getVentas()[1] = new Venta();
        //sd.sucursal.getVentas()[1].setMes(EnumMes.MAYO);
        //sd.sucursal.getVentas()[1].setValor(567.9);
        
        Venta v = new Venta();
        v.setMes(EnumMes.MAYO);
        v.setValor(10080.0);
        //sd.getSucursal().getVentas().insertar(v);
        
        try {
            
            sd.guardar(sd.getSucursal());
            System.out.println(sd.listar());
            sd.listar().imprimir();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }
    
}
