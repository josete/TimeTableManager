/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;
//Prueba Angel
import Funcionalidad.GenerarHorario;
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
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        System.out.println("Hora de inicio (Solo hora): ");
        int h0 = s.nextInt();
        System.out.println("¿Cuantas horas al dia?");
        int horas = s.nextInt();
        GenerarHorario g = new GenerarHorario();
        g.setHoraInicio(h0);
        g.setHorasDia(horas);
        g.generar();
    }
    
}
