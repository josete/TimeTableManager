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
            if (element[0] != undefined) {
                f.fabricar("Profesor", { nombre: element[0], min: element[1], max: element[2] });
            }
            if (element[4] != undefined) {
                f.fabricar("Asignatura", { nombre: element[4], curso: element[5], titulacion: element[6], profesor: element[7] });
            }
            if (element[9] != undefined) {
                f.fabricar("Curso", { nombre: element[9], curso: element[10], titulacion: element[11] });
            }
            if(element[13] != undefined){
                f.fabricar("Sesion", { asignatura: element[13], horas: element[14], curso: element[15] });
            }
        }, this);
        /*worksheet = workbook.Sheets["Hoja2"];
        data = Excel.utils.sheet_to_json(worksheet, { header: 1 });
        data = data.splice(2, data.length);
        data.forEach(function (element) {
            f.fabricar("Sesion", { asignatura: element[13], horas: element[14], curso: element[15] });
        }, this);*/
        //callback();
    }

}

module.exports = leerExcel; 
