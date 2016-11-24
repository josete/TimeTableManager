leerExcel = require("../Source/Funcionalidad/LeerExcel.js");
configuracion = require("../Source/Funcionalidad/Configuracion.js");
fabrica = require("../Source/Funcionalidad/Fabrica.js");
async = require("async");

exports.testLeerExcelSinArchivo = function (test) {
    test.throws(function () { leer = new leerExcel(); });
    test.done();
}

exports.testLeerExcelObteniendoProfesores = function (test) {
    this.c = new configuracion();
    leer = new leerExcel("../Info.xlsx", this.c);
    leer.leer();
    test.equals(1, this.c.profesores.length);
    test.done();
}

exports.testLeerExcelObteniendoProfesoresNombre = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals("Raul", c.profesores[0].getNombre());
    test.done();
}

exports.testLeerExcelObteniendoAsignaturas = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals(1, c.asignaturas.length);
    test.done();
}

exports.testLeerExcelObteniendoAsignaturasNombre = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals("IS", c.asignaturas[0].getNombre());
    test.done();
}

exports.testLeerExcelObteniendoCursos = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals(1, c.cursos.length);
    test.done();
}

exports.testLeerExcelObteniendoCursosNombre = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals("Informatica", c.cursos[0].getNombre());
    test.done();
}

exports.testLeerExcelObteniendoSesiones = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals(3, c.sesiones.length);
    test.done();
}

exports.testLeerExcelObteniendoSesionesNombre = function (test) {
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();
    test.equals("IS", c.sesiones[0].getAsignatura().getNombre());
    test.done();
}