/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import Objetos.Aula;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Rafael
 */
public class DistribucionAulas {
    
    //Horas inicio y fin asignaturas
    //Nº aulas

    Asignatura isi = new Asignatura("ISI", new SimpleDateFormat("8:30"), new SimpleDateFormat("10:30"));//dia?
    Asignatura campos = new Asignatura("Campos", new SimpleDateFormat("10:30"), new SimpleDateFormat("12:30"));
    Asignatura software = new Asignatura("Software", new SimpleDateFormat("12:30"), new SimpleDateFormat("14:30"));
    
    Aula aula1 = new Aula("1.5.2", false);
    Aula aula2 = new Aula("1.5.3", false);
    Aula aula3 = new Aula("1.5.4", false);
    Aula aula4 = new Aula("1.5.5", false);
    
    //False No ocupado, True Ocupado
    boolean libre = false;
    int numero_aulas = 0;
    ArrayList arraylist_aula = new ArrayList();
    ArrayList arraylist_asignaturas = new ArrayList();
    
    
    public ArrayList anadriAula(Aula b){
        arraylist_aula.add(b);
        return arraylist_aula;
    }
    public void comprobar(){
        arraylist_aula.add(aula1);
        arraylist_aula.add(aula2);
        arraylist_aula.add(aula3);
        arraylist_aula.add(aula4);
        
        arraylist_asignaturas.add(isi);
        arraylist_asignaturas.add(campos);
        arraylist_asignaturas.add(software);
        
        
        for(int i=0; i<arraylist_aula.size();i++){
            Aula prueba = (Aula) arraylist_aula.get(i);
            if(prueba.getOcupado()==libre){
                //while()
                prueba.setOcupado(true);
                
            }
            
            
        }
//        if(libre==false){ //Libre
//            //Tenemos que tener muchas aulas x y cada aula es un boolena
//        }
    }
    
    
}
