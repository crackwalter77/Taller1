/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.SucursalControl;
import controlador.ed.cola.Cola;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.pila.Pila;
import controlador.util.Utilidades;
import modelo.Sucursal;

/**
 *
 * @author walter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Pila<Integer> pila = new Pila(5);
        Cola<Integer> cola = new Cola(5);
        try {
            pila.push(5);
            pila.push(56);
            pila.push(9);
            pila.push(45);
            pila.push(8);

            pila.imprimir();
            //pila.pop();

            System.out.println("----------------Cola");
            cola.queue(5);
            cola.queue(56);
            cola.queue(9);
            cola.queue(45);
            cola.queue(8);
            cola.imprimir();
            System.out.println(cola.dequeue());
            cola.imprimir();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        /*
        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
        try {
            Sucursal s1 = new Sucursal();
            
            s1.setId(lista.size()+1);
            s1.setNombre("Alice");
            
            lista.insertar(s1);
            lista.imprimir();
            
            s1 = new Sucursal();
            s1.setId(lista.size()+1);
            s1.setNombre("Marilyn");
            
            lista.insertarPosicion(s1, 0);
            lista.imprimir();
            lista.deleteAll();
            lista.imprimir();
        
            
            
        } catch (VacioException ex) {
            System.out.println(ex.getMessage());
        }catch(PosicionException ex){
            System.out.println(ex.getMessage());
        }
         */
 /*try {
            lista.insertar("Andy");
            lista.insertar("Marylyn");
            lista.insertar("Pedro");
            lista.insertarInicio("Cobos");
            lista.insertarPosicion("Walter", 3);
            lista.imprimir();
            System.out.println("ELIMINAR");
            System.out.println(lista.Delete(2));

            lista.imprimir();
            
            
        } catch (VacioException ex) {
            System.out.println(ex.getMessage());
        }catch(PosicionException ex){
            System.out.println(ex.getMessage());
        }*/
 /*
        SucursalControl sc = new SucursalControl();
        
            try {
            sc.getSucursal().setId(1);
            sc.getSucursal().setNombre("Carlos ");
            sc.registrar();
            Utilidades.imprimir(sc.getSucursal().getVentas());
            sc.setSucursal(null);

            sc.getSucursal().setId(2);
            sc.getSucursal().setNombre("Alberto ");
            sc.registrar();
            sc.setSucursal(null);

            sc.getSucursal().setId(3);
            sc.getSucursal().setNombre("Kevin ");
            sc.registrar();
            sc.setSucursal(null);

            sc.getSucursal().setId(4);
            sc.getSucursal().setNombre("John ");
            sc.registrar();
            Utilidades.imprimir(sc.getSucursales());
            sc.setSucursal(null);
            
            }
            
            catch(Exception e){
            
                System.out.println("Error"+e.getMessage());
            //Utilidades.imprimir(sc.getSucursales());
            }*/
    }

}
