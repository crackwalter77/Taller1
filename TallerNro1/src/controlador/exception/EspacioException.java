/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.exception;

/**
 *
 * @author walter
 */
public class EspacioException extends Exception{

    public EspacioException() {
        super("No hay espacio suficiente o posicion no valida");
    }
    
}
