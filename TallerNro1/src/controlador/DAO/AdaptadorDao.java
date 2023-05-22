/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import com.thoughtworks.xstream.io.StreamException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;


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
    public void guardar(T obj) throws IOException   {
        
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
        conexion.getXstream().toXML(lista, new FileWriter(url));
        
    }

    @Override
    public void modificar(T obj, Integer pos) {
        
    }

    @Override
    public T[] listar() throws StreamException{
        //TODO: Impplementar con listas aqui esta con arreglos
        T[] lista = (T[])conexion.getXstream().fromXML(url);
        
        return lista;

    }

    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    



    
    
    
}
