/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Dao;

import java.io.IOException;

/**
 *
 * @author emilio
 */
public interface InterfazDao<T> {
    
    public void guardar(T obj) throws IOException;
    public void modificar(T obj, Integer pos);
    public T[] listar(); /// hacer con listas en la practica 
    public T obtener(Integer id);
    
    
}
