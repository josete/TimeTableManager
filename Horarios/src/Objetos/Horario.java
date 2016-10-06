/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Excepciones.EHorarioSinAsignaturas;
import Excepciones.EHorarioSinGrupo;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Familia
 */
public class Horario {

    int id;
    HashMap<String, Sesion> sesiones;
    ArrayList<Asignatura> asignaturas;
    int horaInicio;
    int minInicio;
    int horasDia;
    int dia = 1; //de 1 a 5
    Grupo g;

    boolean generado = false;

    public Horario() {
        sesiones = new HashMap<>();
    }

    public Horario(int horaInicio, int minInicio, int horasDia) {
        this.horaInicio = horaInicio;
        this.minInicio = minInicio;
        this.horasDia = horasDia;
        sesiones = new HashMap<>();
    }

    public Horario(ArrayList<Asignatura> asignaturas, int hora0, int min0, int horasDia, Grupo g) {
        sesiones = new HashMap<>();
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

    public HashMap<String, Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(HashMap<String, Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    public void anadirSesion(String horaInicio, Sesion s) {
        sesiones.put(horaInicio + " " + dia, s);
    }

    public void generar() throws EHorarioSinGrupo, EHorarioSinAsignaturas {
        if (g != null) {
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
        } else {
            throw new EHorarioSinGrupo();
        }
    }

    public ArrayList<Sesion> crearSesiones() throws EHorarioSinAsignaturas {
        ArrayList<Sesion> sesiones = new ArrayList();
        if(asignaturas!=null&&asignaturas.size()>0){
        for (Asignatura a : asignaturas) {
            while (a.getHorasSemanales() > 0) {
                sesiones.add(new Sesion(a, g));
                a.sumar();
            }
        }
        }else{
            throw new EHorarioSinAsignaturas();
        }
        return sesiones;
    }

    public void resetear(ArrayList<Sesion> se) {
        for (Sesion s : se) {
            s.getAsignatura().setDiaActualPuede(true);
        }
    }

    public ObservableList<Fila> datosDibujar() {
        ObservableList<Fila> data = FXCollections.observableArrayList();
        Fila f;
        for (int i = 0; i < (horasDia / 2); i++) {
            f = new Fila();
            f.setHora(horaInicio + ":" + String.format("%02d", minInicio));
            for (int j = 1; j < 6; j++) {
                f.insertar(j, sesiones.get(horaInicio + ":" + minInicio + " " + j));
            }
            data.add(f);
            horaInicio += 2;
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

    public Grupo getG() {
        return g;
    }

    public void setG(Grupo g) {
        this.g = g;
    }

}
