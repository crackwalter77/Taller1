/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 *
 * @author miguel
 */
public class Conexion {
    private  XStream xstream;
    public static String URL = "data/";
    public void conectar () {
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
    }
    
    public  XStream getXstream () {
        if (xstream == null){
            conectar();
        }
        return xstream;
    }
}
