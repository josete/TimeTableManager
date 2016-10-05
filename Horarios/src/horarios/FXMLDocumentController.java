/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Objetos.Fila;
import Objetos.Horario;
import Objetos.Sesion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Familia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    TableView tabla;
    
    Horario horario;
    int horasDia;
    int horaInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public void iniciar(Horario horario, int horasDia,int horaInicio){
        this.horario = horario;
        final ObservableList<Fila> data = horario.datosDibujar();
        tabla.setEditable(true);
        TableColumn blanco = new TableColumn("  ");
        blanco.setCellValueFactory(
                new PropertyValueFactory<Fila, String>("hora"));
        TableColumn lunes = new TableColumn("Lunes");
        lunes.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a1"));
        lunes.setSortable(false);
        TableColumn martes = new TableColumn("Martes");        
        martes.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a2"));
        martes.setSortable(false);
        TableColumn miercoles = new TableColumn("Miercoles");
        miercoles.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a3"));
        miercoles.setSortable(false);
        TableColumn jueves = new TableColumn("Jueves");
        jueves.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a4"));
        jueves.setSortable(false);
        TableColumn viernes = new TableColumn("Viernes");
        viernes.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a5"));
        viernes.setSortable(false);
          
        tabla.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                TablePosition pos = (TablePosition) tabla.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                Fila item = (Fila) tabla.getItems().get(row);
                TableColumn col = pos.getTableColumn();
                Sesion data = (Sesion) col.getCellObservableValue(item).getValue();
                System.out.println(data.getInfo());
            }
        });
        tabla.setItems(data);
        
        tabla.getColumns().addAll(blanco, lunes, martes, miercoles, jueves, viernes);
    }
    
    
}
