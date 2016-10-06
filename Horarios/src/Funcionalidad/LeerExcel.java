/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import Objetos.Profesor;
import Objetos.Titulacion;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Portatil-pc
 */
public class LeerExcel {

    public LeerExcel() {

    }

    public void leer(File archivo, Contenedor almacenamiento) {
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
                    ArrayList<String> nombres = new ArrayList<>();
                    ArrayList<Integer> numeros = new ArrayList<>();
                    while (cellIterator.hasNext()) {
                        celda = cellIterator.next();
                        switch (celda.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                nombres.add(celda.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                Double d = celda.getNumericCellValue();
                                numeros.add(d.intValue());
                                break;
                        }
                    }
                    switch (i) {
                        case 0:
                            almacenamiento.anadirProfesor(
                                    new Profesor(nombres.get(0), nombres.get(1), nombres.get(2), numeros.get(0)));
                            break;
                        case 1:
                            almacenamiento.anadidTitulacion(new Titulacion(numeros.get(0), nombres.get(0), numeros.get(1)));
                            break;
                        case 2:
                            almacenamiento.anadirAsignatura(new Asignatura(nombres.get(0),
                                    almacenamiento.getProfesorPorId(numeros.get(0)), numeros.get(1),
                                    almacenamiento.getTitulacionPorId(numeros.get(2)), numeros.get(3), numeros.get(4)));
                            break;
                    }
                }
            }

        } catch (Exception ex) {
            //Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
