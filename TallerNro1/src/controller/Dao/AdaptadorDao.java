/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 *
 * @author miguel
 */
public class AdaptadorDao<T> implements InterfazDao {

    private Conexion conexion;
    private Class clazz;
    private String url;

    public AdaptadorDao(Class clas) {
        this.conexion = new Conexion();
        this.clazz = clas;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(Object obj) throws IOException {
        T[] lista =  (T[]) Array.newInstance(clazz, 1);
        
        try {
            T[] aux = listar();
                    lista =(T[]) Array.newInstance(clazz, aux.length + 1 );
                    for(int i = 0;i< aux.length; i++){
                    lista[i] = aux [i];
                    }
            lista[aux.length] = (T) obj;
        } catch (Exception e) {
            
        }
       // conexion.getXstream().alias(clazz.getSimpleName().toLowerCase(), T[].getClass());
        conexion.getXstream().alias(clazz.getSimpleName().toLowerCase(), clazz);
        conexion.getXstream().toXML(obj, new FileWriter(url));
    }

    @Override
    public void modificar(Object obj, Integer pos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T[] listar() {
        T[] lista = (T[]) conexion.getXstream().fromXML(url);
        
                
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
