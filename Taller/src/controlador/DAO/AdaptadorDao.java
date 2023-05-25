/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import com.thoughtworks.xstream.io.StreamException;
import controlador.ed.lista.ListaEnlazada;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author walter
 */
public class AdaptadorDao <T> implements InterfazDao<T>{
    
    private Conexion conexion;
    private Class clazz;
    private String url;
    
    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL+clazz.getSimpleName().toLowerCase()+".json";
    }
    
    
    
    
    @Override
    public void guardar(T obj) throws IOException{
        
        ListaEnlazada<T> lista = listar();
        lista.insertar(obj);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
        
        
        /*
        T[] lista = (T[]) Array.newInstance(clazz, 1);
        try {
            T[] aux = listar();
            lista = (T[]) Array.newInstance(clazz, aux.length + 1);     

            for(int i = 0; i < aux.length; i++){
                lista[i] = aux[i];
            }
            lista[aux.length] = obj;
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("no");
            lista[0] = obj;
        }
        conexion.getXstream().alias(clazz.getSimpleName().toLowerCase(), clazz);
        conexion.getXstream().toXML(lista, new FileWriter(url));*/
    }

    @Override
    public void modificar(T obj, Integer pos) throws IOException{
        ListaEnlazada<T> lista = listar();
        //lista.update(obj, pos);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<T>)conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    



    
    
    
}
