/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;
//Prueba Angel

import Funcionalidad.GenerarHorario;
import Objetos.Sesion;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Familia
 */
public class Horarios extends Application {

    static Scanner s = new Scanner(System.in);
    static int h0 = 0;
    static int horas = 0;
    static String[][] horario;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        controller.iniciar(horario,horas,h0);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Horario");
        stage.show();
    }

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
        //System.out.println(sesion11.toString());
        
                    System.out.println(sesion11.toString());
                    System.out.println(sesion12.toString());
                    System.out.println(sesion13.toString());
                    System.out.println(sesion21.toString());
                    System.out.println(sesion22.toString());
                    System.out.println(sesion31.toString());
        System.out.println("Hora de inicio (Solo hora): ");
        h0 = s.nextInt();
        System.out.println("¿Cuantas horas al dia?");
        horas = s.nextInt();
        GenerarHorario g = new GenerarHorario();
        g.setHoraInicio(h0);
        g.setHorasDia(horas);
        g.generar();
        horario = g.getHorario();
        launch(args);

    }
       
               
                     


            
}


