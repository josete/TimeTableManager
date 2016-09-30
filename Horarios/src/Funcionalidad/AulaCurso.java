/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Aula;
import Objetos.Curso;

/**
 *
 * @author Clara
 */
public class AulaCurso {
    Aula aula;
    Curso curso;
    
    Aula[] array_aula = new Aula[2];
    Curso[]array_curso=new Curso[2];
    
    
    public int RecorrerAula(){
    array_aula[0] = new Aula("0.A");
    array_curso[0] = new Curso(1);
    array_aula[1] = new Aula("0.B");
    array_curso[1] = new Curso(2);
    int i=0;
    for(i=0;i<array_curso.length;i++){
        System.out.println("Aula: "+array_aula[i].getId_aula()+" Asignado a: "+array_curso[i].getId_curso());
    }
    return i;
}
}