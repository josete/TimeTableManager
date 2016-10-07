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
public class Aula {
    int id;
    String nAula;
    boolean ocupado;
    

    public Aula(String nAula, boolean ocupado) {
        this.nAula = nAula;
        this.ocupado = ocupado;
    }
    public Aula(int id,String nAula){
        this.nAula=nAula;
        this.id = id;
        
    }

    public String getnAula() {
        return nAula;
    }

    @Override
    public String toString() {
        return "Aula{" + "nAula=" + nAula + ", ocupado=" + ocupado + '}';
    }

    public void setnAula(String nAula) {
        this.nAula = nAula;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
     
    
}
