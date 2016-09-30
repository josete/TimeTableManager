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
    String id_aula;
    boolean ocupado;
    

    public Aula(String id_aula, boolean ocupado) {
        this.id_aula = id_aula;
        this.ocupado = ocupado;
    }
    public Aula(String id_aula){
        this.id_aula=id_aula;
        
    }

    public String getId_aula() {
        return id_aula;
    }

    public void setId_aula(String id_aula) {
        this.id_aula = id_aula;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
