/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Rafael
 */
public class Sesion {
    
    int id;
    Asignatura asignatura;
    Aula aula;
    Grupo grupo;
    
    
//    String asignatura;
//    String nombre_profesor;
//    String aula;
//    int hora;
//
//    public Sesion(int id, String asignatura, String nombre_profesor, String aula, int hora) {
//        this.id = id;
//        this.asignatura = asignatura;
//        this.nombre_profesor = nombre_profesor;
//        this.aula = aula;
//        this.hora = hora;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Sesion "+id + " Id= " + id + ", Asignatura= " + asignatura + ", Profesor= " + 
//                nombre_profesor + ", Aula= " + aula + ", Hora= " + hora + '}';
//    }
//
//    public Sesion() {
//    }
//    
//
//    public String getAsignatura() {
//        return asignatura;
//    }
//
//    public void setAsignatura(String asignatura) {
//        this.asignatura = asignatura;
//    }
//
//    public String getNombre_profesor() {
//        return nombre_profesor;
//    }
//
//    public void setNombre_profesor(String nombre_profesor) {
//        this.nombre_profesor = nombre_profesor;
//    }
//
//    public String getAula() {
//        return aula;
//    }
//
//    public void setAula(String aula) {
//        this.aula = aula;
//    }
//
//    public int getHora() {
//        return hora;
//    }
//
//    public void setHora(int hora) {
//        this.hora = hora;
//    }

    public Sesion(Asignatura asignatura, Aula aula, Grupo grupo) {
        this.asignatura = asignatura;
        this.aula = aula;
        this.grupo = grupo;
    }

    public Sesion() {
        asignatura = new Asignatura("----",null,0,null,2, 2);
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return asignatura.getNombre();
    }
    
    public String getInfo(){
        String info = asignatura.getNombre()+"\n\tProfesor: "+asignatura.getProfesor().getNombre()
                +"\n\tCurso: "+asignatura.getCurso()+"\n\tAula: "+aula.getId_aula();
        return info;
    }
    
    
    
    
 
    
}
