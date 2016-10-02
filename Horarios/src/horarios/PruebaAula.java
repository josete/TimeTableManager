/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Funcionalidad.AulaCurso;
import Objetos.Sesion;
import Objetos.Asignatura;
/**
 *
 * @author Clara
 */
public class PruebaAula {

    /**
     * @param args the command line arguments
     */
    
    static Sesion sesion11=new Sesion(1,"Software","Raul","1.5.10",830);
    static Sesion sesion12=new Sesion(2,"IA","Mariano","1.5.10",1030);
    static Sesion sesion13=new Sesion(3,"ISI","Paloma","1.5.10",1230);
    static Sesion sesion21=new Sesion(4,"Proyectos","Jose Manuel","1.5.10",1030);
    static Sesion sesion22=new Sesion(5,"Software","Raul","1.5.10",1230);
    static Sesion sesion31=new Sesion(6,"SI","Angel","1.5.10",830);
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sesion12.toString());
       // AulaCurso a = new AulaCurso();
       // a.RecorrerAula();
        
    }
    
}
