/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Excepciones.EProfesorSinHoras;
import Excepciones.EProfesorSinNombre;
import java.util.regex.Pattern;

/**
 *
 * @author Familia
 */
public class Profesor {
    
    int id;
    String nombre;
    String email;
    String despacho;
    int maximoHorasDia = 0;
    int horasActualesDia = 0;
    //EProfesorSinNombre e= new EProfesorSinNombre("No puede haber un profesor sin nombre");

    public Profesor(String nombre, String email, String despacho,int id) throws EProfesorSinNombre {
        if (nombre==null){
             throw new Excepciones.EProfesorSinNombre("burrada en el ctor");
        }
        else{
        this.nombre = nombre;
        this.email = email;
        this.despacho = despacho;
        this.id = id;
        }
    }
    public Profesor() throws EProfesorSinNombre{
        throw new Excepciones.EProfesorSinNombre("burrada en el ctor vacio");
    }

    public Profesor(String n) throws EProfesorSinNombre{
        nombre = n;
     }
    public Profesor(String nombre, String email, String despacho) throws EProfesorSinNombre{
        if (nombre==null){
            throw new Excepciones.EProfesorSinNombre("burrada en el semi ctor");
        }
        else{
        this.nombre = nombre;
               Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        this.email = email;
        this.despacho = despacho;
        }
    }
    //public Profesor() {
      // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
        }

    public void setNombre(String nombre) throws EProfesorSinNombre {
        throw new Excepciones.EProfesorSinNombre("burrada en el setter");
        //this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
    
    
//    @Override
//    public String toString() {
//        return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", despacho=" + despacho + ", e=" + e + '}';
//    }

    public int getMaximoHorasDia() {
        return maximoHorasDia;
    }

    public void setMaximoHorasDia(int maximoHorasDia) {
        this.maximoHorasDia = maximoHorasDia;
    }

    public int getHorasActualesDia() {
        return horasActualesDia;
    }

    public void setHorasActualesDia(int horasActualesDia) {
        this.horasActualesDia = horasActualesDia;
    }
    
    public boolean puedeDarClaseHoy(){
        boolean puede = false;
        if(maximoHorasDia-horasActualesDia>0){
            puede = true;
        }
        return puede;
    }
    
    public void sumar(int horas) throws EProfesorSinHoras{
        int i = horasActualesDia + horas;
        if(puedeDarClaseHoy()){
            if(i>maximoHorasDia){
                throw new EProfesorSinHoras();
            }else{
                horasActualesDia = i;
            }
        }else{
            throw new EProfesorSinHoras();
        }
    }
           
}
