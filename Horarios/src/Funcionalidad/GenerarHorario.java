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

    public void generar() {
        Asignatura[] asignaturas = CrearAsignaturas.crearAsignaturas();
        Asignatura[] asignaturas1 = new Asignatura[25];
        int p = 0;
        //El array asignaturas1 tiene 5 veces cada una de las asignaturas originales y como hay 5 asignaturas, 5*5=25
        for(int i=0;i<5;i++){
            System.arraycopy(asignaturas, 0, asignaturas1, p, asignaturas.length);
            p+=5;
        }

        int horasDia = 6;

        String[][] horario = new String[5][6];
        int dia = 1;
        int hora = 1;
        int totalHorasSemana = 30;
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

        System.out.println("\tLunes\tMartes\tMiercoles\tJueves\tViernes");
        System.out.print("8:30\t");
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.print(horario[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public Asignatura seleccionar(Asignatura[] as) {
        Asignatura a = null;
        //for (int i = 0; i < as.length; i++) {
            if (as[asignaturaActual].isDiaActualPuede() && !as[asignaturaActual].isTopeSemana()) {
                a = as[asignaturaActual];
            }else{
                a = new Asignatura("----", 2, 2);
            }
            asignaturaActual++;
            if(asignaturaActual==as.length){
                asignaturaActual=0;
            }
       // }
        return a;
    }

    public void resetearDiaAsignaturas(Asignatura[] as) {
        for (int i = 0; i < as.length; i++) {
            as[i].setDiaActualPuede(true);
        }
    }

}
