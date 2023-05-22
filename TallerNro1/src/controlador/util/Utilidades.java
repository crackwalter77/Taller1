/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.util;

import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author walter
 */
public class Utilidades {
    
    public static void imprimir(Object[] obj){
        
        System.out.println("Lista de " + obj.getClass().getSimpleName());
        
        for(Object o: obj){
            if(o != null){
                System.out.println(o.toString());
            }
        }
    }
    public static Double sumarVentas(Sucursal s){
        if(s.getVentas() != null){
            Double ventas = 0.0;
            for(Venta v:s.getVentas()){
       
                ventas += v.getValor();
            }
            return ventas;
        }
        return 0.0;
    }
    public static Double mediaVentas(Sucursal s){
        Double suma = sumarVentas(s);
        if(suma == 0){
            return suma;
        }
        return suma/s.getVentas().length;
    }
}
