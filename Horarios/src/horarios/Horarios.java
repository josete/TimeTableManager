/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;
//Prueba Angel

import Funcionalidad.Contenedor;
import Funcionalidad.CrearAsignaturas;
import Funcionalidad.GenerarHorario;
import Objetos.Horario;
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
    static Horario horario;
    static Contenedor almacenamiento;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        controller.iniciar(horario,stage, almacenamiento);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Horario");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        almacenamiento = new Contenedor();
        menuGenerarHorario();
//CrearAsignaturas.crearAsignaturas(almacenamiento);
//        System.out.println("Hora de inicio (Solo hora): ");
//        h0 = s.nextInt();
//        System.out.println("¿Cuantas horas al dia?");
//        horas = s.nextInt();
//        horario = new Horario(h0, 0, horas);
//        //horario.generar();
        launch(args);

    }
    
    public static void menuGenerarHorario(){
        
        System.out.println("Hora de inicio (Solo hora): ");
        //h0 = s.nextInt();
       String str=s.nextLine();
	int horaEmpieza=0;
    	try{
        	horaEmpieza=Integer.parseInt(str);
    	}
        catch(NumberFormatException ex){
        	System.out.println("No es un número");
                menuGenerarHorario();
        }

        System.out.println("¿Cuantas horas al dia?");
        String horas = s.nextLine();
        int numeroHorasDia=0;
        try{
            numeroHorasDia=Integer.parseInt(horas);
        }
        catch(NumberFormatException ex){
            System.out.println("No es un número");
                menuGenerarHorario();
        }
        
        
        if(7<horaEmpieza&horaEmpieza<20&2<numeroHorasDia&numeroHorasDia<12){
            horario = new Horario(horaEmpieza, 0, numeroHorasDia);
        }
        else{
            System.out.println("Fallo terrible en sistema: Introduzca de nuevo los datos");
            menuGenerarHorario();
        }
        
        
            
        
                
            
        
    }

}
