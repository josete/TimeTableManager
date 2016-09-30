/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Objetos.Fila;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Familia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    TableView tabla;
    
    String[][] horario;
    int horasDia;
    int horaInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public void iniciar(String[][] horario, int horasDia,int horaInicio){
        System.out.println("Holaa");
        this.horario = horario;
        this.horaInicio = horaInicio;
        this.horasDia = horasDia;
        final ObservableList<Fila> data = FXCollections.observableArrayList();
        Fila f;
        for (int j = 0; j < horasDia; j++) {
            f = new Fila();
            f.setHora(horaInicio+":30");
            for (int i = 0; i < 5; i++) {
                f.insertar(i+1, horario[i][j]);
            }
            data.add(f);
            horaInicio++;
        }
        System.out.println(data.size());
        //tabla = new TableView<Fila>();
        tabla.setEditable(true);
        TableColumn blanco = new TableColumn("  ");
        blanco.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("hora"));
        TableColumn lunes = new TableColumn("Lunes");
        lunes.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("a1"));
        TableColumn martes = new TableColumn("Martes");
        martes.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("a2"));
        TableColumn miercoles = new TableColumn("Miercoles");
        miercoles.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("a3"));
        TableColumn jueves = new TableColumn("Jueves");
        jueves.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("a4"));
        TableColumn viernes = new TableColumn("Viernes");
        viernes.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("a5"));
        
        tabla.setItems(data);

        tabla.getColumns().addAll(blanco, lunes, martes, miercoles, jueves, viernes);
    }
}
