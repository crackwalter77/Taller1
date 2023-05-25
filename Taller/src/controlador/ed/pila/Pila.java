/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.pila;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.pila.exception.TopeException;

/**
 *
 * @author walter
 */
public class Pila <E> {
    private PilaI<E> pilai;
    
    public Pila(Integer cima){
        pilai = new PilaI<>(cima);
    }
    
    public void push(E obj) throws TopeException{
        pilai.push(obj);
    }
    
    public E pop() throws VacioException, PosicionException{
        return pilai.pop();
    }
    
    public Integer getCima(){
        return pilai.getCima();
    }
    
    public void imprimir() throws VacioException{
        pilai.imprimir();
    }
    
}
