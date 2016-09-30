/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;

/**
 *
 * @author Familia
 */
public class GenerarHorario {

    int asignaturaActual = 0;
    int horaInicio = 8;
    int horasDia = 6;
        
    public void generar() {
        Asignatura[] asignaturas = CrearAsignaturas.crearAsignaturas();
        /*Asignatura[] asignaturas1 = new Asignatura[25];
        int p = 0;
        //El array asignaturas1 tiene 5 veces cada una de las asignaturas originales y como hay 5 asignaturas, 5*5=25
        for(int i=0;i<5;i++){
            System.arraycopy(asignaturas, 0, asignaturas1, p, asignaturas.length);
            p+=5;
        }*/

        //Se empeiza a y 30

        String[][] horario = new String[5][horasDia];
        int dia = 1;
        int hora = 1;
        int totalHorasSemana = 5*horasDia;
        for (int i = 0; i < totalHorasSemana; i += 2) {
            //Suponiendo que todas las clases duran lo mismo
            Asignatura asignatura = seleccionar(asignaturas);
            for (int j = 0; j < asignatura.getHorasSesion(); j++) {
                horario[dia - 1][hora - 1] = asignatura.getNombre();
                hora++;
            }
            asignatura.setDiaActualPuede(false);
            asignatura.sumar();
            if ((hora - 1) == horasDia) {
                dia++;
                hora = 1;
                resetearDiaAsignaturas(asignaturas);
            }
        }

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

    public Asignatura seleccionar(Asignatura[] as) {
        Asignatura a = null;
        //for (int i = 0; i < as.length; i++) {
        if (as[asignaturaActual].isDiaActualPuede() && !as[asignaturaActual].isTopeSemana()) {
            a = as[asignaturaActual];
        } else {
            a = new Asignatura("----", 2, 2);
        }
        asignaturaActual++;
        if (asignaturaActual == as.length) {
            asignaturaActual = 0;
        }
        // }
        return a;
    }

    public void resetearDiaAsignaturas(Asignatura[] as) {
        for (int i = 0; i < as.length; i++) {
            as[i].setDiaActualPuede(true);
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
    
    

}
