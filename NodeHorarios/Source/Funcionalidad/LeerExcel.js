var Excel = require('xlsx');
var fabrica = require('./Fabrica.js');

var leerExcel = function (archivo, configuracion) {

    if (archivo == null) {
        throw Error("No hay archivo");
    }
    this.archivo = archivo;
    f = new fabrica(configuracion);

    this.leer = function () {
        var workbook = Excel.readFile(this.archivo);
        var worksheet = workbook.Sheets["Hoja1"];
        var data = Excel.utils.sheet_to_json(worksheet, { header: 1 });
        data = data.splice(2, data.length);
        data.forEach(function (element) {
            f.fabricar("Profesor", { nombre: element[0], min: element[1], max: element[2] });
            if (element[4] != undefined) {
                f.fabricar("Asignatura", { nombre: element[4], curso: element[5], titulacion: element[6], profesor: element[7] });
            }
            if (element[9] != undefined) {
                f.fabricar("Curso", { nombre: element[9], curso: element[10], titulacion: element[11] });
            }
        }, this);
        worksheet = workbook.Sheets["Hoja2"];
        data = Excel.utils.sheet_to_json(worksheet, { header: 1 });
        data = data.splice(2, data.length);
        data.forEach(function (element) {
            f.fabricar("Sesion", { asignatura: element[0], horas: element[1], curso: element[2] });
        }, this);

    }

}

/*f.fabricar("Profesor", { nombre: row.getCell(1).value, min: row.getCell(2).value, max: row.getCell(3).value });
f.fabricar("Asignatura", { nombre: row.getCell(5).value, curso: row.getCell(6).value, titulacion: row.getCell(7).value, profesor: row.getCell(8).value });
f.fabricar("Curso", { nombre: row.getCell(10).value, curso: row.getCell(11).value, titulacion: row.getCell(12).value });
f.fabricar("Sesion", { asignatura: row.getCell(1).value, horas: row.getCell(2).value, curso: row.getCell(3).value });*/

module.exports = leerExcel; 
