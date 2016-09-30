/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Familia
 */
public class Fila {

    //Despues seran sesiones
    String a1;
    String a2;
    String a3;
    String a4;
    String a5;
    String hora;

    public Fila(String hora,String a1, String a2, String a3, String a4, String a5) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
    }

    public Fila() {
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

    public void insertar(int i, String a) {
        switch (i) {
            case 1:
                a1 = a;
                break;
            case 2:
                a2 = a;
                break;
            case 3:
                a3 = a;
                break;
            case 4:
                a4 = a;
                break;
            case 5:
                a5 = a;

        }
    }

}
