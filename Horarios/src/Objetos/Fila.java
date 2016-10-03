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
    Sesion a1;
    Sesion a2;
    Sesion a3;
    Sesion a4;
    Sesion a5;
    String hora;

    public Fila(Sesion hora,Sesion a1, Sesion a2, Sesion a3, Sesion a4, Sesion a5) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
    }

    public Fila() {
    }

    public Sesion getA1() {
        return a1;
    }

    public void setA1(Sesion a1) {
        this.a1 = a1;
    }

    public Sesion getA2() {
        return a2;
    }

    public void setA2(Sesion a2) {
        this.a2 = a2;
    }

    public Sesion getA3() {
        return a3;
    }

    public void setA3(Sesion a3) {
        this.a3 = a3;
    }

    public Sesion getA4() {
        return a4;
    }

    public void setA4(Sesion a4) {
        this.a4 = a4;
    }

    public Sesion getA5() {
        return a5;
    }

    public void setA5(Sesion a5) {
        this.a5 = a5;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

    public void insertar(int i, Sesion a) {
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
