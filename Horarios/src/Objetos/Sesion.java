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
    Grupo grupo;

    public Sesion(Asignatura asignatura, Grupo grupo) {
        this.asignatura = asignatura;
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
                +"\n\tCurso: "+asignatura.getCurso()+"\n\tAula: "+grupo.getAula().getId_aula();
        return info;
    }
    
    
    
    
 
    
}
