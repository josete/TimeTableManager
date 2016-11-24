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
        for (i = 2; i < data.length; i++) {
            f.fabricar("Profesor", { nombre: data[i][0], min: data[i][1], max: data[i][2] });
            f.fabricar("Asignatura", { nombre: data[i][4], curso: data[i][5], titulacion: data[i][6], profesor: data[i][7] });
            i += 2;
            f.fabricar("Curso", { nombre: data[i][9], curso: data[i][10], titulacion: data[i][11] });
        }
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
