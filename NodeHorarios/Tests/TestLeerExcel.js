leerExcel = require("../Source/Funcionalidad/LeerExcel.js");
configuracion = require("../Source/Funcionalidad/Configuracion.js");
async = require("async");

exports.testLeerExcelSinArchivo = function (test) {
    test.throws(function () { leer = new leerExcel(); });
    test.done();
}

exports.testLeerExcelObteniendoProfesores = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    async.series([
        function (callback) { leer.leer(); },
        function (callback) { test.equals(1, c.profesores.length); }
    ]);
    test.done();
}

exports.testLeerExcelObteniendoProfesoresNombre = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    async.series([
        function (callback) { leer.leer(); },
        function (callback) { test.equals("Raul", c.profesores[0].getNombre()); }
    ]);
    test.done();
}