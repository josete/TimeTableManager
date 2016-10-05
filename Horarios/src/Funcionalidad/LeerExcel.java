/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Portatil-pc
 */
public class LeerExcel {

    Contenedor almacenamiento;
    
    public LeerExcel(Contenedor c) {
        c = almacenamiento;
    }

    public void leer(File archivo) {
        try {
            FileInputStream fs = new FileInputStream(archivo);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            for (int i = 0; i < 5; i++) {
                XSSFSheet sheet = null;
                sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                Row row;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell celda;
                    while (cellIterator.hasNext()) {
                        celda = cellIterator.next();
                        switch (celda.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                System.out.println(celda.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.println(celda.getNumericCellValue());
                                break;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            //Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearAsignatura(String nombre,int curso, int horasSemana, int horasSesion){
        Asignatura a = new Asignatura(nombre, curso, horasSemana, horasSesion);
        almacenamiento.anadirAsignatura(a);
    }

}
