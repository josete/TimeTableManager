var Excel = require('exceljs');
var fabrica = require('./Fabrica.js');

var leerExcel = function (archivo,configuracion) {

    if (archivo == null) {
        throw Error("No hay archivo");
    }

    this.archivo = archivo;
    this.c = configuracion;
    f = new fabrica(configuracion);

    this.leer = function () {
        var workbook = new Excel.Workbook();
        workbook.xlsx.readFile(this.archivo)
            .then(function () {
                worksheet = workbook.getWorksheet(1);
                worksheet.eachRow(function (row, rowNumber) {
                    if (rowNumber > 2) {
                        this.c.anadirProfesor(f.fabricar("Profesor",{nombre:row.getCell(1).value,min:row.getCell(2).value,max:row.getCell(3).value}));
                        this.c.anadirAsignatura(f.fabricar("Asignatura",{nombre:row.getCell(5).value,curso:row.getCell(6).value,titulacion:row.getCell(7).value,profesor:row.getCell(8).value}));
                        this.c.anadirCurso(f.fabricar("Curso",{nombre:row.getCell(10).value,curso:row.getCell(11).value,titulacion:row.getCell(12).value}));
                    }
                });
            });
    }

}

module.exports = leerExcel; 