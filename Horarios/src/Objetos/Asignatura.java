/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Familia
 */
public class Asignatura {
    
    String nombre;
    int horasSemanales;
    int horasSesion;
    
    boolean diaActualPuede = true;
    boolean topeSemana = false;

    int horasSemanaActual = 0;
    
    public Asignatura(String nombre, int horasSemanales, int horasSesion) {
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.horasSesion = horasSesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getHorasSesion() {
        return horasSesion;
    }

    public void setHorasSesion(int horasSesion) {
        this.horasSesion = horasSesion;
    }

    public boolean isDiaActualPuede() {
        return diaActualPuede;
    }

    public void sumar(){
        horasSemanaActual+=horasSesion;
        if(horasSemanaActual==horasSemanales){
            topeSemana=true;
        }
    }
    public void setDiaActualPuede(boolean diaActualPuede) {
        this.diaActualPuede = diaActualPuede;
    }

    public boolean isTopeSemana() {
        return topeSemana;
    }

    public void setTopeSemana(boolean topeSemana) {
        this.topeSemana = topeSemana;
    }
    
    
    
    
}
