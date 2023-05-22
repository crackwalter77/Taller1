/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.cola;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.pila.exception.TopeException;

/**
 *
 * @author walter
 */
public class Cola<E> {
    private ColaI<E> cola;
    
    public Cola(Integer tope){
        cola = new ColaI(tope);
    }
    
    public void queue(E obj) throws TopeException{
        cola.queue(obj);
    }
    
    public E dequeue() throws VacioException, PosicionException{
        return cola.dequeue();
    }
    
    public Integer getTope(){
        return cola.getTope();
    }
    
    public void imprimir() throws VacioException{
        cola.imprimir();
    }
    
}
