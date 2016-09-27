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

    public void generar() {
        Asignatura[] asignaturas = CrearAsignaturas.crearAsignaturas();

        int horasDia = 4;

        String[][] horario = new String[5][4];
        int dia = 1;
        int hora = 1;
        for (int i = 0; i < 20; i += 2) {
            //Suponiendo que todas las clases duran lo mismo
            Asignatura nomnre = seleccionar(asignaturas);
            horario[dia - 1][hora-1] = nomnre.getNombre();
            hora++;
            horario[dia - 1][hora-1] = nomnre.getNombre();
            hora++;
            nomnre.setDiaActualPuede(false);
            nomnre.sumar();
            if ((hora-1) == horasDia) {
                dia++;
                hora=1;
                resetearDiaAsignaturas(asignaturas);
            }
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.print(horario[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public Asignatura seleccionar(Asignatura[] as) {
        Asignatura a = null;
        for (int i = 0; i < as.length; i++) {
            if (as[i].isDiaActualPuede()&&!as[i].isTopeSemana()) {
                a = as[i];
            }
        }
        return a;
    }

    public void resetearDiaAsignaturas(Asignatura[] as) {
        for (int i = 0; i < as.length; i++) {
            as[i].setDiaActualPuede(true);
        }
    }

}
