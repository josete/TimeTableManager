/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Hashtable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Familia
 */
public class Horario {

    int id;
    Hashtable<String, Sesion> sesiones;
    ArrayList<Asignatura> asignaturas;
    int horaInicio;
    int minInicio;
    int horasDia;
    int dia = 1; //de 1 a 5
    Grupo g;
    
    boolean generado = false;

    public Horario() {
        sesiones = new Hashtable<>();
    }

    public Horario(int horaInicio, int minInicio, int horasDia) {
        this.horaInicio = horaInicio;
        this.minInicio = minInicio;
        this.horasDia = horasDia;
        sesiones = new Hashtable<>();
    }

    
    public Horario(ArrayList<Asignatura> asignaturas, int hora0, int min0, int horasDia, Grupo g) {
        sesiones = new Hashtable<>();
        this.asignaturas = asignaturas;
        this.horaInicio = hora0;
        this.minInicio = min0;
        this.horasDia = horasDia;
        this.g = g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hashtable<String, Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(Hashtable<String, Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    public void anadirSesion(String horaInicio, Sesion s) {
        sesiones.put(horaInicio+" "+dia, s);
    }

    public void generar() {
        int horaCambia = horaInicio;
        ArrayList<Sesion> sesionesList = crearSesiones();
        int actual = 0;
        while (dia < 6) {
            if (sesionesList.get(actual).getAsignatura().isDiaActualPuede()) {
                anadirSesion(horaCambia + ":" + minInicio, sesionesList.get(actual));
                horaCambia += sesionesList.get(actual).getAsignatura().getHorasSesion();
                sesionesList.get(actual).getAsignatura().setDiaActualPuede(false);
            }
            actual++;
            if (horaCambia == (horasDia + horaInicio)) {
                horaCambia = horaInicio;
                dia++;
                resetear(sesionesList);
            }
            if (actual == sesionesList.size()) {
                actual = 0;
            }
        }
        generado = true;
    }

    public ArrayList<Sesion> crearSesiones() {
        ArrayList<Sesion> sesiones = new ArrayList();
        for (Asignatura a : asignaturas) {
            while (a.getHorasSemanales() > 0) {
                sesiones.add(new Sesion(a, g));
                a.sumar();
            }
        }
        return sesiones;
    }
    
    public void resetear(ArrayList<Sesion> se){
        for(Sesion s:se){
            s.getAsignatura().setDiaActualPuede(true);
        }
    }
    
    public ObservableList<Fila> datosDibujar(){
        ObservableList<Fila> data = FXCollections.observableArrayList();
        Fila f;
        for(int i=0;i<3;i++){
            f = new Fila();
            f.setHora(horaInicio+":"+String.format("%02d", minInicio));
            for(int j=1;j<6;j++){
                f.insertar(j, sesiones.get(horaInicio+":"+minInicio+" "+j));
            }
            data.add(f);
            horaInicio+=2;
        }
        return data;
    }

    public boolean isGenerado() {
        return generado;
    }

    public void setGenerado(boolean generado) {
        this.generado = generado;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    

}
