/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Objetos.Fila;
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
    
    Sesion[][] horario;
    int horasDia;
    int horaInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public void iniciar(Sesion[][] horario, int horasDia,int horaInicio){
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
                new PropertyValueFactory<Fila, Sesion>("a1"));
        TableColumn martes = new TableColumn("Martes");
        
        martes.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a2"));
        TableColumn miercoles = new TableColumn("Miercoles");
        miercoles.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a3"));
        TableColumn jueves = new TableColumn("Jueves");
        jueves.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a4"));
        TableColumn viernes = new TableColumn("Viernes");
        viernes.setCellValueFactory(
                new PropertyValueFactory<Fila, Sesion>("a5"));
          
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
