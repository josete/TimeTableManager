/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Horario;
import Objetos.Sesion;

/**
 *
 * @author Familia
 */
public class GenerarHorario {

    int asignaturaActual = 0;
    int totalSesiones = 0;
    int horaInicio = 8;
    int horasDia = 6;
    Sesion[][] horario;
    Contenedor almacenamiento;
    Horario horario1;
        
    public void generar() {
        almacenamiento = new Contenedor();
        Sesion[] sesiones=null ; //CrearAsignaturas.crearAsignaturas(almacenamiento);
        totalSesiones = sesiones.length;
        System.out.println("-----------"+sesiones.length);
        horario1 = new Horario();
        //Se empeiza a y 30

        horario = new Sesion[5][horasDia];
        for(Sesion s:sesiones){
            horario1.anadirSesion(horaInicio+":30", s);
            horaInicio++;
        }
//        int dia = 1;
//        int hora = 1;
//        int totalHorasSemana = 5*horasDia;
//        for (int i = 0; i < totalHorasSemana; i += 2) {
//            //Suponiendo que todas las clases duran lo mismo
//            Sesion sesion = seleccionar(sesiones);
//            for (int j = 0; j < sesion.getAsignatura().getHorasSesion(); j++) {
//                horario[dia - 1][hora - 1] = sesion;
//                hora++;
//            }
//            sesion.getAsignatura().setDiaActualPuede(false);
//            //sesion.getAsignatura().sumar();
//            if ((hora - 1) == horasDia) {
//                dia++;
//                hora = 1;
//                resetearDiaAsignaturas(sesiones);
//            }
//        }

        System.out.println("\tL\tM\tX\tJ\tV");
        for (int j = 0; j < horasDia; j++) {
            System.out.print(horaInicio + ":30\t");
            for (int i = 0; i < 5; i++) {
                System.out.print(horario[i][j]);
                System.out.print("\t");
            }
            System.out.println("");

            horaInicio++;
        }
    }

    public Sesion seleccionar(Sesion[] as) {
        Sesion a = null;
        try{
            a = as[asignaturaActual];
            asignaturaActual++;
        }catch(NullPointerException ex){
            a = new Sesion();
        }
        return a;
    }

    public void resetearDiaAsignaturas(Sesion[] as) {
        for (int i = 0; i < as.length; i++) {
            as[i].getAsignatura().setDiaActualPuede(true);
        }
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(int horasDia) {
        this.horasDia = horasDia;
    }

    public Horario getHorario() {
        return horario1;
    }

    public void setHorario(Sesion[][] horario) {
        this.horario = horario;
    }
    
    
    

}
