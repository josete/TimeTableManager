/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Excepciones.EHorarioSinAsignaturas;
import Excepciones.EHorarioSinGrupo;
import Funcionalidad.Contenedor;
import Funcionalidad.LeerExcel;
import Objetos.Fila;
import Objetos.Grupo;
import Objetos.Horario;
import Objetos.Sesion;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Familia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    TableView tabla;
    @FXML
    Button generar;
    @FXML
    ComboBox grupos;

    Horario horario;
    int horasDia;
    int horaInicio;

    FileChooser fileChooser = new FileChooser();
    Stage stage;
    LeerExcel leerExcel;

    Contenedor almacenamiento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generar.setDisable(true);
    }

    public void iniciar(Horario horario, Stage stage, Contenedor c) {
        almacenamiento = c;
        leerExcel = new LeerExcel();
        this.stage = stage;
        this.horario = horario;
        if (almacenamiento.hayDatos()) {
            generar.setDisable(false);
            grupos.getItems().setAll(FXCollections.observableArrayList(almacenamiento.getGrupos()));
        }
        if (horario.isGenerado()) {
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

    @FXML
    private void seleccionarArchivo() {
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            if (leerExcel.leer(file, almacenamiento)) {
                generar.setDisable(false);
                grupos.getItems().setAll(FXCollections.observableArrayList(almacenamiento.getGrupos()));
            }
        }

    }

    @FXML
    private void generarHorario() {
        try {
            horario.setAsignaturas(almacenamiento.getAsignaturas());
            Object objeto = grupos.getSelectionModel().getSelectedItem();
            if(objeto.getClass() == Grupo.class){
                Grupo g = (Grupo)objeto;
                horario.setG(g);
            }
            horario.generar();
            repintar();
        } catch (EHorarioSinGrupo|NullPointerException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Horario sin grupo");
        }catch(EHorarioSinAsignaturas ex){
            System.err.println("Horario sin asignaturas");
        }
    }

    private void repintar() {
        if (horario.isGenerado()) {
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
}
