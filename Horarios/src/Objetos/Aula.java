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
    String nAula;
    boolean ocupado;
    

    public Aula(String nAula, boolean ocupado) {
        this.nAula = nAula;
        this.ocupado = ocupado;
    }
    public Aula(String nAula){
        this.nAula=nAula;
        
    }

    public String getId_aula() {
        return nAula;
    }

    @Override
    public String toString() {
        return "Aula{" + "nAula=" + nAula + ", ocupado=" + ocupado + '}';
    }

    public void setId_aula(String nAula) {
        this.nAula = nAula;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
